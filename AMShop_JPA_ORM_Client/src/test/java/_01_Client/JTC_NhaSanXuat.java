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
import service_interface.IService_NhaSanXuat;

class JTC_NhaSanXuat {

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
	void getAllNhaSanXuat() throws MalformedURLException, RemoteException, NotBoundException {
		System.err.println("getAllNhaSanXuat()");
		
		IService_NhaSanXuat service_NhaSanXuat = ServiceInitiator.getInstance().getServiceNhaSanXuat();
		service_NhaSanXuat.getAllNhaSanXuat().forEach(System.out::println);
		
		System.out.println("\n");
	}

	@Test
	void kiemTraTonTai() throws MalformedURLException, RemoteException, NotBoundException{
		System.err.println("kiemTraTonTai()");
		
		IService_NhaSanXuat service_NhaSanXuat = ServiceInitiator.getInstance().getServiceNhaSanXuat();
		System.out.println(service_NhaSanXuat.kiemTraTonTai("Adidas"));
		
		System.out.println("\n");
	}
}
