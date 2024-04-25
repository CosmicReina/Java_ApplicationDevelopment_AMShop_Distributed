package dao;

import connection.ConnectionMSSQL;
import entity.CuaHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_CuaHang {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_CuaHang() {
	}

	public static CuaHang getCuaHang(String maCuaHang) {
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			CuaHang cuaHang = entityManager.find(CuaHang.class, maCuaHang);
			transaction.commit();
			return cuaHang;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
