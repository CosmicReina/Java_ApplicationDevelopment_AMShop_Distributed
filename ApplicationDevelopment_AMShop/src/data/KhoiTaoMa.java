package data;

import dao.DAO_DonDatHang;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import dao.DAO_QuanAo;
import java.time.LocalDate;

public class KhoiTaoMa {
    public static String generateMaNhanVien(){
        String maNhanVien;
        int soNhanVien;
        
        LocalDate localDate = LocalDate.now();
        String year = Integer.toString(localDate.getYear()).substring(2);
        String month = String.format("%02d", localDate.getMonth().getValue());
        String day = String.format("%02d", localDate.getDayOfMonth());
        
        String prefix = "NV" + year + month + day;
        
        String maNhanVienCuoi = DAO_NhanVien.getMaNhanVienCuoi(prefix);
        if(maNhanVienCuoi == null){
            soNhanVien = 1;
            maNhanVien = prefix + String.format("%02d", soNhanVien);
        }
        else{
            soNhanVien = Integer.parseInt(maNhanVienCuoi.substring(8)) + 1;
            maNhanVien = prefix + String.format("%02d", soNhanVien);
        }
        return maNhanVien;
    }
    
    public static String generateMaKhachHang(){
        String maKhachHang;
        int soKhachHang;
        
        LocalDate localDate = LocalDate.now();
        String year = Integer.toString(localDate.getYear()).substring(2);
        
        String prefix = "KH" + year;
        
        String maKhachHangCuoi = DAO_KhachHang.getMaKhachHangCuoi(prefix);
        if(maKhachHangCuoi == null){
            soKhachHang = 1;
            maKhachHang = prefix + String.format("%06d", soKhachHang);
        }
        else{
            soKhachHang = Integer.parseInt(maKhachHangCuoi.substring(4)) + 1;
            maKhachHang = prefix + String.format("%06d", soKhachHang);
        }
        return maKhachHang;
    }
    
    public static String generateMaQuanAo(){
        String maQuanAo;
        int soQuanAo;
        
        String prefix = "QA";
        
        String maQuanAoCuoi = DAO_QuanAo.getMaQuanAoCuoi();
        if(maQuanAoCuoi == null){
            soQuanAo = 1;
            maQuanAo = prefix + String.format("%06d", soQuanAo);
        }
        else{
            soQuanAo = Integer.parseInt(maQuanAoCuoi.substring(2)) + 1;
            maQuanAo = prefix + String.format("%06d", soQuanAo);
        }
        return maQuanAo;
    }
    
    public static String generateMaHoaDon(){
        String maHoaDon;
        int soHoaDon;
        
        LocalDate localDate = LocalDate.now();
        String year = Integer.toString(localDate.getYear()).substring(2);
        String month = String.format("%02d", localDate.getMonth().getValue());
        String day = String.format("%02d", localDate.getDayOfMonth());
        
        String prefix = "HD" + year + month + day;
        
        String maHoaDonCuoi = DAO_HoaDon.getMaHoaDonCuoi(prefix);
        if(maHoaDonCuoi == null){
            soHoaDon = 1;
            maHoaDon = prefix + String.format("%04d", soHoaDon);
        }
        else{
            soHoaDon = Integer.parseInt(maHoaDonCuoi.substring(8)) + 1;
            maHoaDon = prefix + String.format("%04d", soHoaDon);
        }
        return maHoaDon;
    }
    
    public static String generateMaDonDatHang(){
        String maDonDatHang;
        int soDonDatHang;
        
        LocalDate localDate = LocalDate.now();
        String year = Integer.toString(localDate.getYear()).substring(2);
        String month = String.format("%02d", localDate.getMonth().getValue());
        String day = String.format("%02d", localDate.getDayOfMonth());
        
        String prefix = "DD" + year + month + day;
        
        String maDonDatHangCuoi = DAO_DonDatHang.getMaDonDatHangCuoi(prefix);
        if(maDonDatHangCuoi == null){
            soDonDatHang = 1;
            maDonDatHang = prefix + String.format("%04d", soDonDatHang);
        }
        else{
            soDonDatHang = Integer.parseInt(maDonDatHangCuoi.substring(8)) + 1;
            maDonDatHang = prefix + String.format("%04d", soDonDatHang);
        }
        return maDonDatHang;
    }
    
    public static String generateMaLichLamViec(LocalDate localDate, String caLamViec){
        String maLichLamViec;
        
        String year = Integer.toString(localDate.getYear()).substring(2);
        String month = String.format("%02d", localDate.getMonth().getValue());
        String day = String.format("%02d", localDate.getDayOfMonth());
        
        maLichLamViec = "LH" + year + month + day + caLamViec;
        
        return maLichLamViec;
    }
}
