package br.com.jumbo.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.jumbo.frame.Roupas;
import br.com.jumbo.frame.RoupasDetalhe;

import br.com.jumbo.vo.RoupasVO;
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
import org.openswing.swing.message.receive.java.VOListResponse;
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
public class RoupasDetalheController extends FormController {

    private RoupasDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private Roupas roupasFrame = null;

    public RoupasDetalheController(Roupas roupasFrame, String pk, Connection conn) {
        this.roupasFrame = roupasFrame;
        this.pk = pk;
        this.conn = conn;

        frame = new RoupasDetalhe(conn, this);
        MDIFrame.add(frame);
        if (pk != null) {

            frame.getForm1().setMode(Consts.READONLY);
            frame.getForm1().reload();
        } else {
            frame.getForm1().setMode(Consts.INSERT);

        }

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
            String sql = "select roupas.id_roupa, roupas.descricao_roupa, roupas.cor_roupa, "
                    + "roupas.tipo_roupa, roupas.pes_nome, roupas.data_compra, roupas.end_roupa,"
                    + "roupas.obs_roupa, roupas.id_cor, roupas.pes_id, roupas.mod_id from roupas ";
     
            
            ArrayList vals = new ArrayList();
            HashMap map = new HashMap();

            map.put("idRoupa", "roupas.id_roupa");
            map.put("modDescricao", "roupas.descricao_roupa");
            map.put("cor", "roupas.cor_roupa");
            map.put("tipoRoupa", "roupas.tipo_roupa");
            map.put("pesNome", "roupas.pes_nome");
            map.put("dataCompra", "roupas.data_compra");
            map.put("endRoupa", "roupas.end_roupa");
            map.put("obsRoupa", "roupas.obs_roupa");
            map.put("idCor", "roupas.id_cor");
            map.put("pesId", "roupas.pes_id");
            map.put("modId", "roupas.mod_id");
                    

            return QueryUtil.getQuery(
                    conn,
                    sql,
                    vals,
                    map,
                    RoupasVO.class,
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


            
            map.put("idRoupa", "roupas.id_roupa");
            map.put("modDescricao", "roupas.descricao_roupa");
            map.put("cor", "roupas.cor_roupa");
            map.put("tipoRoupa", "roupas.tipo_roupa");
            map.put("pesNome", "roupas.pes_nome");
            map.put("dataCompra", "roupas.data_compra");
            map.put("endRoupa", "roupas.end_roupa");
            map.put("obsRoupa", "roupas.obs_roupa");
            map.put("idCor", "roupas.id_cor");
            map.put("pesId", "roupas.pes_id");
            map.put("modId", "roupas.mod_id");
            

            
                    
            
                HashSet pk = new HashSet();
        pk.add("idRoupa");
       
            return QueryUtil.insertTable(
                    conn,
                   
                    new UserSessionParameters(),
                    newValueObjects,
                    "roupas",
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

    
        
    /**
     * Method invoked when the user has clicked on save button and the grid is
     * in INSERT mode.
     *
     * @param rowNumbers row indexes related to the new rows to save
     * @param newValueObjects list of new value objects to save
     * @return an ErrorResponse value object in case of errors, VOListResponse
     * if the operation is successfully completed
     */
 
    
 
        
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
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = conn.prepareStatement("update cores set  cor=?, abrev_cor=? where id_cor=?");
            stmt2 = conn.prepareStatement("insert into cores ( cor, abrev_cor ) values(?,?)");
            RoupasVO vo = null;
            RoupasVO oldVO = null;
            for (int i = 0; i < persistentObjects.size(); i++) {
                oldVO = (RoupasVO) oldPersistentObjects.get(i);
                vo = (RoupasVO) persistentObjects.get(i);
                if (oldVO != null) {
                   // stmt.setInt(1, vo.getIdCor());
                   // stmt.setString(2, vo.getCor());
                   // stmt.setString(3, vo.getAbrevCor());

                    stmt.execute();
                } else {
                  //  stmt2.setInt(1, vo.getIdCor());
                  //  stmt2.setString(2, vo.getCor());
                   // stmt2.setString(3, vo.getAbrevCor());
                    
    HashSet pk = new HashSet();
        pk.add("idCor");
                    stmt2.execute();
                }

            }
            return new VOListResponse(persistentObjects, false, persistentObjects.size());
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                stmt.close();
                stmt2.close();
                conn.commit();
            } catch (SQLException ex1) {
            }
        }

    }

    /**
     * Method invoked when the user has clicked on delete button and the grid is
     * in READONLY mode.
     *
     * @param persistentObjects value objects to delete (related to the
     * currently selected rows)
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from roupas where id_roupa=?");
            for (int i = 0; i < persistentObjects.size(); i++) {
                RoupasVO vo = (RoupasVO) persistentObjects.get(i);
                stmt.setInt(1, vo.getIdRoupa());
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

    /**
     * Method invoked when the user has clicked on save button and the grid is
     * in INSERT mode.
     *
     * @param rowNumbers row indexes related to the new rows to save
     * @param newValueObjects list of new value objects to save
     * @return an ErrorResponse value object in case of errors, VOListResponse
     * if the operation is successfully completed
     */
  
/*  código todo comentado
    public Response loadData(Class ValueobjectClass) {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            ResultSet rset = stmt.executeQuery("select colaborador.col_id, colaborador.col_nome, "
                    + "colaborador.veiculo_vei_placa, colaborador.col_end,"
                    + "colaborador.col_bairro, colaborador.col_cidade, colaborador.col_est,"
                    + "colaborador.col_fone1, colaborador.col_fone2, colaborador.col_cpf,"
                    + "colaborador.col_rg, colaborador.veiculo_vei_id from colaborador wherecol_id =" + pk);

            if (rset.next()) {
                ColaboradorVO vo = new ColaboradorVO();

                vo.setColId(rset.getInt(1));
                vo.setColNome(rset.getString(2));
                vo.setVeiPlaca(rset.getString(3));
                vo.setColEnd(rset.getString(4));
                vo.setColBairro(rset.getString(5));
                vo.setColCidade(rset.getString(6));
                vo.setColEst(rset.getString(7));
                vo.setColFone1(rset.getString(8));
                vo.setColFone2(rset.getString(9));
                vo.setColCpf(rset.getString(10));
                vo.setColRg(rset.getString(11));
                vo.setVeiId(rset.getInt(12));

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

    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into colaborador ( col_nome, veiculo_vei_placa,"
                    + "col_end, col_bairro, col_cidade, col_est, col_fone1, col_fone2, col_cpf, col_rg,"
                    + "veiculo_vei_id ) values (?,?,?,?,?,?,?,?,?,?,?)");

            ColaboradorVO vo = (ColaboradorVO) newPersistentObject;

            stmt.setString(1, vo.getColNome());
            stmt.setString(2, vo.getVeiPlaca());
            stmt.setString(3, vo.getColEnd());
            stmt.setString(4, vo.getColBairro());
            stmt.setString(5, vo.getColCidade());
            stmt.setString(6, vo.getColEst());
            stmt.setString(7, vo.getColFone1());
            stmt.setString(8, vo.getColFone2());
            stmt.setString(9, vo.getColCpf());
            stmt.setString(10, vo.getColRg());
            stmt.setInt(11, vo.getVeiId());

            stmt.execute();

            colaboradorFrame.reloadData();
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

    public Response updateRecord(ValueObject oldPersistentObject,
            ValueObject persistentObject) {

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("update colaborador set col_nome=?, veiculo_vei_placa=?, col_end=?,"
                    + "col_bairro=?, col_cidade=?, col_est=?, col_fone1=?, col_fone2=?, col_cpf=?, col_rg=?,"
                    + "veiculo_vei_id=?  where col_id=?");

            
            
            ColaboradorVO vo = (ColaboradorVO) persistentObject;

     
            stmt.setString(1, vo.getColNome());
            stmt.setString(2, vo.getVeiPlaca());
            stmt.setString(3, vo.getColEnd());
            stmt.setString(4, vo.getColBairro());
            stmt.setString(5, vo.getColCidade());
            stmt.setString(6, vo.getColEst());
            stmt.setString(7, vo.getColFone1());
            stmt.setString(8, vo.getColFone2());
            stmt.setString(9, vo.getColCpf());
            stmt.setString(10, vo.getColRg());
            stmt.setInt(11, vo.getVeiId());
            stmt.setInt(12, vo.getColId());
            
         
            

            stmt.execute();
            colaboradorFrame.reloadData();
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

    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("delete from colaborador where col_id =?");

            ColaboradorVO vo = (ColaboradorVO) persistentObject;
            
            stmt.setInt(1, vo.getColId());
            stmt.execute();
            
            colaboradorFrame.reloadData();
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
