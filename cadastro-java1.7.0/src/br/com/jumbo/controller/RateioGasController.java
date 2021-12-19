/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jumbo.controller;



import br.com.jumbo.vo.ViagensCabVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.server.QueryUtil;

/**
 *
 * @author Albert Eije
 */
public class RateioGasController extends FormController {

  //  private RateioGas gas = null;
    private Connection conn = null;

    public RateioGasController(Connection conn) {
        this.conn = conn;
      //  gas = new RateioGas(conn, this);
       // MDIFrame.add(gas, true);
    }

    /**
     * This method must be overridden by the subclass to retrieve data and return the valorized value object.
     * @param valueObjectClass value object class
     * @return a VOResponse object if data loading is successfully completed, or an ErrorResponse object if an error occours
     */
    public Response loadData(Class valueObjectClass) {
        try {

            String sql =
                    "select gas_cabecalho.cod_gas_cab,gas_cabecalho.condominio_cod_cond, " +
                    "gas_cabecalho.mes_ano_gas_cab, gas_cabecalho.vlr_compra_gas_cab, " +
                    "gas_cabecalho.fator_conversao_gas_cab, gas_cabecalho.total_consumos_gas_cab," +
                    "condominio.nome_cond " +
                    "from gas_cabecalho, condominio " +
                    "where gas_cabecalho.condominio_cod_cond = condominio.cod_cond and " +
                    " gas_cabecalho.condominio_cod_cond = ? and gas_cabecalho.mes_ano_gas_cab = ?";

            // mapping between attributes and database fields...
            Map attribute2dbField = new HashMap();
            attribute2dbField.put("codGas", "gas_cabecalho.cod_gas_cab");
            attribute2dbField.put("codCondominio", "gas_cabecalho.condominio_cod_cond");
            attribute2dbField.put("nomeCondominio", "condominio.nome_cond");
            attribute2dbField.put("mesAno", "gas_cabecalho.mes_ano_gas_cab");
            attribute2dbField.put("vlrCompra", "gas_cabecalho.vlr_compra_gas_cab");
            attribute2dbField.put("fatorConversao", "gas_cabecalho.fator_conversao_gas_cab");
            attribute2dbField.put("totalConsumos", "gas_cabecalho.total_consumos_gas_cab");

            ArrayList vars = new ArrayList();
        //    vars.add(gas.getTxCodCondominio().getValue().toString());
         //   vars.add(gas.getTxMesAno().getText());

            return QueryUtil.getQuery(
                    conn,
                    sql,
                    vars, // list of values linked to "?" parameters in sql
                    attribute2dbField,
                    ViagensCabVO.class, // v.o. to dinamically create for each row...
                    "Y",
                    "N",
                    true // log query...
                    );
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        }
    }

    /**
     * Method called by the Form panel to insert new data.
     * @param newValueObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        // mapping between attributes and database fields...
        Map attribute2dbField = new HashMap();
        attribute2dbField.put("codGas", "gas_cabecalho.cod_gas_cab");
        attribute2dbField.put("codCondominio", "gas_cabecalho.condominio_cod_cond");
        attribute2dbField.put("mesAno", "gas_cabecalho.mes_ano_gas_cab");
        attribute2dbField.put("vlrCompra", "gas_cabecalho.vlr_compra_gas_cab");
        attribute2dbField.put("fatorConversao", "gas_cabecalho.fator_conversao_gas_cab");
        attribute2dbField.put("totalConsumos", "gas_cabecalho.total_consumos_gas_cab");

        Response res = QueryUtil.insertTable(conn, newPersistentObject, "gas_cabecalho", attribute2dbField, "Y", "N", true);
        return res;
    }

    /**
     * Method called by the Form panel to update existing data.
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        // mapping between attributes and database fields...
        Map attribute2dbField = new HashMap();
        attribute2dbField.put("codGas", "gas_cabecalho.cod_gas_cab");
        attribute2dbField.put("codCondominio", "gas_cabecalho.condominio_cod_cond");
        attribute2dbField.put("mesAno", "gas_cabecalho.mes_ano_gas_cab");
        attribute2dbField.put("vlrCompra", "gas_cabecalho.vlr_compra_gas_cab");
        attribute2dbField.put("fatorConversao", "gas_cabecalho.fator_conversao_gas_cab");
        attribute2dbField.put("totalConsumos", "gas_cabecalho.total_consumos_gas_cab");

        HashSet pk = new HashSet();
        pk.add("codGas");

        Response res = QueryUtil.updateTable(conn, pk, oldPersistentObject, persistentObject, "gas_cabecalho", attribute2dbField, "Y", "N", true);
        return res;
    }

    /**
     * Method called by the Form panel to delete existing data.
     * @param persistentObject value object to delete
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            ViagensCabVO vo = (ViagensCabVO) persistentObject;

            // delete from gas detalhe
            stmt = conn.prepareStatement("delete from gas_detalhe where gas_cabecalho_cod_gas_cab=?");
           // stmt.setInt(1, vo.getCodGas());
            stmt.execute();
            stmt.close();

            // delete from gas cabecalho
            stmt = conn.prepareStatement("delete from gas_cabecalho where cod_gas_cab=?");
           // stmt.setInt(1, vo.getCodGas());
            stmt.execute();

            return new VOResponse(vo);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                stmt.close();
                conn.commit();
            } catch (SQLException ex1) {
            }
        }
    }

    public boolean consultaMovimento() throws Exception {
        String sql =
                "select gas_cabecalho.cod_gas_cab,gas_cabecalho.condominio_cod_cond, " +
                "gas_cabecalho.mes_ano_gas_cab, gas_cabecalho.vlr_compra_gas_cab, " +
                "gas_cabecalho.fator_conversao_gas_cab, gas_cabecalho.total_consumos_gas_cab," +
                "condominio.nome_cond " +
                "from gas_cabecalho, condominio " +
                "where gas_cabecalho.condominio_cod_cond = condominio.cod_cond and " +
                " gas_cabecalho.condominio_cod_cond = ? and gas_cabecalho.mes_ano_gas_cab = ?";

        // mapping between attributes and database fields...
        Map attribute2dbField = new HashMap();
        attribute2dbField.put("codGas", "gas_cabecalho.cod_gas_cab");
        attribute2dbField.put("codCondominio", "gas_cabecalho.condominio_cod_cond");
        attribute2dbField.put("nomeCondominio", "condominio.nome_cond");
        attribute2dbField.put("mesAno", "gas_cabecalho.mes_ano_gas_cab");
        attribute2dbField.put("vlrCompra", "gas_cabecalho.vlr_compra_gas_cab");
        attribute2dbField.put("fatorConversao", "gas_cabecalho.fator_conversao_gas_cab");
        attribute2dbField.put("totalConsumos", "gas_cabecalho.total_consumos_gas_cab");

        ArrayList vars = new ArrayList();
   //     vars.add(gas.getTxCodCondominio().getValue().toString());
    //    vars.add(gas.getTxMesAno().getText());

        Response res = QueryUtil.getQuery(
                conn,
                sql,
                vars, //lista de valores vinculado aos parametros "?" na consulta SQL
                attribute2dbField,
                ViagensCabVO.class,
                "Y",
                "N",
                true //log query...
                );
        if (res.isError()) {
            if (res.getErrorMessage().equals("Record not found.")) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
