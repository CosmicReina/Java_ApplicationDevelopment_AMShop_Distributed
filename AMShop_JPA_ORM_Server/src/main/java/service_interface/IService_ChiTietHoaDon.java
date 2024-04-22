package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietHoaDon;

public interface IService_ChiTietHoaDon extends Remote {
	
	public List<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException;

}
