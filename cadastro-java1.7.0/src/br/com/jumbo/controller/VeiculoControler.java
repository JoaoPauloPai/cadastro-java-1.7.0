/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jumbo.controller;

import br.com.jumbo.frame.Veiculo;
import br.com.jumbo.vo.VeiculoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.FilterWhereClause;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

/**
 *
 * @author Joao
 */
public class VeiculoControler extends GridController implements GridDataLocator {

   
    private Veiculo grid = null;
    private Connection conn = null;
    
    public VeiculoControler(Connection conn) {
        
        this.conn = conn;
        grid = new Veiculo(conn, this);
        MDIFrame.add(grid, true);
        
    }
    
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        VeiculoVO vo = (VeiculoVO) persistentObject;
        new VeiculoDetalheController(grid, vo.getVeiId().toString(), conn);
    }
    
    public Response loadData(
            int action,
            int startIndex,
            Map filteredColumns,
            ArrayList currentSortedColumns,
            ArrayList currentSortedVersusColumns,
            Class valueObjectType,
            Map otherGridParams) {
        PreparedStatement stmt = null;
        
        try {
            
            String sql = "select veiculo.vei_id, veiculo.vei_marca, veiculo.vei_mod,"
                    + "veiculo.vei_ano, veiculo.vei_cor, veiculo.vei_km,"
                    + "veiculo.vei_placa, veiculo.vei_data from veiculo";
            
            Vector vals = new Vector();
            
            Map mapa = new HashMap();
            
            mapa.put("veiId", "veiculo.vei_id");
            mapa.put("veiMarca", "veiculo.vei_marca");
            mapa.put("veiMod", "veiculo.vei_mod");
            mapa.put("veiAno", "veiculo.vei_ano");
            mapa.put("veiCor", "veiculo.vei_cor");
            mapa.put("veiKm", "veiculo.vei_km");
            mapa.put("veiPlaca", "veiculo.vei_placa");
            mapa.put("veiData", "veiculo.vei_data");
            
            if (filteredColumns.size() > 0) {
                FilterWhereClause[] filtro = (FilterWhereClause[]) filteredColumns.get("veiMod");
                sql += " where veiculo.vei_mod" + filtro[0].getOperator() + "?";
                vals.add(filtro[0].getValue());
           
            }
              
            
            if (currentSortedColumns.size() > 0) {
                sql += " order by " + mapa.get(currentSortedColumns.get(0).toString()) + " " + currentSortedVersusColumns.get(0);
            }
           
            stmt = conn.prepareStatement(sql);
            
            for (int i = 0; i < vals.size(); i++) {
                
                stmt.setObject(i + 1, vals.get(i));
            }
            
            ResultSet rset = stmt.executeQuery();
            
            ArrayList list = new ArrayList();
            VeiculoVO vo = null;
            while (rset.next()) {
                
                System.out.println();
                
                vo = new VeiculoVO();
                
                vo.setVeiId(rset.getInt(1));
                vo.setVeiMarca(rset.getString(2));
                vo.setVeiMod(rset.getString(3));
                vo.setVeiAno(rset.getInt(4));
                vo.setVeiCor(rset.getString(5));
                vo.setVeiKm(rset.getInt(6));
                vo.setVeiPlaca(rset.getString(7));
                vo.setVeiData(rset.getDate(8));
                list.add(vo);
            }
            
            return new VOListResponse(list, false, list.size());
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
    
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        PreparedStatement stmt = null;
        try {
            
            stmt = conn.prepareStatement("delete from veiculo where vei_id=?");
            
            for (int i = 0; i < persistentObjects.size(); i++) {
                
                VeiculoVO vo = (VeiculoVO) persistentObjects.get(i);
                
                stmt.setString(1, vo.getVeiId().toString());
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
}
