package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

import entity.QuanAo;

public interface IService_QuanAo extends Remote{
	
	public boolean createQuanAo(QuanAo quanAo) throws RemoteException;
	
	public boolean updateQuanAo(QuanAo quanAo) throws RemoteException;

	public List<QuanAo> getAllQuanAo() throws RemoteException;
	
	public QuanAo getQuanAoTheoMaQuanAo(String maQuanAo) throws RemoteException;
	
	public QuanAo getQuanAoCuoi() throws RemoteException;
	
	public List<?> getQuanAoDaBanTrongKhoangNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) throws RemoteException;
	
	public List<QuanAo> getQuanAoDaHetHang() throws RemoteException;
	
}
