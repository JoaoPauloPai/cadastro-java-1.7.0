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
public class ViagensDetVO extends ValueObjectImpl{
    
    private Integer viDetCod;
    private String viDetVeiculoVeiPlaca;
    private String viDetMes;
    private Integer viDetTotalViagens;
    private Double viDetTotalValor;
    
    public ViagensDetVO(){
        }

    /**
     * @return the viDetCod
     */
    public Integer getViDetCod() {
        return viDetCod;
    }

    /**
     * @param viDetCod the viDetCod to set
     */
    public void setViDetCod(Integer viDetCod) {
        this.viDetCod = viDetCod;
    }

 
    

    /**
     * @return the viDetMes
     */
    public String getViDetMes() {
        return viDetMes;
    }

    /**
     * @param viDetMes the viDetMes to set
     */
    public void setViDetMes(String viDetMes) {
        this.viDetMes = viDetMes;
    }

    /**
     * @return the viDetTotalViagens
     */
    public Integer getViDetTotalViagens() {
        return viDetTotalViagens;
    }

    /**
     * @param viDetTotalViagens the viDetTotalViagens to set
     */
    public void setViDetTotalViagens(Integer viDetTotalViagens) {
        this.viDetTotalViagens = viDetTotalViagens;
    }

    /**
     * @return the viDetTotalValor
     */
    public Double getViDetTotalValor() {
        return viDetTotalValor;
    }

    /**
     * @param viDetTotalValor the viDetTotalValor to set
     */
    public void setViDetTotalValor(Double viDetTotalValor) {
        this.viDetTotalValor = viDetTotalValor;
    }

    /**
     * @return the viDetVeiculoVeiPlaca
     */
    public String getViDetVeiculoVeiPlaca() {
        return viDetVeiculoVeiPlaca;
    }

    /**
     * @param viDetVeiculoVeiPlaca the viDetVeiculoVeiPlaca to set
     */
    public void setViDetVeiculoVeiPlaca(String viDetVeiculoVeiPlaca) {
        this.viDetVeiculoVeiPlaca = viDetVeiculoVeiPlaca;
    }
    
}

