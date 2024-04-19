package _02_Query;

import org.hibernate.testing.junit4.CustomParameterized.Order;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import connection.ConnectionMSSQL;
import dao.DAO_CuaHang;
import entity.CuaHang;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_CuaHang {
	
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
	void getCuaHang() throws InterruptedException{
		System.err.println("getCuaHang()");
		
		System.err.println("query");
		CuaHang cuaHang = DAO_CuaHang.getCuaHang("AMShopGV01");
		
		System.err.println("result");
		System.out.println(cuaHang);

		System.out.println("\n");
	}
}
