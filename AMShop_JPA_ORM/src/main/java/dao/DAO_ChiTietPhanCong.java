package dao;

import java.util.List;

import connect.MSSQLConnection;
import entity.ChiTietPhanCong;
import jakarta.persistence.EntityManager;

public class DAO_ChiTietPhanCong {

	private static EntityManager entityManager = MSSQLConnection.getEntityManager();
	
	private DAO_ChiTietPhanCong() {
	}
	
	public static List<ChiTietPhanCong> getAllChiTietPhanCongTheoMaLichLamViec(String maLichLamViec){
		return entityManager.createNamedQuery("ChiTietPhanCong.getAllChiTietPhanCongTheoMaLichLamViec", ChiTietPhanCong.class)
				.setParameter("maLichLamViec", maLichLamViec)
				.getResultList();
	}
}
