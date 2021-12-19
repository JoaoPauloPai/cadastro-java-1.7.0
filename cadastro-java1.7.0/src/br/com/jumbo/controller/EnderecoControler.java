package br.com.jumbo.controller;



import br.com.jumbo.frame.Endereco;
import br.com.jumbo.vo.EndereçoVO;
import org.openswing.swing.table.client.GridController;
import java.util.*;
import org.openswing.swing.message.receive.java.*;
import java.sql.*;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.server.QueryUtil;
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
 *
 * @version 1.0
 */
public class EnderecoControler extends GridController implements GridDataLocator {

    private Endereco grid = null;
    private Connection conn = null;
    private Endereco enderecoFrame = null;
    private String pk = null;

    public EnderecoControler(Connection conn) {
        this.conn = conn;
        grid = new Endereco(conn, this);
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
            String sql = "select endereco.end_id, endereco.end_nome from endereco ";

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

}
