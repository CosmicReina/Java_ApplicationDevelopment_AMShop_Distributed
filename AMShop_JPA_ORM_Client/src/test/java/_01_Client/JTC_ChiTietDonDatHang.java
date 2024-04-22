package _01_Client;

import java.rmi.RemoteException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuration.ServiceInitiator;
import service_interface.IService_ChiTietDonDatHang;

class JTC_ChiTietDonDatHang {

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
	void getAllChiTietDonDatHangTheoMaDonDatHang() throws RemoteException {
		System.err.println("getAllChiTietDonDatHangTheoMaDonDatHang()");
		
		IService_ChiTietDonDatHang service_ChiTietDonDatHang = ServiceInitiator.getInstance().getServiceChiTietDonDatHang();
		service_ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang("DD2311150001").forEach(System.out::println);
		
		System.out.println("\n");
		
	}

}
