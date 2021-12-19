/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jumbo.controller;



import br.com.jumbo.vo.LookupViagensCabVO;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.lookup.client.LookupDataLocator;
import org.openswing.swing.message.receive.java.*;
import java.sql.*;
import java.util.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import org.openswing.swing.tree.java.OpenSwingTreeNode;

/**
 *
 * @author Albert Eije
 */
public class RateioViagensLookupController extends LookupController {

    private Connection conn = null;
    public static VOListResponse colaboradorImp;

    public RateioViagensLookupController(Connection conn) {
        this.conn = conn;
        this.setLookupDataLocator(new LookupDataLocator() {

            /**
             * Method called by lookup controller when validating code.
             * @param code code to validate
             * @return code validation response: VOListResponse if code validation has success, ErrorResponse otherwise
             */
            public Response validateCode(String code) {
                Statement stmt = null;
                try {
                    stmt = RateioViagensLookupController.this.conn.createStatement();
                    ResultSet rset = stmt.executeQuery(
                            "select viagens.colaborador_col_id, viagens.colaborador_col_nome, viagens.veiculo_vei_placa from viagens where col_id='" +
                            code + "'");
                    ArrayList list = new ArrayList();
                    while (rset.next()) {
                        LookupViagensCabVO vo = new LookupViagensCabVO();
                        vo.setColId(rset.getInt(1));
                        vo.setColNome(rset.getString(2));
                        vo.setVeiculoVeiPlaca(rset.getString(3));
                    
                        
                        list.add(vo);
                    }
                    if (list.size() > 0) {
                        colaboradorImp = new VOListResponse(list, false, list.size());
                        return colaboradorImp;
                    } else {
                        return new ErrorResponse("Código Inválido!");
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

            /**
             * Method called by lookup controller when user clicks on lookup button.
             * @param action fetching versus: PREVIOUS_BLOCK_ACTION, NEXT_BLOCK_ACTION or LAST_BLOCK_ACTION
             * @param startIndex current index row on grid to use to start fetching data
             * @param filteredColumns filtered columns
             * @param currentSortedColumns sorted columns
             * @param currentSortedVersusColumns ordering versus of sorted columns
             * @param valueObjectType type of value object associated to the lookup grid
             * @return list of value objects to fill in the lookup grid: VOListResponse if data fetching has success, ErrorResponse otherwise
             */
            public Response loadData(
                    int action,
                    int startIndex,
                    Map filteredColumns,
                    ArrayList currentSortedColumns,
                    ArrayList currentSortedVersusColumns,
                    Class valueObjectType) {
                Statement stmt = null;
                try {
                    stmt = RateioViagensLookupController.this.conn.createStatement();
                    ResultSet rset = stmt.executeQuery(
                            "select viagens.colaborador_col_id, viagens.colaborador_col_nome, viagens.veiculo_vei_placa from viagens");
                    ArrayList list = new ArrayList();
                    while (rset.next()) {
                        LookupViagensCabVO vo = new LookupViagensCabVO();

                        vo.setColId(rset.getInt(1));
                        vo.setColNome(rset.getString(2));
                        vo.setVeiculoVeiPlaca(rset.getString(3));
                   
                        

                        list.add(vo);
                    }
                    colaboradorImp = new VOListResponse(list, false, list.size());
                    return colaboradorImp;
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

            /**
             * Method called by the TreePanel to fill the tree.
             * @return a VOReponse containing a DefaultTreeModel object
             */
            public Response getTreeModel(JTree tree) {
                return new VOResponse(new DefaultTreeModel(new OpenSwingTreeNode()));
            }
        });

        this.setLookupValueObjectClassName("br.com.jumbo.vo.LookupViagensCabVO");
        this.addLookup2ParentLink("colId", "colId");
        this.addLookup2ParentLink("veiculoVeiPlaca", "veiculoVeiPlaca");
        this.setAllColumnVisible(true);
    }
}