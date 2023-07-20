package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateApp {
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
                double sal = 500230;
                int id = 13;
                if (statement != null) {
                    String sql = "update  emptab set esal=" + sal + " where eid=" + id + "";

                    int noRowUpdated = statement.executeUpdate(sql);
                    System.out.println("No of Row Updated:" + noRowUpdated);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
