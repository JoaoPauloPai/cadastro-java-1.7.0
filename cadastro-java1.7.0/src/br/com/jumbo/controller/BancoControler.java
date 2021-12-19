package br.com.jumbo.controller;

import br.com.jumbo.frame.Banco;
import br.com.jumbo.vo.BancoVO;
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
public class BancoControler extends GridController implements GridDataLocator {

    private Banco grid = null;
    private Connection conn = null;
    private Banco bancoFrame = null;
    private String pk = null;

    public BancoControler(Connection conn) {
        this.conn = conn;
        grid = new Banco(conn, this);
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
            String sql = "select banco.cod_banco, banco.cod_compensacao, banco.nome_banco, banco.site_banco from banco ";

            ArrayList vals = new ArrayList();
            HashMap map = new HashMap();

            map.put("codBanco", "banco.cod_banco");
            map.put("codCompensacao", "banco.cod_compensacao");
            map.put("nomeBanco", "banco.nome_banco");
            map.put("siteBanco", "banco.site_banco");

            return QueryUtil.getQuery(
                    conn,
                    sql,
                    vals,
                    map,
                    BancoVO.class,
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
