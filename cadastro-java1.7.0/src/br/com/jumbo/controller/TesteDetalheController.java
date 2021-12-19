package br.com.jumbo.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import br.com.jumbo.frame.Cores;
import br.com.jumbo.frame.TesteDetalhe;

import br.com.jumbo.vo.TestesVO;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.server.QueryUtil;
import org.openswing.swing.server.UserSessionParameters;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Joao
 */
public class TesteDetalheController extends FormController {

    private TesteDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private Cores CoresFrame = null;

    public TesteDetalheController(Cores coresFrame, String pk, Connection conn) {
        this.CoresFrame = coresFrame;
        this.pk = pk;
        this.conn = conn;

        frame = new TesteDetalhe(conn, this);
        MDIFrame.add(frame);
        if (pk != null) {

           frame.getForm1().setMode(Consts.READONLY);
            frame.getForm1().reload();
        } else {
            frame.getForm1().setMode(Consts.INSERT);

        }

    }

 
    /*
    public Response loadData(Class ValueobjectClass) {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            
            ResultSet rset = stmt.executeQuery("Select testes.id_teste,"
                    + "testes.id_cor, testes.cor from testes where id_teste =" + pk);

            if (rset.next()) {
                TestesVO vo = new TestesVO();
    
                vo.setIdTeste(rset.getInt(1));
                vo.setIdCor(rset.getInt(2));
                vo.setCor(rset.getString(3));
             
                
             
                
                
                return new VOResponse(vo);
            } else {
                return new ErrorResponse("Nenhum registro encontrado.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());

        } finally {
            try {
                stmt.close();
            } catch (SQLException ex1) {

            }
        }

    } 
    
    */
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
            String sql = "select testes.id_teste, testes.id_cor, testes.cor from testes";
     
            
            ArrayList vals = new ArrayList();
            HashMap map = new HashMap();

            map.put("idTeste", "testes.id_teste");
            map.put("idCor", "testes.id_cor");
            map.put("cor", "testes.cor");

            return QueryUtil.getQuery(
                    conn,
                    sql,
                    vals,
                    map,
                    TestesVO.class,
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

    /**
     * Method invoked when the user has clicked on save button and the grid is
     * in INSERT mode.
     *
     * @param rowNumbers row indexes related to the new rows to save
     * @param newValueObjects list of new value objects to save
     * @return an ErrorResponse value object in case of errors, VOListResponse
     * if the operation is successfully completed
     */
    
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {

        
        try {
            HashMap map = new HashMap();

            map.put("idTeste", "testes.id_teste");
            map.put("idCor", "testes.id_cor");
            map.put("cor", "testes.cor");
            
            
              //  HashSet pk = new HashSet();
      //  pk.add("idTeste");
       
            return QueryUtil.insertTable(
                    conn,
                   
                    new UserSessionParameters(),
                    newValueObjects,
                    "testes",
                    map,
                    "Y",
                    "N",
                    null,
                    true
                   
            );
      
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                conn.commit();
            } catch (SQLException ex1) {
            }
        }

    }
    
    /*
    

    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into testes ( id_cor, cor) values (?,?)");
              
            

            TestesVO vo = (TestesVO) newPersistentObject;
    
           stmt.setInt(1, vo.getIdCor());
            stmt.setString(2, vo.getCor());
        
            
            
            stmt.execute();
           
          // coresFrame.reloadData();
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
