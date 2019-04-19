package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EJBControllerDemo {

	EntityManagerFactory emf;

	public EJBControllerDemo() {
		this.emf = Persistence.createEntityManagerFactory("webshopPU");
	}

	private EntityManager entityManager() {
		return this.emf.createEntityManager();
	}

	public static void main(String[] args) {
		EJBControllerDemo testEM = new EJBControllerDemo();

		EntityManager em = testEM.entityManager();

		em.getTransaction().begin();
		for (int i = 0; i < 10; i++) {
			Customers c = new Customers();
			c.setAdress("adress");
			c.setFirstname("asd");
			c.setLastname("dasd");
			c.setPassword("password");
			em.persist(c);
		}
		em.getTransaction().commit();

		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}
			Query query = em.createNamedQuery("Customers.findAll");

			query.getResultList().forEach((obj) -> {
				System.out.println(obj);
			});

		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}

	public void findAll() {

	}
}
