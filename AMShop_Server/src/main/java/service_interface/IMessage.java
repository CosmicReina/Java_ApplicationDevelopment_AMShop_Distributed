package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMessage extends Remote {

	public String sendHelloMessage() throws RemoteException;

}
