package _01_Connect;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connect.MSSQLConnection;
import entity.QuanAo;
import jakarta.persistence.EntityManager;

class JTC_Connect {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		MSSQLConnection.open();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		MSSQLConnection.close();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void connect() {
		EntityManager entityManager = MSSQLConnection.getEntityManager();
		System.out.println(entityManager.createNativeQuery("SELECT 'Connection successful'")
				.getSingleResult()
				.toString());
	}

	@Test
	void getAllQuanAo() {
		EntityManager entityManager = MSSQLConnection.getEntityManager();
		entityManager.createQuery("SELECT qa FROM QuanAo qa", QuanAo.class)
				.getResultList()
				.forEach(System.out::println);
	}

}
