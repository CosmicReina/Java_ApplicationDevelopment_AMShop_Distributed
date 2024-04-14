package connect;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MSSQLConnection {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AMShop_JPA_ORM");
	
	private MSSQLConnection() {}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
