package data;

import java.io.IOException;
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
import entity.QuanAo;

public class InBaoCaoQuanAoDaHet {
	public static boolean createBaoCaoQuanAoDaHet(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws IOException {
		try {
			String baocao_file_path = "files//baoCao//" + "baoCaoQuanAoDaHet.pdf";
			PdfWriter pdfWriter = new PdfWriter(baocao_file_path);
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);
			Document document = new Document(pdfDocument);

			String font_path = "files//font//Inconsolata-VariableFont_wdth,wght.ttf";
			pdfDocument.setDefaultPageSize(new PageSize(1000, 600));
			document.setMargins(5, 5, 0, 5);
			document.setFont(PdfFontFactory.createFont(font_path, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED));

			int tongQuanAo = 0;

			List<QuanAo> list = ServiceInitiator.getInstance().getServiceQuanAo().getQuanAoDaHetHang();

			tongQuanAo = list.size();

			Paragraph prgBaoCao = new Paragraph("Báo Cáo Thống Kê Sản Phẩm Đã Hết");
			prgBaoCao.setFontSize(16).setBold().setTextAlignment(TextAlignment.CENTER).setMargin(0);

			Paragraph prgThoiGianThongKe = new Paragraph();
			prgThoiGianThongKe.add(new Text("Thống kê vào lúc: ").setBold());
			prgThoiGianThongKe.add(FormatLocalDateTime.toFormattedLocalDateTime(LocalDateTime.now()));
			prgThoiGianThongKe.setMarginLeft(50);

			Paragraph prgTongKhachHang = new Paragraph();
			prgTongKhachHang.add(new Text("Tổng số quần áo đã hết: ").setBold());
			prgTongKhachHang.add(new Text(Integer.toString(tongQuanAo)));
			prgTongKhachHang.setMarginLeft(50);

			Paragraph prgBaoCaoDoanhThu = new Paragraph("Danh Sách Thống Kê Quần Áo Đã Hết");
			prgBaoCaoDoanhThu.setFontSize(16).setBold().setTextAlignment(TextAlignment.CENTER).setMargin(0);

			float[] tblHeaderSize = {150, 750};
			String[] tblHeaderList = {"Mã Quần Áo", "Tên Quần Áo"};
			Table tblDetail = new Table(tblHeaderSize);
			for (String thisString : tblHeaderList) {
				tblDetail.addCell(new Paragraph(thisString).setBold().setTextAlignment(TextAlignment.CENTER));
			}

			for (QuanAo quanAo : list) {
				tblDetail.addCell(new Paragraph(quanAo.getMaQuanAo()));
				tblDetail.addCell(new Paragraph(quanAo.getTenQuanAo()));
			}

			tblDetail.setHorizontalAlignment(HorizontalAlignment.CENTER).setMargin(0);

			document.add(prgBaoCao);
			document.add(prgThoiGianThongKe);
			document.add(prgTongKhachHang);
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
