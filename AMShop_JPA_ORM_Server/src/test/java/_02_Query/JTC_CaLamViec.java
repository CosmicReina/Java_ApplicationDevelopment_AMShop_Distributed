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
import dao.DAO_CaLamViec;
import entity.CaLamViec;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_CaLamViec {
	
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
	void getAllCaLamViec() throws InterruptedException{
		System.err.println("getAllCaLamViec()");
		
		System.err.println("query");
		List<CaLamViec> list = DAO_CaLamViec.getAllCaLamViec();
		
		System.err.println("result");
		list.forEach(System.out::println);
		
		System.out.print("\n");
	}
	
	@Test
	@Order(2)
	void getCaLamViecTheoMaCaLamViec() throws InterruptedException{
		System.err.println("getCaLamViecTheoMaCaLamViec()");
		
		System.err.println("query");
		CaLamViec caLamViec = DAO_CaLamViec.getCaLamViecTheoMaCaLamViec(1);
		
		System.err.println("result");
		System.out.println(caLamViec);
		
		System.out.print("\n");
	}
}
