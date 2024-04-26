package configuration;

import entity.NhanVien;

public class Configuration_Client {

	private Configuration_Client() {
	}

	private static final String HOST = "REI";
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

	private static NhanVien nhanVienHienTai = null;

	public static NhanVien getNhanVienHienTai() {
		return nhanVienHienTai;
	}

	public static void setNhanVienHienTai(NhanVien nhanVienHienTai) {
		Configuration_Client.nhanVienHienTai = nhanVienHienTai;
	}

}
