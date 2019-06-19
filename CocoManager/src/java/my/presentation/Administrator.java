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
    private User usuario;
    
    /**
     * Creates a new instance of Administrator
     */
    public Administrator() {
        this.usuarioActual = new User();
        this.usuario = new User();
    }
    
    public User getUsuario() {
        return usuario;
    }
    
    public User getUsuarioActual() {
        return usuarioActual;
    }
    
    public User getUsuarioModificar() {
        return usuarioModificar;
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
                    return "Administrador?faces-redirect=true&includeViewParams=true";
                }
                return "theend";
            } 
        }
        return "index";
    }
    
    public String modificarUsuario(int id){
        this.usuarioModificar = new User();
        this.usuarioModificar = userFacade.find(id);
        return "ModificaUsuario";
    }
    
    public String ModificarUsuario(){
        this.userFacade.edit(this.usuarioModificar);
        return "Administrador";
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
    
    public void modificarUsernameUsuario(int id, String username){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setUsuario(username);
            this.userFacade.edit(UsuarioAEditar);
        //}
    }
    
    public void modificarContraseñaUsuario(int id, String psw){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setContraseña(psw);
            this.userFacade.edit(UsuarioAEditar);
        //}
    } 
   
    public void eliminarProyecto(int idProyecto){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoABorrar = this.proyectoFacade.find(idProyecto);
            this.proyectoFacade.remove(proyectoABorrar);
        //}
    }
    
    public void modificarProyectoNombre(int idProyecto, String nombre){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoAModificar = this.proyectoFacade.find(idProyecto);
            proyectoAModificar.setNombre(nombre);
            this.proyectoFacade.edit(proyectoAModificar);
        //}
    }
    
    public void modificarProyectoDescripcion(int idProyecto, String descripcion){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoAModificar = this.proyectoFacade.find(idProyecto);
            proyectoAModificar.setDescripcion(descripcion);
            this.proyectoFacade.edit(proyectoAModificar);
        //}
    }
    
    
    public void modificarProyectoObjetivos(int idProyecto, String objetivos){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoAModificar = this.proyectoFacade.find(idProyecto);
            proyectoAModificar.setObjetivos(objetivos);
            this.proyectoFacade.edit(proyectoAModificar);
        //}
    }
    
    public void modificarProyectoFecha(int idProyecto, Date fecha){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoAModificar = this.proyectoFacade.find(idProyecto);
            proyectoAModificar.setFecha(fecha);
            this.proyectoFacade.edit(proyectoAModificar);
        //}
    }
    
    public void modificarProyectoCategoria(int idProyecto, Categoria idCategoria){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoAModificar = this.proyectoFacade.find(idProyecto);
            proyectoAModificar.setIdCategoria(idCategoria);
            this.proyectoFacade.edit(proyectoAModificar);
        //}
    }
    
    
    public void modificarProyectoRequerimientos(int idProyecto, String Req){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoAModificar = this.proyectoFacade.find(idProyecto);
            proyectoAModificar.setEnlaceReq(Req);
            this.proyectoFacade.edit(proyectoAModificar);
        //}
    }
    
    
    public void modificarProyectoReporte(int idProyecto, String Reporte){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoAModificar = this.proyectoFacade.find(idProyecto);
            proyectoAModificar.setEnlaceRepT(Reporte);
            this.proyectoFacade.edit(proyectoAModificar);
        //}
    }
    
    
    public void modificarProyectoCodigoFuente(int idProyecto, String CF){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoAModificar = this.proyectoFacade.find(idProyecto);
            proyectoAModificar.setEnlaceCF(CF);
            this.proyectoFacade.edit(proyectoAModificar);
        //}
    }
    
    
    public void modificarProyectoInstalador(int idProyecto, String Ins){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoAModificar = this.proyectoFacade.find(idProyecto);
            proyectoAModificar.setEnlaceInst(Ins);
            this.proyectoFacade.edit(proyectoAModificar);
        //}
    }
}
