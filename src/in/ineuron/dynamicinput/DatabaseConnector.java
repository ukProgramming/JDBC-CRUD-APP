package in.ineuron.dynamicinput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static final String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
    public static final String user = "root";
    public static final String pass = "12345";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
