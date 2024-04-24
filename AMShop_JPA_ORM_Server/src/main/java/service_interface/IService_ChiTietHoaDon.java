package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietHoaDon;

public interface IService_ChiTietHoaDon extends Remote {
	
	public boolean createChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws RemoteException;
	
	public boolean removeChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws RemoteException;
	
	public List<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException;

}
