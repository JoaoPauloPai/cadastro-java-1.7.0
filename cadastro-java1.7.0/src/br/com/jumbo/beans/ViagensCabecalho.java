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
@Table(name = "viagens_cabecalho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViagensCabecalho.findAll", query = "SELECT v FROM ViagensCabecalho v"),
    @NamedQuery(name = "ViagensCabecalho.findByViCodCab", query = "SELECT v FROM ViagensCabecalho v WHERE v.viCodCab = :viCodCab"),
    @NamedQuery(name = "ViagensCabecalho.findByVeiculoVeiPlaca", query = "SELECT v FROM ViagensCabecalho v WHERE v.veiculoVeiPlaca = :veiculoVeiPlaca"),
    @NamedQuery(name = "ViagensCabecalho.findByMesAnoCab", query = "SELECT v FROM ViagensCabecalho v WHERE v.mesAnoCab = :mesAnoCab"),
    @NamedQuery(name = "ViagensCabecalho.findByTotalViagensCab", query = "SELECT v FROM ViagensCabecalho v WHERE v.totalViagensCab = :totalViagensCab"),
    @NamedQuery(name = "ViagensCabecalho.findByValorTotalMesCab", query = "SELECT v FROM ViagensCabecalho v WHERE v.valorTotalMesCab = :valorTotalMesCab")})
public class ViagensCabecalho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vi_cod_cab")
    private Integer viCodCab;
    @Column(name = "veiculo_vei_placa")
    private String veiculoVeiPlaca;
    @Column(name = "mes_ano_cab")
    private String mesAnoCab;
    @Column(name = "total_viagens_cab")
    private Integer totalViagensCab;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total_mes_cab")
    private Double valorTotalMesCab;

    public ViagensCabecalho() {
    }

    public ViagensCabecalho(Integer viCodCab) {
        this.viCodCab = viCodCab;
    }

    public Integer getViCodCab() {
        return viCodCab;
    }

    public void setViCodCab(Integer viCodCab) {
        this.viCodCab = viCodCab;
    }

    public String getVeiculoVeiPlaca() {
        return veiculoVeiPlaca;
    }

    public void setVeiculoVeiPlaca(String veiculoVeiPlaca) {
        this.veiculoVeiPlaca = veiculoVeiPlaca;
    }

    public String getMesAnoCab() {
        return mesAnoCab;
    }

    public void setMesAnoCab(String mesAnoCab) {
        this.mesAnoCab = mesAnoCab;
    }

    public Integer getTotalViagensCab() {
        return totalViagensCab;
    }

    public void setTotalViagensCab(Integer totalViagensCab) {
        this.totalViagensCab = totalViagensCab;
    }

    public Double getValorTotalMesCab() {
        return valorTotalMesCab;
    }

    public void setValorTotalMesCab(Double valorTotalMesCab) {
        this.valorTotalMesCab = valorTotalMesCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viCodCab != null ? viCodCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViagensCabecalho)) {
            return false;
        }
        ViagensCabecalho other = (ViagensCabecalho) object;
        if ((this.viCodCab == null && other.viCodCab != null) || (this.viCodCab != null && !this.viCodCab.equals(other.viCodCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.ViagensCabecalho[ viCodCab=" + viCodCab + " ]";
    }
    
}
