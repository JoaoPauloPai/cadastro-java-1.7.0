/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jumbo.vo;

import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Joao
 */
public class LookupVeiculoVO extends ValueObjectImpl {
    
    private Integer veiId;
    private String veiMarca;
    private String veiMod;
    private String veiCor;
    private String veiPlaca;
    
    public LookupVeiculoVO(){
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
     * @return the veiModelo
     */
    public String getVeiMod() {
        return veiMod;
    }

    /**
     * @param veiModelo the veiModelo to set
     */
    public void setVeiMod(String veiMod) {
        this.veiMod = veiMod;
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
     * @return the veiPlaca
     */
    public String getVeiPlaca() {
        return veiPlaca;
    }

    /**
     * @param veiPlaca the veiPlaca to set
     */
    public void setVeiPlaca(String veiPlaca) {
        this.veiPlaca = veiPlaca;
    }


    

    
}
