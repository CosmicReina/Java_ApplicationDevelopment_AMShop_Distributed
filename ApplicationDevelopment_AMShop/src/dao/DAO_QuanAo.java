package dao;

import data.UtilityImageIcon;
import data.UtilityLocalDate;
import entity.QuanAo;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.ImageIcon;

public class DAO_QuanAo extends DAO {
    public static boolean createQuanAo(QuanAo quanAo){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO QuanAo "
                    + "VALUES ("
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?"
                    + ")";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, quanAo.getMaQuanAo());
            prs.setString(2, quanAo.getTenQuanAo());
            prs.setDouble(3, quanAo.getDonGiaNhap());
            prs.setDouble(4, quanAo.getDonGiaBan());
            prs.setInt(5, quanAo.getSoLuongTrongKho());
            prs.setString(6, quanAo.getNhaSanXuat());
            prs.setString(7, quanAo.getDanhMuc());
            prs.setString(8, quanAo.getGioiTinh());
            prs.setString(9, quanAo.getMauSac());
            prs.setString(10, quanAo.getKichThuoc());
            prs.setString(11, quanAo.getChatLieu());
            prs.setBytes(12, UtilityImageIcon.toBytes(quanAo.getHinhAnh()));
            prs.setBoolean(13, quanAo.isNgungNhap());
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static boolean updateQuanAo(QuanAo quanAo){
        int n = 0;
        try {
            String sql = ""
                    + "UPDATE QuanAO "
                    + "SET "
                    + "TenQuanAo = ?, "
                    + "DonGiaNhap = ?, "
                    + "DonGiaBan = ?, "
                    + "SoLuongTrongKho = ?, "
                    + "NhaSanXuat = ?, "
                    + "DanhMuc = ?, "
                    + "GioiTinh = ?, "
                    + "MauSac = ?, "
                    + "KichThuoc = ?, "
                    + "ChatLieu = ?, "
                    + "HinhAnh = ?, "
                    + "NgungNhap = ?"
                    + "WHERE MaQuanAo = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(13, quanAo.getMaQuanAo());
            prs.setString(1, quanAo.getTenQuanAo());
            prs.setDouble(2, quanAo.getDonGiaNhap());
            prs.setDouble(3, quanAo.getDonGiaBan());
            prs.setInt(4, quanAo.getSoLuongTrongKho());
            prs.setString(5, quanAo.getNhaSanXuat());
            prs.setString(6, quanAo.getDanhMuc());
            prs.setString(7, quanAo.getGioiTinh());
            prs.setString(8, quanAo.getMauSac());
            prs.setString(9, quanAo.getKichThuoc());
            prs.setString(10, quanAo.getChatLieu());
            prs.setBytes(11, UtilityImageIcon.toBytes(quanAo.getHinhAnh()));
            prs.setBoolean(12, quanAo.isNgungNhap());
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ArrayList<QuanAo> getAllQuanAo(){
        ArrayList<QuanAo> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM QuanAo";
            ResultSet rs = getResultSetFromStatement(sql);
            while(rs.next()){
                String maQuanAo = rs.getString(1);
                String tenQuanAo = rs.getString(2);
                double donGiaNhap = rs.getDouble(3);
                double donBan = rs.getDouble(4);
                int soLuongTrongKho = rs.getInt(5);
                String nhaSanXuat = rs.getString(6);
                String danhMuc = rs.getString(7);
                String gioiTinh = rs.getString(8);
                String mauSac = rs.getString(9);
                String kichThuoc = rs.getString(10);
                String chatLieu = rs.getString(11);
                ImageIcon hinhAnh  = UtilityImageIcon.fromBytes(rs.getBytes(12));
                boolean ngungNhap = rs.getBoolean(13);
                
                QuanAo quanAo = new QuanAo(maQuanAo, tenQuanAo, donGiaNhap, donBan, soLuongTrongKho, nhaSanXuat, danhMuc, gioiTinh, mauSac, kichThuoc, chatLieu, hinhAnh, ngungNhap);
                
                list.add(quanAo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static QuanAo getQuanAoTheoMaQuanAo(String maQuanAo){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM QuanAo "
                    + "WHERE MaQuanAo = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, maQuanAo);
            ResultSet rs = prs.executeQuery();
            while(rs.next()){
                String tenQuanAo = rs.getString(2);
                double donGiaNhap = rs.getDouble(3);
                double donBan = rs.getDouble(4);
                int soLuongTrongKho = rs.getInt(5);
                String nhaSanXuat = rs.getString(6);
                String danhMuc = rs.getString(7);
                String gioiTinh = rs.getString(8);
                String mauSac = rs.getString(9);
                String kichThuoc = rs.getString(10);
                String chatLieu = rs.getString(11);
                ImageIcon hinhAnh  = UtilityImageIcon.fromBytes(rs.getBytes(12));
                boolean ngungNhap = rs.getBoolean(13);
                
                QuanAo quanAo = new QuanAo(maQuanAo, tenQuanAo, donGiaNhap, donBan, soLuongTrongKho, nhaSanXuat, danhMuc, gioiTinh, mauSac, kichThuoc, chatLieu, hinhAnh, ngungNhap);
                
                return quanAo;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public static ResultSet thongKeQuanAoDaBanTrongKhoangNgay(LocalDate ngayBatDau, LocalDate ngayKetThuc){
        try {
            String sql = ""
                    + "SELECT QA.MaQuanAo, SUM(CTHD.SoLuong) AS TongSoLuongDaBan "
                    + "FROM (HoaDon HD JOIN ChiTietHoaDon CTHD ON HD.MaHoaDon = CTHD.MaHoaDon) JOIN QuanAo QA ON CTHD.MaQuanAo = QA.MaQuanAo "
                    + "WHERE HD.ThoiGianTao BETWEEN ? AND ? "
                    + "GROUP BY QA.MaQuanAo";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setDate(1, UtilityLocalDate.fromLocalDate(ngayBatDau));
            prs.setDate(2, UtilityLocalDate.fromLocalDate(ngayKetThuc));
            
            ResultSet rs = prs.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public static ResultSet thongKeQuanAoDaHetHang(){
        String sql = ""
                + "SELECT MaQuanAo, TenQuanAo "
                + "FROM QuanAo "
                + "WHERE SoLuongTrongKho = 0 AND NgungNhap = 0";
        ResultSet rs = DAO.getResultSetFromStatement(sql);
        return rs;
    }
    
    public static String getMaQuanAoCuoi(){
        String maQuanAoCuoi = null;
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM QuanAo "
                    + "ORDER BY MaQuanAO DESC";
            ResultSet rs = getResultSetFromStatement(sql);
            if(rs.next()){
                maQuanAoCuoi = rs.getString(1);
                return maQuanAoCuoi;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return maQuanAoCuoi;
    }
}
