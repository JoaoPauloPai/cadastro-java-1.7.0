package br.com.jumbo.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import br.com.jumbo.frame.Produto;
import br.com.jumbo.frame.ProdutoDetalhe;
import br.com.jumbo.vo.ProdutoVO;
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
public class ProdutoDetalheController extends FormController {

    private ProdutoDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private Produto produtoFrame = null;

    public ProdutoDetalheController(Produto produtoFrame, String pk, Connection conn) {
        this.produtoFrame = produtoFrame;
        this.pk = pk;
        this.conn = conn;

        frame = new ProdutoDetalhe(conn, this);
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
            
            ResultSet rset = stmt.executeQuery("Select produto.pro_id,"
                    + "produto.pro_nome, produto.pro_und from produto where pro_id =" + pk);

            if (rset.next()) {
                ProdutoVO vo = new ProdutoVO();
    
                vo.setProId(rset.getInt(1));
                vo.setProNome(rset.getString(2));
                vo.setProUnd(rset.getString(3));
              
                
             
                
                
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
            stmt = conn.prepareStatement("insert into produto (pro_nome,"
                    + "pro_und) values (?,?)");
              
            

            ProdutoVO vo = (ProdutoVO) newPersistentObject;
    
            stmt.setString(1, vo.getProNome());
            stmt.setString(2, vo.getProUnd());
         
            
            
            stmt.execute();
           
            produtoFrame.reloadData();
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
            stmt = conn.prepareStatement("update produto set pro_nome=?, pro_und=?,"
                    + " where pro_id=?");

         ProdutoVO  vo = (ProdutoVO) persistentObject;

            
           
            
            stmt.setString(1, vo.getProNome());
            stmt.setString(2, vo.getProUnd());
            stmt.setInt(3, vo.getProId());
     
            
            
            stmt.execute();
            produtoFrame.reloadData();
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
            stmt = conn.prepareStatement("delete from produto where pro_id =?");

            ProdutoVO vo = (ProdutoVO) persistentObject;
            stmt.setInt(1, vo.getProId());
            stmt.execute();
            produtoFrame.reloadData();
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
