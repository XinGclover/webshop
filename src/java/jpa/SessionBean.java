package jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nikalsNy
 */
@Stateless
public class SessionBean {

	public static void main(String[] args) {
		EntityManagerFactory emf
			= Persistence.createEntityManagerFactory("java18-kvalit18-javaee-webshopPU");
		EntityManager em = emf.createEntityManager();

		System.out.println(em.createNamedQuery("Customers.findAll", Customers.class));

	}

}
