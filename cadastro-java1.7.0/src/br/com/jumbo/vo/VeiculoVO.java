/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jumbo.vo;







import java.sql.Date;
import org.openswing.swing.message.receive.java.ValueObjectImpl;


/**
 *
 * @author Joao
 */
public class VeiculoVO extends ValueObjectImpl {
    
    private Integer veiId;
    private String veiMarca;
    private String veiMod;
    private Integer veiAno;
    private String veiCor;
    private Integer veiKm;
    private String  veiPlaca;
    private Date veiData;
    
    

    public VeiculoVO(){
        
    }

    /**
     * @return the veiId
     */
    public Integer getVeiId() {
        return veiId;
    }

    /**
     * @param veiId the veiId to set
     */
    public void setVeiId(Integer veiId) {
        this.veiId = veiId;
    }

    /**
     * @return the veiMarca
     */
    public String getVeiMarca() {
        return veiMarca;
    }

    /**
     * @param veiMarca the veiMarca to set
     */
    public void setVeiMarca(String veiMarca) {
        this.veiMarca = veiMarca;
    }

    /**
     * @return the veiMod
     */
    public String getVeiMod() {
        return veiMod;
    }

    /**
     * @param veiMod the veiMod to set
     */
    public void setVeiMod(String veiMod) {
        this.veiMod = veiMod;
    }

    /**
     * @return the veiAno
     */
    public Integer getVeiAno() {
        return veiAno;
    }

    /**
     * @param veiAno the veiAno to set
     */
    public void setVeiAno(Integer veiAno) {
        this.veiAno = veiAno;
    }

    /**
     * @return the veiCor
     */
    public String getVeiCor() {
        return veiCor;
    }

    /**
     * @param veiCor the veiCor to set
     */
    public void setVeiCor(String veiCor) {
        this.veiCor = veiCor;
    }

    /**
     * @return the veiKm
     */
    public Integer getVeiKm() {
        return veiKm;
    }

    /**
     * @param veiKm the veiKm to set
     */
    public void setVeiKm(Integer veiKm) {
        this.veiKm = veiKm;
    }

    /**
     * @return the VeiPlaca
     */
    public String getVeiPlaca() {
        return veiPlaca;
    }

    /**
     * @param VeiPlaca the VeiPlaca to set
     */
    public void setVeiPlaca(String VeiPlaca) {
        this.veiPlaca = VeiPlaca;
    }

    /**
     * @return the veiData
     */
    public Date getVeiData() {
        return veiData;
    }

    /**
     * @param veiData the veiData to set
     */
    public void setVeiData(Date veiData) {
        this.veiData = veiData;
    }
            
 

    
}
