import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsuarioDAO {
	private EntityManagerFactory factory;
	
	public UsuarioDAO(){
		factory = Persistence.
				createEntityManagerFactory("uni7-pu");		
	}
	
	public Usuario inserir(Usuario usuario) {
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return usuario;
	}
	
	public List<Usuario> buscarTodos(){
		List<Usuario> result = new ArrayList<Usuario>();
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("from Usuario u");
		result = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return result;
	}
	
	public Usuario buscarPorID(Integer id) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Usuario result = entityManager.find(Usuario.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
	
	public void remover(Integer id) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
