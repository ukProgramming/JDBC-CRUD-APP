package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertApp {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;

        String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
        String user = "root";
        String pass = "12345";

        try {

            connection = DriverManager.getConnection(url, user, pass);

            if (connection != null) {
                statement = connection.createStatement();
                if (statement != null) {
                    String sql = "insert into emptab (`eid`,`ename`,`esal`) values (7,'Dhoni',672390.23) ";
                    int rowAffected = statement.executeUpdate(sql);
                    System.out.println("No of Rows affected:" + rowAffected);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }
}
