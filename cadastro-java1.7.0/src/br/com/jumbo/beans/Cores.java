/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

package br.com.jumbo.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vovo
 */
@Entity
@Table(name = "cores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cores.findAll", query = "SELECT c FROM Cores c"),
    @NamedQuery(name = "Cores.findByIdCor", query = "SELECT c FROM Cores c WHERE c.idCor = :idCor"),
    @NamedQuery(name = "Cores.findByCor", query = "SELECT c FROM Cores c WHERE c.cor = :cor"),
    @NamedQuery(name = "Cores.findByAbrevCor", query = "SELECT c FROM Cores c WHERE c.abrevCor = :abrevCor"),
    @NamedQuery(name = "Cores.findByData", query = "SELECT c FROM Cores c WHERE c.data = :data")})
public class Cores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cor")
    private Integer idCor;
    @Column(name = "cor")
    private String cor;
    @Column(name = "abrev_cor")
    private String abrevCor;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public Cores() {
    }

    public Cores(Integer idCor) {
        this.idCor = idCor;
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

    public String getAbrevCor() {
        return abrevCor;
    }

    public void setAbrevCor(String abrevCor) {
        this.abrevCor = abrevCor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCor != null ? idCor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cores)) {
            return false;
        }
        Cores other = (Cores) object;
        if ((this.idCor == null && other.idCor != null) || (this.idCor != null && !this.idCor.equals(other.idCor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Cores[ idCor=" + idCor + " ]";
    }
    
}
