package service_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import entity.NhanVien;

public interface IService_NhanVien extends Remote {

	public List<NhanVien> getAllNhanVien() throws RemoteException;
	
	public NhanVien getNhanVienTheoMaNhanVien(String maNhanVien) throws RemoteException;
	
	public NhanVien getNhanVienTheoSoDienThoai(String soDienThoai) throws RemoteException;
	
	public NhanVien getNhanVienTheoCanCuocCongDan(String canCuocCongDan) throws RemoteException;
	
	public List<NhanVien> getDanhSachNhanVienChuaCoTrongNgayLamViec(LocalDate ngayLamViec) throws RemoteException;
	
	public NhanVien getNhanVienCuoi(String prefix) throws RemoteException;
	
}
