package dao;

import connect.ConnectDB;
import java.sql.*;

public class DAO {
    protected static Connection connection = ConnectDB.getConnection();
    
    public static ResultSet getResultSetFromStatement(String sql){
        ResultSet rs = null;
        try {
            Statement stm = connection.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rs;
    }
}
