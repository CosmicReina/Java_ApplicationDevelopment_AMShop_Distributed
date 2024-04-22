package server;

import configuration.ServiceBinder;
import connection.ConnectionMSSQL;

public class Server {

	private static final String HOST = "REI";
	private static final int PORT = 8080;
	private static final String URL = "rmi://" + HOST + ":" + PORT + "/";

	public static void main(String[] args) {

		ConnectionMSSQL.open();

		ServiceBinder.getInstance().bind();
		
		System.out.println("Server is running ...");

	}

}
