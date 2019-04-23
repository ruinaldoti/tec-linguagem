import java.util.GregorianCalendar;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseGen {
	public static void main(String[] args) {
		Properties config = new Properties();
		config.put("hibernate.hbm2ddl.auto", "create");

		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("uni7-pu", config);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		
		Usuario u1 = new Funcionario(null, "cristiane", "123456",
				"secretaria", "coordenação");
		Usuario u2 = new Professor(null, "marum", "789456", 
				"SI", "Doutor");
		
		em.persist(u1);
		em.persist(u2);
		
		em.getTransaction().commit();

		em.close();
		factory.close();
	}
}
