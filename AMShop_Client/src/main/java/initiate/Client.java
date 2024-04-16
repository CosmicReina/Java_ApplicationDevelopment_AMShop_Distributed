package initiate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import service_interface.IMessage;

public class Client {

	private static final String ADDRESS = "192.168.11.71";
	private static final String PORT = "8080";
	private static final String URL = "rmi://" + ADDRESS + ":" + PORT + "/";

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			IMessage serviceMessage = (IMessage) Naming.lookup(URL + "message");

			int menu = 0;
			do {
				System.out.println("Menu: ");
				System.out.println("1. Get Hello Message");
				System.out.println("0. Exit");
				System.out.print("Choose: ");
				menu = scanner.nextInt();
				switch (menu) {
					case 1 :
						System.out.println("Server response: " + serviceMessage.sendHelloMessage());
						break;
					case 0 :
						System.out.println("Exiting...");
						break;
					default :
						System.out.println("Invalid choice");
						menu = -1;
						break;
				}
				System.out.println("\n\n");
			} while (menu != 0);

		} catch (RemoteException e) {
			System.err.println("Unable to connect to server");
		} catch (MalformedURLException e) {
			System.err.println("Invalid URL");
		} catch (NotBoundException e) {
			System.err.println("Service not found");
		} catch (Exception e) {
			System.err.println("Unknown error occurred");
		}

	}

}
