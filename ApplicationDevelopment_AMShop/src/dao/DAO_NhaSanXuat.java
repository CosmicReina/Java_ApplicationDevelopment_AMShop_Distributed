package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class DAO_NhaSanXuat extends DAO {
    public static boolean createNhaSanXuat(String nhaSanXuat){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO NhaSanXuat "
                    + "VALUES (?)";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, nhaSanXuat);
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ArrayList<String> getAllNhaSanXuat(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NhaSanXuat";
            ResultSet rs = DAO.getResultSetFromStatement(sql);
            while(rs.next()){
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static boolean kiemTraTonTai(String nhaSanXuat){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM NhaSanXuat "
                    + "WHERE NhaSanXuat = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, nhaSanXuat);
            
            ResultSet rs = prs.executeQuery();
            if(rs.next())
                return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return false;
    }
}
