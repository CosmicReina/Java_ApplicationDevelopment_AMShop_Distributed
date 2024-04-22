package configuration;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import service.Service_CaLamViec;
import service.Service_ChiTietDonDatHang;
import service.Service_ChiTietHoaDon;
import service.Service_ChiTietPhanCong;
import service.Service_CuaHang;
import service.Service_DonDatHang;
import service.Service_HoaDon;
import service.Service_KhachHang;
import service.Service_LichLamViec;
import service.Service_Message;
import service.Service_NhaSanXuat;
import service.Service_NhanVien;
import service.Service_QuanAo;

public class ServiceBinder {

	private static final String URL = Configuration.getURL();
	private static ServiceBinder instance = new ServiceBinder();
	private static Service_Message service_Message;
	private static Service_CaLamViec service_CaLamViec;
	private static Service_ChiTietDonDatHang service_ChiTietDonDatHang;
	private static Service_ChiTietHoaDon service_ChiTietHoaDon;
	private static Service_ChiTietPhanCong service_ChiTietPhanCong;
	private static Service_CuaHang service_CuaHang;
	private static Service_DonDatHang service_DonDatHang;
	private static Service_HoaDon service_HoaDon;
	private static Service_KhachHang service_KhachHang;
	private static Service_LichLamViec service_LichLamViec;
	private static Service_NhanVien service_NhanVien;
	private static Service_NhaSanXuat service_NhaSanXuat;
	private static Service_QuanAo service_QuanAo;

	private ServiceBinder() {
	}

	public static ServiceBinder getInstance() {
		return instance;
	}

	public void bind() {
		try {
			service_Message = new Service_Message();
			service_CaLamViec = new Service_CaLamViec();
			service_ChiTietDonDatHang = new Service_ChiTietDonDatHang();
			service_ChiTietHoaDon = new Service_ChiTietHoaDon();
			service_ChiTietPhanCong = new Service_ChiTietPhanCong();
			service_CuaHang = new Service_CuaHang();
			service_DonDatHang = new Service_DonDatHang();
			service_HoaDon = new Service_HoaDon();
			service_KhachHang = new Service_KhachHang();
			service_LichLamViec = new Service_LichLamViec();
			service_NhanVien = new Service_NhanVien();
			service_NhaSanXuat = new Service_NhaSanXuat();
			service_QuanAo = new Service_QuanAo();

			Context context = new InitialContext();

			LocateRegistry.createRegistry(Configuration.getPORT());

			context.bind(URL + "service_Message", service_Message);
			context.bind(URL + "service_CaLamViec", service_CaLamViec);
			context.bind(URL + "service_ChiTietDonDatHang", service_ChiTietDonDatHang);
			context.bind(URL + "service_ChiTietHoaDon", service_ChiTietHoaDon);
			context.bind(URL + "service_ChiTietPhanCong", service_ChiTietPhanCong);
			context.bind(URL + "service_CuaHang", service_CuaHang);
			context.bind(URL + "service_DonDatHang", service_DonDatHang);
			context.bind(URL + "service_HoaDon", service_HoaDon);
			context.bind(URL + "service_KhachHang", service_KhachHang);
			context.bind(URL + "service_LichLamViec", service_LichLamViec);
			context.bind(URL + "service_NhanVien", service_NhanVien);
			context.bind(URL + "service_NhaSanXuat", service_NhaSanXuat);
			context.bind(URL + "service_QuanAo", service_QuanAo);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
