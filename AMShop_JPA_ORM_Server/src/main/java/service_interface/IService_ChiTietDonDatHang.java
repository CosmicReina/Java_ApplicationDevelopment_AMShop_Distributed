package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietDonDatHang;

public interface IService_ChiTietDonDatHang extends Remote{
	
	public void createChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) throws RemoteException;
	
	public void deleteChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) throws RemoteException;
	
	public List<ChiTietDonDatHang> getAllChiTietDonDatHangTheoMaDonDatHang(String maDonDatHang) throws RemoteException;
	
}
