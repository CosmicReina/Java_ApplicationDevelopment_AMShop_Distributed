package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_KhachHang {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_KhachHang() {
	}

	public static boolean createKhachHang(KhachHang khachHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(khachHang);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean updateKhachHang(KhachHang khachHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(khachHang);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static List<KhachHang> getAllKhachHang() {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<KhachHang> listKhachHang = entityManager.createNamedQuery("KhachHang.getAllKhachHang", KhachHang.class)
					.getResultList();
			entityTransaction.commit();
			return listKhachHang;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static KhachHang getKhachHangTheoMaKhachHang(String maKhachHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			KhachHang khachHang = entityManager
					.createNamedQuery("KhachHang.getKhachHangTheoMaKhachHang", KhachHang.class)
					.setParameter("maKhachHang", maKhachHang)
					.getSingleResult();
			entityTransaction.commit();
			return khachHang;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			KhachHang khachHang = entityManager
					.createNamedQuery("KhachHang.getKhachHangTheoSoDienThoai", KhachHang.class)
					.setParameter("soDienThoai", soDienThoai)
					.getSingleResult();
			entityTransaction.commit();
			return khachHang;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static KhachHang getKhachHangCuoi(String prefix) {
		try {
			prefix = prefix + "%";
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			KhachHang khachHang = entityManager.createNamedQuery("KhachHang.getKhachHangCuoi", KhachHang.class)
					.setParameter("prefix", prefix)
					.getSingleResult();
			entityTransaction.commit();
			return khachHang;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static double getSoTienKhachHangDaThanhToanTheoMaKhachHang(String maKhachHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			double soTien = entityManager
					.createNamedQuery("KhachHang.getSoTienKhachHangDaThanhToanTheoMaKhachHang", Double.class)
					.setParameter("maKhachHang", maKhachHang)
					.getSingleResult();
			entityTransaction.commit();
			return soTien;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return 0;
		}
	}

}
