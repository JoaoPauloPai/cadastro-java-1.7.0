/*
 * The MIT License
 *
 * Copyright 2014 João Paulo Gomes Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * The author may be contacted at: jumbo.vg@hotmail.com</p>
 *
 * João Paulo Gomes Silva
 *
 * JUMBO SISTEMAS
 * Versão 1.0
 */

package br.com.jumbo.controller;


import br.com.jumbo.frame.Cargo;
import br.com.jumbo.vo.CargoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.server.QueryUtil;
import org.openswing.swing.server.UserSessionParameters;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

/**
 *
 * @author vovo
 */
public class CargoController extends GridController implements GridDataLocator{
   
    private Cargo grid = null;
    private Connection conn = null;
    private Cargo cargoFrame = null;
     private String pk = null; 
    
     
       public CargoController(Connection conn) {
        
        this.conn = conn;
         grid = new Cargo(conn, this);
        MDIFrame.add(grid, true);
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
            String sql = "select cores.id_cor, cores.cor, cores.abrev_cor, cores.data from cores ";
            // String sql = "select DEMO3.TEXT,DEMO3.DECNUM,DEMO3.CURRNUM,DEMO3.THEDATE,DEMO3.COMBO,
            //DEMO3.CHECK_BOX,DEMO3.RADIO,DEMO3.CODE,DEMO3_LOOKUP.DESCRCODE,DEMO3.INTNUM from DEMO3,
            //DEMO3_LOOKUP where DEMO3.CODE=DEMO3_LOOKUP.CODE";
            ArrayList vals = new ArrayList();
            HashMap map = new HashMap();

            map.put("idCor", "cores.id_cor");
            map.put("cor", "cores.cor");
            map.put("abrevCor", "cores.abrev_cor");
             map.put("data", "cores.data");

            return QueryUtil.getQuery(
                    conn,
                    sql,
                    vals,
                    map,
                    CargoVO.class,
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
        // CoresVO vo = (CoresVO) newPersistentObject;
        /*
         PreparedStatement stmt = null;
         try {
         stmt = conn.prepareStatement("insert into DEMO3(TEXT,DECNUM,CURRNUM,THEDATE,COMBO,CHECK_BOX,RADIO,CODE) values(?,?,?,?,?,?,?,?)");
         TestVO vo = null;
         for(int i=0;i<newValueObjects.size();i++) {
         vo = (TestVO)newValueObjects.get(i);
         stmt.setObject(6,vo.getCheckValue()==null || !vo.getCheckValue().booleanValue() ? "N":"Y");
         stmt.setString(5,vo.getComboValue());
         stmt.setBigDecimal(3,vo.getCurrencyValue());
         stmt.setDate(4,vo.getDateValue());
         stmt.setBigDecimal(2,vo.getNumericValue());
         stmt.setObject(7,vo.getRadioButtonValue()==null || !vo.getRadioButtonValue().booleanValue() ? "N":"Y");
         stmt.setString(1,vo.getStringValue());
         stmt.setString(8,vo.getLookupValue());
         stmt.execute();
         }
         return new VOListResponse(newValueObjects,false,newValueObjects.size());
         }
         catch (SQLException ex) {
         ex.printStackTrace();
         return new ErrorResponse(ex.getMessage());
         }
         finally {
         try {
         stmt.close();
         conn.commit();
         }
         catch (SQLException ex1) {
         }
         }
         */

        try {
          // private Date data = new Date();
            HashMap map = new HashMap();

            map.put("idCor", "cores.id_cor");
            map.put("cor", "cores.cor");
            map.put("abrevCor", "cores.abrev_cor");
              map.put("data", "cores.data");
            
      //  private     Date data = new Date();
            // coresFrame.reloadData();
                HashSet pk = new HashSet();
        pk.add("idCor");
        
        
       
            return QueryUtil.insertTable(
                    conn,
                   
                    new UserSessionParameters(),
                    newValueObjects,
                    "cores",
                    map,
                    "Y",
                    "N",
                    null,
                    true
                   
            );
        //   coresFrame.reloadData();
           //  return new newValueObjects("cores");
             
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
            CargoVO vo = null;
            CargoVO oldVO = null;
            for (int i = 0; i < persistentObjects.size(); i++) {
                oldVO = (CargoVO) oldPersistentObjects.get(i);
                vo = (CargoVO) persistentObjects.get(i);
                if (oldVO != null) {
                    stmt.setInt(1, vo.getCarId());
                    stmt.setString(2, vo.getCarDescricao());
                    

                    stmt.execute();
                } else {
                    stmt2.setInt(1, vo.getCarId());
                    stmt2.setString(2, vo.getCarDescricao());
                    
                    
    HashSet pk = new HashSet();
        pk.add("carId");
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
            stmt = conn.prepareStatement("delete from cores where id_cor=?");
            for (int i = 0; i < persistentObjects.size(); i++) {
                CargoVO vo = (CargoVO) persistentObjects.get(i);
                stmt.setInt(1, vo.getCarId());
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
