package _02_Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.hibernate.testing.junit4.CustomParameterized.Order;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import connection.ConnectionMSSQL;
import dao.DAO_NhanVien;
import entity.NhanVien;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JTC_NhanVien {

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
	@Order(1)void getAllNhanVien() throws InterruptedException {
		System.err.println("getAllNhanVien()");

		System.err.println("query");
		List<NhanVien> list = DAO_NhanVien.getAllNhanVien();
		
		System.err.println("result");
		list.forEach(System.out::println);

		System.out.println("\n");
	}
	
	@Test
	@Order(2)
	void getNhanVienTheoMaNhanVien()throws InterruptedException  {
		System.err.println("getNhanVienTheoMaNhanVien()");
		
		System.err.println("query");
		NhanVien nhanVien = DAO_NhanVien.getNhanVienTheoMaNhanVien("NV12312312");
		
		System.err.println("result");
		System.out.println(nhanVien);

		System.out.println("\n");
	}
	
	@Test
	@Order(3)
	void getNhanVienTheoSoDienThoai() throws InterruptedException {
		System.err.println("getNhanVienTheoSoDienThoai()");
		
		System.err.println("query");
		NhanVien nhanVienSDT = DAO_NhanVien.getNhanVienTheoSoDienThoai("0332916529");
		
		System.err.println("result");
		System.out.println(nhanVienSDT);

		System.out.println("\n");
	}
	
	@Test
	@Order(4)
	void getNhanVienTheoCanCuocCongDan() throws InterruptedException {
		System.err.println("getNhanVienTheoCanCuocCongDan()");
		
		System.err.println("query");
		NhanVien nhanVienCCCD = DAO_NhanVien.getNhanVienTheoCanCuocCongDan("051203048912");
		
		System.err.println("result");
		System.out.println(nhanVienCCCD);

		System.out.println("\n");
	}
	
	@Test
	@Order(5)
	void getDanhSachNhanVienChuaCoTrongNgayLamViec() throws InterruptedException {
		System.err.println("getDanhSachNhanVienChuaCoTrongNgayLamViec()");
		
		System.err.println("query");
		List<NhanVien> list_n = DAO_NhanVien.getDanhSachNhanVienChuaCoTrongNgayLamViec(LocalDate.of(2023, 12, 03));
		
		System.err.println("result");
		list_n.forEach(System.out::println);

		System.out.println("\n");
	}

	@Test
	@Order(6)
	void getNhanVienCuoi() throws InterruptedException {
		System.err.println("getNhanVienCuoi()");
		
		System.err.println("query");
		NhanVien nhanVienCuoi = DAO_NhanVien.getNhanVienCuoi("NV231213%");
		
		System.err.println("result");
		System.out.println(nhanVienCuoi);

		System.out.println("\n");
	}
	
	@Test
	@Order(7)
	void getNhanVienTheoThongTinDangNhap() throws InterruptedException {
		System.err.println("getNhanVienTheoThongTinDangNhap()");

		System.err.println("query");
		NhanVien nhanVienTTDN_1 = DAO_NhanVien.getNhanVienTheoThongTinDangNhap("NV12312312",
				"123");
		NhanVien nhanVienTTDN_2 = DAO_NhanVien.getNhanVienTheoThongTinDangNhap("NV12312312",
				"123456");

		System.err.println("result");
		System.out.println("NV_1: " + nhanVienTTDN_1);
		System.out.println("NV_2: " + nhanVienTTDN_2);

		System.out.println("\n");
	}
	
	@Test
	@Order(8)
	void getTongThoiGianLamViecTheoThang() throws InterruptedException {
		System.err.println("getTongThoiGianLamViecTheoThang()");

		System.err.println("query");
		Map<NhanVien, Integer> map = DAO_NhanVien.getTongThoiGianLamViecTheoThang(2023, 12);

		System.err.println("result");
		map.forEach((k, v) -> {
			System.out.println(k + " - " + v);
		});

		System.out.println("\n");
	}
	
}
