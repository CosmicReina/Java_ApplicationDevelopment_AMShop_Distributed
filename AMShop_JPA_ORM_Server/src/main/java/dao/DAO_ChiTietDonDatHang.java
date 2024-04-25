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

	public static boolean createChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(chiTietDonDatHang);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean deleteChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.contains(chiTietDonDatHang) ? chiTietDonDatHang : entityManager.merge(chiTietDonDatHang));
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static List<ChiTietDonDatHang> getAllChiTietDonDatHangTheoMaDonDatHang(String maDonDatHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<ChiTietDonDatHang> list = entityManager
					.createNamedQuery("ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang",
							ChiTietDonDatHang.class)
					.setParameter("maDonDatHang", maDonDatHang)
					.getResultList();
			entityTransaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
