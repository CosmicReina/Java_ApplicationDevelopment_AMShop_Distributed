package configuration;

public class Configuration_Server {

	private Configuration_Server() {
	}

	private static final String HOST = "localhost";
	private static final int PORT = 8080;
	private static final String URL = "rmi://" + HOST + ":" + PORT + "/";

	public static String getHOST() {
		return HOST;
	}

	public static int getPORT() {
		return PORT;
	}

	public static String getURL() {
		return URL;
	}

}
