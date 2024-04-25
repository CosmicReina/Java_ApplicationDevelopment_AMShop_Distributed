package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

import entity.KhachHang;

public interface IService_KhachHang extends Remote{
	
	public boolean createKhachHang(KhachHang khachHang) throws RemoteException;
	
	public boolean updateKhachHang(KhachHang khachHang) throws RemoteException;

	public List<KhachHang> getAllKhachHang() throws RemoteException;
	
	public KhachHang getKhachHangTheoMaKhachHang(String maKhachHang) throws RemoteException;
	
	public KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) throws RemoteException;
	
	public KhachHang getKhachHangCuoi(String prefix) throws RemoteException;
	
	public double getSoTienKhachHangDaThanhToanTheoMaKhachHang(String maKhachHang) throws RemoteException;
	
	public List<?> getKhachHangTheoKhoangNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) throws RemoteException;
}
