package br.com.jumbo.controller;








import br.com.jumbo.vo.PessoasVO;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.lookup.client.LookupDataLocator;
import org.openswing.swing.message.receive.java.*;
import java.sql.*;
import java.util.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.openswing.swing.tree.java.OpenSwingTreeNode;

/**
 * <p>
 * Title: OpenSwing Framework</p>
 * <p>
 * Description: Lookup Controller</p>
 * <p>
 * Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p>
 * </p> @author Mauro Carniel
 *
 * @version 1.0
 */
public class RoupasPessoasLookupController extends LookupController {

    private Connection conn = null;
    // public static VOListResponse veiculoImp;

    public RoupasPessoasLookupController(Connection conn) {
        this.conn = conn;
        this.setLookupDataLocator(new LookupDataLocator() {

            /**
             * Method called by lookup controller when validating code.
             *
             * @param code code to validate
             * @return code validation response: VOListResponse if code
             * validation has success, ErrorResponse otherwise
             */
            public Response validateCode(String code) {
                Statement stmt = null;
                try {
                    stmt = RoupasPessoasLookupController.this.conn.createStatement();
                    ResultSet rset = stmt.executeQuery(
                            "select pessoas.pes_id, pessoas.pes_nome, pessoas.pes_sexo from pessoas where pes_id='"
                            + code + "'");
                    ArrayList list = new ArrayList();
                    while (rset.next()) {
                        PessoasVO vo = new PessoasVO();

                        vo.setPesId(rset.getInt(1));
                        vo.setPesNome(rset.getString(2));
                        vo.setPesSexo(rset.getString(3));
             
                        
                 
                        
                        list.add(vo);
                    }
                    if (list.size() > 0) {
                        return new VOListResponse(list, false, list.size());
                    } else {
                        return new ErrorResponse("O Código do Colaborador é Inválido");
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
             * Method called by lookup controller when user clicks on lookup
             * button.
             *
             * @param action fetching versus: PREVIOUS_BLOCK_ACTION,
             * NEXT_BLOCK_ACTION or LAST_BLOCK_ACTION
             * @param startIndex current index row on grid to use to start
             * fetching data
             * @param filteredColumns filtered columns
             * @param currentSortedColumns sorted columns
             * @param currentSortedVersusColumns ordering versus of sorted
             * columns
             * @param valueObjectType type of value object associated to the
             * lookup grid
             * @return list of value objects to fill in the lookup grid:
             * VOListResponse if data fetching has success, ErrorResponse
             * otherwise
             */
            public Response loadData(
                    int action,
                    int startIndex,
                    Map filteredColumns,
                    ArrayList currentSortedColumns,
                    ArrayList currentSortedVersusColumns,
                    Class valueObjectType
            ) {
                Statement stmt = null;
                try {
                    stmt = RoupasPessoasLookupController.this.conn.createStatement();
                    ResultSet rset = stmt.executeQuery("select pessoas.pes_id, pessoas.pes_nome, pessoas.pes_sexo from pessoas");

                    ArrayList list = new ArrayList();
                    while (rset.next()) {
                        PessoasVO vo = new PessoasVO();

                        vo.setPesId(rset.getInt(1));
                        vo.setPesNome(rset.getString(2));
                        vo.setPesSexo(rset.getString(3));
                        
                   
                        
                        list.add(vo);
                    }
                    return new VOListResponse(list, false, list.size());
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
             *
             * @return a VOReponse containing a DefaultTreeModel object
             */
            public Response getTreeModel(JTree tree) {
                return new VOResponse(new DefaultTreeModel(new OpenSwingTreeNode()));
            }

        });

        this.setLookupValueObjectClassName("br.com.jumbo.vo.PessoasVO");
        this.addLookup2ParentLink("pesId", "pesId");
        this.addLookup2ParentLink("pesNome", "pesNome");
        this.setAllColumnVisible(true);
       
    }

}
