package br.com.jumbo.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.jumbo.frame.Colaborador;
import br.com.jumbo.frame.ColaboradorDetalhe;
import br.com.jumbo.vo.ColaboradorVO;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Joao
 */
public class ColaboradorDetalheController extends FormController {

    private ColaboradorDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private Colaborador colaboradorFrame = null;

    public ColaboradorDetalheController(Colaborador colaboradorFrame, String pk, Connection conn) {
        this.colaboradorFrame = colaboradorFrame;
        this.pk = pk;
        this.conn = conn;

        frame = new ColaboradorDetalhe(conn, this);
        MDIFrame.add(frame);
        if (pk != null) {

            frame.getForm1().setMode(Consts.READONLY);
            frame.getForm1().reload();
        } else {
            frame.getForm1().setMode(Consts.INSERT);

        }

    }

    public Response loadData(Class ValueobjectClass) {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            ResultSet rset = stmt.executeQuery("select colaborador.col_id, colaborador.col_nome, "
                    + "colaborador.veiculo_vei_placa, colaborador.col_end,"
                    + "colaborador.col_bairro, colaborador.col_cidade, colaborador.col_est,"
                    + "colaborador.col_fone1, colaborador.col_fone2, colaborador.col_cpf,"
                    + "colaborador.col_rg, colaborador.veiculo_vei_id from colaborador wherecol_id =" + pk);

            if (rset.next()) {
                ColaboradorVO vo = new ColaboradorVO();

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
            stmt = conn.prepareStatement("insert into colaborador ( col_nome, veiculo_vei_placa,"
                    + "col_end, col_bairro, col_cidade, col_est, col_fone1, col_fone2, col_cpf, col_rg,"
                    + "veiculo_vei_id ) values (?,?,?,?,?,?,?,?,?,?,?)");

            ColaboradorVO vo = (ColaboradorVO) newPersistentObject;

            stmt.setString(1, vo.getColNome());
            stmt.setString(2, vo.getVeiPlaca());
            stmt.setString(3, vo.getColEnd());
            stmt.setString(4, vo.getColBairro());
            stmt.setString(5, vo.getColCidade());
            stmt.setString(6, vo.getColEst());
            stmt.setString(7, vo.getColFone1());
            stmt.setString(8, vo.getColFone2());
            stmt.setString(9, vo.getColCpf());
            stmt.setString(10, vo.getColRg());
            stmt.setInt(11, vo.getVeiId());

            stmt.execute();

            colaboradorFrame.reloadData();
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
            stmt = conn.prepareStatement("update colaborador set col_nome=?, veiculo_vei_placa=?, col_end=?,"
                    + "col_bairro=?, col_cidade=?, col_est=?, col_fone1=?, col_fone2=?, col_cpf=?, col_rg=?,"
                    + "veiculo_vei_id=?  where col_id=?");

            
            
            ColaboradorVO vo = (ColaboradorVO) persistentObject;

     
            stmt.setString(1, vo.getColNome());
            stmt.setString(2, vo.getVeiPlaca());
            stmt.setString(3, vo.getColEnd());
            stmt.setString(4, vo.getColBairro());
            stmt.setString(5, vo.getColCidade());
            stmt.setString(6, vo.getColEst());
            stmt.setString(7, vo.getColFone1());
            stmt.setString(8, vo.getColFone2());
            stmt.setString(9, vo.getColCpf());
            stmt.setString(10, vo.getColRg());
            stmt.setInt(11, vo.getVeiId());
            stmt.setInt(12, vo.getColId());
            
         
            

            stmt.execute();
            colaboradorFrame.reloadData();
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

    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("delete from colaborador where col_id =?");

            ColaboradorVO vo = (ColaboradorVO) persistentObject;
            
            stmt.setInt(1, vo.getColId());
            stmt.execute();
            
            colaboradorFrame.reloadData();
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

}
