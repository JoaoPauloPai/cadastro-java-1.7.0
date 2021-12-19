/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jumbo.vo;

import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author vovo
 */
public class CargoVO extends ValueObjectImpl{
    
    private Integer carId;
    private String carDescricao;
    
    public CargoVO(){
        
    }

    /**
     * @return the carId
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * @param carId the carId to set
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * @return the carDescricao
     */
    public String getCarDescricao() {
        return carDescricao;
    }

    /**
     * @param carDescricao the carDescricao to set
     */
    public void setCarDescricao(String carDescricao) {
        this.carDescricao = carDescricao;
    }
    
}
