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
public class CoresVO extends ValueObjectImpl {;
        
        private Integer idCor;
        private String cor;
        private String abrevCor;
        private Date data;
 
        public CoresVO (){
            
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
     * @return the abrevCor
     */
    public String getAbrevCor() {
        return abrevCor;
    }

    /**
     * @param abrevCor the abrevCor to set
     */
    public void setAbrevCor(String abrevCor) {
        this.abrevCor = abrevCor;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    
}
