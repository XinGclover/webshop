package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestEM {

	public static void main(String[] args) {
		TestEM testEM = new TestEM();

		EntityManagerFactory emf
			= Persistence.createEntityManagerFactory("webshopPU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Colleagues col = new Colleagues();
		
		col.setFirstname("Nikals");
		col.setLastname("Nikalsson");
		col.setDepartment("IT");
		col.setEmail("slask@nikals.se");
		col.setTitle("CEO");
		
		em.persist(col);

		em.getTransaction().commit();

		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}
			Query query = em.createNamedQuery("Colleagues.findAll");

			query.getResultList().forEach((obj) -> {
				System.out.println(obj);
				System.out.println("hello");
			});

		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}
}
