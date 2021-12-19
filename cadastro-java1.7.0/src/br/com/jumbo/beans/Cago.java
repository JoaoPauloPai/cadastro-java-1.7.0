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
@Table(name = "cago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cago.findAll", query = "SELECT c FROM Cago c"),
    @NamedQuery(name = "Cago.findByCarId", query = "SELECT c FROM Cago c WHERE c.carId = :carId"),
    @NamedQuery(name = "Cago.findByCarDescricao", query = "SELECT c FROM Cago c WHERE c.carDescricao = :carDescricao")})
public class Cago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "car_id")
    private Integer carId;
    @Column(name = "car_descricao")
    private String carDescricao;

    public Cago() {
    }

    public Cago(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarDescricao() {
        return carDescricao;
    }

    public void setCarDescricao(String carDescricao) {
        this.carDescricao = carDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cago)) {
            return false;
        }
        Cago other = (Cago) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Cago[ carId=" + carId + " ]";
    }
    
}
