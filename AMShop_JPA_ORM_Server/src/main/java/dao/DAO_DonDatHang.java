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
	
	public static boolean createDonDatHang(DonDatHang donDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(donDatHang);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public static boolean updateDonDatHang(DonDatHang donDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(donDatHang);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public static boolean deleteDonDatHang(DonDatHang donDatHang) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(donDatHang);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
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
		prefix = prefix + "%";
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		DonDatHang donDatHang =  entityManager.createNamedQuery("DonDatHang.getDonDatHangCuoi", DonDatHang.class)
				.setParameter("prefix", prefix)
				.getSingleResult();
		entityTransaction.commit();
		return donDatHang;
	}
	
}
