package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_MauSac {
    public static ArrayList<String> getAllMauSac(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MauSac";
            ResultSet rs = DAO.getResultSetFromStatement(sql);
            while(rs.next()){
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }
}
