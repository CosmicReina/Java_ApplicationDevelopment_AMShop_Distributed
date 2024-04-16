package dao;

import java.util.List;

import connect.MSSQLConnection;
import entity.CaLamViec;
import jakarta.persistence.EntityManager;

public class DAO_CaLamViec {
	
	private static EntityManager entityManager = MSSQLConnection.getEntityManager();

	private DAO_CaLamViec() {
	}
	
	public static List<CaLamViec> getAllCaLamViec(){
		return entityManager.createNamedQuery("CaLamViec.getAllCaLamViec", CaLamViec.class)
				.getResultList();
	}
	
	public static CaLamViec getCaLamViecTheoMaCaLamViec(int maCaLamViec) {
		return entityManager
				.createNamedQuery("CaLamViec.getCaLamViecTheoMaCaLamViec", CaLamViec.class)
				.setParameter("maCaLamViec", maCaLamViec)
				.getSingleResult();
	}

}
