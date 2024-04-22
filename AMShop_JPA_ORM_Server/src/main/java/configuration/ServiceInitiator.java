package configuration;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import service_interface.IService_Message;

public class ServiceInitiator {

	private static final String URL = Configuration.getURL();
	private static IService_Message service_Message;

	public ServiceInitiator() {
		try {
			service_Message = (IService_Message) Naming.lookup(URL + "serviceMessage");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public IService_Message getServiceMessage() {
		return service_Message;
	}

}
