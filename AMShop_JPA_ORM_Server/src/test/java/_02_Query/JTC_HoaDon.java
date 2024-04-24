package _02_Query;

import java.time.LocalDate;
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
import dao.DAO_HoaDon;
import entity.HoaDon;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_HoaDon {

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
	void getAllHoaDon() throws InterruptedException{
		System.err.println("getAllHoaDon()");
		
		System.err.println("query");
		List<HoaDon> list = DAO_HoaDon.getAllHoaDon();
		
		System.err.println("result");
		list.forEach(System.out::println);
		
		System.out.println("\n");
	}
	
	@Test
	@Order(2)
	void getAllHoaDonTrongKhoangNgay() throws InterruptedException {
		System.err.println("getAllHoaDonTrongKhoangNgay()");
		
		System.err.println("query");
		List<HoaDon> list_day = DAO_HoaDon.getAllHoaDonTrongKhoangNgay(LocalDate.of(2023, 12, 9), LocalDate.of(2023, 12, 14));
		
		System.err.println("result");
		list_day.forEach(System.out::println);
		
		System.out.println("\n");
	}
	
	@Test
	@Order(3)
	void getHoaDonTheoMaHoaDon() throws InterruptedException {
		System.err.println("getHoaDonTheoMaHoaDon()");
		
		System.err.println("query");
		HoaDon hoaDon = DAO_HoaDon.getHoaDonTheoMaHoaDon("HD2312090001");
		
		System.err.println("result");
		System.out.println(hoaDon);

		System.out.println("\n");
	}
	
	@Test
	@Order(4)
	void getHoaDonCuoi() throws InterruptedException{
		System.err.println("getHoaDonCuoi()");
		
		System.err.println("query");
		HoaDon hoaDonCuoi = DAO_HoaDon.getHoaDonCuoi("HD23121400%");
		
		System.err.println("result");
		System.out.println(hoaDonCuoi);

		System.out.println("\n");
	}
	
}
