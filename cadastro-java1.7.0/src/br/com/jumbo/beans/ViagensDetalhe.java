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
@Table(name = "viagens_detalhe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViagensDetalhe.findAll", query = "SELECT v FROM ViagensDetalhe v"),
    @NamedQuery(name = "ViagensDetalhe.findByViDetCod", query = "SELECT v FROM ViagensDetalhe v WHERE v.viDetCod = :viDetCod"),
    @NamedQuery(name = "ViagensDetalhe.findByViDetVeiculoVeiPlaca", query = "SELECT v FROM ViagensDetalhe v WHERE v.viDetVeiculoVeiPlaca = :viDetVeiculoVeiPlaca"),
    @NamedQuery(name = "ViagensDetalhe.findByViDetMes", query = "SELECT v FROM ViagensDetalhe v WHERE v.viDetMes = :viDetMes"),
    @NamedQuery(name = "ViagensDetalhe.findByViDetTotalViagens", query = "SELECT v FROM ViagensDetalhe v WHERE v.viDetTotalViagens = :viDetTotalViagens"),
    @NamedQuery(name = "ViagensDetalhe.findByViDetTotalValor", query = "SELECT v FROM ViagensDetalhe v WHERE v.viDetTotalValor = :viDetTotalValor")})
public class ViagensDetalhe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vi_det_cod")
    private Integer viDetCod;
    @Column(name = "vi_det_veiculo_vei_placa")
    private String viDetVeiculoVeiPlaca;
    @Column(name = "vi_det_mes")
    private String viDetMes;
    @Column(name = "vi_det_total_viagens")
    private Integer viDetTotalViagens;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vi_det_total_valor")
    private Double viDetTotalValor;

    public ViagensDetalhe() {
    }

    public ViagensDetalhe(Integer viDetCod) {
        this.viDetCod = viDetCod;
    }

    public Integer getViDetCod() {
        return viDetCod;
    }

    public void setViDetCod(Integer viDetCod) {
        this.viDetCod = viDetCod;
    }

    public String getViDetVeiculoVeiPlaca() {
        return viDetVeiculoVeiPlaca;
    }

    public void setViDetVeiculoVeiPlaca(String viDetVeiculoVeiPlaca) {
        this.viDetVeiculoVeiPlaca = viDetVeiculoVeiPlaca;
    }

    public String getViDetMes() {
        return viDetMes;
    }

    public void setViDetMes(String viDetMes) {
        this.viDetMes = viDetMes;
    }

    public Integer getViDetTotalViagens() {
        return viDetTotalViagens;
    }

    public void setViDetTotalViagens(Integer viDetTotalViagens) {
        this.viDetTotalViagens = viDetTotalViagens;
    }

    public Double getViDetTotalValor() {
        return viDetTotalValor;
    }

    public void setViDetTotalValor(Double viDetTotalValor) {
        this.viDetTotalValor = viDetTotalValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viDetCod != null ? viDetCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViagensDetalhe)) {
            return false;
        }
        ViagensDetalhe other = (ViagensDetalhe) object;
        if ((this.viDetCod == null && other.viDetCod != null) || (this.viDetCod != null && !this.viDetCod.equals(other.viDetCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.ViagensDetalhe[ viDetCod=" + viDetCod + " ]";
    }
    
}
