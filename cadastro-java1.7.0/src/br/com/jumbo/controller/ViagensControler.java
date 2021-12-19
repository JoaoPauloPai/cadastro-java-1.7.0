/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jumbo.controller;

import br.com.jumbo.frame.Viagens;
import br.com.jumbo.vo.ViagensVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.server.QueryUtil;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

/**
 *
 * @author Joao
 */
public class ViagensControler extends GridController implements GridDataLocator {

    private Viagens grid = null;
    private Connection conn = null;
     private Viagens viagensFrame = null;

    public ViagensControler(Connection conn) {

        this.conn = conn;
        grid = new Viagens(conn, this);
        MDIFrame.add(grid, true);

    }

    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        ViagensVO vo = (ViagensVO) persistentObject;
        new ViagensDetalheController(grid, vo.getCodVi().toString(), conn);

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
    public Response loadData(
            int action,
            int startIndex,
            Map filteredColumns,
            ArrayList currentSortedColumns,
            ArrayList currentSortedVersusColumns,
            Class valueObjectType,
            Map otherGridParams) {
        try {
            String sql = "select viagens.cod_vi, viagens.veiculo_vei_placa, viagens.colaborador_col_nome,"
                    + "viagens.vi_loc_car, viagens.vi_loc_des, viagens.vi_data_car, viagens.vi_data_des,"
                    + "viagens.vi_valor_ton, viagens.vi_peso_total, viagens.vi_num_nf,"
                    + "viagens.vi_obs, viagens.pro_nome, viagens.colaborador_col_id, viagens.vi_valor_total,"
                    + " viagens.vi_mes_ref,viagens.pro_id from viagens ";

            ArrayList vals = new ArrayList();
            HashMap map = new HashMap();

            map.put("codVi", "viagens.cod_vi");
            map.put("veiculoVeiPlaca", "viagens.veiculo_vei_placa");
            map.put("colNome", "viagens.colaborador_col_nome");
            map.put("viLocCar", "viagens.vi_loc_car");
            map.put("viLocDes", "viagens.vi_loc_des");
            map.put("viDataCar", "viagens.vi_data_car");
            map.put("viDataDes", "viagens.vi_data_des");
            map.put("viValorTon", "viagens.vi_valor_ton");
            map.put("viPesoTotal", "viagens.vi_peso_total");
            map.put("viNumNf", "viagens.vi_num_nf");
            map.put("viObs", "viagens.vi_obs");
            map.put("proNome", "viagens.pro_nome");
            map.put("colId", "viagens.colaborador_col_id");
            map.put("viValorTotal", "viagens.vi_valor_total");
            map.put("viMesRef", "viagens.vi_mes_ref");
            map.put("proId", "viagens.pro_id");
           // map.put("viData", "viagens.vi_data");
            
            return QueryUtil.getQuery(
                    conn,
                    sql,
                    vals,
                    map,
                    ViagensVO.class,
                    "Y",
                    "N",
                    new GridParams(
                            action,
                            startIndex,
                            filteredColumns,
                            currentSortedColumns,
                            currentSortedVersusColumns,
                            new HashMap()
                    ),
                    true
            );

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        }
    }
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        PreparedStatement stmt = null;
        try {
            
            stmt = conn.prepareStatement("delete from veiculo where vei_id=?");
            
            for (int i = 0; i < persistentObjects.size(); i++) {
                
                ViagensVO vo = (ViagensVO) persistentObjects.get(i);
                
                stmt.setInt(1, vo.getCodVi().intValue());
                
                stmt.execute();
                
            }
            return new VOResponse(new Boolean(true));
            
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
    /*
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("delete from viagens where cod_vi =?");

            ViagensVO vo = (ViagensVO) persistentObject;
            stmt.setInt(1, vo.getCodVi());
            stmt.execute();
            //JOptionPane.showMessageDialog(null, "Os dados foram excluídos com susseso!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            viagensFrame.reloadData();
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

    */
}
