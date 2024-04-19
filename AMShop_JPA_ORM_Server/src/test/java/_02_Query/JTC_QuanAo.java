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
	
	@Test
	@Order(2)
	void getQuanAoTheoMaQuanAo() throws InterruptedException{
		System.err.println("getQuanAoTheoMaQuanAo");
		
		System.err.println("query");
		QuanAo quanAo = DAO_QuanAo.getQuanAoTheoMaQuanAo("QA000001");
		
		System.err.println("result");
		System.out.println(quanAo);
		
		System.out.println("\n");
	}
	
	@Test
	@Order(3)
	void getQuanAoCuoi() throws InterruptedException{
		System.err.println("getQuanAoCuoi");
		
		System.err.println("query");
		QuanAo quanAoCuoi = DAO_QuanAo.getQuanAoCuoi("QA0000%");
		
		System.err.println("result");
		System.out.println(quanAoCuoi);
		
		System.out.println("\n");
	}

}
