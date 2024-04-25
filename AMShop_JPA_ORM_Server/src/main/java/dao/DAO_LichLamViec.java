package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.LichLamViec;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_LichLamViec {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_LichLamViec() {
	}

	public static boolean createLichLamViec(LichLamViec lichLamViec) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(lichLamViec);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean updateLichLamViec(LichLamViec lichLamViec) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(lichLamViec);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static List<LichLamViec> getAllLichLamViec() {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<LichLamViec> listLichLamViec = entityManager
					.createNamedQuery("LichLamViec.getAllLichLamViec", LichLamViec.class)
					.getResultList();
			entityTransaction.commit();
			return listLichLamViec;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static LichLamViec getLichLamViecTheoMaLichLamViec(String maLichLamViec) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			LichLamViec lichLamViec = entityManager
					.createNamedQuery("LichLamViec.getLichLamViecTheoMaLichLamViec", LichLamViec.class)
					.setParameter("maLichLamViec", maLichLamViec)
					.getSingleResult();
			entityTransaction.commit();
			return lichLamViec;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}
}
