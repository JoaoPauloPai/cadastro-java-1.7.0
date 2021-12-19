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
@Table(name = "empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e"),
    @NamedQuery(name = "Empresas.findByEmpId", query = "SELECT e FROM Empresas e WHERE e.empId = :empId"),
    @NamedQuery(name = "Empresas.findByEmpRazao", query = "SELECT e FROM Empresas e WHERE e.empRazao = :empRazao"),
    @NamedQuery(name = "Empresas.findByEmpFantasia", query = "SELECT e FROM Empresas e WHERE e.empFantasia = :empFantasia"),
    @NamedQuery(name = "Empresas.findByEmpEndedeco", query = "SELECT e FROM Empresas e WHERE e.empEndedeco = :empEndedeco"),
    @NamedQuery(name = "Empresas.findByEmpBairro", query = "SELECT e FROM Empresas e WHERE e.empBairro = :empBairro"),
    @NamedQuery(name = "Empresas.findByEmpCidade", query = "SELECT e FROM Empresas e WHERE e.empCidade = :empCidade"),
    @NamedQuery(name = "Empresas.findByEmpEst", query = "SELECT e FROM Empresas e WHERE e.empEst = :empEst"),
    @NamedQuery(name = "Empresas.findByEmpInscEst", query = "SELECT e FROM Empresas e WHERE e.empInscEst = :empInscEst"),
    @NamedQuery(name = "Empresas.findByEmpCnpj", query = "SELECT e FROM Empresas e WHERE e.empCnpj = :empCnpj")})
public class Empresas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "emp_razao")
    private String empRazao;
    @Column(name = "emp_fantasia")
    private String empFantasia;
    @Column(name = "emp_endedeco")
    private String empEndedeco;
    @Column(name = "emp_bairro")
    private String empBairro;
    @Column(name = "emp_cidade")
    private String empCidade;
    @Column(name = "emp_est")
    private String empEst;
    @Column(name = "emp_insc_est")
    private Integer empInscEst;
    @Column(name = "emp_cnpj")
    private String empCnpj;

    public Empresas() {
    }

    public Empresas(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpRazao() {
        return empRazao;
    }

    public void setEmpRazao(String empRazao) {
        this.empRazao = empRazao;
    }

    public String getEmpFantasia() {
        return empFantasia;
    }

    public void setEmpFantasia(String empFantasia) {
        this.empFantasia = empFantasia;
    }

    public String getEmpEndedeco() {
        return empEndedeco;
    }

    public void setEmpEndedeco(String empEndedeco) {
        this.empEndedeco = empEndedeco;
    }

    public String getEmpBairro() {
        return empBairro;
    }

    public void setEmpBairro(String empBairro) {
        this.empBairro = empBairro;
    }

    public String getEmpCidade() {
        return empCidade;
    }

    public void setEmpCidade(String empCidade) {
        this.empCidade = empCidade;
    }

    public String getEmpEst() {
        return empEst;
    }

    public void setEmpEst(String empEst) {
        this.empEst = empEst;
    }

    public Integer getEmpInscEst() {
        return empInscEst;
    }

    public void setEmpInscEst(Integer empInscEst) {
        this.empInscEst = empInscEst;
    }

    public String getEmpCnpj() {
        return empCnpj;
    }

    public void setEmpCnpj(String empCnpj) {
        this.empCnpj = empCnpj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Empresas[ empId=" + empId + " ]";
    }
    
}
