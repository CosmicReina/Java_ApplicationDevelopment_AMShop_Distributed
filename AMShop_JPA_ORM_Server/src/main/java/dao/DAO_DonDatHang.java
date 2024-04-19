package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.DonDatHang;
import jakarta.persistence.EntityManager;

public class DAO_DonDatHang {
	
	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_DonDatHang() {
	}
	
	public static List<DonDatHang> getAllDonDatHang(){
		return entityManager.createNamedQuery("DonDatHang.getAllDonDatHang", DonDatHang.class)
				.getResultList();
	}
	
	public static DonDatHang getDonDatHangTheoMaDonDatHang(String maDonDatHang) {
		return entityManager
				.createNamedQuery("DonDatHang.getDonDatHangTheoMaDonDatHang", DonDatHang.class)
				.setParameter("maDonDatHang", maDonDatHang)
				.getSingleResult();
	}

	public static DonDatHang getDonDatHangCuoi(String prefix) {
		return entityManager.createNamedQuery("DonDatHang.getDonDatHangCuoi", DonDatHang.class)
				.setParameter("prefix", prefix)
				.getSingleResult();
	}
	
}
