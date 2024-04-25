package dao;

import java.util.List;

import connection.ConnectionMSSQL;
import entity.CaLamViec;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_CaLamViec {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_CaLamViec() {
	}

	public static List<CaLamViec> getAllCaLamViec() {
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			List<CaLamViec> listCaLamViec = entityManager.createNamedQuery("CaLamViec.getAllCaLamViec", CaLamViec.class)
					.getResultList();
			transaction.commit();
			return listCaLamViec;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static CaLamViec getCaLamViecTheoMaCaLamViec(int maCaLamViec) {
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			CaLamViec caLamViec = entityManager.createNamedQuery("CaLamViec.getCaLamViecTheoMaCaLamViec", CaLamViec.class)
					.setParameter("maCaLamViec", maCaLamViec)
					.getSingleResult();
			transaction.commit();
			return caLamViec;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
