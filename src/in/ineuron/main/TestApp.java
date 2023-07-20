package in.ineuron.main;

import java.sql.*;

public class TestApp {
    public static void main(String[] args) throws SQLException {

        // Step: 1 Load and Registered Driver.
//        Driver driver =new Driver();
//        DriverManager.registerDriver(driver);

        // Step: 2 Make the Connection

        String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
        String user = "root";
        String pass = "12345";
        Connection con = DriverManager.getConnection(url, user, pass);

        // Step: 3 Create the Statement Object

        Statement st = con.createStatement();

        // Step:4 Execute the Statement Object from the Statement Object.

        String sql = "select eid,ename,esal from emptab";
        ResultSet resultset = st.executeQuery(sql);

        // Step: 5 Process the Result

        while (resultset.next()) {
            System.out.println(resultset.getInt("eid") + "  " + resultset.getString("ename") + "  " + resultset.getDouble("esal"));
        }

        resultset.close();
        st.close();
        con.close();
    }
}
