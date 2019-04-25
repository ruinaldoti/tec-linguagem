import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAO<T> {
	private Class<T> _class;
	private EntityManagerFactory factory;

	public DAO(Class<T> _class) {
		this._class = _class;
		factory = Persistence.createEntityManagerFactory("uni7-pu");
	}

	public T inserir(T t) {
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();

		entityManager.close();

		return t;
	}

	public List<T> buscarTodos() {
		List<T> result = null;

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("from " + this._class.getSimpleName() + " t");
		result = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();

		return result;
	}
}
