package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DAO_ChiTietDonDatHang;
import entity.ChiTietDonDatHang;
import service_interface.IService_ChiTietDonDatHang;

public class Service_ChiTietDonDatHang extends UnicastRemoteObject implements IService_ChiTietDonDatHang{

	private static final long serialVersionUID = 4561975764196512284L;

	public Service_ChiTietDonDatHang() throws RemoteException {
		super();
	}

	@Override
	public boolean createChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) throws RemoteException {
		return DAO_ChiTietDonDatHang.createChiTietDonDatHang(chiTietDonDatHang);
	}
	
	@Override
	public boolean deleteChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) throws RemoteException {
		return DAO_ChiTietDonDatHang.deleteChiTietDonDatHang(chiTietDonDatHang);
	}

	
	@Override
	public List<ChiTietDonDatHang> getAllChiTietDonDatHangTheoMaDonDatHang(String maDonDatHang) throws RemoteException {
		return DAO_ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang(maDonDatHang);
	}

}
