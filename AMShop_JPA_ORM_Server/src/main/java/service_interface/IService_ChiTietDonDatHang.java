package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietDonDatHang;

public interface IService_ChiTietDonDatHang extends Remote{
	
	public boolean createChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) throws RemoteException;
	
	public boolean deleteChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) throws RemoteException;
	
	public List<ChiTietDonDatHang> getAllChiTietDonDatHangTheoMaDonDatHang(String maDonDatHang) throws RemoteException;
	
}
