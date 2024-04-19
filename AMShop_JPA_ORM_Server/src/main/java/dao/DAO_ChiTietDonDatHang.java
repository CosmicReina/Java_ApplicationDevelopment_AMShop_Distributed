package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.ChiTietDonDatHang;
import jakarta.persistence.EntityManager;

public class DAO_ChiTietDonDatHang {
	
	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_ChiTietDonDatHang() {
	}
	
	public static List<ChiTietDonDatHang> getAllChiTietDonDatHangTheoMaDonDatHang(String maDonDatHang){
		return entityManager.createNamedQuery("ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang", ChiTietDonDatHang.class)
				.setParameter("maDonDatHang", maDonDatHang)
				.getResultList();
	}
}
