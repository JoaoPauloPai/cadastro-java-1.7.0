package br.com.jumbo.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.jumbo.frame.Pessoas;
import br.com.jumbo.frame.PessoasDetalhe;

import br.com.jumbo.vo.PessoasVO;
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
public class PessoasDetalheController extends FormController {

    private PessoasDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private Pessoas pessoasFrame = null;

    public PessoasDetalheController(Pessoas pessoasFrame, String pk, Connection conn) {
        this.pessoasFrame = pessoasFrame;
        this.pk = pk;
        this.conn = conn;

        frame = new PessoasDetalhe(conn, this);
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

            ResultSet rset = stmt.executeQuery(" select pessoas.pes_id, pessoas.pes_nome, pessoas.pes_sexo,"
                    + "pessoas.pes_end, pessoas.pes_nr, pessoas.pes_bairro, pessoas.pes_cidade,"
                    + "pessoas.pes_est, pessoas.pes_fone1, pessoas.pes_fone2, pessoas.pes_data_nasc, pessoas.pes_cpf,"
                    + "pessoas.pes_rg from pessoas where pes_id =" + pk);

            if (rset.next()) {
                PessoasVO vo = new PessoasVO();

                vo.setPesId(rset.getInt(1));
                vo.setPesNome(rset.getString(2));
                vo.setPesSexo(rset.getString(3));
                vo.setPesEnd(rset.getString(4));
                vo.setPesNr(rset.getInt(5));
                vo.setPesBairro(rset.getString(6));
                vo.setPesCidade(rset.getString(7));
                vo.setPesEst(rset.getString(8));
                vo.setPesFone1(rset.getString(9));
                vo.setPesFone2(rset.getString(10));
                vo.setPesDataNasc(rset.getString(11));
                vo.setPesCpf(rset.getString(12));
                vo.setPesRg(rset.getString(13));

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
            stmt = conn.prepareStatement("insert into pessoas ( pessoas.pes_nome, pessoas.pes_sexo,"
                    + "pessoas.pes_end, pessoas.pes_nr, pessoas.pes_bairro, pessoas.pes_cidade,"
                    + "pessoas.pes_est, pessoas.pes_fone1, pessoas.pes_fone2, pessoas.pes_data_nasc, pessoas.pes_cpf,"
                    + "pessoas.pes_rg ) values (?,?,?,?,?,?,?,?,?,?,?,?)");

            PessoasVO vo = (PessoasVO) newPersistentObject;

            stmt.setString(1, vo.getPesNome());
            stmt.setString(2, vo.getPesSexo());
            stmt.setString(3, vo.getPesEnd());
            stmt.setInt(4, vo.getPesNr());
            stmt.setString(5, vo.getPesBairro());
            stmt.setString(6, vo.getPesCidade());
            stmt.setString(7, vo.getPesEst());
            stmt.setString(8, vo.getPesFone1());
            stmt.setString(9, vo.getPesFone2());
            stmt.setString(10, vo.getPesDataNasc());
            stmt.setString(11, vo.getPesCpf());
            stmt.setString(12, vo.getPesRg());

            stmt.execute();

            pessoasFrame.reloadData();
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

            PessoasVO vo = (PessoasVO) persistentObject;

            // stmt.setString(1, vo.getColNome());
            stmt.execute();
            pessoasFrame.reloadData();
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
            stmt = conn.prepareStatement("delete from pessoas where pes_id =?");

            PessoasVO vo = (PessoasVO) persistentObject;

            stmt.setInt(1, vo.getPesId());
            stmt.execute();

            pessoasFrame.reloadData();
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
