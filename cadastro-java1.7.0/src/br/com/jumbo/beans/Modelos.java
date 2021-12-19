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
@Table(name = "modelos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelos.findAll", query = "SELECT m FROM Modelos m"),
    @NamedQuery(name = "Modelos.findByModId", query = "SELECT m FROM Modelos m WHERE m.modId = :modId"),
    @NamedQuery(name = "Modelos.findByModDescricao", query = "SELECT m FROM Modelos m WHERE m.modDescricao = :modDescricao"),
    @NamedQuery(name = "Modelos.findByModAbrev", query = "SELECT m FROM Modelos m WHERE m.modAbrev = :modAbrev")})
public class Modelos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mod_id")
    private Integer modId;
    @Column(name = "mod_descricao")
    private String modDescricao;
    @Column(name = "mod_abrev")
    private String modAbrev;

    public Modelos() {
    }

    public Modelos(Integer modId) {
        this.modId = modId;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String getModDescricao() {
        return modDescricao;
    }

    public void setModDescricao(String modDescricao) {
        this.modDescricao = modDescricao;
    }

    public String getModAbrev() {
        return modAbrev;
    }

    public void setModAbrev(String modAbrev) {
        this.modAbrev = modAbrev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelos)) {
            return false;
        }
        Modelos other = (Modelos) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Modelos[ modId=" + modId + " ]";
    }
    
}
