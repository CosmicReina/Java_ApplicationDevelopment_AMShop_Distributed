package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.QuanAo;
import jakarta.persistence.EntityManager;

public class DAO_QuanAo {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_QuanAo() {
	}
	
	public static void createQuanAo(QuanAo quanAo) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(quanAo);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void updateQuanAo(QuanAo quanAo) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(quanAo);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static List<QuanAo> getAllQuanAo() {
		List<QuanAo> list = entityManager.createNamedQuery("QuanAo.getAllQuanAo", QuanAo.class).getResultList();
		return list;
	}
	
	public static QuanAo getQuanAoTheoMaQuanAo(String maQuanAo) {
		return entityManager.createNamedQuery("QuanAo.getQuanAoTheoMaQuanAo", QuanAo.class)
				.setParameter("maQuanAo", maQuanAo)
				.getSingleResult();
	}
	
	public static QuanAo getQuanAoCuoi(String prefix) {
		return entityManager.createNamedQuery("QuanAo.getQuanAoCuoi", QuanAo.class)
				.setParameter("prefix", prefix)
				.getSingleResult();
	}
	
}
