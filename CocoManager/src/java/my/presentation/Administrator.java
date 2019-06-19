/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import entities.Categoria;
import entities.Proyecto;
import entities.User;
import facedes.ProyectoFacade;
import facedes.UserFacade;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Efraín
 */
@Named(value = "administrator")
@RequestScoped
public class Administrator {
    @EJB
    private ProyectoFacade proyectoFacade;
    
    @EJB
    private UserFacade userFacade;
    private User usuarioActual;
    private User usuarioModificar;
    private Proyecto proyectoModificar;
    
    /**
     * Creates a new instance of Administrator
     */
    public Administrator() {
        this.usuarioActual = new User();
        this.usuarioModificar = new User();
        this.proyectoModificar = new Proyecto();
    }
    
    public User getUsuarioActual() {
        return usuarioActual;
    }
    
    public User getUsuarioModificar() {
        return usuarioModificar;
    }
    
    public Proyecto getProyectoModificar(){
        return proyectoModificar;
    }
    
    public List<User> obtenerTodosUsuarios(){
        return userFacade.findAll();
    }
    
    public List<Proyecto> obtenerTodosProyectos(){
        return proyectoFacade.findAll();
    }
    
    public String traerUsuarioActual(){
        List<User> Usuarios = userFacade.findAll();
        for(User usr : Usuarios){
            if (usr.getUsuario().equals(this.usuarioActual.getUsuario())) {
                this.usuarioActual = usr;
                if (usr.getTipoDeUsuario()){
                    return "Administrador";
                }
                return "theend";
            } 
        }
        return "index";
    }
    
    public String modificarUsuario(int id){
        this.usuarioModificar = userFacade.find(id);
        return "ModificaUsuario";
    }
    
    public String ModificarUsuario(){
        List<User> Usuarios = userFacade.findAll();
        for(User usr : Usuarios){
            if (usr.getUsuario().equals(this.usuarioModificar.getUsuario())) {
                usr.setUsuario(this.usuarioModificar.getUsuario());
                usr.setContraseña(this.usuarioModificar.getContraseña());
                this.userFacade.edit(usr);
                return "Administrador";
            } 
        }
        return "Failure";
    }
    
    public void autorizarUsuario(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setAutorizacion(true);
            this.userFacade.edit(UsuarioAEditar);
        //}
    }
    
    public void crearAdmins(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setTipoDeUsuario(true);
            this.userFacade.edit(UsuarioAEditar);
        //}
    }
    
    public void asignarLimiteAUsuario(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setLimiteDeProyectos(false);
            this.userFacade.edit(UsuarioAEditar);
        //}
    }
    
    public void noAsignarLimiteAUsuario(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setLimiteDeProyectos(true);
            this.userFacade.edit(UsuarioAEditar);
        //}
    }
    
    public void eliminarUsuario(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEliminar = this.userFacade.find(id);
            this.userFacade.remove(UsuarioAEliminar);
        //}
    }
    
   
    public void eliminarProyecto(int idProyecto){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoABorrar = this.proyectoFacade.find(idProyecto);
            this.proyectoFacade.remove(proyectoABorrar);
        //}
    }
    
    public String modificarProyecto(int id){
        this.proyectoModificar = proyectoFacade.find(id);
        return "ModificarProyecto";
    }
    
    public String ModificarProyecto(){
        List<Proyecto> Proyectos = proyectoFacade.findAll();
        for(Proyecto pyt : Proyectos){
            if (pyt.getNombre().equals(this.proyectoModificar.getNombre())) {
                pyt.setNombre(this.proyectoModificar.getNombre());
                pyt.setDescripcion(this.proyectoModificar.getDescripcion());
                pyt.setEnlaceCF(this.proyectoModificar.getEnlaceCF());
                pyt.setEnlaceInst(this.proyectoModificar.getEnlaceInst());
                pyt.setEnlaceRepT(this.proyectoModificar.getEnlaceRepT());
                pyt.setEnlaceReq(this.proyectoModificar.getEnlaceReq());
                pyt.setEstado(this.proyectoModificar.getEstado());
                pyt.setFecha(this.proyectoModificar.getFecha());
                pyt.setIdCategoria(this.proyectoModificar.getIdCategoria());
                pyt.setObjetivos(this.proyectoModificar.getObjetivos());
                this.proyectoFacade.edit(pyt);
                return "Administrador";
            } 
        }
        return "Failure";
    }
}
