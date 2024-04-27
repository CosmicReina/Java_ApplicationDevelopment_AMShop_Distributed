package script;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMSSQL;
import dao.DAO_ChiTietHoaDon;
import dao.DAO_CuaHang;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import dao.DAO_QuanAo;
import entity.ChiTietHoaDon;
import entity.CuaHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.QuanAo;

public class GenerateScriptHoaDon {

	public static void main(String[] args) {
		
		ConnectionMSSQL.open();
		
		// Tính thời gian chạy script
		long startTime = System.currentTimeMillis();
		
		// Khởi tạo dữ liệu
		generateHoaDon();
		
		// Tính thời gian chạy script
		long endTime = System.currentTimeMillis();
		System.out.println("Thời gian chạy script: " + (endTime - startTime) + "ms");

	}

	private static void generateHoaDon() {

		// Khởi tạo danh sách hóa đơn từ ngày bắt đầu đến ngày kết thúc
		// Với mỗi hóa đơn, tạo ngẫu nhiên các thông tin sau:
		// String maHoaDon;
		// CuaHang cuaHang;
		// NhanVien nhanVien;
		// KhachHang khachHang;
		// private double tienKhachDua;
		// private LocalDateTime thoiGianTao;

		LocalDate ngayBatDau = LocalDate.of(2024, 3, 1);
		LocalDate ngayKetThuc = LocalDate.now();

		CuaHang cuaHang = DAO_CuaHang.getCuaHang("AMShopGV01");

		List<NhanVien> listNhanVien = DAO_NhanVien.getAllNhanVien();
		List<KhachHang> listKhachHang = DAO_KhachHang.getAllKhachHang();
		List<QuanAo> listQuanAo = DAO_QuanAo.getAllQuanAo();

		for (LocalDate date = ngayBatDau; date.isBefore(ngayKetThuc); date = date.plusDays(1)) {
			// Random số lượng hóa đơn trong ngày
			int soLuongHoaDon = (int) (Math.random() * 3) + 1;
			for (int i = 0; i < soLuongHoaDon; i++) {
				String maHoaDon = khoiTaoMaHoaDon(date);
				NhanVien nhanVien = getRandomNhanVien(listNhanVien);
				KhachHang khachHang = getRandomKhachHang(listKhachHang);
				double tienKhachDua = 10000000 + Math.random() * 10000000;
				HoaDon hoaDon = new HoaDon(maHoaDon, cuaHang, nhanVien, khachHang, tienKhachDua,
						LocalDateTime.of(date, LocalDateTime.now().toLocalTime()));
				DAO_HoaDon.createHoaDon(hoaDon);
				
				// Random số lượng sản phẩm trong hóa đơn
				List<QuanAo> listQuanAoInHoaDon = getRandomListQuanAo(listQuanAo);
				for (QuanAo quanAo : listQuanAoInHoaDon) {
//					ChiTietHoaDon(HoaDon hoaDon, QuanAo quanAo, int soLuong, double donGia)
					// Random số lượng sản phẩm với mỗi sản phẩm
					int soLuong = (int) (Math.random() * 3) + 1;
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(hoaDon, quanAo, soLuong, quanAo.getDonGiaBan());
					DAO_ChiTietHoaDon.createChiTietHoaDon(chiTietHoaDon);
					
				}
			}
		}

	}

	private static String khoiTaoMaHoaDon(LocalDate localDate) {
		String maHoaDon;
		int soHoaDon;

		String year = Integer.toString(localDate.getYear()).substring(2);
		String month = String.format("%02d", localDate.getMonth().getValue());
		String day = String.format("%02d", localDate.getDayOfMonth());

		String prefix = "HD" + year + month + day;

		HoaDon hoaDon = DAO_HoaDon.getHoaDonCuoi(prefix);
		if (hoaDon == null) {
			soHoaDon = 1;
			maHoaDon = prefix + String.format("%04d", soHoaDon);
		} else {
			soHoaDon = Integer.parseInt(hoaDon.getMaHoaDon().substring(8)) + 1;
			maHoaDon = prefix + String.format("%04d", soHoaDon);
		}
		return maHoaDon;
	}

	private static NhanVien getRandomNhanVien(List<NhanVien> listNhanVien) {
		int index = (int) (Math.random() * listNhanVien.size());
		return listNhanVien.get(index);
	}

	private static KhachHang getRandomKhachHang(List<KhachHang> listKhachHang) {
		int index = (int) (Math.random() * listKhachHang.size());
		return listKhachHang.get(index);
	}
	
	// Lấy từ 1 đến 5 quần áo ngẫu nhiên từ listQuanAo
	private static List<QuanAo> getRandomListQuanAo(List<QuanAo> listQuanAo) {
		int soLuongQuanAo = (int) (Math.random() * 3) + 1;
		List<QuanAo> list = new ArrayList<>();
		for (int i = 0; i < soLuongQuanAo; i++) {
			int index = (int) (Math.random() * listQuanAo.size());
			list.add(listQuanAo.get(index));
		}
		return list;
	}

}
