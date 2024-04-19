package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.NhaSanXuat;
import jakarta.persistence.EntityManager;

public class DAO_NhaSanXuat {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_NhaSanXuat() {
	}
	
	public static List<NhaSanXuat> getAllNhaSanXuat(){
		return entityManager.createNamedQuery("NhaSanXuat.getAllNhaSanXuat",NhaSanXuat.class)
				.getResultList();
	}
	
	public static NhaSanXuat kiemTraTonTai(String tenNhaSanXuat) {
		return entityManager.createNamedQuery("NhaSanXuat.kiemTraTonTai", NhaSanXuat.class)
				.setParameter("tenNhaSanXuat", tenNhaSanXuat)
				.getSingleResult();
	}
}
