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
import service_interface.IService_LichLamViec;

class JTC_LichLamViec {

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
	void getAllLichLamViec() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getAllLichLamViec()");
		
		IService_LichLamViec service_LichLamViec = ServiceInitiator.getInstance().getServiceLichLamViec();
		service_LichLamViec.getAllLichLamViec().forEach(System.out::println);
		
		System.out.println("\n");
	}
	
	@Test
	void getLichLamViecTheoMaLichLamViec() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getLichLamViecTheoMaLichLamViec()");
		
		IService_LichLamViec service_LichLamViec = ServiceInitiator.getInstance().getServiceLichLamViec();
		System.out.println(service_LichLamViec.getLichLamViecTheoMaLichLamViec("LH231101C"));
		
		System.out.println("\n");
	}

}
