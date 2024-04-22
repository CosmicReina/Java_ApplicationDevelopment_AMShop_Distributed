package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietDonDatHang;

public interface IService_ChiTietDonDatHang extends Remote{
	
	public List<ChiTietDonDatHang> getAllChiTietDonDatHangTheoMaDonDatHang(String maDonDatHang) throws RemoteException;
	
}
