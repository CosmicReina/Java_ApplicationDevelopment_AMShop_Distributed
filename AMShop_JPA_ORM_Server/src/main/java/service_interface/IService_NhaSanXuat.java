package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhaSanXuat;

public interface IService_NhaSanXuat extends Remote{

	public List<NhaSanXuat> getAllNhaSanXuat() throws RemoteException;
	
	public NhaSanXuat kiemTraTonTai(String tenNhaSanXuat) throws RemoteException;
	
}
