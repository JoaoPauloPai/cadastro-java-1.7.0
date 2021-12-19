package br.com.jumbo.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.com.jumbo.frame.FuncoesDetalhe;
import br.com.jumbo.frame.Veiculo;
import br.com.jumbo.frame.VeiculoDetalhe;
import br.com.jumbo.vo.FuncoesVO;

import br.com.jumbo.vo.VeiculoVO;
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
public class FuncoesDetalheController extends FormController {

    private FuncoesDetalhe grid = null;
    private VeiculoDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private FuncoesDetalhe funcoesFrame = null;
    
       public FuncoesDetalheController(Connection conn) {

        this.conn = conn;
        grid = new FuncoesDetalhe(conn, this);
        MDIFrame.add(grid, true);

    }

    public FuncoesDetalheController(FuncoesDetalhe funcoesFrame, String pk, Connection conn) {
        this.funcoesFrame = funcoesFrame;
        this.pk = pk;
        this.conn = conn;

      //  frame = new FuncoesDetalhe(conn, this);
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
            
            ResultSet rset = stmt.executeQuery("Select funcoes.fun_id,"
                    + "funcoes.fun_descricao from funcoes where fun_id =" + pk);

            if (rset.next()) {
                FuncoesVO vo = new FuncoesVO();
    
                vo.setIdFuncoes(rset.getInt(1));
                vo.setFunDescricao(rset.getString(2));
            
                
                
                
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
            stmt = conn.prepareStatement("insert into funcoes (fun_descricao) values (?)");
              
            

            FuncoesVO vo = (FuncoesVO) newPersistentObject;
    
            stmt.setString(1, vo.getFunDescricao());
         
            
            
            stmt.execute();
           
         //   veiculoFrame.reloadData();
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
            stmt = conn.prepareStatement("update veiculo set =?, vei_mod=?,"
                    + "vei_ano=?, vei_cor=?, vei_km=?, vei_placa=?, vei_data=? where vei_id=?");

            VeiculoVO vo = (VeiculoVO) persistentObject;

            
           
            
            stmt.setString(1, vo.getVeiMarca());
            stmt.setString(2, vo.getVeiMod());
            stmt.setInt(3, vo.getVeiAno());
            stmt.setString(4, vo.getVeiCor());
            stmt.setInt(5, vo.getVeiKm());
            stmt.setString(6, vo.getVeiPlaca());
            stmt.setDate(7, vo.getVeiData());
            stmt.setInt(8, vo.getVeiId());
     
            
            
            stmt.execute();
          //  veiculoFrame.reloadData();
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
            stmt = conn.prepareStatement("delete from veiculo where vei_id =?");

            VeiculoVO vo = (VeiculoVO) persistentObject;
            stmt.setInt(1, vo.getVeiId());
            stmt.execute();
          //  veiculoFrame.reloadData();
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
