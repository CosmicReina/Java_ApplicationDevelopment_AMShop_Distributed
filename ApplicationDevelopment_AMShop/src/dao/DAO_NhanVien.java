package dao;

import data.UtilityLocalDate;
import entity.NhanVien;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;

public class DAO_NhanVien extends DAO {
    
    public static NhanVien nhanVienHienTai = null;


    
    public static boolean createNhanVien(NhanVien nhanVien){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO NhanVien "
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
                    + "?"
                    + ")";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, nhanVien.getMaNhanVien());
            prs.setString(2, nhanVien.getHoTen());
            prs.setString(3, nhanVien.getSoDienThoai());
            prs.setString(4, nhanVien.getDiaChi());
            prs.setString(5, nhanVien.getChucVu());
            prs.setDate(6, UtilityLocalDate.fromLocalDate(nhanVien.getNgaySinh()));
            prs.setString(7, nhanVien.getCanCuocCongDan());
            prs.setString(8, nhanVien.getGioiTinh());
            prs.setDate(9, UtilityLocalDate.fromLocalDate(nhanVien.getNgayBatDauLam()));
            prs.setDate(10, UtilityLocalDate.fromLocalDate(nhanVien.getNgayKetThucLam()));
            prs.setDouble(11, nhanVien.getLuong());
            
            n = prs.executeUpdate();
            DAO_TaiKhoan.createTaiKhoan(nhanVien.getTenDangNhap(), nhanVien.getMatKhau());
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static boolean updateNhanVien(NhanVien nhanVien){
        int n = 0;
        try {
            String sql = ""
                    + "UPDATE NhanVien "
                    + "SET "
                    + "HoTen = ?, "
                    + "SoDienThoai = ?, "
                    + "DiaChi = ?, "
                    + "ChucVu = ?, "
                    + "NgaySinh = ?, "
                    + "CanCuocCongDan = ?, "
                    + "GioiTinh = ?, "
                    + "NgayBatDauLam = ?, "
                    + "NgayKetThucLam = ?, "
                    + "Luong = ? "
                    + "WHERE MaNhanVien = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(11, nhanVien.getMaNhanVien());
            prs.setString(1, nhanVien.getHoTen());
            prs.setString(2, nhanVien.getSoDienThoai());
            prs.setString(3, nhanVien.getDiaChi());
            prs.setString(4, nhanVien.getChucVu());
            prs.setDate(5, UtilityLocalDate.fromLocalDate(nhanVien.getNgaySinh()));
            prs.setString(6, nhanVien.getCanCuocCongDan());
            prs.setString(7, nhanVien.getGioiTinh());
            prs.setDate(8, UtilityLocalDate.fromLocalDate(nhanVien.getNgayBatDauLam()));
            prs.setDate(9, UtilityLocalDate.fromLocalDate(nhanVien.getNgayKetThucLam()));
            prs.setDouble(10, nhanVien.getLuong());
            
            DAO_TaiKhoan.updateTaiKhoan(nhanVien.getTenDangNhap(), nhanVien.getMatKhau());
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ArrayList<NhanVien> getAllNhanVien(){
        ArrayList<NhanVien> list = new ArrayList();
        try {
            String sql = "SELECT * FROM NhanVien";
            ResultSet rs_NhanVien = getResultSetFromStatement(sql);
            while(rs_NhanVien.next()){
                String maNhanVien = rs_NhanVien.getString(1);
                String hoTen = rs_NhanVien.getString(2);
                String soDienThoai = rs_NhanVien.getString(3);
                String diaChi = rs_NhanVien.getString(4);
                String chucVu = rs_NhanVien.getString(5);
                LocalDate ngaySinh = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(6));
                String canCuocCongDan = rs_NhanVien.getString(7);
                String gioiTinh = rs_NhanVien.getString(8);
                LocalDate ngayBatDauLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(9));
                LocalDate ngayKetThucLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(10));
                double luong = rs_NhanVien.getDouble(11);
                String tenDangNhap = null;
                String matKhau = null;
                
                ResultSet rs_TaiKhoan = DAO_TaiKhoan.getTaiKhoanTheoTenDangNhap(maNhanVien);
                if(rs_TaiKhoan != null && rs_TaiKhoan.next()){
                    tenDangNhap = rs_TaiKhoan.getString(1);
                    matKhau = rs_TaiKhoan.getString(2);
                }
                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, soDienThoai, diaChi, chucVu, ngaySinh, canCuocCongDan, gioiTinh, ngayBatDauLam, ngayKetThucLam, luong, tenDangNhap, matKhau);
                
                list.add(nhanVien);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static NhanVien getNhanVienTheoMaNhanVien(String maNhanVien){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM NhanVien "
                    + "WHERE MaNhanVien = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, maNhanVien);
            ResultSet rs_NhanVien = prs.executeQuery();
            while(rs_NhanVien.next()){
                String hoTen = rs_NhanVien.getString(2);
                String soDienThoai = rs_NhanVien.getString(3);
                String diaChi = rs_NhanVien.getString(4);
                String chucVu = rs_NhanVien.getString(5);
                LocalDate ngaySinh = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(6));
                String canCuocCongDan = rs_NhanVien.getString(7);
                String gioiTinh = rs_NhanVien.getString(8);
                LocalDate ngayBatDauLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(9));
                LocalDate ngayKetThucLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(10));
                double luong = rs_NhanVien.getDouble(11);
                String tenDangNhap = null;
                String matKhau = null;
                
                ResultSet rs_TaiKhoan = DAO_TaiKhoan.getTaiKhoanTheoTenDangNhap(maNhanVien);
                if(rs_TaiKhoan != null && rs_TaiKhoan.next()){
                    tenDangNhap = rs_TaiKhoan.getString(1);
                    matKhau = rs_TaiKhoan.getString(2);
                }
                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, soDienThoai, diaChi, chucVu, ngaySinh, canCuocCongDan, gioiTinh, ngayBatDauLam, ngayKetThucLam, luong, tenDangNhap, matKhau);
                
                return nhanVien;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public static NhanVien getNhanVienTheoSoDienThoai(String soDienThoai){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM NhanVien "
                    + "WHERE SoDienThoai = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, soDienThoai);
            ResultSet rs_NhanVien = prs.executeQuery();
            while(rs_NhanVien.next()){
                String maNhanVien = rs_NhanVien.getString(1);
                String hoTen = rs_NhanVien.getString(2);
                String diaChi = rs_NhanVien.getString(4);
                String chucVu = rs_NhanVien.getString(5);
                LocalDate ngaySinh = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(6));
                String canCuocCongDan = rs_NhanVien.getString(7);
                String gioiTinh = rs_NhanVien.getString(8);
                LocalDate ngayBatDauLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(9));
                LocalDate ngayKetThucLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(10));
                double luong = rs_NhanVien.getDouble(11);
                String tenDangNhap = null;
                String matKhau = null;
                
                ResultSet rs_TaiKhoan = DAO_TaiKhoan.getTaiKhoanTheoTenDangNhap(maNhanVien);
                if(rs_TaiKhoan != null && rs_TaiKhoan.next()){
                    tenDangNhap = rs_TaiKhoan.getString(1);
                    matKhau = rs_TaiKhoan.getString(2);
                }
                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, soDienThoai, diaChi, chucVu, ngaySinh, canCuocCongDan, gioiTinh, ngayBatDauLam, ngayKetThucLam, luong, tenDangNhap, matKhau);
                
                return nhanVien;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public static NhanVien getNhanVienTheoCanCuocCongDan(String canCuocCongDan){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM NhanVien "
                    + "WHERE CanCuocCongDan = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, canCuocCongDan);
            ResultSet rs_NhanVien = prs.executeQuery();
            while(rs_NhanVien.next()){
                String maNhanVien = rs_NhanVien.getString(1);
                String hoTen = rs_NhanVien.getString(2);
                String soDienThoai = rs_NhanVien.getString(3);
                String diaChi = rs_NhanVien.getString(4);
                String chucVu = rs_NhanVien.getString(5);
                LocalDate ngaySinh = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(6));
                String gioiTinh = rs_NhanVien.getString(8);
                LocalDate ngayBatDauLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(9));
                LocalDate ngayKetThucLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(10));
                double luong = rs_NhanVien.getDouble(11);
                String tenDangNhap = null;
                String matKhau = null;
                
                ResultSet rs_TaiKhoan = DAO_TaiKhoan.getTaiKhoanTheoTenDangNhap(maNhanVien);
                if(rs_TaiKhoan != null && rs_TaiKhoan.next()){
                    tenDangNhap = rs_TaiKhoan.getString(1);
                    matKhau = rs_TaiKhoan.getString(2);
                }
                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, soDienThoai, diaChi, chucVu, ngaySinh, canCuocCongDan, gioiTinh, ngayBatDauLam, ngayKetThucLam, luong, tenDangNhap, matKhau);
                
                return nhanVien;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public static ArrayList<NhanVien> getDanhSachNhanVienChuaCoTrongNgayLamViec(LocalDate ngayLamViec){
        ArrayList<NhanVien> list = new ArrayList();
        try {
            String sql = ""
                    + "SELECT * FROM NhanVien "
                    + "WHERE MaNhanVien NOT IN "
                    + "("
                    + "SELECT MaNhanVien "
                    + "FROM ChiTietPhanCong CT JOIN LichLamViec L ON CT.MaLichLamViec = L.MaLichLamViec "
                    + "WHERE NgayLamViec = ?) AND NgayKetThucLam IS NULL";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setDate(1, UtilityLocalDate.fromLocalDate(ngayLamViec));
            
            ResultSet rs_NhanVien = prs.executeQuery();
            while(rs_NhanVien.next()){
                String maNhanVien = rs_NhanVien.getString(1);
                String hoTen = rs_NhanVien.getString(2);
                String soDienThoai = rs_NhanVien.getString(3);
                String diaChi = rs_NhanVien.getString(4);
                String chucVu = rs_NhanVien.getString(5);
                LocalDate ngaySinh = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(6));
                String canCuocCongDan = rs_NhanVien.getString(7);
                String gioiTinh = rs_NhanVien.getString(8);
                LocalDate ngayBatDauLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(9));
                LocalDate ngayKetThucLam = UtilityLocalDate.toLocalDate(rs_NhanVien.getDate(10));
                double luong = rs_NhanVien.getDouble(11);
                String tenDangNhap = null;
                String matKhau = null;
                
                ResultSet rs_TaiKhoan = DAO_TaiKhoan.getTaiKhoanTheoTenDangNhap(maNhanVien);
                if(rs_TaiKhoan != null && rs_TaiKhoan.next()){
                    tenDangNhap = rs_TaiKhoan.getString(1);
                    matKhau = rs_TaiKhoan.getString(2);
                }
                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, soDienThoai, diaChi, chucVu, ngaySinh, canCuocCongDan, gioiTinh, ngayBatDauLam, ngayKetThucLam, luong, tenDangNhap, matKhau);
                
                list.add(nhanVien);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static ResultSet tinhLuongNhanVien(int nam, int thang){
        try {
            String sql = "SELECT MaNhanVien, SUM(DATEDIFF(SECOND, '00:00:00', CONVERT(DATETIME, ThoiGianRaCa - ThoiGianVaoCa))) AS TotalSeconds "
                    + "FROM LichLamViec L JOIN ChiTietPhanCong CT ON L.MaLichLamViec = CT.MaLichLamViec "
                    + "WHERE YEAR(NgayLamViec) = ? AND MONTH(NgayLamViec) = ? "
                    + "GROUP BY MaNhanVien";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setInt(1, nam);
            prs.setInt(2, thang);
            
            ResultSet rs = prs.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public static String getMaNhanVienCuoi(String prefix){
        String searchPrefix = prefix + "%";
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM NhanVien "
                    + "WHERE MaNhanVien LIKE ? "
                    + "ORDER BY MaNhanVien DESC";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, searchPrefix);
            ResultSet rs = prs.executeQuery();
            if(rs.next()){
                String maNhanVienCuoi = rs.getString(1);
                return maNhanVienCuoi;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
