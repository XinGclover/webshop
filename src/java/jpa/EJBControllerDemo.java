package jpa;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EJBControllerDemo {
//			Customers c = new Customers();
//			c.setAdress("adress");
//			c.setFirstname("asd");
//			c.setLastname("dasd");
//			c.setPassword("password");
//			em.persist(c);

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshopPU");

	private EntityManager entityManager() {
		return this.emf.createEntityManager();
	}

	public <T> boolean persist(T t) {
		EntityManager em = this.entityManager();
		boolean saved = false;
		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}

			em.persist(t);
			em.getTransaction().commit();
			em.close();
			saved = true;

		} catch (Exception ex) {
			em.getTransaction().rollback();
			saved = false;
		} finally {
			em.close();
		}
		return saved;

	}

	public List namedQuery(String namedQuery) {
		EntityManager em = this.entityManager();
		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}

			return em.createNamedQuery(namedQuery).getResultList();

		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return null;
	}

	public List namedQuery(String namedQuery, Map<String, Object> params) {
		EntityManager em = this.entityManager();
		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}
			Query query = em.createNamedQuery(namedQuery);

			params.entrySet().forEach((entry) -> {
				query.setParameter(entry.getKey(), entry.getValue());
			});

			return query.getResultList();

		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return null;
	}
}
