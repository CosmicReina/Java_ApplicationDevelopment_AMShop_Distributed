package data;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
import entity.KhachHang;

public class InBaoCaoKhachHang {
	public static boolean createBaoCaoKhachHang(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws IOException {
		try {
			String baocao_file_path = "files//baoCao//" + "baoCaoKhachHang.pdf";
			PdfWriter pdfWriter = new PdfWriter(baocao_file_path);
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);
			Document document = new Document(pdfDocument);

			String font_path = "files//font//Inconsolata-VariableFont_wdth,wght.ttf";
			pdfDocument.setDefaultPageSize(new PageSize(1000, 600));
			document.setMargins(5, 5, 0, 5);
			document.setFont(PdfFontFactory.createFont(font_path, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED));

			int tongKhachHang = 0;
			double tongDoanhThu = 0;

			List<?> list = ServiceInitiator.getInstance()
					.getServiceKhachHang()
					.getKhachHangTheoKhoangNgay(LocalDateTime.of(ngayBatDau, LocalDateTime.MIN.toLocalTime()),
							LocalDateTime.of(ngayKetThuc, LocalDateTime.MAX.toLocalTime()));

			for (Object object : list) {
				Object[] obj = (Object[]) object;
				BigDecimal tongDoanhThuKhachHang = (BigDecimal) obj[3];
				Double tongDoanhThuKhachHangDouble = tongDoanhThuKhachHang.doubleValue();
				tongKhachHang++;
				tongDoanhThu += tongDoanhThuKhachHangDouble;
			}

			Paragraph prgBaoCao = new Paragraph("Báo Cáo Thống Kê Khách Hàng");
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
			prgTongKhachHang.add(new Text("Tổng số khách hàng: ").setBold());
			prgTongKhachHang.add(new Text(Integer.toString(tongKhachHang)));
			prgTongKhachHang.setMarginLeft(50);

			Paragraph prgTongDoanhThu = new Paragraph();
			prgTongDoanhThu.add(new Text("Tổng doanh thu: ").setBold());
			prgTongDoanhThu.add(new Text(FormatDouble.toMoney(tongDoanhThu)));
			prgTongDoanhThu.setMarginLeft(50);

			Paragraph prgBaoCaoDoanhThu = new Paragraph("Danh Sách Thống Kê Khách Hàng");
			prgBaoCaoDoanhThu.setFontSize(16).setBold().setTextAlignment(TextAlignment.CENTER).setMargin(0);

			float[] tblHeaderSize = {150, 150, 150, 150, 150, 150};
			String[] tblHeaderList = {"Mã Khách Hàng", "Tên Khách Hàng", "Nhóm Khách Hàng", "Số Lần Mua Hàng",
					"Số Quần Áo Đã Mua", "Tổng Số Tiền"};
			Table tblDetail = new Table(tblHeaderSize);
			for (String thisString : tblHeaderList) {
				tblDetail.addCell(new Paragraph(thisString).setBold().setTextAlignment(TextAlignment.CENTER));
			}
			
			for (Object object : list) {
				Object[] obj = (Object[]) object;
				String maKhachHang = (String) obj[0];
				KhachHang khachHang = ServiceInitiator.getInstance().getServiceKhachHang().getKhachHangTheoMaKhachHang(maKhachHang);
				BigDecimal tongDoanhThuKhachHang = (BigDecimal) obj[3];
				Double tongDoanhThuKhachHangDouble = tongDoanhThuKhachHang.doubleValue();
				
				tblDetail.addCell(new Paragraph(maKhachHang));
				tblDetail.addCell(new Paragraph(khachHang.getHoTen()));
				tblDetail.addCell(new Paragraph(khachHang.getNhomKhachHang()));
				tblDetail.addCell(new Paragraph(Integer.toString((int) obj[1])));
				tblDetail.addCell(new Paragraph(Integer.toString((int) obj[2])));
				tblDetail.addCell(new Paragraph(FormatDouble.toMoney(tongDoanhThuKhachHangDouble)));
			}

			tblDetail.setHorizontalAlignment(HorizontalAlignment.CENTER).setMargin(0);

			document.add(prgBaoCao);
			document.add(prgThoiGianThongKe);
			document.add(prgKhoangThoiGian);
			document.add(prgTongKhachHang);
			document.add(prgTongDoanhThu);
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
