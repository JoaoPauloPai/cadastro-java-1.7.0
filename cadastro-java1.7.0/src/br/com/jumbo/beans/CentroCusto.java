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
@Table(name = "centro_custo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroCusto.findAll", query = "SELECT c FROM CentroCusto c"),
    @NamedQuery(name = "CentroCusto.findByCodConta", query = "SELECT c FROM CentroCusto c WHERE c.codConta = :codConta"),
    @NamedQuery(name = "CentroCusto.findByDescricaoConta", query = "SELECT c FROM CentroCusto c WHERE c.descricaoConta = :descricaoConta"),
    @NamedQuery(name = "CentroCusto.findByTipoConta", query = "SELECT c FROM CentroCusto c WHERE c.tipoConta = :tipoConta")})
public class CentroCusto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_conta")
    private Integer codConta;
    @Column(name = "descricao_conta")
    private String descricaoConta;
    @Column(name = "tipo_conta")
    private String tipoConta;

    public CentroCusto() {
    }

    public CentroCusto(Integer codConta) {
        this.codConta = codConta;
    }

    public Integer getCodConta() {
        return codConta;
    }

    public void setCodConta(Integer codConta) {
        this.codConta = codConta;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codConta != null ? codConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroCusto)) {
            return false;
        }
        CentroCusto other = (CentroCusto) object;
        if ((this.codConta == null && other.codConta != null) || (this.codConta != null && !this.codConta.equals(other.codConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.CentroCusto[ codConta=" + codConta + " ]";
    }
    
}
