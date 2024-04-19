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
import dao.DAO_NhaSanXuat;
import entity.NhaSanXuat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_NhaSanXuat {
	
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
	void getAllNhaSanXuat() throws InterruptedException {
		System.err.println("getAllNhaSanXuat()");
		
		System.err.println("query");
		List<NhaSanXuat> list = DAO_NhaSanXuat.getAllNhaSanXuat();
		
		System.err.println("result");
		list.forEach(System.out::println);

		System.out.println("\n");
	}
	
	@Test
	@Order(2)
	void kiemTraTonTai() throws InterruptedException{
		System.err.println("kiemTraTonTai()");
		
		System.err.println("query");
		NhaSanXuat nhaSanXuat = DAO_NhaSanXuat.kiemTraTonTai("Adidas");
		
		System.err.println("result");
		System.out.println(nhaSanXuat);

		System.out.println("\n");
	}
}
