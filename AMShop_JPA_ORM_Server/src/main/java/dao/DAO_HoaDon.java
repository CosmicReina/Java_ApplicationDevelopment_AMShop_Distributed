package dao;

import java.time.LocalDate;
import java.util.List;

import connection.ConnectionMSSQL;
import entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_HoaDon {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_HoaDon() {
	}
	
	public static boolean createHoaDon(HoaDon hoaDon) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(hoaDon);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public static boolean updateHoaDon(HoaDon hoaDon) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(hoaDon);
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public static boolean deleteHoaDon(HoaDon hoaDon) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(hoaDon);
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	
	public static List<HoaDon> getAllHoaDon() {
		return entityManager.createNamedQuery("HoaDon.getAllHoaDon", HoaDon.class)
				.getResultList();
	}
	
	public static List<HoaDon> getAllHoaDonTrongKhoangNgay(LocalDate ngayBatDau, LocalDate ngayKetThuc){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<HoaDon> list = entityManager.createNamedQuery("HoaDon.getAllHoaDonTrongKhoangNgay", HoaDon.class)
				.setParameter("ngayBatDau", ngayBatDau)
				.setParameter("ngayKetThuc", ngayKetThuc)
				.getResultList();
		entityTransaction.commit();
		return list;
	}
	
	public static HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		HoaDon hoaDon = entityManager.createNamedQuery("HoaDon.getHoaDonTheoMaHoaDon", HoaDon.class)
				.setParameter("maHoaDon", maHoaDon)
				.getSingleResult();
		entityTransaction.commit();
		return hoaDon;
	}
	
	public static HoaDon getHoaDonCuoi(String prefix) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		HoaDon hoaDon = entityManager.createNamedQuery("HoaDon.getHoaDonCuoi", HoaDon.class)
				.setParameter("prefix", prefix)
				.getSingleResult();
		entityTransaction.commit();
		return hoaDon;
	}

}
