package _01_Client;

import java.rmi.RemoteException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuration.ServiceInitiator;
import service_interface.IService_CaLamViec;

class JTC_CaLamViec {

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
	void getAllCaLamViec() throws RemoteException{
		
		System.err.println("getAllCaLamViec()");
		
		IService_CaLamViec service_CaLamViec = ServiceInitiator.getInstance().getServiceCaLamViec();
		service_CaLamViec.getAllCaLamViec().forEach(System.out::println);
		
		System.out.println("\n");
	}
	
	@Test
	void getCaLamViecTheoMaCaLamViec() throws RemoteException{
		
		System.err.println("getCaLamViecTheoMaCaLamViec()");
		
		IService_CaLamViec service_CaLamViec = ServiceInitiator.getInstance().getServiceCaLamViec();
		System.out.println(service_CaLamViec.getCaLamViecTheoMaCaLamViec(1));
		
		System.out.println("\n");
	}

}
