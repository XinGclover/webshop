package jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EJBControllerDemo {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshopPU");

	private EntityManager entityManager() {
		return this.emf.createEntityManager();
	}

	public List findAll(String namedQuery) {
		EntityManager em = this.entityManager();
		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}

			return em.createNamedQuery(namedQuery).getResultList();

		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return null;
	}

}

//	public static void main(String[] args) {
//		EJBControllerDemo testEM = new EJBControllerDemo();
//		EntityManager em = testEM.entityManager();
//		em.getTransaction().begin();
//		for (int i = 0; i < 10; i++) {
//			Customers c = new Customers();
//			c.setAdress("adress");
//			c.setFirstname("asd");
//			c.setLastname("dasd");
//			c.setPassword("password");
//			em.persist(c);
//		}
//		em.getTransaction().commit();
//	}
