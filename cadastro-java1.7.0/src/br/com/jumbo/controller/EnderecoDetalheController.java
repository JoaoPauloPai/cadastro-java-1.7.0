package br.com.jumbo.controller;


import br.com.jumbo.frame.Endereco;
import br.com.jumbo.frame.EnderecoDetalhe;
import br.com.jumbo.vo.EndereçoVO;
import org.openswing.swing.form.client.FormController;

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
public class EnderecoDetalheController extends FormController {

    private EnderecoDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private Endereco enderecoFrame = null;

    public EnderecoDetalheController(Endereco enderecoFrame, String pk, Connection conn) {
        this.enderecoFrame = enderecoFrame;
        this.pk = pk;
        this.conn = conn;

        frame = new EnderecoDetalhe(conn, this);
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

            ResultSet rset = stmt.executeQuery("select endereco.end_id, endereco.end_nome from endereco where end_id =" + pk);

            if (rset.next()) {
                EndereçoVO vo = new EndereçoVO();

                vo.setEndId(rset.getInt(1));
                vo.setEndNome(rset.getString(2));
                
                
                
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
            stmt = conn.prepareStatement("insert into endereco ( endereco.end_nome) values (?)");

            EndereçoVO vo = (EndereçoVO) newPersistentObject;

            stmt.setString(1, vo.getEndNome());
         
            
            
            
            stmt.execute();

            enderecoFrame.reloadData();
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
            stmt = conn.prepareStatement("update viagens set veiculo_vei_placa=?, colaborador_col_nome=?,"
                    + "vi_loc_car=?, vi_loc_des=?, vi_data_car=?, vi_data_des=?, vi_valor_ton=?, vi_peso_total=?,"
                    + "vi_num_nf=?, vi_obs=?, pro_nome=?, colaborador_col_id=?, vi_valor_total=?, vi_mes_ref=?, pro_id=? where cod_vi =?");

            EndereçoVO vo = (EndereçoVO) persistentObject;

            stmt.setString(1, vo.getVeiculoVeiPlaca());
            stmt.setString(2, vo.getColNome());
            stmt.setString(3, vo.getViLocCar());
            stmt.setString(4, vo.getViLocDes());
            stmt.setDate(5, vo.getViDataCar());
            stmt.setDate(6, vo.getViDataDes());
            stmt.setDouble(7, vo.getViValorTon());
            stmt.setDouble(8, vo.getViPesoTotal());
            stmt.setInt(9, vo.getViNumNf());
            stmt.setString(10, vo.getViObs());
            stmt.setString(11, vo.getProNome());
            stmt.setInt(12, vo.getColId());
            stmt.setDouble(13, vo.getViValorTotal());
            stmt.setString(14, vo.getViMesRef());
            stmt.setInt(15, vo.getProId());
            stmt.setInt(16, vo.getCodVi());
          
            
            stmt.execute();
            //viagensFrame.reloadData();
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

    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("delete from viagens where cod_vi =?");

          EndereçoVO vo = (EndereçoVO) persistentObject;
            stmt.setInt(1, vo.getEndId());
            stmt.execute();
            enderecoFrame.reloadData();
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
            String sql = "select endereco.end_id, endereco.end_nome from endereco ";
            // String sql = "select DEMO3.TEXT,DEMO3.DECNUM,DEMO3.CURRNUM,DEMO3.THEDATE,DEMO3.COMBO,
            //DEMO3.CHECK_BOX,DEMO3.RADIO,DEMO3.CODE,DEMO3_LOOKUP.DESCRCODE,DEMO3.INTNUM from DEMO3,
            //DEMO3_LOOKUP where DEMO3.CODE=DEMO3_LOOKUP.CODE";
            ArrayList vals = new ArrayList();
            HashMap map = new HashMap();

            map.put("endId", "endereco.end_id");
            map.put("endNome", "endereco.end_nome");
         
            
            return QueryUtil.getQuery(
                    conn,
                    sql,
                    vals,
                    map,
                    EndereçoVO.class,
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
            // String sql = "select endereco.end_id, endereco.end_nome from endereco ";
            

        
        try {
            HashMap map = new HashMap();

            map.put("endId", "endereco.end_id");
            map.put("endNome", "endereco.end_nome");
         
            
         
            
        
            
       
            return QueryUtil.insertTable(
                    conn,
                   
                    new UserSessionParameters(),
                    newValueObjects,
                    "endereco",
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
        
   
        
}
