package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.ChiTietPhanCong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_ChiTietPhanCong {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_ChiTietPhanCong() {
	}

	public static boolean createChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(chiTietPhanCong);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean updateChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(chiTietPhanCong);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean deleteChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(chiTietPhanCong);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static List<ChiTietPhanCong> getAllChiTietPhanCongTheoMaLichLamViec(String maLichLamViec) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<ChiTietPhanCong> list = entityManager
				.createNamedQuery("ChiTietPhanCong.getAllChiTietPhanCongTheoMaLichLamViec", ChiTietPhanCong.class)
				.setParameter("maLichLamViec", maLichLamViec)
				.getResultList();
		entityTransaction.commit();
		return list;
	}
}
