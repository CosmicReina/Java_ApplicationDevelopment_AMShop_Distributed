package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DAO_ChiTietHoaDon;
import entity.ChiTietHoaDon;
import service_interface.IService_ChiTietHoaDon;

public class Service_ChiTietHoaDon extends UnicastRemoteObject implements IService_ChiTietHoaDon{

	private static final long serialVersionUID = 2236664299910085355L;

	protected Service_ChiTietHoaDon() throws RemoteException {
		super();
	}

	@Override
	public List<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException {
		return DAO_ChiTietHoaDon.getAllChiTietHoaDonTheoMaHoaDon(maHoaDon);
	}

	
	
	

}
