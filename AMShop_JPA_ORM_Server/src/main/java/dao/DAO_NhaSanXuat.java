package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.NhaSanXuat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_NhaSanXuat {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_NhaSanXuat() {
	}
	
	public static boolean createNhaSanXuat(NhaSanXuat nhaSanXuat) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(nhaSanXuat);
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public static List<NhaSanXuat> getAllNhaSanXuat(){
		return entityManager.createNamedQuery("NhaSanXuat.getAllNhaSanXuat",NhaSanXuat.class)
				.getResultList();
	}
	
	public static NhaSanXuat kiemTraTonTai(String tenNhaSanXuat) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			NhaSanXuat nhaSanXuat = entityManager.createNamedQuery("NhaSanXuat.kiemTraTonTai", NhaSanXuat.class)
                    .setParameter("tenNhaSanXuat", tenNhaSanXuat)
                    .getSingleResult();
			entityTransaction.commit();
			return nhaSanXuat;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}
}
