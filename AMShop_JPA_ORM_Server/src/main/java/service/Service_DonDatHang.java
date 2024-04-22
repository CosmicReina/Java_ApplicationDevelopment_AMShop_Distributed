package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DAO_DonDatHang;
import entity.DonDatHang;
import service_interface.IService_DonDatHang;

public class Service_DonDatHang extends UnicastRemoteObject implements IService_DonDatHang{

	private static final long serialVersionUID = -6862522127545101341L;

	public Service_DonDatHang() throws RemoteException {
		super();
	}
	
	@Override
	public void createDonDatHang(DonDatHang donDatHang) throws RemoteException {
	}

	@Override
	public void updateDonDatHang(DonDatHang donDatHang) throws RemoteException {	
	}

	@Override
	public List<DonDatHang> getAllDonDatHang() throws RemoteException {
		return DAO_DonDatHang.getAllDonDatHang();
	}

	@Override
	public DonDatHang getDonDatHangTheoMaDonDatHang(String maDonDatHang) throws RemoteException {
		return DAO_DonDatHang.getDonDatHangTheoMaDonDatHang(maDonDatHang);
	}

	@Override
	public DonDatHang getDonDatHangCuoi(String prefix) throws RemoteException {
		return DAO_DonDatHang.getDonDatHangCuoi(prefix);
	}
	
	
	
}
