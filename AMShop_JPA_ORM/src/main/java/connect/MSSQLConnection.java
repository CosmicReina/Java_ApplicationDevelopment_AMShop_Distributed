package connect;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MSSQLConnection {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	private MSSQLConnection() {
	}
	
	public static void open() {
		entityManagerFactory = Persistence.createEntityManagerFactory("AMShop_JPA_ORM");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static void close() {
		entityManager.close();
		entityManagerFactory.close();
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

}
