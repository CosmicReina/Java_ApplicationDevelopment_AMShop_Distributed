package configuration;

import entity.NhanVien;

public class Configuration {
	
	private static final String HOST = "REI";
	private static final int PORT = 8080;
	private static final String URL = "rmi://" + HOST + ":" + PORT + "/";
	
	private static NhanVien nhanVienHienTai = null;
	
	private Configuration() {
	}
	
	public static String getURL() {
		return URL;
	}

}
