/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jumbo.controller;



import br.com.jumbo.frame.Produto;
import br.com.jumbo.vo.ProdutoVO;
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
public class ProdutoControler extends GridController implements GridDataLocator {

    private Produto grid = null;
    private Connection conn = null;

    public ProdutoControler(Connection conn) {

        this.conn = conn;
        grid = new Produto (conn, this);
        MDIFrame.add(grid, true);

    }

    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        ProdutoVO vo = (ProdutoVO) persistentObject;
          new ProdutoDetalheController(grid, vo.getProId().toString(), conn);
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

            String sql = "select produto.pro_id, produto.pro_nome, produto.pro_und from produto";

            Vector vals = new Vector();

            Map mapa = new HashMap();

            mapa.put("proId", "produto.pro_id");
            mapa.put("proNome", "produto.pro_nome");
            mapa.put("proUnd", "produto.pro_und");
        
            
            
            
            
            if (currentSortedColumns.size() > 0) {
                sql += " order by " + mapa.get(currentSortedColumns.get(0).toString()) + " " + currentSortedVersusColumns.get(0);
            }

            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < vals.size(); i++) {

                stmt.setObject(i + 1, vals.get(i));
            }

            ResultSet rset = stmt.executeQuery();

            ArrayList list = new ArrayList();
            ProdutoVO vo = null;
            while (rset.next()) {

                System.out.println();

                vo = new ProdutoVO();

                vo.setProId(rset.getInt(1));
                vo.setProNome(rset.getString(2));
                vo.setProUnd(rset.getString(3));
              
                
                
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

            stmt = conn.prepareStatement("delete from viagens where cod_vi=? ");

            for (int i = 0; i < persistentObjects.size(); i++) {

                ProdutoVO vo = (ProdutoVO) persistentObjects.get(i);

                stmt.setString(i, vo.getProId().toString());
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
