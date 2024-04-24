package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.ChiTietHoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_ChiTietHoaDon {
	
	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_ChiTietHoaDon(){
	}
	
	public static boolean createChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(chiTietHoaDon);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<ChiTietHoaDon> list = entityManager.createNamedQuery("ChiTietHoaDon.getAllChiTietHoaDonTheoMaHoaDon", ChiTietHoaDon.class)
				.setParameter("maHoaDon", maHoaDon)
				.getResultList();
		entityTransaction.commit();
		return list;
	}
	
}
