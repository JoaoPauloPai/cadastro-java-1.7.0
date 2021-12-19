/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

package br.com.jumbo.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vovo
 */
@Entity
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c"),
    @NamedQuery(name = "Colaborador.findByColId", query = "SELECT c FROM Colaborador c WHERE c.colId = :colId"),
    @NamedQuery(name = "Colaborador.findByColNome", query = "SELECT c FROM Colaborador c WHERE c.colNome = :colNome"),
    @NamedQuery(name = "Colaborador.findByVeiculoVeiPlaca", query = "SELECT c FROM Colaborador c WHERE c.veiculoVeiPlaca = :veiculoVeiPlaca"),
    @NamedQuery(name = "Colaborador.findByColEnd", query = "SELECT c FROM Colaborador c WHERE c.colEnd = :colEnd"),
    @NamedQuery(name = "Colaborador.findByColBairro", query = "SELECT c FROM Colaborador c WHERE c.colBairro = :colBairro"),
    @NamedQuery(name = "Colaborador.findByColCidade", query = "SELECT c FROM Colaborador c WHERE c.colCidade = :colCidade"),
    @NamedQuery(name = "Colaborador.findByColEst", query = "SELECT c FROM Colaborador c WHERE c.colEst = :colEst"),
    @NamedQuery(name = "Colaborador.findByColFone1", query = "SELECT c FROM Colaborador c WHERE c.colFone1 = :colFone1"),
    @NamedQuery(name = "Colaborador.findByColFone2", query = "SELECT c FROM Colaborador c WHERE c.colFone2 = :colFone2"),
    @NamedQuery(name = "Colaborador.findByColCpf", query = "SELECT c FROM Colaborador c WHERE c.colCpf = :colCpf"),
    @NamedQuery(name = "Colaborador.findByColRg", query = "SELECT c FROM Colaborador c WHERE c.colRg = :colRg"),
    @NamedQuery(name = "Colaborador.findByVeiculoVeiId", query = "SELECT c FROM Colaborador c WHERE c.veiculoVeiId = :veiculoVeiId")})
public class Colaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "col_id")
    private Integer colId;
    @Column(name = "col_nome")
    private String colNome;
    @Column(name = "veiculo_vei_placa")
    private String veiculoVeiPlaca;
    @Column(name = "col_end")
    private String colEnd;
    @Column(name = "col_bairro")
    private String colBairro;
    @Column(name = "col_cidade")
    private String colCidade;
    @Column(name = "col_est")
    private String colEst;
    @Column(name = "col_fone1")
    private String colFone1;
    @Column(name = "col_fone2")
    private String colFone2;
    @Column(name = "col_cpf")
    private String colCpf;
    @Column(name = "col_rg")
    private String colRg;
    @Column(name = "veiculo_vei_id")
    private Integer veiculoVeiId;

    public Colaborador() {
    }

    public Colaborador(Integer colId) {
        this.colId = colId;
    }

    public Integer getColId() {
        return colId;
    }

    public void setColId(Integer colId) {
        this.colId = colId;
    }

    public String getColNome() {
        return colNome;
    }

    public void setColNome(String colNome) {
        this.colNome = colNome;
    }

    public String getVeiculoVeiPlaca() {
        return veiculoVeiPlaca;
    }

    public void setVeiculoVeiPlaca(String veiculoVeiPlaca) {
        this.veiculoVeiPlaca = veiculoVeiPlaca;
    }

    public String getColEnd() {
        return colEnd;
    }

    public void setColEnd(String colEnd) {
        this.colEnd = colEnd;
    }

    public String getColBairro() {
        return colBairro;
    }

    public void setColBairro(String colBairro) {
        this.colBairro = colBairro;
    }

    public String getColCidade() {
        return colCidade;
    }

    public void setColCidade(String colCidade) {
        this.colCidade = colCidade;
    }

    public String getColEst() {
        return colEst;
    }

    public void setColEst(String colEst) {
        this.colEst = colEst;
    }

    public String getColFone1() {
        return colFone1;
    }

    public void setColFone1(String colFone1) {
        this.colFone1 = colFone1;
    }

    public String getColFone2() {
        return colFone2;
    }

    public void setColFone2(String colFone2) {
        this.colFone2 = colFone2;
    }

    public String getColCpf() {
        return colCpf;
    }

    public void setColCpf(String colCpf) {
        this.colCpf = colCpf;
    }

    public String getColRg() {
        return colRg;
    }

    public void setColRg(String colRg) {
        this.colRg = colRg;
    }

    public Integer getVeiculoVeiId() {
        return veiculoVeiId;
    }

    public void setVeiculoVeiId(Integer veiculoVeiId) {
        this.veiculoVeiId = veiculoVeiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (colId != null ? colId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.colId == null && other.colId != null) || (this.colId != null && !this.colId.equals(other.colId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Colaborador[ colId=" + colId + " ]";
    }
    
}
