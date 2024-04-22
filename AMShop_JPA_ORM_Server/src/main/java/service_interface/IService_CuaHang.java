package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.CuaHang;

public interface IService_CuaHang extends Remote{

	public CuaHang getCuaHang(String maCuaHang) throws RemoteException;
	
}
