package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DAO_LichLamViec;
import entity.LichLamViec;
import service_interface.IService_LichLamViec;

public class Service_LichLamViec extends UnicastRemoteObject implements IService_LichLamViec{

	private static final long serialVersionUID = -9208656538614128589L;

	public Service_LichLamViec() throws RemoteException {
		super();
	}
	
	@Override
	public boolean createLichLamViec(LichLamViec lichLamViec) throws RemoteException {
		return DAO_LichLamViec.createLichLamViec(lichLamViec);
	}
	
	@Override
	public boolean updateLichLamViec(LichLamViec lichLamViec) throws RemoteException {
		return DAO_LichLamViec.updateLichLamViec(lichLamViec);
	}

	@Override
	public List<LichLamViec> getAllLichLamViec() throws RemoteException {
		return DAO_LichLamViec.getAllLichLamViec();
	}

	@Override
	public LichLamViec getLichLamViecTheoMaLichLamViec(String maLichLamViec) throws RemoteException {
		return DAO_LichLamViec.getLichLamViecTheoMaLichLamViec(maLichLamViec);
	}
	
}
