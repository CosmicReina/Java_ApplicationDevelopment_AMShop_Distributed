package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DAO_QuanAo;
import entity.QuanAo;
import service_interface.IService_QuanAo;

public class Service_QuanAo extends UnicastRemoteObject implements IService_QuanAo {

	private static final long serialVersionUID = 4430025161351722262L;

	public Service_QuanAo() throws RemoteException {
		super();
	}
	
	@Override
	public boolean createQuanAo(QuanAo quanAo) throws RemoteException {
		return DAO_QuanAo.createQuanAo(quanAo);
	}

	@Override
	public boolean updateQuanAo(QuanAo quanAo) throws RemoteException {
		return DAO_QuanAo.updateQuanAo(quanAo);
	}

	@Override
	public List<QuanAo> getAllQuanAo() throws RemoteException {
		return DAO_QuanAo.getAllQuanAo();
	}

	@Override
	public QuanAo getQuanAoTheoMaQuanAo(String maQuanAo) throws RemoteException {
		return DAO_QuanAo.getQuanAoTheoMaQuanAo(maQuanAo);
	}

	@Override
	public QuanAo getQuanAoCuoi() throws RemoteException {
		return DAO_QuanAo.getQuanAoCuoi();
	}

}
