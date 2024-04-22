package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

import entity.HoaDon;

public interface IService_HoaDon extends Remote{

	public List<HoaDon> getAllHoaDon() throws RemoteException;
	
	public List<HoaDon> getAllHoaDonTrongKhoangNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) throws RemoteException;
	
	public HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException;
	
	public HoaDon getHoaDonCuoi(String prefix) throws RemoteException;
	
}
