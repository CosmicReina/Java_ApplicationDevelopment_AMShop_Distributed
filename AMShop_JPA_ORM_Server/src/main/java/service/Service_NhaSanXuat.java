package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DAO_NhaSanXuat;
import entity.NhaSanXuat;
import service_interface.IService_NhaSanXuat;

public class Service_NhaSanXuat extends UnicastRemoteObject implements IService_NhaSanXuat {

	private static final long serialVersionUID = 4945790864115092327L;

	public Service_NhaSanXuat() throws RemoteException {
		super();
	}
	
	@Override
	public void createNhaSanXuat(NhaSanXuat nhaSanXuat) throws RemoteException {
		DAO_NhaSanXuat.createNhaSanXuat(nhaSanXuat);
	}
	
	@Override
	public List<NhaSanXuat> getAllNhaSanXuat() throws RemoteException {
		return DAO_NhaSanXuat.getAllNhaSanXuat();
	}

	@Override
	public NhaSanXuat kiemTraTonTai(String tenNhaSanXuat) throws RemoteException {
		return DAO_NhaSanXuat.kiemTraTonTai(tenNhaSanXuat);
	}

}
