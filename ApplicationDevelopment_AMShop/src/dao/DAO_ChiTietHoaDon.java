package dao;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.QuanAo;
import java.util.ArrayList;
import java.sql.*;

public class DAO_ChiTietHoaDon extends DAO {
    public static boolean createChiTietHoaDon(ChiTietHoaDon chiTietHoaDon){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO ChiTietHoaDon "
                    + "VALUES ("
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?"
                    + ")";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, chiTietHoaDon.getHoaDon().getMaHoaDon());
            prs.setString(2, chiTietHoaDon.getQuanAo().getMaQuanAo());
            prs.setInt(3, chiTietHoaDon.getSoLuong());
            prs.setDouble(4, chiTietHoaDon.getDonGia());
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ArrayList<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon){
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM ChiTietHoaDon "
                    + "WHERE MaHoaDon = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, maHoaDon);
            
            ResultSet rs = prs.executeQuery();
            while(rs.next()){
                String maQuanAo = rs.getString(2);
                int soLuong = rs.getInt(3);
                double donGia = rs.getDouble(4);
                
                HoaDon hoaDon = DAO_HoaDon.getHoaDonTheoMaHoaDon(maHoaDon);
                QuanAo quanAo = DAO_QuanAo.getQuanAoTheoMaQuanAo(maQuanAo);
                
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(hoaDon, quanAo, soLuong, donGia);
                list.add(chiTietHoaDon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
}
