package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServiceMessage extends Remote {
	
	public String sendHello() throws RemoteException;

}
