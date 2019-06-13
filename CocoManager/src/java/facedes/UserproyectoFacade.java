/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facedes;

import entities.Userproyecto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Efraín
 */
@Stateless
public class UserproyectoFacade extends AbstractFacade<Userproyecto> {

    @PersistenceContext(unitName = "CocoManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserproyectoFacade() {
        super(Userproyecto.class);
    }
    
}
