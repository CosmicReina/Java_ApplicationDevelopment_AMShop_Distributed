package _01_Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuration.ServiceInitiator;
import service_interface.IService_NhanVien;

class JTC_NhanVien {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getAllNhanVien() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getAllNhanVien()");
		
		IService_NhanVien service_NhanVien = ServiceInitiator.getInstance().getServiceNhanVien();
		service_NhanVien.getAllNhanVien().forEach(System.out::println);
		
		System.out.println("\n");
	}
	
	@Test
	void getNhanVienTheoMaNhanVien() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getNhanVienTheoMaNhanVien()");
		
		IService_NhanVien service_NhanVien = ServiceInitiator.getInstance().getServiceNhanVien();
		System.out.println(service_NhanVien.getNhanVienTheoMaNhanVien("NV12312312"));
		
		System.out.println("\n");
	}
	
	@Test
	void getNhanVienTheoSoDienThoai() throws MalformedURLException, RemoteException, NotBoundException{
		System.err.println("getNhanVienTheoSoDienThoai()");
		
		IService_NhanVien service_NhanVien = ServiceInitiator.getInstance().getServiceNhanVien();
		System.out.println(service_NhanVien.getNhanVienTheoSoDienThoai("0332916529"));
		
		System.out.println("\n");
	}
	
	@Test
	void getNhanVienTheoCanCuocCongDan() throws MalformedURLException, RemoteException, NotBoundException{
		System.err.println("getNhanVienTheoCanCuocCongDan()");
		
		IService_NhanVien service_NhanVien = ServiceInitiator.getInstance().getServiceNhanVien();
		System.out.println(service_NhanVien.getNhanVienTheoCanCuocCongDan("051203048912"));
		
		System.out.println("\n");
	}
	
	@Test
	void getDanhSachNhanVienChuaCoTrongNgayLamViec() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getDanhSachNhanVienChuaCoTrongNgayLamViec()");
		
		IService_NhanVien service_NhanVien = ServiceInitiator.getInstance().getServiceNhanVien();
		service_NhanVien.getDanhSachNhanVienChuaCoTrongNgayLamViec(LocalDate.of(2023, 12, 03)).forEach(System.out::println);;
		
		System.out.println("\n");
	}
	
	@Test
	void getNhanVienCuoi() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getNhanVienCuoi()");
		
		IService_NhanVien service_NhanVien = ServiceInitiator.getInstance().getServiceNhanVien();
		System.out.println(service_NhanVien.getNhanVienCuoi("NV231213%"));
		
		System.out.println("\n");
	}
	
	@Test
	void getNhanVienTheoThongTinDangNhap() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getNhanVienTheoThongTinDangNhap()");
		
		IService_NhanVien service_NhanVien = ServiceInitiator.getInstance().getServiceNhanVien();
		System.out
				.println(service_NhanVien.getNhanVienTheoThongTinDangNhap("NV12312312", "123"));

		System.out.println("\n");
	}

}
