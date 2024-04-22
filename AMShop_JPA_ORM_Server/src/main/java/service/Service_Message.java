package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import connection.ConnectionMSSQL;
import jakarta.persistence.EntityManager;
import service_interface.IService_Message;

public class Service_Message extends UnicastRemoteObject implements IService_Message {
	

	private static final long serialVersionUID = -2427389336855226372L;

	public Service_Message() throws RemoteException {
		super();
	}

	@Override
	public String sendHello() throws RemoteException {
		EntityManager entityManager = ConnectionMSSQL.getEntityManager();
		String message = entityManager.createQuery("SELECT 'Hello, Client!'").getSingleResult().toString();
		return message;
	}

}
