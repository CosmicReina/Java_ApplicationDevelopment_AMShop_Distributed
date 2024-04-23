package _01_Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuration.ServiceInitiator;
import service_interface.IService_KhachHang;

class JTC_KhachHang {

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
	void getAllKhachHang() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getAllKhachHang()");
		
		IService_KhachHang service_KhachHang = ServiceInitiator.getInstance().getServiceKhachHang();
		service_KhachHang.getAllKhachHang().forEach(System.out::println);
		
		System.out.println("\n");
		
	}
	
	@Test
	void getKhachHangTheoMaKhachHang() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getKhachHangTheoMaKhachHang()");
		
		IService_KhachHang service_KhachHang = ServiceInitiator.getInstance().getServiceKhachHang();
		System.out.println(service_KhachHang.getKhachHangTheoMaKhachHang("KH23000001"));
		
		System.out.println("\n");
		
	}
	
	@Test
	void getKhachHangTheoSoDienThoai() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getKhachHangTheoSoDienThoai()");
		
		IService_KhachHang service_KhachHang = ServiceInitiator.getInstance().getServiceKhachHang();
		System.out.println(service_KhachHang.getKhachHangTheoSoDienThoai("0334999221"));
		
		System.out.println("\n");
		
	}
	
	@Test
	void getKhachHangCuoi() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getKhachHangCuoi()");
		
		IService_KhachHang service_KhachHang = ServiceInitiator.getInstance().getServiceKhachHang();
		System.out.println(service_KhachHang.getKhachHangCuoi("KH230000%"));
		
		System.out.println("\n");
		
	}
	
	

}
