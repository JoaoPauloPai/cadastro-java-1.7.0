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
@Table(name = "cfop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cfop.findAll", query = "SELECT c FROM Cfop c"),
    @NamedQuery(name = "Cfop.findByIdCod", query = "SELECT c FROM Cfop c WHERE c.idCod = :idCod"),
    @NamedQuery(name = "Cfop.findById", query = "SELECT c FROM Cfop c WHERE c.id = :id"),
    @NamedQuery(name = "Cfop.findByCfop", query = "SELECT c FROM Cfop c WHERE c.cfop = :cfop"),
    @NamedQuery(name = "Cfop.findByDescricao", query = "SELECT c FROM Cfop c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Cfop.findByAplicacao", query = "SELECT c FROM Cfop c WHERE c.aplicacao = :aplicacao")})
public class Cfop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cod")
    private Integer idCod;
    @Column(name = "id")
    private Integer id;
    @Column(name = "cfop")
    private Integer cfop;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "aplicacao")
    private String aplicacao;

    public Cfop() {
    }

    public Cfop(Integer idCod) {
        this.idCod = idCod;
    }

    public Integer getIdCod() {
        return idCod;
    }

    public void setIdCod(Integer idCod) {
        this.idCod = idCod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCod != null ? idCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cfop)) {
            return false;
        }
        Cfop other = (Cfop) object;
        if ((this.idCod == null && other.idCod != null) || (this.idCod != null && !this.idCod.equals(other.idCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Cfop[ idCod=" + idCod + " ]";
    }
    
}
