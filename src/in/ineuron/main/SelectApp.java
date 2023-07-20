package in.ineuron.main;

import java.sql.*;

public class SelectApp {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
        String user = "root";
        String pass = "12345";


        try {
            // Step 2: Create the Connection.
            connection = DriverManager.getConnection(url, user, pass);

            if (connection != null) {

                // Step 2: Create the Statement Object
                statement = connection.createStatement();

                if (statement != null) {

                    String sql = "select eid,ename,esal from emptab";

                    // Step 3: Execute the Result

                    resultset = statement.executeQuery(sql);
                    if (resultset != null) {
                        while (resultset.next()) {

                            System.out.println(resultset.getInt("eid") + "  " + resultset.getString("ename") + "  " + resultset.getDouble("esal"));
                        }
                    }
                }
            }

        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            resultset.close();
            statement.close();
            connection.close();
        }
    }
}
