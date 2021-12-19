/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jumbo.controller;

import br.com.jumbo.frame.Colaborador;
import br.com.jumbo.vo.ColaboradorVO;
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
public class ColaboradorControler extends GridController implements GridDataLocator {

    private Colaborador grid = null;
    private Connection conn = null;

    public ColaboradorControler(Connection conn) {

        this.conn = conn;
        grid = new Colaborador(conn, this);
        MDIFrame.add(grid, true);

    }

    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        ColaboradorVO vo = (ColaboradorVO) persistentObject;
        new ColaboradorDetalheController(grid, vo.getVeiId().toString(), conn);
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

            String sql = "select colaborador.col_id, colaborador.col_nome, "
                    + "colaborador.veiculo_vei_placa, colaborador.col_end,"
                    + "colaborador.col_bairro, colaborador.col_cidade, colaborador.col_est,"
                    + "colaborador.col_fone1, colaborador.col_fone2, colaborador.col_cpf,"
                    + "colaborador.col_rg, colaborador.veiculo_vei_id from colaborador ";
                

            

            Vector vals = new Vector();

            Map mapa = new HashMap();

            mapa.put("colId", "colaborador.col_id");
            mapa.put("colNome", "colaborador.col_nome");
            mapa.put("veiPlaca", "colaborador.veiculo_vei_placa");
            mapa.put("colEnd", "colaborador.col_end");
            mapa.put("colBairro", "colaborador.col_bairro");
            mapa.put("colCidade", "colaborador.col_cidade");
            mapa.put("colEst", "colaborador.col_est");
            mapa.put("colFone1", "colaborador.col_fone1");
            mapa.put("colFone2", "colaborador.col_fone2");
            mapa.put("colCpf", "colaborador.col_cpf");
            mapa.put("colRg", "colaborador.col_rg");
            mapa.put("veiId", "colaborador.veiculo_vei_id");
 

            if (filteredColumns.size() > 0) {
                FilterWhereClause[] filtro = (FilterWhereClause[]) filteredColumns.get("veiPlaca");
                sql += " where colaborador.veiculo_vei_placa" + filtro[0].getOperator() + "?";
                vals.add(filtro[0].getValue());
            }
            if (currentSortedColumns.size() > 0) {
                sql += " order by " + mapa.get(currentSortedColumns.get(0).toString()) + " " + currentSortedVersusColumns.get(0);
            }

            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < vals.size(); i++) {

                stmt.setObject(i + 1, vals.get(i));
            }

            ResultSet rset = stmt.executeQuery();

            ArrayList list = new ArrayList();
            ColaboradorVO vo = null;
            while (rset.next()) {

                System.out.println();

                vo = new ColaboradorVO();

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

            stmt = conn.prepareStatement("delete from colaborador where col_id=? ");

            for (int i = 0; i < persistentObjects.size(); i++) {

                ColaboradorVO vo = (ColaboradorVO) persistentObjects.get(i);

                stmt.setString(i, vo.getVeiId().toString());
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
