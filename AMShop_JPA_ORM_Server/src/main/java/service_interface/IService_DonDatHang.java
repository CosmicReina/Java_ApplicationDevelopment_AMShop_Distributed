package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.DonDatHang;

public interface IService_DonDatHang extends Remote {
	
	List<DonDatHang> getAllDonDatHang() throws RemoteException;
	
}
