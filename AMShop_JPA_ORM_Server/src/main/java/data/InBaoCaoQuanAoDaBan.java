package data;

import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;

import configuration.ServiceInitiator;
import entity.QuanAo;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class InBaoCaoQuanAoDaBan {
	public static boolean createBaoCaoQuanAoDaBan(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws IOException {
		try {
			String baocao_file_path = "files//baoCao//" + "baoCaoQuanAoDaBan.pdf";
			PdfWriter pdfWriter = new PdfWriter(baocao_file_path);
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);
			Document document = new Document(pdfDocument);

			String font_path = "files//font//Inconsolata-VariableFont_wdth,wght.ttf";
			pdfDocument.setDefaultPageSize(new PageSize(1000, 600));
			document.setMargins(5, 5, 0, 5);
			document.setFont(PdfFontFactory.createFont(font_path, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED));

			int tongQuanAo = 0;
			double tongDoanhThu = 0;
			double tongDoanhThuThuan = 0;

			// ResultSet rs = DAO_QuanAo.thongKeQuanAoDaBanTrongKhoangNgay(ngayBatDau, ngayKetThuc);
			// try {
			// while(rs.next()){
			// String maQuanAo = rs.getString(1);
			// QuanAo quanAo = DAO_QuanAo.getQuanAoTheoMaQuanAo(maQuanAo);
			// int soLuong = rs.getInt(2);
			// double doanhThuThanhPhan = rs.getDouble(2) * quanAo.getDonGiaBan();
			// double doanhThuThuanThanhPhan = rs.getDouble(2) * (quanAo.getDonGiaBan() - quanAo.getDonGiaNhap());
			// tongQuanAo += soLuong;
			// tongDoanhThu += doanhThuThanhPhan;
			// tongDoanhThuThuan += doanhThuThuanThanhPhan;
			// }
			// } catch (SQLException ex) {
			// ex.printStackTrace(System.out);
			// }

			List<?> list = ServiceInitiator.getInstance()
					.getServiceQuanAo()
					.getQuanAoDaBanTrongKhoangNgay(LocalDateTime.of(ngayBatDau, LocalDateTime.MIN.toLocalTime()),
							LocalDateTime.of(ngayKetThuc, LocalDateTime.MAX.toLocalTime()));

			Paragraph prgBaoCao = new Paragraph("Báo Cáo Thống Kê Sản Phẩm Đã Bán");
			prgBaoCao.setFontSize(16).setBold().setTextAlignment(TextAlignment.CENTER).setMargin(0);

			Paragraph prgKhoangThoiGian = new Paragraph();
			prgKhoangThoiGian.add(new Text("Thống kê từ: ").setBold());
			prgKhoangThoiGian.add(new Text(FormatLocalDate.fromLocalDate(ngayBatDau)));
			prgKhoangThoiGian.add(new Text(" đến ").setBold());
			prgKhoangThoiGian.add(new Text(FormatLocalDate.fromLocalDate(ngayKetThuc)));
			prgKhoangThoiGian.setMarginLeft(50);

			Paragraph prgThoiGianThongKe = new Paragraph();
			prgThoiGianThongKe.add(new Text("Thống kê vào lúc: ").setBold());
			prgThoiGianThongKe.add(FormatLocalDateTime.toFormattedLocalDateTime(LocalDateTime.now()));
			prgThoiGianThongKe.setMarginLeft(50);

			Paragraph prgTongKhachHang = new Paragraph();
			prgTongKhachHang.add(new Text("Tổng số quần áo đã bán: ").setBold());
			prgTongKhachHang.add(new Text(Integer.toString(tongQuanAo)));
			prgTongKhachHang.setMarginLeft(50);

			Paragraph prgTongDoanhThu = new Paragraph();
			prgTongDoanhThu.add(new Text("Tổng doanh thu: ").setBold());
			prgTongDoanhThu.add(new Text(FormatDouble.toMoney(tongDoanhThu)));
			prgTongDoanhThu.setMarginLeft(50);

			Paragraph prgTongDoanhThuThuan = new Paragraph();
			prgTongDoanhThuThuan.add(new Text("Tổng doanh thu thuần: ").setBold());
			prgTongDoanhThuThuan.add(new Text(FormatDouble.toMoney(tongDoanhThuThuan)));
			prgTongDoanhThuThuan.setMarginLeft(50);

			Paragraph prgBaoCaoDoanhThu = new Paragraph("Danh Sách Thống Kê Quần Áo");
			prgBaoCaoDoanhThu.setFontSize(16).setBold().setTextAlignment(TextAlignment.CENTER).setMargin(0);

			float[] tblHeaderSize = {150, 150, 150, 150, 150};
			String[] tblHeaderList = {"Mã Quần Áo", "Tên Quần Áo", "Số Lượng Đã Bán", "Doanh Thu", "Doanh Thu Thuần"};
			Table tblDetail = new Table(tblHeaderSize);
			for (String thisString : tblHeaderList) {
				tblDetail.addCell(new Paragraph(thisString).setBold().setTextAlignment(TextAlignment.CENTER));
			}
//		try {
//			rs = DAO_QuanAo.thongKeQuanAoDaBanTrongKhoangNgay(ngayBatDau, ngayKetThuc);
//			while (rs.next()) {
//				String maQuanAo = rs.getString(1);
//				QuanAo quanAo = DAO_QuanAo.getQuanAoTheoMaQuanAo(maQuanAo);
//				int soLuong = rs.getInt(2);
//				double doanhThuThanhPhan = rs.getDouble(2) * quanAo.getDonGiaBan();
//				double doanhThuThuanThanhPhan = rs.getDouble(2) * (quanAo.getDonGiaBan() - quanAo.getDonGiaNhap());
//
//				tblDetail.addCell(new Paragraph(maQuanAo));
//				tblDetail.addCell(new Paragraph(quanAo.getTenQuanAo()));
//				tblDetail.addCell(new Paragraph(Integer.toString(soLuong)));
//				tblDetail.addCell(new Paragraph(FormatDouble.toMoney(doanhThuThanhPhan)));
//				tblDetail.addCell(new Paragraph(FormatDouble.toMoney(doanhThuThuanThanhPhan)));
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace(System.out);
//		}
			
			for (Object object : list) {
				Object[] obj = (Object[]) object;
				String maQuanAo = (String) obj[0];
				QuanAo quanAo = ServiceInitiator.getInstance().getServiceQuanAo().getQuanAoTheoMaQuanAo(maQuanAo);
				int soLuong = (int) obj[1];
				double doanhThuThanhPhan = soLuong * quanAo.getDonGiaBan();
				double doanhThuThuanThanhPhan = soLuong * (quanAo.getDonGiaBan() - quanAo.getDonGiaNhap());
				
				tblDetail.addCell(new Paragraph(maQuanAo));
				tblDetail.addCell(new Paragraph(quanAo.getTenQuanAo()));
				tblDetail.addCell(new Paragraph(Integer.toString(soLuong)));
				tblDetail.addCell(new Paragraph(FormatDouble.toMoney(doanhThuThanhPhan)));
				tblDetail.addCell(new Paragraph(FormatDouble.toMoney(doanhThuThuanThanhPhan)));
			}

			tblDetail.setHorizontalAlignment(HorizontalAlignment.CENTER).setMargin(0);

			document.add(prgBaoCao);
			document.add(prgThoiGianThongKe);
			document.add(prgKhoangThoiGian);
			document.add(prgTongKhachHang);
			document.add(prgTongDoanhThu);
			document.add(prgTongDoanhThuThuan);
			document.add(prgBaoCaoDoanhThu);
			document.add(tblDetail);

			document.close();
			return true;
		} catch (IOException | NotBoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
