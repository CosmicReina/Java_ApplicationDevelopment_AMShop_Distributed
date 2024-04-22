package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

import dao.DAO_NhanVien;
import entity.NhanVien;
import service_interface.IService_NhanVien;

public class Service_NhanVien extends UnicastRemoteObject implements IService_NhanVien {

	private static final long serialVersionUID = -410609373671610546L;

	public Service_NhanVien() throws RemoteException {
		super();
	}
	
	@Override
	public void createNhanVien(NhanVien nhanVien) throws RemoteException {
		
	}

	@Override
	public void updateNhanVien(NhanVien nhanVien) throws RemoteException {
		
	}

	@Override
	public List<NhanVien> getAllNhanVien() throws RemoteException {
		return DAO_NhanVien.getAllNhanVien();
	}

	@Override
	public NhanVien getNhanVienTheoMaNhanVien(String maNhanVien) throws RemoteException {
		return DAO_NhanVien.getNhanVienTheoMaNhanVien(maNhanVien);
	}

	@Override
	public NhanVien getNhanVienTheoSoDienThoai(String soDienThoai) throws RemoteException {
		return DAO_NhanVien.getNhanVienTheoSoDienThoai(soDienThoai);
	}

	@Override
	public NhanVien getNhanVienTheoCanCuocCongDan(String canCuocCongDan) throws RemoteException {
		return DAO_NhanVien.getNhanVienTheoCanCuocCongDan(canCuocCongDan);
	}

	@Override
	public List<NhanVien> getDanhSachNhanVienChuaCoTrongNgayLamViec(LocalDate ngayLamViec) throws RemoteException {
		return DAO_NhanVien.getDanhSachNhanVienChuaCoTrongNgayLamViec(ngayLamViec);
	}

	@Override
	public NhanVien getNhanVienCuoi(String prefix) throws RemoteException {
		return DAO_NhanVien.getNhanVienCuoi(prefix);
	}

}
