package br.com.jumbo.controller;

import br.com.jumbo.frame.Cargo;
import br.com.jumbo.vo.CargoVO;
import br.com.jumbo.vo.CoresVO;
import org.openswing.swing.table.client.GridController;
import java.util.*;
import org.openswing.swing.message.receive.java.*;
import java.sql.*;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.server.QueryUtil;
import org.openswing.swing.server.UserSessionParameters;
import org.openswing.swing.message.send.java.GridParams;

/**
 * <p>
 * Title: OpenSwing Framework</p>
 * <p>
 * Description: Grid controller.</p>
 * <p>
 * Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p>
 * </p> @author Mauro Carniel
 * @version 1.0
 */
public class CargoControler1 extends GridController implements GridDataLocator {

    
    private Cargo grid = null;
    private Connection conn = null;
    private Cargo cargoFrame = null;
     private String pk = null;
   //  private Date data = new Date();
/*
    public CoresControler(  String pk, Connection conn) {
        
        this.pk = pk;
        this.conn = conn;
        grid = new Cores(conn, this);
        MDIFrame.add(grid, true);
         if (pk != null){
                   grid.getGridControl1().setMode(Consts.READONLY);
            grid.getGridControl1().reloadData();
        } else {
            grid.getGridControl1().setMode(Consts.INSERT);

        }
    }
*/
    public CargoControler1(Connection conn) {
        
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
            String sql = "select cargo.car_id, cargo.car_descricao from cargo ";
            // String sql = "select DEMO3.TEXT,DEMO3.DECNUM,DEMO3.CURRNUM,DEMO3.THEDATE,DEMO3.COMBO,
            //DEMO3.CHECK_BOX,DEMO3.RADIO,DEMO3.CODE,DEMO3_LOOKUP.DESCRCODE,DEMO3.INTNUM from DEMO3,
            //DEMO3_LOOKUP where DEMO3.CODE=DEMO3_LOOKUP.CODE";
            ArrayList vals = new ArrayList();
            HashMap map = new HashMap();

            map.put("carId", "cargo.car_id");
            map.put("carDescricao", "cargo.car_descricao");
         
            

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
      //   CargoVO vo = (CargoVO) newPersistentObject;
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
            CoresVO vo = null;
            CoresVO oldVO = null;
            for (int i = 0; i < persistentObjects.size(); i++) {
                oldVO = (CoresVO) oldPersistentObjects.get(i);
                vo = (CoresVO) persistentObjects.get(i);
                if (oldVO != null) {
                    stmt.setInt(1, vo.getIdCor());
                    stmt.setString(2, vo.getCor());
                    stmt.setString(3, vo.getAbrevCor());

                    stmt.execute();
                } else {
                    stmt2.setInt(1, vo.getIdCor());
                    stmt2.setString(2, vo.getCor());
                    stmt2.setString(3, vo.getAbrevCor());
                    
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
            stmt = conn.prepareStatement("delete from cores where id_cor=?");
            for (int i = 0; i < persistentObjects.size(); i++) {
                CoresVO vo = (CoresVO) persistentObjects.get(i);
                stmt.setInt(1, vo.getIdCor());
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
    // Comentei todo esse código
/*
     private ImageIcon getButtonIcon(Boolean checkValue) {
     if (checkValue!=null && checkValue.booleanValue())
     return new ImageIcon(ClientUtils.getImage("chiuso.gif"));
     else
     return new ImageIcon(ClientUtils.getImage("aperto.gif"));

     }


     /**
     * Callback method invoked each time a cell is edited: this method define if the new value is valid.
     * This method is invoked ONLY if:
     * - the edited value is not equals to the old value OR it has exmplicitely called setCellAt or setValueAt
     * - the cell is editable
     * Default behaviour: cell value is valid.
     * @param rowNumber selected row index
     * @param attributeName attribute name related to the column currently selected
     * @param oldValue old cell value (before cell editing)
     * @param newValue new cell value (just edited)
     * @return <code>true</code> if cell value is valid, <code>false</code> otherwise
     */
    /*
     public boolean validateCell(int rowNumber,String attributeName,Object oldValue,Object newValue) {
     if (attributeName.equals("checkValue")) {
     CoresVO vo = (TestVO)grid.getGrid().getVOListTableModel().getObjectForRow(rowNumber);
     vo.setButton( getButtonIcon((Boolean)newValue) );
     }
     return true;
     }


     /**
     * @param grid grid
     * @param row selected row index
     * @param attributeName attribute name that identifies the selected grid column
     * @return <code>true</code> if the selected cell is editable, <code>false</code> otherwise
     */
    /*
     public boolean isCellEditable(GridControl grid,int row,String attributeName) {
     TestVO vo = (TestVO)grid.getVOListTableModel().getObjectForRow(row);
     if (attributeName.equals("button") && "O".equals(vo.getComboValue())) {
     return false;
     }
     return grid.isFieldEditable(row,attributeName);
     }


     /**
     * Method used to define the background color for each cell of the grid.
     * @param rowNumber selected row index
     * @param attributeName attribute name related to the column currently selected
     * @param value object contained in the selected cell
     * @return background color of the selected cell
     */
    /*
     public Color getBackgroundColor(int row,String attributeName,Object value) {
     if (attributeName.equals("button"))
     return new Color(200,200,220);
     return super.getBackgroundColor(row,attributeName,value);
     }



     */
 // private  Date data = new Date();
}



