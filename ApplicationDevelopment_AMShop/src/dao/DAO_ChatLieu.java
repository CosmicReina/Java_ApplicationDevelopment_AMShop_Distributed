package dao;

import static dao.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_ChatLieu {
    public static boolean createChatLieu(String chatLieu){
        int n = 0;
        try {
            String sql = ""
                    + "INSERT INTO ChatLieu "
                    + "VALUES (?)";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, chatLieu);
            
            n = prs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return n > 0;
    }
    
    public static ArrayList<String> getAllChatLieu(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ChatLieu";
            ResultSet rs = DAO.getResultSetFromStatement(sql);
            while(rs.next()){
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
    
    public static boolean kiemTraTonTai(String chatLieu){
        try {
            String sql = ""
                    + "SELECT * "
                    + "FROM ChatLieu "
                    + "WHERE ChatLieu = ?";
            PreparedStatement prs = connection.prepareStatement(sql);
            prs.setString(1, chatLieu);
            
            ResultSet rs = prs.executeQuery();
            if(rs.next())
                return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return false;
    }
}
