package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.DonDatHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_DonDatHang {
	
	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_DonDatHang() {
	}
	
	public static void createDonDatHang(DonDatHang donDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(donDatHang);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void updateDonDatHang(DonDatHang donDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(donDatHang);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void deleteDonDatHang(DonDatHang donDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(donDatHang);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static List<DonDatHang> getAllDonDatHang(){
		return entityManager.createNamedQuery("DonDatHang.getAllDonDatHang", DonDatHang.class)
				.getResultList();
	}
	
	public static DonDatHang getDonDatHangTheoMaDonDatHang(String maDonDatHang) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		DonDatHang donDatHang = entityManager
				.createNamedQuery("DonDatHang.getDonDatHangTheoMaDonDatHang", DonDatHang.class)
				.setParameter("maDonDatHang", maDonDatHang)
				.getSingleResult();
		entityTransaction.commit();
		return donDatHang;
	}

	public static DonDatHang getDonDatHangCuoi(String prefix) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		DonDatHang donDatHang =  entityManager.createNamedQuery("DonDatHang.getDonDatHangCuoi", DonDatHang.class)
				.setParameter("prefix", prefix)
				.getSingleResult();
		entityTransaction.commit();
		return donDatHang;
	}
	
}
