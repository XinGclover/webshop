/*
 *  
Java18-OOJ
 */
package crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.Fruit;

/**
 *
 * @author xingao
 */
@Stateless
public class FruitFacade extends AbstractFacade<Fruit> {

    @PersistenceContext(unitName = "webshopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FruitFacade() {
        super(Fruit.class);
    }
    
}
