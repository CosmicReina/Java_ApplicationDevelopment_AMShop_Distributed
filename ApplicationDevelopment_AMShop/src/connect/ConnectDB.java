package connect;

import java.sql.*;

public class ConnectDB {
    private static final ConnectDB instance = new ConnectDB();
    private static Connection connection = null;

    public ConnectDB() {}
    
    public static ConnectDB getInstance() {
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }
    
    public void connectDatabase(){
        try {
            String url = ""
                    + "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=AMShop;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true";
            String username = "sa";
            String password = "123";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void disconnectDatabase(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
