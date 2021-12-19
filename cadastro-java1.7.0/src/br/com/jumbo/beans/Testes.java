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
@Table(name = "testes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testes.findAll", query = "SELECT t FROM Testes t"),
    @NamedQuery(name = "Testes.findByIdTeste", query = "SELECT t FROM Testes t WHERE t.idTeste = :idTeste"),
    @NamedQuery(name = "Testes.findByIdCor", query = "SELECT t FROM Testes t WHERE t.idCor = :idCor"),
    @NamedQuery(name = "Testes.findByCor", query = "SELECT t FROM Testes t WHERE t.cor = :cor")})
public class Testes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_teste")
    private Integer idTeste;
    @Column(name = "id_cor")
    private Integer idCor;
    @Column(name = "cor")
    private String cor;

    public Testes() {
    }

    public Testes(Integer idTeste) {
        this.idTeste = idTeste;
    }

    public Integer getIdTeste() {
        return idTeste;
    }

    public void setIdTeste(Integer idTeste) {
        this.idTeste = idTeste;
    }

    public Integer getIdCor() {
        return idCor;
    }

    public void setIdCor(Integer idCor) {
        this.idCor = idCor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTeste != null ? idTeste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testes)) {
            return false;
        }
        Testes other = (Testes) object;
        if ((this.idTeste == null && other.idTeste != null) || (this.idTeste != null && !this.idTeste.equals(other.idTeste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Testes[ idTeste=" + idTeste + " ]";
    }
    
}
