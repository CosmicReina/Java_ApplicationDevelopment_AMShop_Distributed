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
import service_interface.IService_DonDatHang;

class JTC_DonDatHang {

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
	void getAllDonDatHang() throws MalformedURLException, RemoteException, NotBoundException{
		System.err.println("getAllDonDatHang()");
		
		IService_DonDatHang service_DonDatHang = ServiceInitiator.getInstance().getServiceDonDatHang();
		service_DonDatHang.getAllDonDatHang().forEach(System.out::println);
		
		System.out.println("\n");
	}
	
	@Test
	void getDonDatHangTheoMaDonDatHang() throws MalformedURLException, RemoteException, NotBoundException{
		System.err.println("getDonDatHangTheoMaDonDatHang()");
		
		IService_DonDatHang service_DonDatHang = ServiceInitiator.getInstance().getServiceDonDatHang();
		System.out.println(service_DonDatHang.getDonDatHangTheoMaDonDatHang("DD2311150001"));
		
		System.out.println("\n");
	}
	
	@Test
	void getMaDonDatHangCuoi() throws MalformedURLException, RemoteException, NotBoundException{
		System.err.println("getDonDatHangCuoi()");
		
		IService_DonDatHang service_DonDatHang = ServiceInitiator.getInstance().getServiceDonDatHang();
		System.out.println(service_DonDatHang.getDonDatHangCuoi("DD23111500%"));
		
		System.out.println("\n");
	}

}
