package jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomersFacade extends AbstractFacade<Customers> {

	@PersistenceContext(unitName = "java18-kvalit18-javaee-webshopPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CustomersFacade() {
		super(Customers.class);
	}


}
