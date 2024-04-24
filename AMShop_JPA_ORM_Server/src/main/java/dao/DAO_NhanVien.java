package dao;

import java.time.LocalDate;
import java.util.List;

import connection.ConnectionMSSQL;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_NhanVien {
	
	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_NhanVien() {
	}
	
	public static boolean createNhanVien(NhanVien nhanVien) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(nhanVien);
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public static boolean updateNhanVien(NhanVien nhanVien) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(nhanVien);
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public static List<NhanVien> getAllNhanVien(){
		return entityManager.createNamedQuery("NhanVien.getAllNhanVien", NhanVien.class)
				.getResultList();
	}
	
	public static NhanVien getNhanVienTheoMaNhanVien(String maNhanVien) {
		return entityManager.createNamedQuery("NhanVien.getNhanVienTheoMaNhanVien", NhanVien.class)
				.setParameter("maNhanVien", maNhanVien)
				.getSingleResult();
	}
	
	public static NhanVien getNhanVienTheoSoDienThoai(String soDienThoai) {
		return entityManager.createNamedQuery("NhanVien.getNhanVienTheoSoDienThoai", NhanVien.class)
				.setParameter("soDienThoai", soDienThoai)
				.getSingleResult();
	}

	public static NhanVien getNhanVienTheoCanCuocCongDan(String canCuocCongDan) {
		return entityManager.createNamedQuery("NhanVien.getNhanVienTheoCanCuocCongDan", NhanVien.class)
				.setParameter("canCuocCongDan", canCuocCongDan)
				.getSingleResult();
	}

	public static List<NhanVien> getDanhSachNhanVienChuaCoTrongNgayLamViec(LocalDate ngayLamViec){
		return entityManager.createNamedQuery("NhanVien.getDanhSachNhanVienChuaCoTrongNgayLamViec", NhanVien.class)
				.setParameter("ngayLamViec", ngayLamViec)
				.getResultList();
	}

	public static NhanVien getNhanVienCuoi(String prefix) {
		return entityManager.createNamedQuery("NhanVien.getNhanVienCuoi", NhanVien.class)
				.setParameter("prefix", prefix)
				.getSingleResult();
	}
	
	public static NhanVien getNhanVienTheoThongTinDangNhap(String maNhanVien, String matKhau) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			NhanVien nhanVien = entityManager
					.createNamedQuery("NhanVien.getNhanVienTheoThongTinDangNhap", NhanVien.class)
					.setParameter("maNhanVien", maNhanVien)
					.setParameter("matKhau", matKhau)
					.getSingleResult();
			entityTransaction.commit();
			return nhanVien;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}
	
}
