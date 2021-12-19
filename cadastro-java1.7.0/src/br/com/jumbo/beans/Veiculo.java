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
@Table(name = "veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.findByVeiId", query = "SELECT v FROM Veiculo v WHERE v.veiId = :veiId"),
    @NamedQuery(name = "Veiculo.findByVeiMarca", query = "SELECT v FROM Veiculo v WHERE v.veiMarca = :veiMarca"),
    @NamedQuery(name = "Veiculo.findByVeiMod", query = "SELECT v FROM Veiculo v WHERE v.veiMod = :veiMod"),
    @NamedQuery(name = "Veiculo.findByVeiAno", query = "SELECT v FROM Veiculo v WHERE v.veiAno = :veiAno"),
    @NamedQuery(name = "Veiculo.findByVeiCor", query = "SELECT v FROM Veiculo v WHERE v.veiCor = :veiCor"),
    @NamedQuery(name = "Veiculo.findByVeiKm", query = "SELECT v FROM Veiculo v WHERE v.veiKm = :veiKm"),
    @NamedQuery(name = "Veiculo.findByVeiPlaca", query = "SELECT v FROM Veiculo v WHERE v.veiPlaca = :veiPlaca"),
    @NamedQuery(name = "Veiculo.findByVeiData", query = "SELECT v FROM Veiculo v WHERE v.veiData = :veiData")})
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vei_id")
    private Integer veiId;
    @Column(name = "vei_marca")
    private String veiMarca;
    @Column(name = "vei_mod")
    private String veiMod;
    @Column(name = "vei_ano")
    private Integer veiAno;
    @Column(name = "vei_cor")
    private String veiCor;
    @Column(name = "vei_km")
    private Integer veiKm;
    @Column(name = "vei_placa")
    private String veiPlaca;
    @Column(name = "vei_data")
    @Temporal(TemporalType.DATE)
    private Date veiData;

    public Veiculo() {
    }

    public Veiculo(Integer veiId) {
        this.veiId = veiId;
    }

    public Integer getVeiId() {
        return veiId;
    }

    public void setVeiId(Integer veiId) {
        this.veiId = veiId;
    }

    public String getVeiMarca() {
        return veiMarca;
    }

    public void setVeiMarca(String veiMarca) {
        this.veiMarca = veiMarca;
    }

    public String getVeiMod() {
        return veiMod;
    }

    public void setVeiMod(String veiMod) {
        this.veiMod = veiMod;
    }

    public Integer getVeiAno() {
        return veiAno;
    }

    public void setVeiAno(Integer veiAno) {
        this.veiAno = veiAno;
    }

    public String getVeiCor() {
        return veiCor;
    }

    public void setVeiCor(String veiCor) {
        this.veiCor = veiCor;
    }

    public Integer getVeiKm() {
        return veiKm;
    }

    public void setVeiKm(Integer veiKm) {
        this.veiKm = veiKm;
    }

    public String getVeiPlaca() {
        return veiPlaca;
    }

    public void setVeiPlaca(String veiPlaca) {
        this.veiPlaca = veiPlaca;
    }

    public Date getVeiData() {
        return veiData;
    }

    public void setVeiData(Date veiData) {
        this.veiData = veiData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (veiId != null ? veiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.veiId == null && other.veiId != null) || (this.veiId != null && !this.veiId.equals(other.veiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Veiculo[ veiId=" + veiId + " ]";
    }
    
}
