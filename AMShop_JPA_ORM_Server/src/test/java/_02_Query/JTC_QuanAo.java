package _02_Query;

import java.util.List;

import org.hibernate.testing.junit4.CustomParameterized.Order;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import connection.ConnectionMSSQL;
import dao.DAO_QuanAo;
import entity.QuanAo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_QuanAo {

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
	@Order(1)
	void getAllQuanAo() throws InterruptedException {
		System.err.println("getAllQuanAo");
		
		System.err.println("query");
		List<QuanAo> list = DAO_QuanAo.getAllQuanAo();
		
		System.err.println("result");
		list.forEach(System.out::println);
		
		System.out.println("\n\n");
	}

}
