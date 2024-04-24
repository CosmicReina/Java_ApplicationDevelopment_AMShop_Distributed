package _01_Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuration.ServiceInitiator;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import service_interface.IService_HoaDon;

class JTC_HoaDon {

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
	void getAllHoaDon() throws MalformedURLException, RemoteException, NotBoundException{
		
		System.err.println("getAllHoaDon()");
		
		IService_HoaDon service_HoaDon = ServiceInitiator.getInstance().getServiceHoaDon();
		List<HoaDon> list = service_HoaDon.getAllHoaDon();
		list.forEach(System.out::println);
		
		HoaDon hoaDon = list.get(0);
		NhanVien nhanvien = hoaDon.getNhanVien();
		KhachHang khachhang = hoaDon.getKhachHang();
		
		System.out.println("NhanVien: " + nhanvien);
		System.out.println("KhachHang: " + khachhang);
		
		System.out.println("\n");
	}

	@Test
	void getAllHoaDonTrongKhoangNgay() throws MalformedURLException, RemoteException, NotBoundException{
		
		System.err.println("getAllHoaDonTrongKhoangNgay()");
		
		IService_HoaDon service_HoaDon = ServiceInitiator.getInstance().getServiceHoaDon();
		service_HoaDon.getAllHoaDonTrongKhoangNgay(LocalDateTime.of(2023, 12, 01, 0, 0), LocalDateTime.of(2023, 12, 30, 0, 0)).forEach(System.out::println);
		
		System.out.println("\n");
	}
	
	@Test
	void getHoaDonTheoMaHoaDon() throws MalformedURLException, RemoteException, NotBoundException{
		
		System.err.println("getHoaDonTheoMaHoaDon()");
		
		IService_HoaDon service_HoaDon = ServiceInitiator.getInstance().getServiceHoaDon();
		System.out.println(service_HoaDon.getHoaDonTheoMaHoaDon("HD2312090001"));
		
		System.out.println("\n");
	}
	
	@Test
	void getHoaDonCuoi() throws MalformedURLException, RemoteException, NotBoundException{
		
		System.err.println("getHoaDonCuoi()");
		
		IService_HoaDon service_HoaDon = ServiceInitiator.getInstance().getServiceHoaDon();
		System.out.println(service_HoaDon.getHoaDonCuoi("HD23121400%"));
		
		System.out.println("\n");
	}
	
}
