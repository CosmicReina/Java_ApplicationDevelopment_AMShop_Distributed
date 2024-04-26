package script;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMSSQL;
import dao.DAO_CaLamViec;
import dao.DAO_ChiTietPhanCong;
import dao.DAO_LichLamViec;
import dao.DAO_NhanVien;
import entity.CaLamViec;
import entity.ChiTietPhanCong;
import entity.LichLamViec;
import entity.NhanVien;

public class GenerateScriptChiTietPhanCong {

	public static void main(String[] args) {

		ConnectionMSSQL.open();

		// Tính thời gian chạy script
		long startTime = System.currentTimeMillis();

		// Khởi tạo dữ liệu
		generateChiTietPhanCong();

		// Tính thời gian chạy script
		long endTime = System.currentTimeMillis();
		System.out.println("Thời gian chạy script: " + (endTime - startTime) + "ms");

	}

	private static void generateChiTietPhanCong() {

		// Khởi tạo lịch làm việc từ ngày bắt đầu đến ngày kết thúc
		// LichLamViec(String maLichLamViec, LocalDate ngayLamViec, CaLamViec caLamViec)

		LocalDate ngayBatDau = LocalDate.of(2024, 2, 1);
		LocalDate ngayKetThuc = LocalDate.now();

		List<NhanVien> listNhanVien = DAO_NhanVien.getAllNhanVien();

		for (LocalDate date = ngayBatDau; date.isBefore(ngayKetThuc); date = date.plusDays(1)) {
			// Tạo lịch làm việc sáng
			List<NhanVien> listNhanVienCopy = new ArrayList<NhanVien>(listNhanVien);
			String maLichLamViecSang = khoiTaoMaLichLamViecSang(date);
			CaLamViec caLamViecSang = DAO_CaLamViec.getCaLamViecTheoMaCaLamViec(1);
			LichLamViec lichLamViecSang = new LichLamViec(maLichLamViecSang, date, caLamViecSang);
			DAO_LichLamViec.createLichLamViec(lichLamViecSang);
			List<NhanVien> listNhanVienInHoaDonSang = getRandomListNhanVien(listNhanVienCopy);
			for (NhanVien nhanVien : listNhanVienInHoaDonSang) {
				// Tạo chi tiết phân công
				ChiTietPhanCong chiTietPhanCong = new ChiTietPhanCong(
						lichLamViecSang,
						nhanVien,  
						LocalDateTime.of(
								lichLamViecSang.getNgayLamViec(),
								caLamViecSang.getGioBatDau()),
						LocalDateTime.of(
                                lichLamViecSang.getNgayLamViec(), 
                                caLamViecSang.getGioKetThuc()));
				DAO_ChiTietPhanCong.createChiTietPhanCong(chiTietPhanCong);
			}
			
			// Tạo lịch làm việc chiều
			String maLichLamViecChieu = khoiTaoMaLichLamViecChieu(date);
			CaLamViec caLamViecChieu = DAO_CaLamViec.getCaLamViecTheoMaCaLamViec(2);
			LichLamViec lichLamViecChieu = new LichLamViec(maLichLamViecChieu, date, caLamViecChieu);
			DAO_LichLamViec.createLichLamViec(lichLamViecChieu);
			List<NhanVien> listNhanVienInHoaDonChieu = getRemainingListNhanVien(listNhanVienCopy, listNhanVienInHoaDonSang);
			for (NhanVien nhanVien : listNhanVienInHoaDonChieu) {
				// Tạo chi tiết phân công
				ChiTietPhanCong chiTietPhanCong = new ChiTietPhanCong(lichLamViecChieu, nhanVien,
						LocalDateTime.of(lichLamViecChieu.getNgayLamViec(), caLamViecChieu.getGioBatDau()),
						LocalDateTime.of(lichLamViecChieu.getNgayLamViec(), caLamViecChieu.getGioKetThuc()));
				DAO_ChiTietPhanCong.createChiTietPhanCong(chiTietPhanCong);
			}
		}

	}

	private static String khoiTaoMaLichLamViecSang(LocalDate localDate) {
		String maLichLamViec;

		String year = Integer.toString(localDate.getYear()).substring(2);
		String month = String.format("%02d", localDate.getMonth().getValue());
		String day = String.format("%02d", localDate.getDayOfMonth());

		maLichLamViec = "LH" + year + month + day + "S";

		return maLichLamViec;

	}

	private static String khoiTaoMaLichLamViecChieu(LocalDate ngayLamViec) {
		String maLichLamViec;

		String year = Integer.toString(ngayLamViec.getYear()).substring(2);
		String month = String.format("%02d", ngayLamViec.getMonth().getValue());
		String day = String.format("%02d", ngayLamViec.getDayOfMonth());

		maLichLamViec = "LH" + year + month + day + "C";

		return maLichLamViec;

	}

	// Chọn từ 3 đến 5 nhân viên ngẫu nhiên
	private static List<NhanVien> getRandomListNhanVien(List<NhanVien> listNhanVien) {
		List<NhanVien> listNhanVienInHoaDon = listNhanVien.subList(0, (int) (Math.random() * 3) + 3);
		return listNhanVienInHoaDon;
	}

	// Chọn từ 3 đến 5 nhân viên còn lại
	private static List<NhanVien> getRemainingListNhanVien(List<NhanVien> listNhanVien,
			List<NhanVien> danhSachNhanVienDaChon) {
		List<NhanVien> listNhanVienConLai = listNhanVien;
		listNhanVienConLai.removeAll(danhSachNhanVienDaChon);
		List<NhanVien> listNhanVienInHoaDon = listNhanVienConLai.subList(0, (int) (Math.random() * 3) + 3);
		return listNhanVienInHoaDon;
	}

}
