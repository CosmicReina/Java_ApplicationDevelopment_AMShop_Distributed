package dao;

import static dao.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_DanhMuc {
    public static boolean createDanhMuc(String danhMuc){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO DanhMuc "
                    + "VALUES (?)";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, danhMuc);
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ArrayList<String> getAllDanhMuc(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DanhMuc";
            ResultSet rs = DAO.getResultSetFromStatement(sql);
            while(rs.next()){
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static boolean kiemTraTonTai(String danhMuc){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM DanhMuc "
                    + "WHERE DanhMuc = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, danhMuc);
            
            ResultSet rs = prs.executeQuery();
            if(rs.next())
                return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return false;
    }
}
