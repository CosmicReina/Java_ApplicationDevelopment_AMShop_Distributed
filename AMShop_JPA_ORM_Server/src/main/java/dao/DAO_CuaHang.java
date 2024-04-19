package dao;

import connection.ConnectionMSSQL;
import entity.CuaHang;
import jakarta.persistence.EntityManager;

public class DAO_CuaHang {
	
	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();
	
	private DAO_CuaHang() {
	}
	
	public static CuaHang getCuaHang(String maCuaHang) {
		return entityManager.createNamedQuery("CuaHang.getCuaHang", CuaHang.class)
				.setParameter("maCuaHang", maCuaHang)
				.getSingleResult();
	}
	
}
