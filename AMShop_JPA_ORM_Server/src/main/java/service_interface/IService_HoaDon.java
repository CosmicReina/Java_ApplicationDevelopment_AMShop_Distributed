package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import entity.HoaDon;

public interface IService_HoaDon extends Remote{
	
	public boolean createHoaDon(HoaDon hoaDon) throws RemoteException;
	
	public boolean updateHoaDon(HoaDon hoaDon) throws RemoteException;
	
	public boolean deleteHoaDon(HoaDon hoaDon) throws RemoteException;

	public List<HoaDon> getAllHoaDon() throws RemoteException;
	
	public List<HoaDon> getAllHoaDonTrongKhoangNgay(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws RemoteException;
	
	public HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException;
	
	public HoaDon getHoaDonCuoi(String prefix) throws RemoteException;
	
}
