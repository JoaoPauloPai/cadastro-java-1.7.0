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
public class EndereçoVO extends ValueObjectImpl{
    
    private Integer endId;
    private String endNome;
    
    
    public EndereçoVO(){
        
    }

    /**
     * @return the endId
     */
    public Integer getEndId() {
        return endId;
    }

    /**
     * @param endId the endId to set
     */
    public void setEndId(Integer endId) {
        this.endId = endId;
    }

    /**
     * @return the endNome
     */
    public String getEndNome() {
        return endNome;
    }

    /**
     * @param endNome the endNome to set
     */
    public void setEndNome(String endNome) {
        this.endNome = endNome;
    }
    
}
