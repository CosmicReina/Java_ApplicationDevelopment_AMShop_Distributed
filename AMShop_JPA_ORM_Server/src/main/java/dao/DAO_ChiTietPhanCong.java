package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.ChiTietPhanCong;
import jakarta.persistence.EntityManager;

public class DAO_ChiTietPhanCong {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_ChiTietPhanCong() {
	}
	
	public static void createChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(chiTietPhanCong);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void updateChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(chiTietPhanCong);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void deleteChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(chiTietPhanCong);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static List<ChiTietPhanCong> getAllChiTietPhanCongTheoMaLichLamViec(String maLichLamViec){
		return entityManager.createNamedQuery("ChiTietPhanCong.getAllChiTietPhanCongTheoMaLichLamViec", ChiTietPhanCong.class)
				.setParameter("maLichLamViec", maLichLamViec)
				.getResultList();
	}
}
