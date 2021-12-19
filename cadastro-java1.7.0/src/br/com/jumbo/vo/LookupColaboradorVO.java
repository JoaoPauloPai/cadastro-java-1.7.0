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
public class LookupColaboradorVO extends ValueObjectImpl {
    
    private Integer colId;
    private String colNome;
    private String veiculoVeiPlaca;
   // private Double viValorTotal;
    
    public LookupColaboradorVO(){
        
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

    /**
     * @return the colNome
     */
    public String getColNome() {
        return colNome;
    }

    /**
     * @param colNome the colNome to set
     */
    public void setColNome(String colNome) {
        this.colNome = colNome;
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


    
    
}
