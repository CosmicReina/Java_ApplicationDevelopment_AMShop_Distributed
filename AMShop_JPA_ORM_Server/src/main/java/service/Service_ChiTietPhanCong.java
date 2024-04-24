package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DAO_ChiTietPhanCong;
import entity.ChiTietPhanCong;
import service_interface.IService_ChiTietPhanCong;

public class Service_ChiTietPhanCong extends UnicastRemoteObject implements IService_ChiTietPhanCong {

	private static final long serialVersionUID = -2856705427967305931L;

	public Service_ChiTietPhanCong() throws RemoteException {
		super();
	}
	
	@Override
	public boolean createChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) throws RemoteException {
		return DAO_ChiTietPhanCong.createChiTietPhanCong(chiTietPhanCong);
	}
	
	@Override
	public boolean updateChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) throws RemoteException {
		return DAO_ChiTietPhanCong.updateChiTietPhanCong(chiTietPhanCong);
	}

	@Override
	public boolean deleteChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) throws RemoteException {
		return DAO_ChiTietPhanCong.deleteChiTietPhanCong(chiTietPhanCong);
	}

	@Override
	public List<ChiTietPhanCong> getAllChiTietPhanCongTheoMaLichLamViec(String maLichLamViec) throws RemoteException {
		return DAO_ChiTietPhanCong.getAllChiTietPhanCongTheoMaLichLamViec(maLichLamViec);
	}

}
