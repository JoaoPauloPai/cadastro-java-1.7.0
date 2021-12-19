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
@Table(name = "conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
    @NamedQuery(name = "Conta.findByIdConta", query = "SELECT c FROM Conta c WHERE c.idConta = :idConta"),
    @NamedQuery(name = "Conta.findByDescricaoConta", query = "SELECT c FROM Conta c WHERE c.descricaoConta = :descricaoConta"),
    @NamedQuery(name = "Conta.findByValorConta", query = "SELECT c FROM Conta c WHERE c.valorConta = :valorConta"),
    @NamedQuery(name = "Conta.findByDataInsercao", query = "SELECT c FROM Conta c WHERE c.dataInsercao = :dataInsercao"),
    @NamedQuery(name = "Conta.findByDataReceber", query = "SELECT c FROM Conta c WHERE c.dataReceber = :dataReceber"),
    @NamedQuery(name = "Conta.findByCentroCustoCodConta", query = "SELECT c FROM Conta c WHERE c.centroCustoCodConta = :centroCustoCodConta"),
    @NamedQuery(name = "Conta.findByCentroCustoTipoConta", query = "SELECT c FROM Conta c WHERE c.centroCustoTipoConta = :centroCustoTipoConta")})
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conta")
    private Integer idConta;
    @Column(name = "descricao_conta")
    private String descricaoConta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_conta")
    private Double valorConta;
    @Column(name = "data_insercao")
    @Temporal(TemporalType.DATE)
    private Date dataInsercao;
    @Column(name = "data_receber")
    @Temporal(TemporalType.DATE)
    private Date dataReceber;
    @Column(name = "centro_custo_cod_conta")
    private Integer centroCustoCodConta;
    @Column(name = "centro_custo_tipo_conta")
    private String centroCustoTipoConta;

    public Conta() {
    }

    public Conta(Integer idConta) {
        this.idConta = idConta;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public Double getValorConta() {
        return valorConta;
    }

    public void setValorConta(Double valorConta) {
        this.valorConta = valorConta;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Date getDataReceber() {
        return dataReceber;
    }

    public void setDataReceber(Date dataReceber) {
        this.dataReceber = dataReceber;
    }

    public Integer getCentroCustoCodConta() {
        return centroCustoCodConta;
    }

    public void setCentroCustoCodConta(Integer centroCustoCodConta) {
        this.centroCustoCodConta = centroCustoCodConta;
    }

    public String getCentroCustoTipoConta() {
        return centroCustoTipoConta;
    }

    public void setCentroCustoTipoConta(String centroCustoTipoConta) {
        this.centroCustoTipoConta = centroCustoTipoConta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConta != null ? idConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.idConta == null && other.idConta != null) || (this.idConta != null && !this.idConta.equals(other.idConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Conta[ idConta=" + idConta + " ]";
    }
    
}
