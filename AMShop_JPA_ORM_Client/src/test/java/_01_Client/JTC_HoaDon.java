package _01_Client;

import java.rmi.RemoteException;

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

}
