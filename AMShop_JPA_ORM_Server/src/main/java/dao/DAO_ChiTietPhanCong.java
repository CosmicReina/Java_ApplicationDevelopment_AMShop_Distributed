package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.ChiTietPhanCong;
import entity.LichLamViec;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_ChiTietPhanCong {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_ChiTietPhanCong() {
	}

	public static boolean createChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(chiTietPhanCong);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean updateChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(chiTietPhanCong);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean deleteChiTietPhanCong(LichLamViec lichLamViec, NhanVien nhanVien) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			ChiTietPhanCong chiTietPhanCong = entityManager
					.createQuery("SELECT c FROM ChiTietPhanCong c WHERE c.lichLamViec = :lichLamViec AND c.nhanVien = :nhanVien", ChiTietPhanCong.class)
					.setParameter("lichLamViec", lichLamViec)
					.setParameter("nhanVien", nhanVien)
					.getSingleResult();
			entityManager.remove(chiTietPhanCong);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static List<ChiTietPhanCong> getAllChiTietPhanCongTheoMaLichLamViec(String maLichLamViec) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<ChiTietPhanCong> list = entityManager
					.createNamedQuery("ChiTietPhanCong.getAllChiTietPhanCongTheoMaLichLamViec", ChiTietPhanCong.class)
					.setParameter("maLichLamViec", maLichLamViec)
					.getResultList();
			entityTransaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}
}
