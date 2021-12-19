package br.com.jumbo.controller;

import br.com.jumbo.frame.Pessoas;
import br.com.jumbo.vo.PessoasVO;
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
 * Copyright: Copyright (C) 2014 João Paulo</p>
 * <p>
 * </p> @author João Paulo
 *
 * @version 1.7
 */
public class PessoasControler extends GridController implements GridDataLocator {

    private Pessoas grid = null;
    private Connection conn = null;
    private Pessoas pessoasFrame = null;
    private String pk = null;

    public PessoasControler(Connection conn) {
        this.conn = conn;
        grid = new Pessoas(conn, this);
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
            String sql = "select pessoas.pes_id, pessoas.pes_nome, pessoas.pes_sexo, pessoas.pes_end, pessoas.pes_nr,"
                    + "pessoas.pes_bairro, pessoas.pes_cidade, pessoas.pes_est, pessoas.pes_fone1, pessoas.pes_fone2,"
                    + "pessoas.pes_data_nasc, pessoas.pes_cpf, pessoas.pes_rg from pessoas ";

            ArrayList vals = new ArrayList();
            HashMap map = new HashMap();

            map.put("pesId", "pessoas.pes_id");
            map.put("pesNome", "pessoas.pes_nome");
            map.put("pesSexo", "pessoas.pes_sexo");
            map.put("pesEnd", "pessoas.pes_end");
            map.put("pesNr", "pessoas.pes_nr");
            map.put("pesBairro", "pessoas.pes_bairro");
            map.put("pesCidade", "pessoas.pes_cidade");
            map.put("pesEst", "pessoas.pes_est");
            map.put("pesFone1", "pessoas.pes_fone1");
            map.put("pesFone2", "pessoas.pes_fone2");
            map.put("pesDataNasc", "pessoas.pes_data_nasc");
            map.put("pesCpf", "pessoas.pes_cpf");
            map.put("pesRg", "pessoas.pes_rg");

            return QueryUtil.getQuery(
                    conn,
                    sql,
                    vals,
                    map,
                    PessoasVO.class,
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
