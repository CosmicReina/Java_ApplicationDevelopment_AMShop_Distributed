package dao;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import connection.ConnectionMSSQL;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO_NhanVien {

	private static EntityManager entityManager = ConnectionMSSQL.getEntityManager();

	private DAO_NhanVien() {
	}

	public static boolean createNhanVien(NhanVien nhanVien) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(nhanVien);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static boolean updateNhanVien(NhanVien nhanVien) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(nhanVien);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public static List<NhanVien> getAllNhanVien() {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<NhanVien> danhSachNhanVien = entityManager.createNamedQuery("NhanVien.getAllNhanVien", NhanVien.class)
					.getResultList();
			entityTransaction.commit();
			return danhSachNhanVien;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static NhanVien getNhanVienTheoMaNhanVien(String maNhanVien) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			NhanVien nhanVien = entityManager.createNamedQuery("NhanVien.getNhanVienTheoMaNhanVien", NhanVien.class)
					.setParameter("maNhanVien", maNhanVien)
					.getSingleResult();
			entityTransaction.commit();
			return nhanVien;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static NhanVien getNhanVienTheoSoDienThoai(String soDienThoai) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			NhanVien nhanVien = entityManager.createNamedQuery("NhanVien.getNhanVienTheoSoDienThoai", NhanVien.class)
					.setParameter("soDienThoai", soDienThoai)
					.getSingleResult();
			entityTransaction.commit();
			return nhanVien;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static NhanVien getNhanVienTheoCanCuocCongDan(String canCuocCongDan) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			NhanVien nhanVien = entityManager.createNamedQuery("NhanVien.getNhanVienTheoCanCuocCongDan", NhanVien.class)
					.setParameter("canCuocCongDan", canCuocCongDan)
					.getSingleResult();
			entityTransaction.commit();
			return nhanVien;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static List<NhanVien> getDanhSachNhanVienChuaCoTrongNgayLamViec(LocalDate ngayLamViec) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<NhanVien> danhSachNhanVien = entityManager
					.createNamedQuery("NhanVien.getDanhSachNhanVienChuaCoTrongNgayLamViec", NhanVien.class)
					.setParameter("ngayLamViec", ngayLamViec)
					.getResultList();
			entityTransaction.commit();
			return danhSachNhanVien;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static NhanVien getNhanVienCuoi(String prefix) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			prefix = prefix + "%";
			NhanVien nhanVien = entityManager.createNamedQuery("NhanVien.getNhanVienCuoi", NhanVien.class)
					.setParameter("prefix", prefix)
					.getSingleResult();
			entityTransaction.commit();
			return nhanVien;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static NhanVien getNhanVienTheoThongTinDangNhap(String maNhanVien, String matKhau) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			NhanVien nhanVien = entityManager
					.createNamedQuery("NhanVien.getNhanVienTheoThongTinDangNhap", NhanVien.class)
					.setParameter("maNhanVien", maNhanVien)
					.setParameter("matKhau", matKhau)
					.getSingleResult();
			entityTransaction.commit();
			return nhanVien;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public static Map<NhanVien, Integer> getTongThoiGianLamViecTheoThang(int year, int month) {
		try {
			List<?> list = entityManager.createNativeQuery(
					"SELECT MaNhanVien, SUM(DATEDIFF(SECOND, '00:00:00', CONVERT(DATETIME, ThoiGianRaCa - ThoiGianVaoCa))) AS TotalSeconds "
							+ "FROM LichLamViec L JOIN ChiTietPhanCong CT ON L.MaLichLamViec = CT.MaLichLamViec "
							+ "WHERE YEAR(NgayLamViec) = :year AND MONTH(NgayLamViec) = :month "
							+ "GROUP BY MaNhanVien "
							+ "ORDER BY MaNhanVien ASC")
					.setParameter("year", year)
					.setParameter("month", month)
					.getResultList();
			LinkedHashMap<NhanVien, Integer> map = list.stream()
					.collect(Collectors.toMap(o -> getNhanVienTheoMaNhanVien((String) ((Object[]) o)[0]),
							o -> (Integer) ((Object[]) o)[1], (o1, o2) -> o1, LinkedHashMap::new));
			return map;
		} catch (Exception e) {
			return null;
		}
	}

}
