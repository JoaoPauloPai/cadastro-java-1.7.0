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
public class RoupasVO extends ValueObjectImpl{
    
    private Integer idRoupa;
    private String modDescricao;
    private String cor;
    private String tipoRoupa;
    private String pesNome;
    private Date dataCompra;
    private String endRoupa;
    private String obsRoupa;
    private Integer idCor;
    private Integer pesId;
    private Integer modId;
    
    
    public RoupasVO(){
    }

    /**
     * @return the idRoupa
     */
    public Integer getIdRoupa() {
        return idRoupa;
    }

    /**
     * @param idRoupa the idRoupa to set
     */
    public void setIdRoupa(Integer idRoupa) {
        this.idRoupa = idRoupa;
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
     * @return the tipoRoupa
     */
    public String getTipoRoupa() {
        return tipoRoupa;
    }

    /**
     * @param tipoRoupa the tipoRoupa to set
     */
    public void setTipoRoupa(String tipoRoupa) {
        this.tipoRoupa = tipoRoupa;
    }

    /**
     * @return the pesNome
     */
    public String getPesNome() {
        return pesNome;
    }

    /**
     * @param pesNome the pesNome to set
     */
    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    /**
     * @return the dataCompra
     */
    public Date getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the endRoupa
     */
    public String getEndRoupa() {
        return endRoupa;
    }

    /**
     * @param endRoupa the endRoupa to set
     */
    public void setEndRoupa(String endRoupa) {
        this.endRoupa = endRoupa;
    }

    /**
     * @return the obsRoupa
     */
    public String getObsRoupa() {
        return obsRoupa;
    }

    /**
     * @param obsRoupa the obsRoupa to set
     */
    public void setObsRoupa(String obsRoupa) {
        this.obsRoupa = obsRoupa;
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
     * @return the pesId
     */
    public Integer getPesId() {
        return pesId;
    }

    /**
     * @param pesId the pesId to set
     */
    public void setPesId(Integer pesId) {
        this.pesId = pesId;
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


    

    
    
    
}
