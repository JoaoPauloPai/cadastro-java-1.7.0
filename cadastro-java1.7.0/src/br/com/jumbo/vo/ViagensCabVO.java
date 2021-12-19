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
public class ViagensCabVO extends ValueObjectImpl{
    
    private Integer viCodCab;
    private Integer colId;
    private String veiculoVeiPlaca;
    private String mesAnoCab;
    private Integer totalViagensCab;
    private Double valorTotalMesCab;
    
    public ViagensCabVO(){
        
    }

    /**
     * @return the viCodCab
     */
    public Integer getViCodCab() {
        return viCodCab;
    }

    /**
     * @param viCodCab the viCodCab to set
     */
    public void setViCodCab(Integer viCodCab) {
        this.viCodCab = viCodCab;
    }

    /**
     * @return the veiculoVeiPlaca
     */
    public String getVeiculoVeiPlaca() {
        return veiculoVeiPlaca;
    }

    /**
     * @param veiculoVeiPlaca the veiculoVeiPlaca to set
     */
    public void setVeiculoVeiPlaca(String veiculoVeiPlaca) {
        this.veiculoVeiPlaca = veiculoVeiPlaca;
    }

    /**
     * @return the mesAnoCab
     */
    public String getMesAnoCab() {
        return mesAnoCab;
    }

    /**
     * @param mesAnoCab the mesAnoCab to set
     */
    public void setMesAnoCab(String mesAnoCab) {
        this.mesAnoCab = mesAnoCab;
    }

    /**
     * @return the totalViagensCab
     */
    public Integer getTotalViagensCab() {
        return totalViagensCab;
    }

    /**
     * @param totalViagensCab the totalViagensCab to set
     */
    public void setTotalViagensCab(Integer totalViagensCab) {
        this.totalViagensCab = totalViagensCab;
    }

    /**
     * @return the valorTotalMesCab
     */
    public Double getValorTotalMesCab() {
        return valorTotalMesCab;
    }

    /**
     * @param valorTotalMesCab the valorTotalMesCab to set
     */
    public void setValorTotalMesCab(Double valorTotalMesCab) {
        this.valorTotalMesCab = valorTotalMesCab;
    }

    /**
     * @return the colId
     */
    public Integer getColId() {
        return colId;
    }

    /**
     * @param colId the colId to set
     */
    public void setColId(Integer colId) {
        this.colId = colId;
    }
    
}

