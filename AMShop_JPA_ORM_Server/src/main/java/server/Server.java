package server;

import configuration.ServiceBinder;
import connection.ConnectionMSSQL;

public class Server {

	public static void main(String[] args) {

		ConnectionMSSQL.open();

		ServiceBinder.getInstance().bind();

		System.out.println("Server is running ...");

	}

}
