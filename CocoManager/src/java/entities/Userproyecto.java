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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Efraín
 */
@Entity
@Table(name = "userproyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userproyecto.findAll", query = "SELECT u FROM Userproyecto u")
    , @NamedQuery(name = "Userproyecto.findByIdUserProyecto", query = "SELECT u FROM Userproyecto u WHERE u.idUserProyecto = :idUserProyecto")})
public class Userproyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdUserProyecto")
    private Integer idUserProyecto;
    @JoinColumn(name = "IdProyecto", referencedColumnName = "IdProyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @JoinColumn(name = "IdUser", referencedColumnName = "IdUser")
    @ManyToOne(optional = false)
    private User idUser;

    public Userproyecto() {
    }

    public Userproyecto(Integer idUserProyecto) {
        this.idUserProyecto = idUserProyecto;
    }

    public Integer getIdUserProyecto() {
        return idUserProyecto;
    }

    public void setIdUserProyecto(Integer idUserProyecto) {
        this.idUserProyecto = idUserProyecto;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserProyecto != null ? idUserProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userproyecto)) {
            return false;
        }
        Userproyecto other = (Userproyecto) object;
        if ((this.idUserProyecto == null && other.idUserProyecto != null) || (this.idUserProyecto != null && !this.idUserProyecto.equals(other.idUserProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userproyecto[ idUserProyecto=" + idUserProyecto + " ]";
    }
    
}
