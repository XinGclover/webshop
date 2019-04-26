package crud;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
//@Local(GenericCrudService.class)
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class GenericCrudServiceBean implements GenericCrudService {

	@PersistenceContext(name = "webshopPU")
	private EntityManager em;

	@Override
	public <T> T create(T t) {
		em.persist(t);
		return t;
	}

	@Override
	public <T> T find(Class<T> type, Object id) {
		return em.find(type, id);
	}

	@Override
	public <T> void delete(T t) {
		t = em.merge(t);
		em.remove(t);
	}

	@Override
	public <T> T update(T t) {
		return em.merge(t);
	}

	@Override
	public List findWithNamedQuery(String queryName) {
		return em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List findWithNamedQuery(String queryName, int resultLimit) {
		return em.createNamedQuery(queryName).setMaxResults(resultLimit)
			.getResultList();
	}

	@Override
	public List findWithNamedQuery(String namedQueryName,
		Map<String, Object> parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List findWithNamedQuery(String namedQueryName,
		Map<String, Object> parameters,
		int resultLimit) {
		Query query = this.em.createNamedQuery(namedQueryName);
		if (resultLimit > 0) {
			query.setMaxResults(resultLimit);
		}

		parameters.entrySet().forEach((entry) -> {
			query.setParameter(entry.getKey(), entry.getValue());
		});
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> findWithNativeQuery(String sql, Class<T> type) {
		return em.createNativeQuery(sql, type).getResultList();
	}

	@Override
	public <T> void nuke(Class<T> type) {
		
		findWithNativeQuery("SELECT * from " + type.getSimpleName(), type).forEach(e -> {
			delete(e);
		});
	}
}
