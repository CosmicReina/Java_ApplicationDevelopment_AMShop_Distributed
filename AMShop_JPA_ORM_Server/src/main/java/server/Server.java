package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import connection.ConnectionMSSQL;
import service.Service_Message;

public class Server {

	private static final String HOST = "REI";
	private static final int PORT = 8080;
	private static final String URL = "rmi://" + HOST + ":" + PORT + "/";

	public static void main(String[] args) {

		try {
			ConnectionMSSQL.open();

			Service_Message serviceMessage = new Service_Message();

			Context context = new InitialContext();
			
			LocateRegistry.createRegistry(PORT);
			
			context.bind(URL + "service_Message", serviceMessage);
			
			System.out.println("Server is running ...");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
