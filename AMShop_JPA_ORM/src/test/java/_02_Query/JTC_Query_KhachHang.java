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
import dao.DAO_KhachHang;
import entity.KhachHang;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_Query_KhachHang {

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
	void getAllKhachHang() {
		System.err.println("getAllKhachHang()");

		System.err.println("query");
		List<KhachHang> list = DAO_KhachHang.getAllKhachHang();

		System.err.println("result");
		list.forEach(System.out::println);

		System.out.println("\n");
	}

	@Test
	@Order(2)
	void getKhachHangTheoMaKhachHang() {
		System.err.println("getKhachHangTheoMaKhachHang()");

		System.err.println("query");
		KhachHang khachHang = DAO_KhachHang.getKhachHangTheoMaKhachHang("KH23000001");

		System.err.println("result");
		System.out.println(khachHang);

		System.out.println("\n");
	}

}
