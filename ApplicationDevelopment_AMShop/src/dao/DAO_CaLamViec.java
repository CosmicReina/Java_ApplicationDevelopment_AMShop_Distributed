package dao;

import data.UtilityLocalTime;
import entity.CaLamViec;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalTime;

public class DAO_CaLamViec extends DAO {
    public static ArrayList<CaLamViec> getAllCaLamViec(){
        ArrayList<CaLamViec> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CaLamViec";
            ResultSet rs = getResultSetFromStatement(sql);
            while(rs.next()){
                int maCaLamViec = rs.getInt(1);
                String tenCaLamViec = rs.getString(2);
                LocalTime thoiGianBatDau = UtilityLocalTime.toLocalTime(rs.getTime(3));
                LocalTime thoiGianKetThuc = UtilityLocalTime.toLocalTime(rs.getTime(4));
                
                CaLamViec caLamViec = new CaLamViec(maCaLamViec, tenCaLamViec, thoiGianBatDau, thoiGianKetThuc);
                list.add(caLamViec);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static CaLamViec getCaLamViecTheoMaCaLamViec(int maCaLamViec){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM CaLamViec "
                    + "WHERE MaCaLamViec = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setInt(1, maCaLamViec);
            
            ResultSet rs = prs.executeQuery();
            if(rs.next()){
                String tenCaLamViec = rs.getString(2);
                LocalTime thoiGianBatDau = UtilityLocalTime.toLocalTime(rs.getTime(3));
                LocalTime thoiGianKetThuc = UtilityLocalTime.toLocalTime(rs.getTime(4));
                
                CaLamViec caLamViec = new CaLamViec(maCaLamViec, tenCaLamViec, thoiGianBatDau, thoiGianKetThuc);
                return caLamViec;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
