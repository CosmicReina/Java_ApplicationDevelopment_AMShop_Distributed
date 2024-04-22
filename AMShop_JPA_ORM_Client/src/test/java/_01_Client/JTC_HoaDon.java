package _01_Client;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuration.ServiceInitiator;
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
	void getAllHoaDon() throws RemoteException{
		
		System.err.println("getAllHoaDon()");
		
		IService_HoaDon service_HoaDon = ServiceInitiator.getInstance().getServiceHoaDon();
		service_HoaDon.getAllHoaDon().forEach(System.out::println);
		
		System.out.println("\n");
	}

	@Test
	void getAllHoaDonTrongKhoangNgay() throws RemoteException{
		
		System.err.println("getAllHoaDonTrongKhoangNgay()");
		
		IService_HoaDon service_HoaDon = ServiceInitiator.getInstance().getServiceHoaDon();
		service_HoaDon.getAllHoaDonTrongKhoangNgay(LocalDateTime.of(2023, 12, 01, 0, 0), LocalDateTime.of(2023, 12, 30, 0, 0)).forEach(System.out::println);
		
		System.out.println("\n");
	}
	
	@Test
	void getHoaDonTheoMaHoaDon() throws RemoteException{
		
		System.err.println("getHoaDonTheoMaHoaDon()");
		
		IService_HoaDon service_HoaDon = ServiceInitiator.getInstance().getServiceHoaDon();
		System.out.println(service_HoaDon.getHoaDonTheoMaHoaDon("HD2312090001"));
		
		System.out.println("\n");
	}
	
	@Test
	void getHoaDonCuoi() throws RemoteException{
		
		System.err.println("getHoaDonCuoi()");
		
		IService_HoaDon service_HoaDon = ServiceInitiator.getInstance().getServiceHoaDon();
		System.out.println(service_HoaDon.getHoaDonCuoi("HD23121400%"));
		
		System.out.println("\n");
	}
	
}
