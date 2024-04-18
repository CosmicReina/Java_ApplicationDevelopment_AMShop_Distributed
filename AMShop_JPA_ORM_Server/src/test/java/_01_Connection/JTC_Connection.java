package _01_Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connection.ConnectionMSSQL;
import jakarta.persistence.EntityManager;

class JTC_Connection {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ConnectionMSSQL.open();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		ConnectionMSSQL.close();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		EntityManager entityManager = ConnectionMSSQL.getEntityManager();
		System.out.println(entityManager.createQuery("SELECT 'Connection successful'")
				.getSingleResult()
				.toString());
	}

}
