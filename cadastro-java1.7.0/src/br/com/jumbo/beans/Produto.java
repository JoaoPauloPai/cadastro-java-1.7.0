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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByProId", query = "SELECT p FROM Produto p WHERE p.proId = :proId"),
    @NamedQuery(name = "Produto.findByProNome", query = "SELECT p FROM Produto p WHERE p.proNome = :proNome"),
    @NamedQuery(name = "Produto.findByProUnd", query = "SELECT p FROM Produto p WHERE p.proUnd = :proUnd"),
    @NamedQuery(name = "Produto.findByProMedida", query = "SELECT p FROM Produto p WHERE p.proMedida = :proMedida")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Column(name = "pro_nome")
    private String proNome;
    @Column(name = "pro_und")
    private String proUnd;
    @Column(name = "pro_medida")
    private String proMedida;

    public Produto() {
    }

    public Produto(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public String getProUnd() {
        return proUnd;
    }

    public void setProUnd(String proUnd) {
        this.proUnd = proUnd;
    }

    public String getProMedida() {
        return proMedida;
    }

    public void setProMedida(String proMedida) {
        this.proMedida = proMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Produto[ proId=" + proId + " ]";
    }
    
}
