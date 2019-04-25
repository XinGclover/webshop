package jpa;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EJBControllerDemo {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshopPU");

	private EntityManager entityManager() {
		return this.emf.createEntityManager();
	}

	public <T> void create(T t) {
		EntityManager em = this.entityManager();
		boolean saved = false;
		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}
			em.persist(t);
			entr.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public <T> T find(Class<T> type, Object id) {
		EntityManager em = this.entityManager();
		T t = null;
		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}
			t = em.find(type, id);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return t;
	}

	public <T> void update(T t) {
		EntityManager em = this.entityManager();
		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}
			em.merge(t);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public <T> void delete(T t) {
		EntityManager em = this.entityManager();
		try {
			EntityTransaction entr = em.getTransaction();
			if (!em.getTransaction().isActive()) {
				entr.begin();
			}
			t = em.merge(t);
			em.remove(t);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

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

	public <T> T namedQuery(String namedQuery, Map<String, Object> params) {
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

			return (T) query.getSingleResult();

		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return null;
	}
}
