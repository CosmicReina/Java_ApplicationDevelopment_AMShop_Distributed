package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CaLamViec;

public interface IService_CaLamViec extends Remote {
	
	public List<CaLamViec> getAllCaLamViec() throws RemoteException;
	
	public CaLamViec getCaLamViecTheoMaCaLamViec(int maCaLamViec) throws RemoteException;

}
