package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.ChiTietDonDatHang;
import jakarta.persistence.EntityManager;

public class DAO_ChiTietDonDatHang {
	
	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_ChiTietDonDatHang() {
	}

	public static void createChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(chiTietDonDatHang);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void deleteChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(chiTietDonDatHang);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static List<ChiTietDonDatHang> getAllChiTietDonDatHangTheoMaDonDatHang(String maDonDatHang){
		return entityManager.createNamedQuery("ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang", ChiTietDonDatHang.class)
				.setParameter("maDonDatHang", maDonDatHang)
				.getResultList();
	}
}
