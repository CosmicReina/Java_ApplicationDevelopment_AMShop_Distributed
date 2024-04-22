package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LichLamViec;

public interface IService_LichLamViec extends Remote {

	public List<LichLamViec> getAllLichLamViec() throws RemoteException;
	
	public LichLamViec getLichLamViecTheoMaLichLamViec(String maLichLamViec) throws RemoteException;
	
}
