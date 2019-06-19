/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import entities.Categoria;
import facedes.CategoriaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Efraín
 */
@Named(value = "messageView")
@RequestScoped
public class MessageView {

    @EJB
    private CategoriaFacade categoriaFacade;
    private Categoria categoria;
    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.categoria= new Categoria();
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public int getNumberOfCategorias(){
        return categoriaFacade.findAll().size();
    }
    
    public List<Categoria> getTotalCategorias(){
        return categoriaFacade.findAll();
    }
    
    public String postCategoria(){
        this.categoriaFacade.create(categoria);
        return "theend";
    }
    
    
    
}
