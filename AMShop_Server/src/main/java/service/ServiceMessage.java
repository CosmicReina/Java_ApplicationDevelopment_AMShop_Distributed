package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import connect.MSSQLConnection;
import jakarta.persistence.EntityManager;
import service_interface.IMessage;

public class ServiceMessage extends UnicastRemoteObject implements IMessage {

	private static final long serialVersionUID = -3601247619539596175L;
	private EntityManager entityManager;
	
	public ServiceMessage() throws RemoteException {
		entityManager = MSSQLConnection.getEntityManager();
	}

	@Override
	public String sendHelloMessage() throws RemoteException {
		return entityManager.createNativeQuery("SELECT 'Hello, Client!'")
				.getSingleResult()
				.toString();
	}
	
	

}
