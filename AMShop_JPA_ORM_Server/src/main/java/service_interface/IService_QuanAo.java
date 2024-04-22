package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.QuanAo;

public interface IService_QuanAo extends Remote{
	
	public void createQuanAo(QuanAo quanAo) throws RemoteException;
	
	public void updateQuanAo(QuanAo quanAo) throws RemoteException;

	public List<QuanAo> getAllQuanAo() throws RemoteException;
	
	public QuanAo getQuanAoTheoMaQuanAo(String maQuanAo) throws RemoteException;
	
	public QuanAo getQuanAoCuoi(String prefix) throws RemoteException;
	
}
