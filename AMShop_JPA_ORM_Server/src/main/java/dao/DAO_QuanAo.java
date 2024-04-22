package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.QuanAo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		QuanAo quanAo =  entityManager.createNamedQuery("QuanAo.getQuanAoTheoMaQuanAo", QuanAo.class)
				.setParameter("maQuanAo", maQuanAo)
				.getSingleResult();
		entityTransaction.commit();
		return quanAo;
	}
	
	public static QuanAo getQuanAoCuoi(String prefix) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		QuanAo quanAo = entityManager.createNamedQuery("QuanAo.getQuanAoCuoi", QuanAo.class)
				.setParameter("prefix", prefix)
				.getSingleResult();
		entityTransaction.commit();
		return quanAo;
	}
	
}
