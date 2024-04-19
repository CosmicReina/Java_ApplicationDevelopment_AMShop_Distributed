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
import dao.DAO_ChiTietDonDatHang;
import entity.ChiTietDonDatHang;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_ChiTietDonDatHang {
	
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
	void getAllChiTietDonDatHangTheoMaDonDatHang() throws InterruptedException {
		System.err.println("getAllChiTietDonDatHangTheoMaDonDatHang()");
		
		System.err.println("query");
		List<ChiTietDonDatHang> list = DAO_ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang("DD2311150001");
		
		System.err.println("result");
		list.forEach(System.out::println);

		System.out.println("\n");
	}
}
