/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Efraín
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "User.findByLimiteDeProyectos", query = "SELECT u FROM User u WHERE u.limiteDeProyectos = :limiteDeProyectos")
    , @NamedQuery(name = "User.findByUsuario", query = "SELECT u FROM User u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "User.findByContrase\u00f1a", query = "SELECT u FROM User u WHERE u.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "User.findByTipoDeUsuario", query = "SELECT u FROM User u WHERE u.tipoDeUsuario = :tipoDeUsuario")
    , @NamedQuery(name = "User.findByAutorizacion", query = "SELECT u FROM User u WHERE u.autorizacion = :autorizacion")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdUser")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LimiteDeProyectos")
    private boolean limiteDeProyectos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Contrase\u00f1a")
    private String contraseña;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TipoDeUsuario")
    private boolean tipoDeUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Autorizacion")
    private boolean autorizacion;

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, boolean limiteDeProyectos, String usuario, String contraseña, boolean tipoDeUsuario, boolean autorizacion) {
        this.idUser = idUser;
        this.limiteDeProyectos = limiteDeProyectos;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipoDeUsuario = tipoDeUsuario;
        this.autorizacion = autorizacion;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public boolean getLimiteDeProyectos() {
        return limiteDeProyectos;
    }

    public void setLimiteDeProyectos(boolean limiteDeProyectos) {
        this.limiteDeProyectos = limiteDeProyectos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(boolean tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public boolean getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ idUser=" + idUser + " ]";
    }
    
}
