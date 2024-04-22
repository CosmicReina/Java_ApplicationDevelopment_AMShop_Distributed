package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.KhachHang;
import jakarta.persistence.EntityManager;

public class DAO_KhachHang {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_KhachHang() {
	}
	
	public static void createKhachHang(KhachHang khachHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(khachHang);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void updateKhachHang(KhachHang khachHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(khachHang);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public static List<KhachHang> getAllKhachHang() {
		return entityManager.createNamedQuery("KhachHang.getAllKhachHang", KhachHang.class)
				.getResultList();
	}

	public static KhachHang getKhachHangTheoMaKhachHang(String maKhachHang) {
		return entityManager
				.createNamedQuery("KhachHang.getKhachHangTheoMaKhachHang", KhachHang.class)
				.setParameter("maKhachHang", maKhachHang)
				.getSingleResult();
	}
	
	public static KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) {
		return entityManager
				.createNamedQuery("KhachHang.getKhachHangTheoSoDienThoai", KhachHang.class)
				.setParameter("soDienThoai", soDienThoai)
				.getSingleResult();
	}
	
	public static KhachHang getKhachHangCuoi(String prefix) {
		return entityManager
				.createNamedQuery("KhachHang.getKhachHangCuoi", KhachHang.class)
				.setParameter("prefix", prefix)
				.getSingleResult();
	}

}
