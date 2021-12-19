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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUCod", query = "SELECT u FROM Usuario u WHERE u.uCod = :uCod"),
    @NamedQuery(name = "Usuario.findByUNome", query = "SELECT u FROM Usuario u WHERE u.uNome = :uNome"),
    @NamedQuery(name = "Usuario.findByULogin", query = "SELECT u FROM Usuario u WHERE u.uLogin = :uLogin"),
    @NamedQuery(name = "Usuario.findByUSenha", query = "SELECT u FROM Usuario u WHERE u.uSenha = :uSenha")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "u_cod")
    private Integer uCod;
    @Basic(optional = false)
    @Column(name = "u_nome")
    private String uNome;
    @Basic(optional = false)
    @Column(name = "u_login")
    private String uLogin;
    @Basic(optional = false)
    @Column(name = "u_senha")
    private String uSenha;

    public Usuario() {
    }

    public Usuario(Integer uCod) {
        this.uCod = uCod;
    }

    public Usuario(Integer uCod, String uNome, String uLogin, String uSenha) {
        this.uCod = uCod;
        this.uNome = uNome;
        this.uLogin = uLogin;
        this.uSenha = uSenha;
    }

    public Integer getUCod() {
        return uCod;
    }

    public void setUCod(Integer uCod) {
        this.uCod = uCod;
    }

    public String getUNome() {
        return uNome;
    }

    public void setUNome(String uNome) {
        this.uNome = uNome;
    }

    public String getULogin() {
        return uLogin;
    }

    public void setULogin(String uLogin) {
        this.uLogin = uLogin;
    }

    public String getUSenha() {
        return uSenha;
    }

    public void setUSenha(String uSenha) {
        this.uSenha = uSenha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uCod != null ? uCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.uCod == null && other.uCod != null) || (this.uCod != null && !this.uCod.equals(other.uCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jumbo.beans.Usuario[ uCod=" + uCod + " ]";
    }
    
}
