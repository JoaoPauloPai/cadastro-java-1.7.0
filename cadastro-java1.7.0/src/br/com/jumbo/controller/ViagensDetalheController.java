package br.com.jumbo.controller;

import br.com.jumbo.frame.Viagens;
import br.com.jumbo.frame.ViagensDetalhe;
import br.com.jumbo.vo.ViagensVO;
import org.openswing.swing.form.client.FormController;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
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
public class ViagensDetalheController extends FormController {

    private ViagensDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private Viagens viagensFrame = null;

    public ViagensDetalheController(Viagens viagensFrame, String pk, Connection conn) {
        this.viagensFrame = viagensFrame;
        this.pk = pk;
        this.conn = conn;

        frame = new ViagensDetalhe(conn, this);
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

            ResultSet rset = stmt.executeQuery("select viagens.cod_vi, viagens.veiculo_vei_placa, viagens.colaborador_col_nome,"
                    + "viagens.vi_loc_car, viagens.vi_loc_des, viagens.vi_data_car, viagens.vi_data_des,"
                    + "viagens.vi_valor_ton, viagens.vi_peso_total, viagens.vi_num_nf,"
                    + "viagens.vi_obs, viagens.pro_nome, viagens.colaborador_col_id, "
                    + "viagens.vi_valor_total, viagens.vi_mes_ref, viagens.pro_id from viagens where cod_vi =" + pk);

            if (rset.next()) {
                ViagensVO vo = new ViagensVO();

                vo.setCodVi(rset.getInt(1));
                vo.setVeiculoVeiPlaca(rset.getString(2));
                vo.setColNome(rset.getString(3));
                vo.setViLocCar(rset.getString(4));
                vo.setViLocDes(rset.getString(5));
                vo.setViDataCar(rset.getDate(6));
                vo.setViDataDes(rset.getDate(7));
                vo.setViValorTon(rset.getDouble(8));
                vo.setViPesoTotal(rset.getDouble(9));
                vo.setViNumNf(rset.getInt(10));
                vo.setViObs(rset.getString(11));
                vo.setProNome(rset.getString(12));
                vo.setColId(rset.getInt(13));
                vo.setViValorTotal(rset.getDouble(14));
                vo.setViMesRef(rset.getString(15));
                vo.setProId(rset.getInt(16));
               // vo.setViData(rset.getDate(17));

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
            stmt = conn.prepareStatement("insert into viagens ( viagens.veiculo_vei_placa, viagens.colaborador_col_nome,"
                    + "viagens.vi_loc_car, viagens.vi_loc_des, viagens.vi_data_car, viagens.vi_data_des,"
                    + "viagens.vi_valor_ton, viagens.vi_peso_total, viagens.vi_num_nf,"
                    + "viagens.vi_obs, viagens.pro_nome, viagens.colaborador_col_id,"
                    + " viagens.vi_valor_total, viagens.vi_mes_ref, viagens.pro_id ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ViagensVO vo = (ViagensVO) newPersistentObject;

            stmt.setString(1, vo.getVeiculoVeiPlaca());
            stmt.setString(2, vo.getColNome());
            stmt.setString(3, vo.getViLocCar());
            stmt.setString(4, vo.getViLocDes());
            stmt.setDate(5, vo.getViDataCar());
            stmt.setDate(6, vo.getViDataDes());
            stmt.setDouble(7, vo.getViValorTon());
            stmt.setDouble(8, vo.getViPesoTotal());
            stmt.setInt(9, vo.getViNumNf());
            stmt.setString(10, vo.getViObs());
            stmt.setString(11, vo.getProNome());
            stmt.setInt(12, vo.getColId());
            stmt.setDouble(13, vo.getViValorTotal());
            stmt.setString(14, vo.getViMesRef());
            stmt.setInt(15, vo.getProId());
           // stmt.setDate(17, vo.getViData());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Viagém cadastrada com sosseso!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
            viagensFrame.reloadData();

            return new VOResponse(vo);

        } catch (SQLException ex) {

            ex.printStackTrace();
        //    JOptionPane.showMessageDialog(null, "Os dados do cadastro estão imcorretos!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ErrorResponse(ex.getMessage());
        } finally {
            
            try {
                stmt.close();
                conn.commit();
                //  JOptionPane.showMessageDialog(null, "Os dados do cadastro estão imcorretos!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);

            } catch (SQLException ex1) {
                //     JOptionPane.showMessageDialog(null, "Os dados do cadastro estão incorretos!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);      
            }

        }

    }

    public Response updateRecord(ValueObject oldPersistentObject,
            ValueObject persistentObject) {

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("update viagens set veiculo_vei_placa=?, colaborador_col_nome=?,"
                    + "vi_loc_car=?, vi_loc_des=?, vi_data_car=?, vi_data_des=?, vi_valor_ton=?, vi_peso_total=?,"
                    + "vi_num_nf=?, vi_obs=?, pro_nome=?, colaborador_col_id=?, vi_valor_total=?, vi_mes_ref=?, pro_id=? where cod_vi =?");

            ViagensVO vo = (ViagensVO) persistentObject;

            stmt.setString(1, vo.getVeiculoVeiPlaca());
            stmt.setString(2, vo.getColNome());
            stmt.setString(3, vo.getViLocCar());
            stmt.setString(4, vo.getViLocDes());
            stmt.setDate(5, vo.getViDataCar());
            stmt.setDate(6, vo.getViDataDes());
            stmt.setDouble(7, vo.getViValorTon());
            stmt.setDouble(8, vo.getViPesoTotal());
            stmt.setInt(9, vo.getViNumNf());
            stmt.setString(10, vo.getViObs());
            stmt.setString(11, vo.getProNome());
            stmt.setInt(12, vo.getColId());
            stmt.setDouble(13, vo.getViValorTotal());
            stmt.setString(14, vo.getViMesRef());
            stmt.setInt(15, vo.getProId());
            stmt.setInt(16, vo.getCodVi());

            stmt.execute();
            viagensFrame.reloadData();
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
            stmt = conn.prepareStatement("delete from viagens where cod_vi =?");

            ViagensVO vo = (ViagensVO) persistentObject;
            stmt.setInt(1, vo.getCodVi());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Os dados foram excluídos com susseso!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            viagensFrame.reloadData();
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
