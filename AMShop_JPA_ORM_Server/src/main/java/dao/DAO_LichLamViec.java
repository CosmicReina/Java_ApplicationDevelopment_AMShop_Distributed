package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.LichLamViec;
import jakarta.persistence.EntityManager;

public class DAO_LichLamViec {
	
	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_LichLamViec() {
	}
	
	public static void createLichLamViec(LichLamViec lichLamViec) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(lichLamViec);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void updateLichLamViec(LichLamViec lichLamViec) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(lichLamViec);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
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
