package dao;

import java.time.LocalDateTime;
import java.util.List;

import connection.ConnectionMSSQL;
import entity.HoaDon;
import jakarta.persistence.EntityManager;

public class DAO_HoaDon {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_HoaDon() {
	}
	
	public static void createHoaDon(HoaDon hoaDon) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(hoaDon);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void updateHoaDon(HoaDon hoaDon) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(hoaDon);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public static void deleteHoaDon(HoaDon hoaDon) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(hoaDon);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	
	public static List<HoaDon> getAllHoaDon() {
		return entityManager.createNamedQuery("HoaDon.getAllHoaDon", HoaDon.class)
				.getResultList();
	}
	
	public static List<HoaDon> getAllHoaDonTrongKhoangNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc){
		return entityManager.createNamedQuery("HoaDon.getAllHoaDonTrongKhoangNgay", HoaDon.class)
				.setParameter("ngayBatDau", ngayBatDau)
				.setParameter("ngayKetThuc", ngayKetThuc)
				.getResultList();
	}
	
	public static HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) {
		return entityManager.createNamedQuery("HoaDon.getHoaDonTheoMaHoaDon", HoaDon.class)
				.setParameter("maHoaDon", maHoaDon)
				.getSingleResult();
	}
	
	public static HoaDon getHoaDonCuoi(String prefix) {
		return entityManager.createNamedQuery("HoaDon.getHoaDonCuoi", HoaDon.class)
				.setParameter("prefix", prefix)
				.getSingleResult();
	}

}
