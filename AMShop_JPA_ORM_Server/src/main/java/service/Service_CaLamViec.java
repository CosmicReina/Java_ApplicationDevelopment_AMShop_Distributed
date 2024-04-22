package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DAO_CaLamViec;
import entity.CaLamViec;
import service_interface.IService_CaLamViec;

public class Service_CaLamViec extends UnicastRemoteObject implements IService_CaLamViec{

	private static final long serialVersionUID = -2909325968796501924L;

	public Service_CaLamViec() throws RemoteException {
		super();
	}

	@Override
	public List<CaLamViec> getAllCaLamViec() throws RemoteException {
		return DAO_CaLamViec.getAllCaLamViec();
	}

	@Override
	public CaLamViec getCaLamViecTheoMaCaLamViec(int maCaLamViec) throws RemoteException {
		return DAO_CaLamViec.getCaLamViecTheoMaCaLamViec(maCaLamViec);
	}

	
}
