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
public class PessoasVO extends ValueObjectImpl {
    
    private Integer pesId;
    private String pesNome;
    private String pesSexo;
    private Date pesData;
    private String pesEnd;
    private Integer pesNr;
    private String pesBairro;
    private String pesCidade;
    private String pesEst;
    private String pesFone1;
    private String pesFone2;
    private String pesDataNasc;
    private String pesCpf;
    private String pesRg;
    
 public PessoasVO(){
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
     * @return the pesSexo
     */
    public String getPesSexo() {
        return pesSexo;
    }

    /**
     * @param pesSexo the pesSexo to set
     */
    public void setPesSexo(String pesSexo) {
        this.pesSexo = pesSexo;
    }

    /**
     * @return the pesData
     */
    public Date getPesData() {
        return pesData;
    }

    /**
     * @param pesData the pesData to set
     */
    public void setPesData(Date pesData) {
        this.pesData = pesData;
    }

    /**
     * @return the pesEnd
     */
    public String getPesEnd() {
        return pesEnd;
    }

    /**
     * @param pesEnd the pesEnd to set
     */
    public void setPesEnd(String pesEnd) {
        this.pesEnd = pesEnd;
    }

    /**
     * @return the pesNr
     */
    public Integer getPesNr() {
        return pesNr;
    }

    /**
     * @param pesNr the pesNr to set
     */
    public void setPesNr(Integer pesNr) {
        this.pesNr = pesNr;
    }

    /**
     * @return the pesBairro
     */
    public String getPesBairro() {
        return pesBairro;
    }

    /**
     * @param pesBairro the pesBairro to set
     */
    public void setPesBairro(String pesBairro) {
        this.pesBairro = pesBairro;
    }

    /**
     * @return the pesCidade
     */
    public String getPesCidade() {
        return pesCidade;
    }

    /**
     * @param pesCidade the pesCidade to set
     */
    public void setPesCidade(String pesCidade) {
        this.pesCidade = pesCidade;
    }

    /**
     * @return the pesEst
     */
    public String getPesEst() {
        return pesEst;
    }

    /**
     * @param pesEst the pesEst to set
     */
    public void setPesEst(String pesEst) {
        this.pesEst = pesEst;
    }

    /**
     * @return the pesFone1
     */
    public String getPesFone1() {
        return pesFone1;
    }

    /**
     * @param pesFone1 the pesFone1 to set
     */
    public void setPesFone1(String pesFone1) {
        this.pesFone1 = pesFone1;
    }

    /**
     * @return the pesFone2
     */
    public String getPesFone2() {
        return pesFone2;
    }

    /**
     * @param pesFone2 the pesFone2 to set
     */
    public void setPesFone2(String pesFone2) {
        this.pesFone2 = pesFone2;
    }

    /**
     * @return the pesDataNasc
     */
    public String getPesDataNasc() {
        return pesDataNasc;
    }

    /**
     * @param pesDataNasc the pesDataNasc to set
     */
    public void setPesDataNasc(String pesDataNasc) {
        this.pesDataNasc = pesDataNasc;
    }

    /**
     * @return the pesCpf
     */
    public String getPesCpf() {
        return pesCpf;
    }

    /**
     * @param pesCpf the pesCpf to set
     */
    public void setPesCpf(String pesCpf) {
        this.pesCpf = pesCpf;
    }

    /**
     * @return the pesRg
     */
    public String getPesRg() {
        return pesRg;
    }

    /**
     * @param pesRg the pesRg to set
     */
    public void setPesRg(String pesRg) {
        this.pesRg = pesRg;
    }

     

    
}
