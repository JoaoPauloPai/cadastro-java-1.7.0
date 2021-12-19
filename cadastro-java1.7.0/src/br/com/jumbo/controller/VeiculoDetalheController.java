package br.com.jumbo.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.com.jumbo.frame.Veiculo;
import br.com.jumbo.frame.VeiculoDetalhe;

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
public class VeiculoDetalheController extends FormController {

    private VeiculoDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private Veiculo veiculoFrame = null;

    public VeiculoDetalheController(Veiculo veiculoFrame, String pk, Connection conn) {
        this.veiculoFrame = veiculoFrame;
        this.pk = pk;
        this.conn = conn;

        frame = new VeiculoDetalhe(conn, this);
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
            
            ResultSet rset = stmt.executeQuery("Select veiculo.vei_id,"
                    + "veiculo.vei_marca, veiculo.vei_mod, veiculo.vei_ano,"
                    + "veiculo.vei_cor, veiculo.vei_km, veiculo.vei_placa,"
                    + "veiculo.vei_data from veiculo where vei_id =" + pk);

            if (rset.next()) {
                VeiculoVO vo = new VeiculoVO();
    
                vo.setVeiId(rset.getInt(1));
                vo.setVeiMarca(rset.getString(2));
                vo.setVeiMod(rset.getString(3));
                vo.setVeiAno(rset.getInt(4));
                vo.setVeiCor(rset.getString(5));
                vo.setVeiKm(rset.getInt(6));
                vo.setVeiPlaca(rset.getString(7));
                vo.setVeiData(rset.getDate(8));
             
                
                
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
            stmt = conn.prepareStatement("insert into veiculo (vei_marca,"
                    + "vei_mod, vei_ano, vei_cor, vei_km, vei_placa, vei_data) values (?,?,?,?,?,?,?)");
              
            

            VeiculoVO vo = (VeiculoVO) newPersistentObject;
    
            stmt.setString(1, vo.getVeiMarca());
            stmt.setString(2, vo.getVeiMod());
            stmt.setInt(3, vo.getVeiAno());
            stmt.setString(4, vo.getVeiCor());
            stmt.setInt(5, vo.getVeiKm());
            stmt.setString(6, vo.getVeiPlaca());
            stmt.setDate(7, vo.getVeiData());
        
            
            stmt.execute();
           
            veiculoFrame.reloadData();
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
            stmt = conn.prepareStatement("update veiculo set vei_marca=?, vei_mod=?,"
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
            veiculoFrame.reloadData();
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
            veiculoFrame.reloadData();
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
