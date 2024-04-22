package dao;

import entity.ChiTietDonDatHang;
import entity.DonDatHang;
import entity.QuanAo;
import java.util.ArrayList;
import java.sql.*;

public class DAO_ChiTietDonDatHang extends DAO {
    public static boolean createChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO ChiTietDonDatHang "
                    + "VALUES ("
                    + "?, "
                    + "?, "
                    + "?"
                    + ")";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, chiTietDonDatHang.getDonDatHang().getMaDonDatHang());
            prs.setString(2, chiTietDonDatHang.getQuanAo().getMaQuanAo());
            prs.setInt(3, chiTietDonDatHang.getSoLuong());
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ArrayList<ChiTietDonDatHang> getAllChiTietDonDatHangTheoMaDonDatHang(String maDonDatHang){
        ArrayList<ChiTietDonDatHang> list = new ArrayList<>();
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM ChiTietDonDatHang "
                    + "WHERE MaDonDatHang = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, maDonDatHang);
            
            ResultSet rs = prs.executeQuery();
            while(rs.next()){
                String maQuanAo = rs.getString(2);
                int soLuong = rs.getInt(3);
                
                DonDatHang donDatHang = DAO_DonDatHang.getDonDatHangTheoMaDonDatHang(maDonDatHang);
                QuanAo quanAo = DAO_QuanAo.getQuanAoTheoMaQuanAo(maQuanAo);
                
                ChiTietDonDatHang chiTietDonDatHang = new ChiTietDonDatHang(donDatHang, quanAo, soLuong);
                list.add(chiTietDonDatHang);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static boolean deleteChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang){
        int n = 0;
        try {
            String sql = ""
                    + "DELETE FROM ChiTietDonDatHang "
                    + "WHERE MaDonDatHang = ? AND MaQuanAo = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, chiTietDonDatHang.getDonDatHang().getMaDonDatHang());
            prs.setString(2, chiTietDonDatHang.getQuanAo().getMaQuanAo());
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
}
