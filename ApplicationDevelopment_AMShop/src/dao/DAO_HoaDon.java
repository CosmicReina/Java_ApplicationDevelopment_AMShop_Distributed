package dao;

import data.UtilityLocalDate;
import data.UtilityLocalDateTime;
import entity.CuaHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DAO_HoaDon extends DAO {
    public static boolean createHoaDon(HoaDon hoaDon){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO HoaDon "
                    + "VALUES ("
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?)";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, hoaDon.getMaHoaDon());
            prs.setString(2, hoaDon.getCuaHang().getMaCuaHang());
            prs.setString(3, hoaDon.getNhanVien().getMaNhanVien());
            prs.setString(4, hoaDon.getKhachHang().getMaKhachHang());
            prs.setTimestamp(5, UtilityLocalDateTime.fromLocalDateTime(hoaDon.getThoiGianTao()));
            prs.setDouble(6, hoaDon.getTienKhachDua());
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ArrayList<HoaDon> getAllHoaDon(){
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HoaDon";
            ResultSet rs = getResultSetFromStatement(sql);
            while(rs.next()) {
                String maHoaDon = rs.getString(1);
                String maNhanVien = rs.getString(3);
                String maKhachHang = rs.getString(4);
                LocalDateTime thoiGianTao = UtilityLocalDateTime.toLocalDateTime(rs.getTimestamp(5));
                double tienKhachDua = rs.getDouble(6);
                
                CuaHang cuaHang = DAO_CuaHang.getCuaHang();
                NhanVien nhanVien = DAO_NhanVien.getNhanVienTheoMaNhanVien(maNhanVien);
                KhachHang khachHang = DAO_KhachHang.getKhachHangTheoMaKhachHang(maKhachHang);
                
                HoaDon hoaDon = new HoaDon(maHoaDon, cuaHang, nhanVien, khachHang, thoiGianTao, tienKhachDua);
                list.add(hoaDon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static ArrayList<HoaDon> getAllHoaDonTrongKhoangNgay(LocalDate ngayBatDau, LocalDate ngayKetThuc){
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM HoaDon "
                    + "WHERE ThoiGianTao BETWEEN ? AND ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setDate(1, UtilityLocalDate.fromLocalDate(ngayBatDau));
            prs.setDate(2, UtilityLocalDate.fromLocalDate(ngayKetThuc));
            
            ResultSet rs = prs.executeQuery();
            while(rs.next()) {
                String maHoaDon = rs.getString(1);
                String maNhanVien = rs.getString(3);
                String maKhachHang = rs.getString(4);
                LocalDateTime thoiGianTao = UtilityLocalDateTime.toLocalDateTime(rs.getTimestamp(5));
                double tienKhachDua = rs.getDouble(6);
                
                CuaHang cuaHang = DAO_CuaHang.getCuaHang();
                NhanVien nhanVien = DAO_NhanVien.getNhanVienTheoMaNhanVien(maNhanVien);
                KhachHang khachHang = DAO_KhachHang.getKhachHangTheoMaKhachHang(maKhachHang);
                
                HoaDon hoaDon = new HoaDon(maHoaDon, cuaHang, nhanVien, khachHang, thoiGianTao, tienKhachDua);
                list.add(hoaDon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static HoaDon getHoaDonTheoMaHoaDon(String maHoaDon){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM HoaDon "
                    + "WHERE MaHoaDon = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, maHoaDon);
            
            ResultSet rs = prs.executeQuery();
            if(rs.next()) {
                String maNhanVien = rs.getString(3);
                String maKhachHang = rs.getString(4);
                LocalDateTime thoiGianTao = UtilityLocalDateTime.toLocalDateTime(rs.getTimestamp(5));
                double tienKhachDua = rs.getDouble(6);
                
                CuaHang cuaHang = DAO_CuaHang.getCuaHang();
                NhanVien nhanVien = DAO_NhanVien.getNhanVienTheoMaNhanVien(maNhanVien);
                KhachHang khachHang = DAO_KhachHang.getKhachHangTheoMaKhachHang(maKhachHang);
                
                HoaDon hoaDon = new HoaDon(maHoaDon, cuaHang, nhanVien, khachHang, thoiGianTao, tienKhachDua);
                return hoaDon;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public static String getMaHoaDonCuoi(String prefix){
        String searchPrefix = prefix + "%";
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM HoaDon "
                    + "WHERE MaHoaDon LIKE ? "
                    + "ORDER BY MaHoaDon DESC";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, searchPrefix);
            
            ResultSet rs = prs.executeQuery();
            if(rs.next()){
                String maHoaDonCuoi = rs.getString(1);
                return maHoaDonCuoi;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
