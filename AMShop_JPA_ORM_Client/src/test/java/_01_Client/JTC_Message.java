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
import service_interface.IService_Message;

class JTC_Message {

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
	void sendHello() throws MalformedURLException, RemoteException, NotBoundException {
		IService_Message service_Message = ServiceInitiator.getInstance().getServiceMessage();
		System.out.println(service_Message.sendHello());
	}
	
}
