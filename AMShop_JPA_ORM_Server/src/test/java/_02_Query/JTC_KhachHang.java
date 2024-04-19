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
import dao.DAO_KhachHang;
import entity.KhachHang;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_KhachHang {

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
	void getAllKhachHang() throws InterruptedException{
		System.err.println("getAllKhachHang()");

		System.err.println("query");
		List<KhachHang> list = DAO_KhachHang.getAllKhachHang();

		System.err.println("result");
		list.forEach(System.out::println);

		System.out.println("\n");
	}

	@Test
	@Order(2)
	void getKhachHangTheoMaKhachHang() throws InterruptedException{
		System.err.println("getKhachHangTheoMaKhachHang()");

		System.err.println("query");
		KhachHang khachHang = DAO_KhachHang.getKhachHangTheoMaKhachHang("KH23000001");

		System.err.println("result");
		System.out.println(khachHang);

		System.out.println("\n");
	}
	
	@Test
	@Order(3)
	void getKhachHangTheoSoDienThoai() throws InterruptedException{
		System.err.println("getKhachHangTheoSoDienThoai()");
		
		System.err.println("query");
		KhachHang khachHangSDT = DAO_KhachHang.getKhachHangTheoSoDienThoai("0334999221");
		
		System.err.println("result");
		System.out.println(khachHangSDT);
		
		System.out.println("\n");
	}
	
	@Test
	@Order(4)
	void getKhachHangCuoi() throws InterruptedException{
		System.err.println("getKhachHangCuoi()");
		
		System.err.println("query");
		KhachHang khachHangCuoi = DAO_KhachHang.getKhachHangCuoi("KH230000%");
		
		System.err.println("result");
		System.out.println(khachHangCuoi);
		
		System.out.println("\n");
	}

}
