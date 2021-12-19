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
public class ColaboradorVO extends ValueObjectImpl {

    private Integer colId;

    private String colNome;
    private String veiPlaca;
    private String colEnd;
    private String colBairro;
    private String colCidade;
    private String colEst;
    private String colFone1;
    private String colFone2;
    private String colCpf;
    private String colRg;
    private Integer veiId;

    public ColaboradorVO() {

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
     * @return the colBairro
     */
    public String getColBairro() {
        return colBairro;
    }

    /**
     * @param colBairro the colBairro to set
     */
    public void setColBairro(String colBairro) {
        this.colBairro = colBairro;
    }

    /**
     * @return the colCidade
     */
    public String getColCidade() {
        return colCidade;
    }

    /**
     * @param colCidade the colCidade to set
     */
    public void setColCidade(String colCidade) {
        this.colCidade = colCidade;
    }

    /**
     * @return the colEst
     */
    public String getColEst() {
        return colEst;
    }

    /**
     * @param colEst the colEst to set
     */
    public void setColEst(String colEst) {
        this.colEst = colEst;
    }

    /**
     * @return the colFone1
     */
    public String getColFone1() {
        return colFone1;
    }

    /**
     * @param colFone1 the colFone1 to set
     */
    public void setColFone1(String colFone1) {
        this.colFone1 = colFone1;
    }

    /**
     * @return the colFone2
     */
    public String getColFone2() {
        return colFone2;
    }

    /**
     * @param colFone2 the colFone2 to set
     */
    public void setColFone2(String colFone2) {
        this.colFone2 = colFone2;
    }

    /**
     * @return the colCpf
     */
    public String getColCpf() {
        return colCpf;
    }

    /**
     * @param colCpf the colCpf to set
     */
    public void setColCpf(String colCpf) {
        this.colCpf = colCpf;
    }

    /**
     * @return the colRg
     */
    public String getColRg() {
        return colRg;
    }

    /**
     * @param colRg the colRg to set
     */
    public void setColRg(String colRg) {
        this.colRg = colRg;
    }


    

    /**
     * @return the veiPlaca
     */
    public String getVeiPlaca() {
        return veiPlaca;
    }

    /**
     * @param veiPlaca the veiPlaca to set
     */
    public void setVeiPlaca(String veiPlaca) {
        this.veiPlaca = veiPlaca;
    }

    /**
     * @return the colEnd
     */
    public String getColEnd() {
        return colEnd;
    }

    /**
     * @param colEnd the colEnd to set
     */
    public void setColEnd(String colEnd) {
        this.colEnd = colEnd;
    }

    /**
     * @return the veiId
     */
    public Integer getVeiId() {
        return veiId;
    }

    /**
     * @param veiId the veiId to set
     */
    public void setVeiId(Integer veiId) {
        this.veiId = veiId;
    }

    
}
