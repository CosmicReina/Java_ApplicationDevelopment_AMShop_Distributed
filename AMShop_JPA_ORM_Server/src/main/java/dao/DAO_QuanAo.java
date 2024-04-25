package dao;

import java.time.LocalDateTime;
import java.util.List;

import connection.ConnectionMSSQL;
import entity.QuanAo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_QuanAo {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_QuanAo() {
	}

	public static boolean createQuanAo(QuanAo quanAo) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(quanAo);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean updateQuanAo(QuanAo quanAo) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(quanAo);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static List<QuanAo> getAllQuanAo() {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<QuanAo> danhSachQuanAo = entityManager.createNamedQuery("QuanAo.getAllQuanAo", QuanAo.class)
					.getResultList();
			entityTransaction.commit();
			return danhSachQuanAo;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static QuanAo getQuanAoTheoMaQuanAo(String maQuanAo) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			QuanAo quanAo = entityManager.createNamedQuery("QuanAo.getQuanAoTheoMaQuanAo", QuanAo.class)
					.setParameter("maQuanAo", maQuanAo)
					.getSingleResult();
			entityTransaction.commit();
			return quanAo;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static QuanAo getQuanAoCuoi() {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			QuanAo quanAo = entityManager.createNamedQuery("QuanAo.getQuanAoCuoi", QuanAo.class).getSingleResult();
			entityTransaction.commit();
			return quanAo;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static List<?> getQuanAoDaBanTrongKhoangNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) {
		try {
			List<?> list = entityManager.createNativeQuery(""
					+ "SELECT QA.MaQuanAo, SUM(CTHD.SoLuong) AS TongSoLuongDaBan "
					+ "FROM (HoaDon HD JOIN ChiTietHoaDon CTHD ON HD.MaHoaDon = CTHD.MaHoaDon) JOIN QuanAo QA ON CTHD.MaQuanAo = QA.MaQuanAo "
					+ "WHERE HD.ThoiGianTao BETWEEN :ngayBatDau AND :ngayKetThuc " + "GROUP BY QA.MaQuanAo")
					.setParameter("ngayBatDau", ngayBatDau)
					.setParameter("ngayKetThuc", ngayKetThuc)
					.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<QuanAo> getQuanAoDaHetHang() {
		try {
			List<QuanAo> list = entityManager
					.createQuery(
							"SELECT QA " + "FROM QuanAo QA " + "WHERE QA.soLuongTrongKho = 0 AND QA.ngungNhap = false",
							QuanAo.class)
					.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
