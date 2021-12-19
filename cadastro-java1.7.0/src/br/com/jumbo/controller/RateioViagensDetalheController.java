/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jumbo.controller;

import br.com.jumbo.frame.RateioViagens;
import br.com.jumbo.frame.RateioViagens;
import br.com.jumbo.vo.ViagensCabVO;
import br.com.jumbo.vo.ViagensDetVO;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.server.QueryUtil;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

/**
 *
 * @author Albert Eije
 */
public class RateioViagensDetalheController extends GridController implements GridDataLocator {

    private Connection conn = null;
    private RateioViagens viagens = null;

    public RateioViagensDetalheController(RateioViagens rateioViagens, Connection conn) {
        this.conn = conn;
        this.viagens = rateioViagens;
    }

    /**
     * Callback method invoked to load data on the grid.
     *
     * @param action fetching versus: PREVIOUS_BLOCK_ACTION, NEXT_BLOCK_ACTION
     * or LAST_BLOCK_ACTION
     * @param startPos start position of data fetching in result set
     * @param filteredColumns filtered columns
     * @param currentSortedColumns sorted columns
     * @param currentSortedVersusColumns ordering versus of sorted columns
     * @param valueObjectType v.o. type
     * @param otherGridParams other grid parameters
     * @return response from the server: an object of type VOListResponse if
     * data loading was successfully completed, or an ErrorResponse onject if
     * some error occours
     */
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {

        try {
            String sql
                    = "select viagens_detalhe.vi_det_cod, viagens_detalhe.vi_det_veiculo_vei_placa, "
                    + "viagens_detalhe.vi_det_mes, viagens_detalhe.vi_det_total_viagens, "
                    + "viagens_detalhe.vi_det_total_valor from viagens_detalhe, viagens "
                    + "where viagens_detalhe.vi_det_veiculo_vei_placa = viagens.veiculo_veiculo_vei_placa and "
                    + "viagens_detalhe.vi_det_cod = ?";

            // mapping between attributes and database fields...
            Map attribute2dbField = new HashMap();
            attribute2dbField.put("viDetCod", "viagens_detalhe.vi_det_cod");
            attribute2dbField.put("viDetVeiculoVeiPlaca", "viagens_detalhe.vi_det_veiculo_vei_placa");
            attribute2dbField.put("viDetMes", "viagens_detalhe.vi_det_mes");
            attribute2dbField.put("viDetTotalViagens", "viagens_detalhe.vi_det_total_viagens");
            attribute2dbField.put("viDetTotalValor", "viagens_detalhe.vi_det_total_valor");

            ViagensCabVO viagensC = (ViagensCabVO) viagens.getForm1().getVOModel().getValueObject();
            
            ArrayList vars = new ArrayList();
            vars.add(viagensC.getViCodCab());

            Response res = QueryUtil.getQuery(
                    conn,
                    sql,
                    vars, // list of values linked to "?" parameters in sql
                    attribute2dbField,
                    ViagensDetVO.class, // v.o. to dinamically create for each row...
                    "Y",
                    "N",
                    new GridParams(
                            action,
                            startIndex,
                            filteredColumns,
                            currentSortedColumns,
                            currentSortedVersusColumns,
                            new HashMap() // other params...
                    ),
                    true // log query...
            );

            ArrayList list = (ArrayList) ((VOListResponse) res).getRows();
            if (list.size() > 0) {
                return res;
            } else {
                carregaViagensNova();
                return null;
            }

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

        attribute2dbField.put("viDetCod", "viagens_detalhe.vi_det_cod");
        attribute2dbField.put("viDetVeiculoVeiPlaca", "viagens_detalhe.vi_det_veiculo_vei_placa");
        attribute2dbField.put("viDetMes", "viagens_detalhe.vi_det_mes");
        attribute2dbField.put("viDetTotalViagens", "viagens_detalhe.vi_det_total_viagens");
        attribute2dbField.put("viDetTotalValor", "viagens_detalhe.vi_det_total_valor");

        Response res = QueryUtil.insertTable(conn, newPersistentObject, "viagens_detalhe", attribute2dbField, "Y", "N", true);
        return res;
    }

    /**
     * Method invoked when the user has clicked on save button and the grid is
     * in EDIT mode.
     *
     * @param rowNumbers row indexes related to the changed rows
     * @param oldPersistentObjects old value objects, previous the changes
     * @param persistentObjects value objects relatied to the changed rows
     * @return an ErrorResponse value object in case of errors, VOListResponse
     * if the operation is successfully completed
     */
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        Map attribute2dbField = new HashMap();

        attribute2dbField.put("viDetCod", "viagens_detalhe.vi_det_cod");
        attribute2dbField.put("viDetVeiculoVeiPlaca", "viagens_detalhe.vi_det_veiculo_vei_placa");
        attribute2dbField.put("viDetMes", "viagens_detalhe.vi_det_mes");
        attribute2dbField.put("viDetTotalViagens", "viagens_detalhe.vi_det_total_viagens");
        attribute2dbField.put("viDetTotalValor", "viagens_detalhe.vi_det_total_valor");

        HashSet pk = new HashSet();
        pk.add("viCodCab");
        pk.add("");

        Response res = null;
        ViagensDetVO oldVO = null;
        ViagensDetVO newVO = null;

        for (int i = 0; i < persistentObjects.size(); i++) {
            oldVO = (ViagensDetVO) oldPersistentObjects.get(i);
            newVO = (ViagensDetVO) persistentObjects.get(i);
            res = QueryUtil.updateTable(conn, pk, oldVO, newVO, "viagens_detalhe", attribute2dbField, "Y", "N", true);
        }
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
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
            ViagensDetVO vo = (ViagensDetVO) persistentObject;

            // delete from gas detalhe
            stmt = conn.prepareStatement("delete from gas_detalhe where gas_cabecalho_cod_gas_cab=? and inquilino_cod_inq=?");
           // stmt.setInt(1, vo.getCodGas());
            // stmt.setString(2, vo.getCodInquilino());
            stmt.execute();
            stmt.close();

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

    public void carregaViagensNova() {

        PreparedStatement stmt = null;
        ResultSet rset = null;
        ResultSet rset2 = null;
        try {
            ViagensCabVO viagensC = (ViagensCabVO) viagens.getForm1().getVOModel().getValueObject();
            ViagensDetVO viagensD = null;

            String sql = "select viagens.veiculo_vei_placa, viagens.vi_mes_ref "
                    + //  + "inquilino.cod_inq,inquilino.nome_inq, " +
                    //  "inquilino.condominio_cod_cond" +
                    " from viagens where =" + viagensC.getVeiculoVeiPlaca();
            stmt = conn.prepareStatement(sql);
            rset = stmt.executeQuery();

            if (!rset.next()) {
                JOptionPane.showMessageDialog(null, "Mes sem viagens registro de viagens");
            } else {

                rset.beforeFirst();
                while (rset.next()) {

                    viagensD = new ViagensDetVO();
                    viagensD.setViDetCod(viagensC.getViCodCab());
                    viagensD.setViDetVeiculoVeiPlaca(rset.getNString(1));
               //     gasD.setNomeInquilino(rset.getString(2));

                    //tenta pegar a leitura atual do mes anterior e torna-la leitura anterior no mes atual
                    //    sql = "select gd.leitura_atual " +
                    //           "from gas_detalhe gd join gas_cabecalho gc " +
                    //           "on gc.cod_gas_cab = gd.gas_cabecalho_cod_gas_cab " +
                    //                " where gd.inquilino_cod_inq = '" + gasD.getCodInquilino() + "' and " +
                    //                " gc.mes_ano_gas_cab = '" + periodoAnterior(gasC.getMesAno()) + "'";
                    //        stmt = conn.prepareStatement(sql);
                    rset2 = stmt.executeQuery();

                    if (rset2.next()) {
                        //            gasD.setLeituraAnterior(rset2.getDouble(1));
                    } else {
                        //         gasD.setLeituraAnterior(0.0);
                    }

               //     gasD.setConsumoMes(0.0);
                    //      gasD.setLeituraAtual(0.0);
                    //      gasD.setVlrPagamento(0.0);
                    try {
                        insertRecord(viagensD);
                    } catch (Exception ex) {
                        Logger.getLogger(RateioViagensDetalheController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //    gas.getGridControl1().reloadData();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex1) {
            }
        }
    }

    public String periodoAnterior(String periodo) {
        String periodoMes;
        String periodoAno;
        if (periodo.substring(0, 2).equals("01")) {
            periodoMes = "12";
            periodoAno = String.valueOf(Integer.valueOf(periodo.substring(3)) - 1);
        } else {
            periodoMes = String.valueOf(Integer.valueOf(periodo.substring(0, 2)) - 1);
            if (Integer.parseInt(periodoMes) < 10) {
                periodoMes = "0" + periodoMes;
            }
            periodoAno = periodo.substring(3);
        }
        return periodoMes + "/" + periodoAno;
    }

}
