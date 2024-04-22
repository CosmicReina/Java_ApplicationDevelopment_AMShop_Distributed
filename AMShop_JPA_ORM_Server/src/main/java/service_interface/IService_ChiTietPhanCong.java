package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhanCong;

public interface IService_ChiTietPhanCong extends Remote {
	
	public void createChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) throws RemoteException;

	public List<ChiTietPhanCong> getAllChiTietPhanCongTheoMaLichLamViec(String maLichLamViec) throws RemoteException;
	
}
