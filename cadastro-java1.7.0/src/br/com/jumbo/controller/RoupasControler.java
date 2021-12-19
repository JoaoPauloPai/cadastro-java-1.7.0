package br.com.jumbo.controller;




import br.com.jumbo.frame.Roupas;
import br.com.jumbo.vo.RoupasVO;
import org.openswing.swing.table.client.GridController;
import java.util.*;
import org.openswing.swing.message.receive.java.*;
import java.sql.*;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.server.QueryUtil;
import org.openswing.swing.server.UserSessionParameters;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.util.java.Consts;

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
public class RoupasControler extends GridController implements GridDataLocator {

    private Roupas grid = null;
    private Connection conn = null;
    private Roupas roupasFrame = null;
     private String pk = null;

     
    public RoupasControler(Connection conn) {
        this.conn = conn;
         grid = new Roupas(conn, this);
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
  
    
}
