package dao;

import java.time.LocalDateTime;
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
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(hoaDon);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean updateHoaDon(HoaDon hoaDon) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(hoaDon);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean deleteHoaDon(HoaDon hoaDon) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.contains(hoaDon) ? hoaDon : entityManager.merge(hoaDon));
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static List<HoaDon> getAllHoaDon() {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<HoaDon> list = entityManager.createNamedQuery("HoaDon.getAllHoaDon", HoaDon.class).getResultList();
			entityTransaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static List<HoaDon> getAllHoaDonTrongKhoangNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<HoaDon> list = entityManager.createNamedQuery("HoaDon.getAllHoaDonTrongKhoangNgay", HoaDon.class)
					.setParameter("ngayBatDau", ngayBatDau)
					.setParameter("ngayKetThuc", ngayKetThuc)
					.getResultList();
			entityTransaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			HoaDon hoaDon = entityManager.createNamedQuery("HoaDon.getHoaDonTheoMaHoaDon", HoaDon.class)
					.setParameter("maHoaDon", maHoaDon)
					.getSingleResult();
			entityTransaction.commit();
			return hoaDon;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static HoaDon getHoaDonCuoi(String prefix) {
		try {
			prefix = prefix + "%";
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			HoaDon hoaDon = entityManager.createNamedQuery("HoaDon.getHoaDonCuoi", HoaDon.class)
					.setParameter("prefix", prefix)
					.getSingleResult();
			entityTransaction.commit();
			return hoaDon;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}
	
}
