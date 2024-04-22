package dao;

import java.sql.*;

public class DAO_TaiKhoan extends DAO {
    public static boolean createTaiKhoan(String tenDangNhap, String matKhau){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO TaiKhoan "
                    + "VALUES ("
                    + "?, "
                    + "?"
                    + ")";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, tenDangNhap);
            prs.setString(2, matKhau);
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static boolean updateTaiKhoan(String tenDangNhap, String matKhau){
        int n = 0;
        try {
            String sql = ""
                    + "UPDATE TaiKhoan "
                    + "SET MatKhau = ? "
                    + "WHERE TenDangNhap = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, matKhau);
            prs.setString(2, tenDangNhap);
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ResultSet getTaiKhoanTheoTenDangNhap(String tenDangNhap){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM TaiKhoan "
                    + "WHERE TenDangNhap = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, tenDangNhap);
            ResultSet rs = prs.executeQuery();
            
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public static boolean kiemTraDangNhap(String tenDangNhap, String matKhau){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM TaiKhoan "
                    + "WHERE TenDangNhap = ? AND MatKhau = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, tenDangNhap);
            prs.setString(2, matKhau);
            ResultSet rs = prs.executeQuery();
            
            if(rs.next())
                return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
        return false;
    }
}
