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
@Table(name = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findByCodBanco", query = "SELECT b FROM Banco b WHERE b.codBanco = :codBanco"),
    @NamedQuery(name = "Banco.findByCodCompensacao", query = "SELECT b FROM Banco b WHERE b.codCompensacao = :codCompensacao"),
    @NamedQuery(name = "Banco.findByNomeBanco", query = "SELECT b FROM Banco b WHERE b.nomeBanco = :nomeBanco"),
    @NamedQuery(name = "Banco.findBySiteBanco", query = "SELECT b FROM Banco b WHERE b.siteBanco = :siteBanco")})
public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_banco")
    private Integer codBanco;
    @Column(name = "cod_compensacao")
    private Integer codCompensacao;
    @Column(name = "nome_banco")
    private String nomeBanco;
    @Column(name = "site_banco")
    private String siteBanco;

    public Banco() {
    }

    public Banco(Integer codBanco) {
        this.codBanco = codBanco;
    }

    public Integer getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(Integer codBanco) {
        this.codBanco = codBanco;
    }

    public Integer getCodCompensacao() {
        return codCompensacao;
    }

    public void setCodCompensacao(Integer codCompensacao) {
        this.codCompensacao = codCompensacao;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getSiteBanco() {
        return siteBanco;
    }

    public void setSiteBanco(String siteBanco) {
        this.siteBanco = siteBanco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBanco != null ? codBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.codBanco == null && other.codBanco != null) || (this.codBanco != null && !this.codBanco.equals(other.codBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Banco[ codBanco=" + codBanco + " ]";
    }
    
}
