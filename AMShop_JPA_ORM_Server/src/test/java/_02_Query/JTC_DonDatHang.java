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
import dao.DAO_DonDatHang;
import entity.DonDatHang;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JTC_DonDatHang {
	
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
	void getAllDonDatHang() throws InterruptedException{
		System.err.println("getAllDonDatHang()");
		
		System.err.println("query");
		List<DonDatHang> list = DAO_DonDatHang.getAllDonDatHang();
		
		System.err.println("result");
		list.forEach(System.out::println);
		
		System.out.println("\n");
	}
	
	@Test
	@Order(2)
	void getDonDatHangTheoMaDonDatHang() throws InterruptedException{
		System.err.println("getDonDatHangTheoMaDonDatHang()");
		
		System.err.println("query");
		DonDatHang donDatHang = DAO_DonDatHang.getDonDatHangTheoMaDonDatHang("DD2311150001");
		
		System.err.println("result");
		System.out.println(donDatHang);
		
		System.out.println("\n");
	}
	
	@Test
	@Order(3)
	void getMaDonDatHangCuoi() throws InterruptedException{
		System.err.println("getDonDatHangCuoi()");
		
		System.err.println("query");
		DonDatHang donDatHangCuoi = DAO_DonDatHang.getDonDatHangCuoi("DD23111500%");
		
		System.err.println("result");
		System.out.println(donDatHangCuoi);
		
		System.out.println("\n");
	}
}
