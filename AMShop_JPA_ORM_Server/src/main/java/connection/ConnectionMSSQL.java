package connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ConnectionMSSQL {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	private ConnectionMSSQL() {
	}

	public static void open() {
		entityManagerFactory = jakarta.persistence.Persistence
				.createEntityManagerFactory("AMShop_JPA_ORM_Server");
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
