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
public class TestesVO extends ValueObjectImpl{
    
    private Integer idTeste;
   private Integer idCor;
    private String cor;
    
    public TestesVO(){
        
    }

    /**
     * @return the idTeste
     */
    public Integer getIdTeste() {
        return idTeste;
    }

    /**
     * @param idTeste the idTeste to set
     */
    public void setIdTeste(Integer idTeste) {
        this.idTeste = idTeste;
    }

 
    

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the idCor
     */
    public Integer getIdCor() {
        return idCor;
    }

    /**
     * @param idCor the idCor to set
     */
    public void setIdCor(Integer idCor) {
        this.idCor = idCor;
    }
    
}
