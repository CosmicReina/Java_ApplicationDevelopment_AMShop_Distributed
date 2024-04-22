package configuration;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import service_interface.IService_CaLamViec;
import service_interface.IService_ChiTietDonDatHang;
import service_interface.IService_ChiTietHoaDon;
import service_interface.IService_ChiTietPhanCong;
import service_interface.IService_CuaHang;
import service_interface.IService_DonDatHang;
import service_interface.IService_HoaDon;
import service_interface.IService_KhachHang;
import service_interface.IService_LichLamViec;
import service_interface.IService_Message;
import service_interface.IService_NhaSanXuat;
import service_interface.IService_NhanVien;
import service_interface.IService_QuanAo;

public class ServiceInitiator {

	private static final String URL = Configuration.getURL();
	private static ServiceInitiator instance = new ServiceInitiator();
	private static IService_Message service_Message;
	private static IService_CaLamViec service_CaLamViec;
	private static IService_ChiTietDonDatHang service_ChiTietDonDatHang;
	private static IService_ChiTietHoaDon service_ChiTietHoaDon;
	private static IService_ChiTietPhanCong service_ChiTietPhanCong;
	private static IService_CuaHang service_CuaHang;
	private static IService_DonDatHang service_DonDatHang;
	private static IService_HoaDon service_HoaDon;
	private static IService_KhachHang service_KhachHang;
	private static IService_LichLamViec service_LichLamViec;
	private static IService_NhanVien service_NhanVien;
	private static IService_NhaSanXuat service_NhaSanXuat;
	private static IService_QuanAo service_QuanAo;

	private ServiceInitiator() {
		try {
			service_Message = (IService_Message) Naming.lookup(URL + "service_Message");
			service_CaLamViec = (IService_CaLamViec) Naming.lookup(URL + "service_CaLamViec");
			service_ChiTietDonDatHang = (IService_ChiTietDonDatHang) Naming.lookup(URL + "service_ChiTietDonDatHang");
			service_ChiTietHoaDon = (IService_ChiTietHoaDon) Naming.lookup(URL + "service_ChiTietHoaDon");
			service_ChiTietPhanCong = (IService_ChiTietPhanCong) Naming.lookup(URL + "service_ChiTietPhanCong");
			service_CuaHang = (IService_CuaHang) Naming.lookup(URL + "service_CuaHang");
			service_DonDatHang = (IService_DonDatHang) Naming.lookup(URL + "service_DonDatHang");
			service_HoaDon = (IService_HoaDon) Naming.lookup(URL + "service_HoaDon");
			service_KhachHang = (IService_KhachHang) Naming.lookup(URL + "service_KhachHang");
			service_LichLamViec = (IService_LichLamViec) Naming.lookup(URL + "service_LichLamViec");
			service_NhanVien = (IService_NhanVien) Naming.lookup(URL + "service_NhanVien");
			service_NhaSanXuat = (IService_NhaSanXuat) Naming.lookup(URL + "service_NhaSanXuat");
			service_QuanAo = (IService_QuanAo) Naming.lookup(URL + "service_QuanAo");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public static ServiceInitiator getInstance() {
		return instance;
	}

	public IService_Message getServiceMessage() {
		return service_Message;
	}
	
	public IService_CaLamViec getServiceCaLamViec() {
		return service_CaLamViec;
	}
	
	public IService_ChiTietDonDatHang getServiceChiTietDonDatHang() {
		return service_ChiTietDonDatHang;
	}
	
	public IService_ChiTietHoaDon getServiceChiTietHoaDon() {
		return service_ChiTietHoaDon;
	}
	
	public IService_ChiTietPhanCong getServiceChiTietPhanCong() {
		return service_ChiTietPhanCong;
	}
	
	public IService_CuaHang getServiceCuaHang() {
		return service_CuaHang;
	}
	
	public IService_DonDatHang getServiceDonDatHang() {
		return service_DonDatHang;
	}
	
	public IService_HoaDon getServiceHoaDon() {
		return service_HoaDon;
	}
	
	public IService_KhachHang getServiceKhachHang() {
		return service_KhachHang;
	}
	
	public IService_LichLamViec getServiceLichLamViec() {
		return service_LichLamViec;
	}
	
	public IService_NhanVien getServiceNhanVien() {
		return service_NhanVien;
	}
	
	public IService_NhaSanXuat getServiceNhaSanXuat() {
		return service_NhaSanXuat;
	}
	
	public IService_QuanAo getServiceQuanAo() {
		return service_QuanAo;
	}

}
