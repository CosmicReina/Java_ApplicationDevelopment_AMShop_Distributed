package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.DAO_CuaHang;
import entity.CuaHang;
import service_interface.IService_CuaHang;

public class Service_CuaHang extends UnicastRemoteObject implements IService_CuaHang{

	private static final long serialVersionUID = 8582438986302256679L;

	protected Service_CuaHang() throws RemoteException {
		super();
	}

	@Override
	public CuaHang getCuaHang(String maCuaHang) throws RemoteException {
		return DAO_CuaHang.getCuaHang(maCuaHang);
	}

}
