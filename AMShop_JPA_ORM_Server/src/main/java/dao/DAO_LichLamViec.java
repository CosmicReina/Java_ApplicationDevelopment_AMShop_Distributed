package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.LichLamViec;
import jakarta.persistence.EntityManager;

public class DAO_LichLamViec {
	
	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_LichLamViec() {
	}
	
	public static boolean createLichLamViec(LichLamViec lichLamViec) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(lichLamViec);
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public static boolean updateLichLamViec(LichLamViec lichLamViec) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(lichLamViec);
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public static List<LichLamViec> getAllLichLamViec(){
		return entityManager.createNamedQuery("LichLamViec.getAllLichLamViec", LichLamViec.class)
				.getResultList();
	}
	
	public static LichLamViec getLichLamViecTheoMaLichLamViec(String maLichLamViec) {
		return entityManager.createNamedQuery("LichLamViec.getLichLamViecTheoMaLichLamViec",LichLamViec.class)
				.setParameter("maLichLamViec", maLichLamViec)
				.getSingleResult();
	}
}
