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
@Table(name = "roupas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roupas.findAll", query = "SELECT r FROM Roupas r"),
    @NamedQuery(name = "Roupas.findByIdRoupa", query = "SELECT r FROM Roupas r WHERE r.idRoupa = :idRoupa"),
    @NamedQuery(name = "Roupas.findByDescricaoRoupa", query = "SELECT r FROM Roupas r WHERE r.descricaoRoupa = :descricaoRoupa"),
    @NamedQuery(name = "Roupas.findByCorRoupa", query = "SELECT r FROM Roupas r WHERE r.corRoupa = :corRoupa"),
    @NamedQuery(name = "Roupas.findByTipoRoupa", query = "SELECT r FROM Roupas r WHERE r.tipoRoupa = :tipoRoupa"),
    @NamedQuery(name = "Roupas.findByPesNome", query = "SELECT r FROM Roupas r WHERE r.pesNome = :pesNome"),
    @NamedQuery(name = "Roupas.findByDataCompra", query = "SELECT r FROM Roupas r WHERE r.dataCompra = :dataCompra"),
    @NamedQuery(name = "Roupas.findByEndRoupa", query = "SELECT r FROM Roupas r WHERE r.endRoupa = :endRoupa"),
    @NamedQuery(name = "Roupas.findByObsRoupa", query = "SELECT r FROM Roupas r WHERE r.obsRoupa = :obsRoupa"),
    @NamedQuery(name = "Roupas.findByIdCor", query = "SELECT r FROM Roupas r WHERE r.idCor = :idCor"),
    @NamedQuery(name = "Roupas.findByPesId", query = "SELECT r FROM Roupas r WHERE r.pesId = :pesId"),
    @NamedQuery(name = "Roupas.findByModId", query = "SELECT r FROM Roupas r WHERE r.modId = :modId")})
public class Roupas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_roupa")
    private Integer idRoupa;
    @Column(name = "descricao_roupa")
    private String descricaoRoupa;
    @Column(name = "cor_roupa")
    private String corRoupa;
    @Column(name = "tipo_roupa")
    private String tipoRoupa;
    @Column(name = "pes_nome")
    private String pesNome;
    @Column(name = "data_compra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Column(name = "end_roupa")
    private String endRoupa;
    @Column(name = "obs_roupa")
    private String obsRoupa;
    @Column(name = "id_cor")
    private Integer idCor;
    @Column(name = "pes_id")
    private Integer pesId;
    @Column(name = "mod_id")
    private Integer modId;

    public Roupas() {
    }

    public Roupas(Integer idRoupa) {
        this.idRoupa = idRoupa;
    }

    public Integer getIdRoupa() {
        return idRoupa;
    }

    public void setIdRoupa(Integer idRoupa) {
        this.idRoupa = idRoupa;
    }

    public String getDescricaoRoupa() {
        return descricaoRoupa;
    }

    public void setDescricaoRoupa(String descricaoRoupa) {
        this.descricaoRoupa = descricaoRoupa;
    }

    public String getCorRoupa() {
        return corRoupa;
    }

    public void setCorRoupa(String corRoupa) {
        this.corRoupa = corRoupa;
    }

    public String getTipoRoupa() {
        return tipoRoupa;
    }

    public void setTipoRoupa(String tipoRoupa) {
        this.tipoRoupa = tipoRoupa;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getEndRoupa() {
        return endRoupa;
    }

    public void setEndRoupa(String endRoupa) {
        this.endRoupa = endRoupa;
    }

    public String getObsRoupa() {
        return obsRoupa;
    }

    public void setObsRoupa(String obsRoupa) {
        this.obsRoupa = obsRoupa;
    }

    public Integer getIdCor() {
        return idCor;
    }

    public void setIdCor(Integer idCor) {
        this.idCor = idCor;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoupa != null ? idRoupa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roupas)) {
            return false;
        }
        Roupas other = (Roupas) object;
        if ((this.idRoupa == null && other.idRoupa != null) || (this.idRoupa != null && !this.idRoupa.equals(other.idRoupa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Roupas[ idRoupa=" + idRoupa + " ]";
    }
    
}
