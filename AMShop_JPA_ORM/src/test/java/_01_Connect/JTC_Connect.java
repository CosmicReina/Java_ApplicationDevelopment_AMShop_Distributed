package _01_Connect;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connect.MSSQLConnection;
import jakarta.persistence.EntityManager;

class JTC_Connect {

	private EntityManager entityManager = MSSQLConnection.getEntityManager();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void connect() {
		System.out.println(entityManager.createNativeQuery("SELECT 'Connection successful'")
				.getSingleResult()
				.toString());
	}

}
