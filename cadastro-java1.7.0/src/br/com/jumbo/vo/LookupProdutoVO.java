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
public class LookupProdutoVO extends ValueObjectImpl {
    
    private Integer proId;
    private String proNome;
 
    
    
    public LookupProdutoVO(){
    }

    /**
     * @return the proId
     */
    public Integer getProId() {
        return proId;
    }

    /**
     * @param proId the proId to set
     */
    public void setProId(Integer proId) {
        this.proId = proId;
    }

    /**
     * @return the proNome
     */
    public String getProNome() {
        return proNome;
    }

    /**
     * @param proNome the proNome to set
     */
    public void setProNome(String proNome) {
        this.proNome = proNome;
    }


    

    

    
}
