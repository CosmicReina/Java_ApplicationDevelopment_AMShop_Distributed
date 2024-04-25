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
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(donDatHang);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean updateDonDatHang(DonDatHang donDatHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(donDatHang);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean deleteDonDatHang(DonDatHang donDatHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.contains(donDatHang) ? donDatHang : entityManager.merge(donDatHang));
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static List<DonDatHang> getAllDonDatHang() {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<DonDatHang> listDonDatHang = entityManager
					.createNamedQuery("DonDatHang.getAllDonDatHang", DonDatHang.class)
					.getResultList();
			entityTransaction.commit();
			return listDonDatHang;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static DonDatHang getDonDatHangTheoMaDonDatHang(String maDonDatHang) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			DonDatHang donDatHang = entityManager
					.createNamedQuery("DonDatHang.getDonDatHangTheoMaDonDatHang", DonDatHang.class)
					.setParameter("maDonDatHang", maDonDatHang)
					.getSingleResult();
			entityTransaction.commit();
			return donDatHang;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static DonDatHang getDonDatHangCuoi(String prefix) {
		try {
			prefix = prefix + "%";
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			DonDatHang donDatHang = entityManager.createNamedQuery("DonDatHang.getDonDatHangCuoi", DonDatHang.class)
					.setParameter("prefix", prefix)
					.getSingleResult();
			entityTransaction.commit();
			return donDatHang;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

}
