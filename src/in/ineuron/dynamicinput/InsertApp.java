package in.ineuron.dynamicinput;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertApp {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        Scanner s1 = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
        String user = "root";
        String pass = "12345";

        System.out.println("Enter the Employee ID:");
        int eid = s1.nextInt();
        System.out.println("Enter the Employee Name:");
        String ename = s1.next();
        System.out.println("Enter the Employee Salary.");
        double esal = s1.nextDouble();

        //ename="'"+ename+"'";

        try {
            connection = DriverManager.getConnection(url, user, pass);

            if (connection != null) {
                statement = connection.createStatement();
                if (statement != null) {
                    // First Way to Insert the Data into the Table.
                    // String query="insert into emptab(`eid`,`ename`,`esal`) values("+eid+","+ename+","+esal+")";

                    // Second Way to Insert the Data into the Table.
                    String query = String.format("insert into emptab(`eid`,`ename`,`esal`) values('%d','%s','%f')", eid, ename, esal);

                    int rowAffected = statement.executeUpdate(query);
                    System.out.println(query);
                    System.out.println("No of Row Affected:" + rowAffected);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
