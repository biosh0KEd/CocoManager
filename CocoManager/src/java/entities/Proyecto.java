/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Efraín
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto")
    , @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT p FROM Proyecto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Proyecto.findByFecha", query = "SELECT p FROM Proyecto p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Proyecto.findByEnlaceReq", query = "SELECT p FROM Proyecto p WHERE p.enlaceReq = :enlaceReq")
    , @NamedQuery(name = "Proyecto.findByEnlaceRepT", query = "SELECT p FROM Proyecto p WHERE p.enlaceRepT = :enlaceRepT")
    , @NamedQuery(name = "Proyecto.findByEnlaceCF", query = "SELECT p FROM Proyecto p WHERE p.enlaceCF = :enlaceCF")
    , @NamedQuery(name = "Proyecto.findByEnlaceInst", query = "SELECT p FROM Proyecto p WHERE p.enlaceInst = :enlaceInst")
    , @NamedQuery(name = "Proyecto.findByEstado", query = "SELECT p FROM Proyecto p WHERE p.estado = :estado")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdProyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 240)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Objetivos")
    private String objetivos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EnlaceReq")
    private String enlaceReq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EnlaceRepT")
    private String enlaceRepT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EnlaceCF")
    private String enlaceCF;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EnlaceInst")
    private String enlaceInst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "IdCategoria", referencedColumnName = "IdCategoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private Collection<Userproyecto> userproyectoCollection;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String nombre, String descripcion, String objetivos, Date fecha, String enlaceReq, String enlaceRepT, String enlaceCF, String enlaceInst, String estado) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.fecha = fecha;
        this.enlaceReq = enlaceReq;
        this.enlaceRepT = enlaceRepT;
        this.enlaceCF = enlaceCF;
        this.enlaceInst = enlaceInst;
        this.estado = estado;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEnlaceReq() {
        return enlaceReq;
    }

    public void setEnlaceReq(String enlaceReq) {
        this.enlaceReq = enlaceReq;
    }

    public String getEnlaceRepT() {
        return enlaceRepT;
    }

    public void setEnlaceRepT(String enlaceRepT) {
        this.enlaceRepT = enlaceRepT;
    }

    public String getEnlaceCF() {
        return enlaceCF;
    }

    public void setEnlaceCF(String enlaceCF) {
        this.enlaceCF = enlaceCF;
    }

    public String getEnlaceInst() {
        return enlaceInst;
    }

    public void setEnlaceInst(String enlaceInst) {
        this.enlaceInst = enlaceInst;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public Collection<Userproyecto> getUserproyectoCollection() {
        return userproyectoCollection;
    }

    public void setUserproyectoCollection(Collection<Userproyecto> userproyectoCollection) {
        this.userproyectoCollection = userproyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
    
}
