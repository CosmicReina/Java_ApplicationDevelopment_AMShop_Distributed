package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.List;

import dao.DAO_HoaDon;
import entity.HoaDon;
import service_interface.IService_HoaDon;

public class Service_HoaDon extends UnicastRemoteObject implements IService_HoaDon {

	private static final long serialVersionUID = 8516238878987800789L;

	public Service_HoaDon() throws RemoteException {
		super();
	}
	
	@Override
	public boolean createHoaDon(HoaDon hoaDon) throws RemoteException {
		return DAO_HoaDon.createHoaDon(hoaDon);
	}

	@Override
	public boolean updateHoaDon(HoaDon hoaDon) throws RemoteException {
		return DAO_HoaDon.updateHoaDon(hoaDon);
	}
	
	@Override
	public boolean deleteHoaDon(HoaDon hoaDon) throws RemoteException {
		return DAO_HoaDon.deleteHoaDon(hoaDon);
	}

	@Override
	public List<HoaDon> getAllHoaDon() throws RemoteException {
		return DAO_HoaDon.getAllHoaDon();
	}

	@Override
	public List<HoaDon> getAllHoaDonTrongKhoangNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc)
			throws RemoteException {
		return DAO_HoaDon.getAllHoaDonTrongKhoangNgay(ngayBatDau, ngayKetThuc);
	}

	@Override
	public HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException {
		return DAO_HoaDon.getHoaDonTheoMaHoaDon(maHoaDon);
	}

	@Override
	public HoaDon getHoaDonCuoi(String prefix) throws RemoteException {
		return DAO_HoaDon.getHoaDonCuoi(prefix);
	}

}
