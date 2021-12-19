/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jumbo.controller;

import br.com.jumbo.frame.RateioViagens;
import br.com.jumbo.vo.ViagensCabVO;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
 * @author Joao
 */
public class RateioViagensController extends FormController {

    private RateioViagens viagens = null;
    private Connection conn = null;

    public RateioViagensController(Connection conn) {
        this.conn = conn;
        viagens = new RateioViagens(conn, this);
        MDIFrame.add(viagens, true);
    }

    /**
     * This method must be overridden by the subclass to retrieve data and
     * return the valorized value object.
     *
     * @param valueObjectClass value object class
     * @return a VOResponse object if data loading is successfully completed, or
     * an ErrorResponse object if an error occours
     */
    public Response loadData(Class valueObjectClass) {
        try {

            String sql
                    = "select viagens_cabecalho.vi_cod_cab, viagens_cabecalho.veiculo_vei_placa, "
                    + "viagens_cabecalho.mes_ano_cab, viagens_cabecalho.total_viagens_cab, "
                    + "viagens_cabecalho.valor_total_mes_cab from viagens_cabecalho, viagens "
                    + "where viagens_cabecalho.veiculo_vei_placa = viagens.veiculo_vei_placa and "
                    + " viagens_cabecalho.veiculo_vei_placa = ? and viagens_cabecalho.mes_ano_cab = ?";

           // ArrayList vars = new ArrayList();
            // vars.add(viagens.getTxVeiculoVeiPlaca().getValue().toString());
            // vars.add(viagens.getTxMesAnoCab().getText());
            Map attribute2dbField = new HashMap();
            attribute2dbField.put("viCodCab", "viagens_cabecalho.vi_cod_cab");
            attribute2dbField.put("veiculoVeiPlaca", "viagens_cabecalho.veiculo_vei_placa");
            attribute2dbField.put("colId", "viagens.colaborador_col_id");
            attribute2dbField.put("mesAnoCab", "viagens_cabecalho.mes_ano_cab");
            attribute2dbField.put("totalViagensCab", "viagens_cabecalho.total_viagens_cab");
            attribute2dbField.put("valorTotalMesCab", "viagens_cabecalho.valor_total_mes_cab");
            // attribute2dbField.put("totalConsumos", "gas_cabecalho.total_consumos_gas_cab");

            ArrayList vars = new ArrayList();
            vars.add(viagens.getTxVeiculoVeiPlaca().getValue().toString());
            vars.add(viagens.getTxMesAnoCab().getText());

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
     *
     * @param newValueObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        // mapping between attributes and database fields...
        Map attribute2dbField = new HashMap();
        attribute2dbField.put("viCodCab", "viagens_cabecalho.vi_cod_cab");
        attribute2dbField.put("veiculoVeiPlaca", "viagens_cabecalho.veiculo_vei_placa");
        attribute2dbField.put("mesAnoCab", "viagens_cabecalho.mes_ano_cab");
        attribute2dbField.put("totalViagensCab", "viagens_cabecalho.total_viagens_cab");
        attribute2dbField.put("valorTotalMesCab", "viagens_cabecalho.valor_total_mes_cab");

        Response res = QueryUtil.insertTable(conn, newPersistentObject, "viagens_cabecalho", attribute2dbField, "Y", "N", true);
        return res;
    }

    /**
     * Method called by the Form panel to update existing data.
     *
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        // mapping between attributes and database fields...
        Map attribute2dbField = new HashMap();
        attribute2dbField.put("viCodCab", "viagens_cabecalho.vi_cod_cab");
        attribute2dbField.put("veiculoVeiPlaca", "viagens_cabecalho.veiculo_vei_placa");
        attribute2dbField.put("colId", "viagens.colaborador_col_id");
        attribute2dbField.put("mesAnoCab", "viagens_cabecalho.mes_ano_cab");
        attribute2dbField.put("totalViagensCab", "viagens_cabecalho.total_viagens_cab");
        attribute2dbField.put("valorTotalMesCab", "viagens_cabecalho.valor_total_mes_cab");

        HashSet pk = new HashSet();
        pk.add("viCodCab");

        Response res = QueryUtil.updateTable(conn, pk, oldPersistentObject, persistentObject, "viagens.cabecalho", attribute2dbField, "Y", "N", true);
        return res;
    }

    /**
     * Method called by the Form panel to delete existing data.
     *
     * @param persistentObject value object to delete
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            ViagensCabVO vo = (ViagensCabVO) persistentObject;

            // delete from viagens detalhe
            stmt = conn.prepareStatement("delete from viagens_detalhe where gas_cabecalho_cod_gas_cab=?");
            stmt.setInt(1, vo.getViCodCab());
            stmt.execute();
            stmt.close();

            // delete from viagens cabecalho
            stmt = conn.prepareStatement("delete from gas_cabecalho where cod_gas_cab=?");
            stmt.setInt(1, vo.getViCodCab());
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
        String sql
                = "select viagens_cabecalho.vi_cod_cab, viagens_cabecalho.veiculo_vei_placa,"
                + "viagens_cabecalho.mes_ano_cab, viagens_cabecalho.total_viagens_cab,"
                + "viagens_cabecalho.valor_total_mes_cab from viagens_cabecalho, viagens"
                + "where viagens_cabecalho.veiculo_vei_placa = viagens.veiculo_vei_placa and"
                + "viagens_cabecalho.veiculo_vei_placa = ? and viagens_cabecalho.mes_ano_cab = ?";

        // mapping between attributes and database fields...
        Map attribute2dbField = new HashMap();

        attribute2dbField.put("viCodCab", "viagens_cabecalho.vi_cod_cab");
        attribute2dbField.put("veiculoVeiPlaca", "viagens_cabecalho.veiculo_vei_placa");
        attribute2dbField.put("colId", "viagens.colaborador_col_id");
        attribute2dbField.put("mesAnoCab", "viagens_cabecalho.mes_ano_cab");
        attribute2dbField.put("totalViagensCab", "viagens_cabecalho.total_viagens_cab");
        attribute2dbField.put("valorTotalMesCab", "viagens_cabecalho.valor_total_mes_cab");

        ArrayList vars = new ArrayList();
        vars.add(viagens.getTxVeiculoVeiPlaca().getValue().toString());
        vars.add(viagens.getTxMesAnoCab().getText());

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
