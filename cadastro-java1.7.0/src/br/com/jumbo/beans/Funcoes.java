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
@Table(name = "funcoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcoes.findAll", query = "SELECT f FROM Funcoes f"),
    @NamedQuery(name = "Funcoes.findByFunId", query = "SELECT f FROM Funcoes f WHERE f.funId = :funId"),
    @NamedQuery(name = "Funcoes.findByFunDescricao", query = "SELECT f FROM Funcoes f WHERE f.funDescricao = :funDescricao")})
public class Funcoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fun_id")
    private Integer funId;
    @Column(name = "fun_descricao")
    private String funDescricao;

    public Funcoes() {
    }

    public Funcoes(Integer funId) {
        this.funId = funId;
    }

    public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }

    public String getFunDescricao() {
        return funDescricao;
    }

    public void setFunDescricao(String funDescricao) {
        this.funDescricao = funDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funId != null ? funId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcoes)) {
            return false;
        }
        Funcoes other = (Funcoes) object;
        if ((this.funId == null && other.funId != null) || (this.funId != null && !this.funId.equals(other.funId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Funcoes[ funId=" + funId + " ]";
    }
    
}
