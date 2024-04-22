package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IService_Message extends Remote {
	
	public String sendHello() throws RemoteException;

}
