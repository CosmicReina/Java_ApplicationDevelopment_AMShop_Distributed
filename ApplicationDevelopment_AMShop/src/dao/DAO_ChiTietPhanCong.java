package dao;

import data.UtilityLocalDateTime;
import entity.ChiTietPhanCong;
import entity.LichLamViec;
import entity.NhanVien;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDateTime;

public class DAO_ChiTietPhanCong extends DAO {
    public static boolean createChiTietPhanCong(ChiTietPhanCong chiTietPhanCong){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO ChiTietPhanCong "
                    + "VALUES ("
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?"
                    + ")";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, chiTietPhanCong.getLichLamViec().getMaLichLamViec());
            prs.setString(2, chiTietPhanCong.getNhanVien().getMaNhanVien());
            prs.setTimestamp(3, UtilityLocalDateTime.fromLocalDateTime(chiTietPhanCong.getThoiGianVaoCa()));
            prs.setTimestamp(4, UtilityLocalDateTime.fromLocalDateTime(chiTietPhanCong.getThoiGianRaCa()));
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static boolean updateChiTietPhanCong(ChiTietPhanCong chiTietPhanCong){
        int n = 0;
        try {
            String sql = ""
                    + "UPDATE ChiTietPhanCong "
                    + "SET "
                    + "ThoiGianVaoCa = ?, "
                    + "ThoiGianRaCa = ? "
                    + "WHERE MaLichLamViec = ? AND MaNhanVien = ?";
            
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(3, chiTietPhanCong.getLichLamViec().getMaLichLamViec());
            prs.setString(4, chiTietPhanCong.getNhanVien().getMaNhanVien());
            prs.setTimestamp(1, UtilityLocalDateTime.fromLocalDateTime(chiTietPhanCong.getThoiGianVaoCa()));
            prs.setTimestamp(2, UtilityLocalDateTime.fromLocalDateTime(chiTietPhanCong.getThoiGianRaCa()));
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static boolean deleteChiTietPhanCong(String maLichLamViec, String maNhanVien){
        int n = 0;
        try {
            String sql = ""
                    + "DELETE FROM ChiTietPhanCong "
                    + "WHERE MaLichLamViec = ? AND MaNhanVien = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, maLichLamViec);
            prs.setString(2, maNhanVien);
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ArrayList<ChiTietPhanCong> getAllChiTietPhanCongTheoMaLichLamViec(String maLichLamViec){
        ArrayList<ChiTietPhanCong> list = new ArrayList<>();
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM ChiTietPhanCong "
                    + "WHERE MaLichLamViec = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, maLichLamViec);
            
            ResultSet rs = prs.executeQuery();
            while(rs.next()){
                String maNhanVien = rs.getString(2);
                LocalDateTime thoiGianVaoCa = UtilityLocalDateTime.toLocalDateTime(rs.getTimestamp(3));
                LocalDateTime thoiGianRaCa = UtilityLocalDateTime.toLocalDateTime(rs.getTimestamp(4));
                
                LichLamViec lichLamViec = DAO_LichLamViec.getLichLamViecTheoMaLichLamViec(maLichLamViec);
                NhanVien nhanVien = DAO_NhanVien.getNhanVienTheoMaNhanVien(maNhanVien);
                
                ChiTietPhanCong chiTietPhanCong = new ChiTietPhanCong(lichLamViec, nhanVien, thoiGianVaoCa, thoiGianRaCa);
                list.add(chiTietPhanCong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
}
