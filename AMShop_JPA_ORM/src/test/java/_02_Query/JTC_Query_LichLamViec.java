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

import connect.MSSQLConnection;
import dao.DAO_LichLamViec;
import entity.LichLamViec;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_Query_LichLamViec {
	
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
	@Order(1)
	void getAllLichLamViec() {
		System.err.println("getAllLichLamViec()");
		
		System.err.println("query");
		List<LichLamViec> list = DAO_LichLamViec.getAllLichLamViec();
		
		System.err.println("result");
		list.forEach(System.out::println);

		System.out.println("\n");
	}
	
	@Test
	@Order(2)
	void getLichLamViecTheoMaLichLamViec() {
		System.err.println("getLichLamViecTheoMaLichLamViec()");
		
		System.err.println("query");
		LichLamViec lichLamViec = DAO_LichLamViec.getLichLamViecTheoMaLichLamViec("LH231101C");
		
		System.err.println("result");
		System.out.println(lichLamViec);

		System.out.println("\n");
	}
}
