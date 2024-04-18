package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.QuanAo;
import jakarta.persistence.EntityManager;

public class DAO_QuanAo {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_QuanAo() {
	}
	
	public static List<QuanAo> getAllQuanAo() {
		List<QuanAo> list = entityManager.createNamedQuery("QuanAo.getAllQuanAo", QuanAo.class).getResultList();
		return list;
	}
	
}
