package _01_Client;

import java.rmi.RemoteException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuration.ServiceInitiator;
import service_interface.IService_QuanAo;

class JTC_QuanAo {

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
	void getAllQuanAo() throws RemoteException {
		System.err.println("getAllQuanAo");
		
		IService_QuanAo service_QuanAo = ServiceInitiator.getInstance().getServiceQuanAo();
		service_QuanAo.getAllQuanAo().forEach(System.out::println);
		
		System.out.println("\n");
	}
	
//	@Test
//	void getQuanAoTheoMaQuanAo() throws RemoteException {
//		System.err.println("getQuanAoTheoMaQuanAo()");
//		
//		IService_QuanAo service_QuanAo = ServiceInitiator.getInstance().getServiceQuanAo();
//		System.out.println(service_QuanAo.getQuanAoTheoMaQuanAo("QA000001"));
//		
//		System.out.println("\n");
//	}
	
//	@Test
//	void getQuanAoCuoi() throws RemoteException {
//		System.err.println("getQuanAoCuoi()");
//		
//		IService_QuanAo service_QuanAo = ServiceInitiator.getInstance().getServiceQuanAo();
//		System.out.println(service_QuanAo.getQuanAoCuoi("QA0000%"));
//		
//		System.out.println("\n");
//	}

}
