/*
 *  
Java18-OOJ
 */
package crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.Categories;

/**
 *
 * @author xingao
 */
@Stateless
public class CategoriesFacade extends AbstractFacade<Categories> {

    @PersistenceContext(unitName = "webshopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriesFacade() {
        super(Categories.class);
    }
    
}
