package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DAO_KhachHang;
import entity.KhachHang;
import service_interface.IService_KhachHang;

public class Service_KhachHang extends UnicastRemoteObject implements IService_KhachHang {

	private static final long serialVersionUID = 1263555923521234738L;

	public Service_KhachHang() throws RemoteException {
		super();
	}
	
	@Override
	public boolean createKhachHang(KhachHang khachHang) throws RemoteException {
		return DAO_KhachHang.createKhachHang(khachHang);
	}

	@Override
	public boolean updateKhachHang(KhachHang khachHang) throws RemoteException {
		return DAO_KhachHang.updateKhachHang(khachHang);
	}

	@Override
	public List<KhachHang> getAllKhachHang() throws RemoteException {
		return DAO_KhachHang.getAllKhachHang();
	}

	@Override
	public KhachHang getKhachHangTheoMaKhachHang(String maKhachHang) throws RemoteException {
		return DAO_KhachHang.getKhachHangTheoMaKhachHang(maKhachHang);
	}

	@Override
	public KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) throws RemoteException {
		return DAO_KhachHang.getKhachHangTheoSoDienThoai(soDienThoai);
	}

	@Override
	public KhachHang getKhachHangCuoi(String prefix) throws RemoteException {
		return DAO_KhachHang.getKhachHangCuoi(prefix);
	}

	@Override
	public double getSoTienKhachHangDaThanhToanTheoMaKhachHang(String maKhachHang) throws RemoteException {
		return DAO_KhachHang.getSoTienKhachHangDaThanhToanTheoMaKhachHang(maKhachHang);
	}

}
