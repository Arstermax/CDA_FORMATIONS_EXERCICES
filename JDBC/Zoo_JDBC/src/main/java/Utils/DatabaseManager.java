package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URI = "jdbc:mysql://localhost:3306/demo_jbdc", USER = "root", PASSWORD="";
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}
