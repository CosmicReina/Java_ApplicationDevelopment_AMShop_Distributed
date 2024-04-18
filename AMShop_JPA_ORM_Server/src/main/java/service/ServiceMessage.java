package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import connection.ConnectionMSSQL;
import jakarta.persistence.EntityManager;
import service_interface.IServiceMessage;

public class ServiceMessage extends UnicastRemoteObject implements IServiceMessage {
	

	private static final long serialVersionUID = -2427389336855226372L;

	protected ServiceMessage() throws RemoteException {
		super();
	}

	@Override
	public String sendHello() throws RemoteException {
		EntityManager entityManager = ConnectionMSSQL.getEntityManager();
		String message = entityManager.createQuery("SELECT 'Hello, Client!'").getSingleResult().toString();
		return message;
	}

}
