package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.DonDatHang;

public interface IService_DonDatHang extends Remote {
	
	public boolean createDonDatHang(DonDatHang donDatHang) throws RemoteException;
	
	public boolean updateDonDatHang(DonDatHang donDatHang) throws RemoteException;
	
	public boolean deleteDonDatHang(DonDatHang donDatHang) throws RemoteException;
	
	public List<DonDatHang> getAllDonDatHang() throws RemoteException;
	
	public DonDatHang getDonDatHangTheoMaDonDatHang(String maDonDatHang) throws RemoteException;
	
	public DonDatHang getDonDatHangCuoi(String prefix) throws RemoteException;
}
