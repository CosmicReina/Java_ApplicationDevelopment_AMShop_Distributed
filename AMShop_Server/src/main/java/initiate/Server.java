package initiate;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import service.ServiceMessage;

public class Server {

	private static final String ADDRESS = "localhost";
	private static final String PORT = "8080";
	private static final String URL = "rmi://" + ADDRESS + ":" + PORT + "/";

	public static void main(String[] args) {
		try {

			ServiceMessage serviceMessage = new ServiceMessage();

			Context context = new InitialContext();

			LocateRegistry.createRegistry(Integer.parseInt(PORT));

			context.bind(URL + "message", serviceMessage);

			System.out.println("Server is running...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
