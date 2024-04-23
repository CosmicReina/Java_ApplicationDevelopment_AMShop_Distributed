package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import configuration.Configuration_Client;
import service_interface.IService_Message;

public class Client {
	
	public static void main(String[] args) {
		
		try {
			String URL = Configuration_Client.getURL();
			
			IService_Message serviceMessage = (IService_Message) Naming.lookup(URL + "serviceMessage");
			
			System.out.println(serviceMessage.sendHello());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
