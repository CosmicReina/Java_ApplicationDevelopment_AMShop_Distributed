package dao;

import java.util.List;

import connect.MSSQLConnection;
import entity.KhachHang;
import jakarta.persistence.EntityManager;

public class DAO_KhachHang {

	private static EntityManager entityManager = MSSQLConnection.getEntityManager();

	private DAO_KhachHang() {
	}

	public static List<KhachHang> getAllKhachHang() {
		return entityManager.createNamedQuery("KhachHang.getAllKhachHang", KhachHang.class)
				.getResultList();
	}

	public static KhachHang getKhachHangTheoMaKhachHang(String maKhachHang) {
		return entityManager
				.createNamedQuery("KhachHang.getKhachHangTheoMaKhachHang", KhachHang.class)
				.setParameter("maKhachHang", maKhachHang)
				.getSingleResult();
	}

}
