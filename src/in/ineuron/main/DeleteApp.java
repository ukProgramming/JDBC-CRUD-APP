package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteApp {
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
                    String sql = "delete from  emptab where eid=45";

                    int noOfRowDeleted = statement.executeUpdate(sql);
                    System.out.println("No of Row Deleted from the Table are:" + noOfRowDeleted);
                }
            }

        } catch (Exception s) {
            s.printStackTrace();
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
