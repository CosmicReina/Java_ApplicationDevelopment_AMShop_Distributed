package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.ChiTietDonDatHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_ChiTietDonDatHang {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_ChiTietDonDatHang() {
	}

	public static void createChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(chiTietDonDatHang);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public static void deleteChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(chiTietDonDatHang);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public static List<ChiTietDonDatHang> getAllChiTietDonDatHangTheoMaDonDatHang(
			String maDonDatHang) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<ChiTietDonDatHang> list = entityManager
				.createNamedQuery("ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang",
						ChiTietDonDatHang.class)
				.setParameter("maDonDatHang", maDonDatHang)
				.getResultList();
		entityTransaction.commit();
		return list;
	}
}
