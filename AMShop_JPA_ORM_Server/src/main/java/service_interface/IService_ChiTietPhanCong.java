package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhanCong;
import entity.LichLamViec;
import entity.NhanVien;

public interface IService_ChiTietPhanCong extends Remote {
	
	public boolean createChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) throws RemoteException;
	
	public boolean updateChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) throws RemoteException;
	
	public boolean deleteChiTietPhanCong(LichLamViec lichLamViec, NhanVien nhanVien) throws RemoteException;

	public List<ChiTietPhanCong> getAllChiTietPhanCongTheoMaLichLamViec(String maLichLamViec) throws RemoteException;
	
}
