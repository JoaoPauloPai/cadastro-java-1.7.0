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
public class ModelosVO extends ValueObjectImpl {

    private Integer modId;
    private String modDescricao;
    private String modAbrev;

    public ModelosVO() {

    }

    /**
     * @return the modId
     */
    public Integer getModId() {
        return modId;
    }

    /**
     * @param modId the modId to set
     */
    public void setModId(Integer modId) {
        this.modId = modId;
    }

    /**
     * @return the modDescricao
     */
    public String getModDescricao() {
        return modDescricao;
    }

    /**
     * @param modDescricao the modDescricao to set
     */
    public void setModDescricao(String modDescricao) {
        this.modDescricao = modDescricao;
    }

    /**
     * @return the modAbrev
     */
    public String getModAbrev() {
        return modAbrev;
    }

    /**
     * @param modAbrev the modAbrev to set
     */
    public void setModAbrev(String modAbrev) {
        this.modAbrev = modAbrev;
    }

}
