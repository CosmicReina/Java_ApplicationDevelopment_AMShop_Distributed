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
import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class InBaoCaoDoanhThu {
    public static boolean createBaoCaoDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws IOException{
        String baocao_file_path = "files//baoCao//" + "baoCaoDoanhThu.pdf";
        PdfWriter pdfWriter = new PdfWriter(baocao_file_path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        
        String font_path = "files//font//Inconsolata-VariableFont_wdth,wght.ttf";
        pdfDocument.setDefaultPageSize(new PageSize(1000, 600));
        document.setMargins(5, 5, 0, 5);
        document.setFont(PdfFontFactory.createFont(font_path, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED));
        
        ArrayList<HoaDon> listHD = DAO_HoaDon.getAllHoaDonTrongKhoangNgay(ngayBatDau, ngayKetThuc);
        
        int tongQuanAo = 0;
        double tongDoanhThu = 0;
        double tongDoanhThuThuan = 0;
        for(HoaDon thisHoaDon : listHD){
            ArrayList<ChiTietHoaDon> listCTHD = DAO_ChiTietHoaDon.getAllChiTietHoaDonTheoMaHoaDon(thisHoaDon.getMaHoaDon());
            double tongDoanhThuThanhPhan = 0;
            double tongDoanhThuThuanThanhPhan = 0;
            int tongQuanAoThanhPhan = 0;
            for(ChiTietHoaDon thisChiTietHoaDon : listCTHD){
                tongDoanhThuThanhPhan += thisChiTietHoaDon.getSoLuong() * thisChiTietHoaDon.getDonGia();
                tongDoanhThuThuanThanhPhan += thisChiTietHoaDon.getSoLuong() * (thisChiTietHoaDon.getDonGia() - thisChiTietHoaDon.getQuanAo().getDonGiaNhap());
                tongQuanAoThanhPhan += thisChiTietHoaDon.getSoLuong();
            }
            tongQuanAo += tongQuanAoThanhPhan;
            tongDoanhThu += tongDoanhThuThanhPhan;
            tongDoanhThuThuan += tongDoanhThuThuanThanhPhan;
        }
        
        Paragraph prgBaoCao = new Paragraph("Báo Cáo Thống Kê Doanh Thu");
        prgBaoCao
                .setFontSize(16)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER)
                .setMargin(0);
        
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
        
        Paragraph prgTongHoaDon = new Paragraph();
        prgTongHoaDon.add(new Text("Tổng số hóa đơn: ").setBold());
        prgTongHoaDon.add(new Text(Integer.toString(listHD.size())));
        prgTongHoaDon.setMarginLeft(50);
        
        Paragraph prgTongQuanAo = new Paragraph();
        prgTongQuanAo.add(new Text("Tổng số quần áo: ").setBold());
        prgTongQuanAo.add(new Text(Integer.toString(tongQuanAo)));
        prgTongQuanAo.setMarginLeft(50);
        
        Paragraph prgTongDoanhThu = new Paragraph();
        prgTongDoanhThu.add(new Text("Tổng doanh thu: ").setBold());
        prgTongDoanhThu.add(new Text(FormatDouble.toMoney(tongDoanhThu)));
        prgTongDoanhThu.setMarginLeft(50);
        
        Paragraph prgTongDoanhThuThuan = new Paragraph();
        prgTongDoanhThuThuan.add(new Text("Tổng doanh thu thuần: ").setBold());
        prgTongDoanhThuThuan.add(new Text(FormatDouble.toMoney(tongDoanhThuThuan)));
        prgTongDoanhThuThuan.setMarginLeft(50);
        
        Paragraph prgBaoCaoDoanhThu = new Paragraph("Danh Sách Thống Kê Doanh Thu");
        prgBaoCaoDoanhThu
                .setFontSize(16)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER)
                .setMargin(0);
        
        float[] tblHeaderSize = {150, 150, 150, 150, 150, 150};
        String[] tblHeaderList = {
            "Mã Hóa Đơn",
            "Tên Nhân Viên",
            "Tên Khách Hàng",
            "Thời Gian Lập Đơn",
            "Số Quần Áo Đã Bán",
            "Tổng Tiền"
        };
        
        Table tblDetail = new Table(tblHeaderSize);
        for(String thisString : tblHeaderList) {
                tblDetail.addCell(new Paragraph(thisString).setBold().setTextAlignment(TextAlignment.CENTER));
        }

        for(HoaDon thisHoaDon : listHD){
            ArrayList<ChiTietHoaDon> listCTHD = DAO_ChiTietHoaDon.getAllChiTietHoaDonTheoMaHoaDon(thisHoaDon.getMaHoaDon());
            int tongQuanAoThanhPhan = 0;
            double doanhThuThanhPhan = 0;
            
            for(ChiTietHoaDon thisChiTietHoaDon : listCTHD){
                doanhThuThanhPhan += thisChiTietHoaDon.getSoLuong() * thisChiTietHoaDon.getDonGia();
                tongQuanAoThanhPhan += thisChiTietHoaDon.getSoLuong();
                
            }
            tblDetail.addCell(new Paragraph(thisHoaDon.getMaHoaDon()));
            tblDetail.addCell(new Paragraph(thisHoaDon.getNhanVien().getHoTen()));
            tblDetail.addCell(new Paragraph(thisHoaDon.getKhachHang().getHoTen()));
            tblDetail.addCell(new Paragraph(FormatLocalDateTime.toFormattedLocalDateTime(thisHoaDon.getThoiGianTao())));
            tblDetail.addCell(new Paragraph(Integer.toString(tongQuanAoThanhPhan)));
            tblDetail.addCell(new Paragraph(FormatDouble.toMoney(doanhThuThanhPhan)));
        }
        tblDetail
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setMargin(0);
        
        document.add(prgBaoCao);
        document.add(prgKhoangThoiGian);
        document.add(prgThoiGianThongKe);
        document.add(prgTongHoaDon);
        document.add(prgTongQuanAo);
        document.add(prgTongDoanhThu);
        document.add(prgTongDoanhThuThuan);
        document.add(prgBaoCaoDoanhThu);
        document.add(tblDetail);
        
        document.close();
        return true;
    }
}
