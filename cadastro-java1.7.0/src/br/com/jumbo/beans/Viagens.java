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
@Table(name = "viagens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viagens.findAll", query = "SELECT v FROM Viagens v"),
    @NamedQuery(name = "Viagens.findByCodVi", query = "SELECT v FROM Viagens v WHERE v.codVi = :codVi"),
    @NamedQuery(name = "Viagens.findByVeiculoVeiPlaca", query = "SELECT v FROM Viagens v WHERE v.veiculoVeiPlaca = :veiculoVeiPlaca"),
    @NamedQuery(name = "Viagens.findByColaboradorColNome", query = "SELECT v FROM Viagens v WHERE v.colaboradorColNome = :colaboradorColNome"),
    @NamedQuery(name = "Viagens.findByViLocCar", query = "SELECT v FROM Viagens v WHERE v.viLocCar = :viLocCar"),
    @NamedQuery(name = "Viagens.findByViLocDes", query = "SELECT v FROM Viagens v WHERE v.viLocDes = :viLocDes"),
    @NamedQuery(name = "Viagens.findByViDataCar", query = "SELECT v FROM Viagens v WHERE v.viDataCar = :viDataCar"),
    @NamedQuery(name = "Viagens.findByViDataDes", query = "SELECT v FROM Viagens v WHERE v.viDataDes = :viDataDes"),
    @NamedQuery(name = "Viagens.findByViValorTon", query = "SELECT v FROM Viagens v WHERE v.viValorTon = :viValorTon"),
    @NamedQuery(name = "Viagens.findByViPesoTotal", query = "SELECT v FROM Viagens v WHERE v.viPesoTotal = :viPesoTotal"),
    @NamedQuery(name = "Viagens.findByViNumNf", query = "SELECT v FROM Viagens v WHERE v.viNumNf = :viNumNf"),
    @NamedQuery(name = "Viagens.findByViObs", query = "SELECT v FROM Viagens v WHERE v.viObs = :viObs"),
    @NamedQuery(name = "Viagens.findByProNome", query = "SELECT v FROM Viagens v WHERE v.proNome = :proNome"),
    @NamedQuery(name = "Viagens.findByColaboradorColId", query = "SELECT v FROM Viagens v WHERE v.colaboradorColId = :colaboradorColId"),
    @NamedQuery(name = "Viagens.findByViValorTotal", query = "SELECT v FROM Viagens v WHERE v.viValorTotal = :viValorTotal"),
    @NamedQuery(name = "Viagens.findByViMesRef", query = "SELECT v FROM Viagens v WHERE v.viMesRef = :viMesRef"),
    @NamedQuery(name = "Viagens.findByProId", query = "SELECT v FROM Viagens v WHERE v.proId = :proId"),
    @NamedQuery(name = "Viagens.findByViData", query = "SELECT v FROM Viagens v WHERE v.viData = :viData")})
public class Viagens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_vi")
    private Integer codVi;
    @Column(name = "veiculo_vei_placa")
    private String veiculoVeiPlaca;
    @Column(name = "colaborador_col_nome")
    private String colaboradorColNome;
    @Column(name = "vi_loc_car")
    private String viLocCar;
    @Column(name = "vi_loc_des")
    private String viLocDes;
    @Column(name = "vi_data_car")
    @Temporal(TemporalType.DATE)
    private Date viDataCar;
    @Column(name = "vi_data_des")
    @Temporal(TemporalType.DATE)
    private Date viDataDes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vi_valor_ton")
    private Double viValorTon;
    @Column(name = "vi_peso_total")
    private Double viPesoTotal;
    @Column(name = "vi_num_nf")
    private Integer viNumNf;
    @Column(name = "vi_obs")
    private String viObs;
    @Column(name = "pro_nome")
    private String proNome;
    @Column(name = "colaborador_col_id")
    private Integer colaboradorColId;
    @Column(name = "vi_valor_total")
    private Double viValorTotal;
    @Column(name = "vi_mes_ref")
    private String viMesRef;
    @Column(name = "pro_id")
    private Integer proId;
    @Column(name = "vi_data")
    @Temporal(TemporalType.DATE)
    private Date viData;

    public Viagens() {
    }

    public Viagens(Integer codVi) {
        this.codVi = codVi;
    }

    public Integer getCodVi() {
        return codVi;
    }

    public void setCodVi(Integer codVi) {
        this.codVi = codVi;
    }

    public String getVeiculoVeiPlaca() {
        return veiculoVeiPlaca;
    }

    public void setVeiculoVeiPlaca(String veiculoVeiPlaca) {
        this.veiculoVeiPlaca = veiculoVeiPlaca;
    }

    public String getColaboradorColNome() {
        return colaboradorColNome;
    }

    public void setColaboradorColNome(String colaboradorColNome) {
        this.colaboradorColNome = colaboradorColNome;
    }

    public String getViLocCar() {
        return viLocCar;
    }

    public void setViLocCar(String viLocCar) {
        this.viLocCar = viLocCar;
    }

    public String getViLocDes() {
        return viLocDes;
    }

    public void setViLocDes(String viLocDes) {
        this.viLocDes = viLocDes;
    }

    public Date getViDataCar() {
        return viDataCar;
    }

    public void setViDataCar(Date viDataCar) {
        this.viDataCar = viDataCar;
    }

    public Date getViDataDes() {
        return viDataDes;
    }

    public void setViDataDes(Date viDataDes) {
        this.viDataDes = viDataDes;
    }

    public Double getViValorTon() {
        return viValorTon;
    }

    public void setViValorTon(Double viValorTon) {
        this.viValorTon = viValorTon;
    }

    public Double getViPesoTotal() {
        return viPesoTotal;
    }

    public void setViPesoTotal(Double viPesoTotal) {
        this.viPesoTotal = viPesoTotal;
    }

    public Integer getViNumNf() {
        return viNumNf;
    }

    public void setViNumNf(Integer viNumNf) {
        this.viNumNf = viNumNf;
    }

    public String getViObs() {
        return viObs;
    }

    public void setViObs(String viObs) {
        this.viObs = viObs;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public Integer getColaboradorColId() {
        return colaboradorColId;
    }

    public void setColaboradorColId(Integer colaboradorColId) {
        this.colaboradorColId = colaboradorColId;
    }

    public Double getViValorTotal() {
        return viValorTotal;
    }

    public void setViValorTotal(Double viValorTotal) {
        this.viValorTotal = viValorTotal;
    }

    public String getViMesRef() {
        return viMesRef;
    }

    public void setViMesRef(String viMesRef) {
        this.viMesRef = viMesRef;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Date getViData() {
        return viData;
    }

    public void setViData(Date viData) {
        this.viData = viData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVi != null ? codVi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viagens)) {
            return false;
        }
        Viagens other = (Viagens) object;
        if ((this.codVi == null && other.codVi != null) || (this.codVi != null && !this.codVi.equals(other.codVi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Viagens[ codVi=" + codVi + " ]";
    }
    
}
