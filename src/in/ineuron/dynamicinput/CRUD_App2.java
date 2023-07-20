package in.ineuron.dynamicinput;

import java.sql.*;
import java.util.Scanner;


public class CRUD_App2 {
    private static final String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
    private static final String user = "root";
    private static final String pass = "12345";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        try {
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();

            createTableIfNotExits(statement);
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("----CRUD OPERATION----");
                System.out.println("1. Create");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit.");
                System.out.println("Enter the Choice.");
                choice = scanner.nextInt();
                scanner.nextLine();// Consume new Line Character.
                scanner.nextLine();
                switch (choice) {
                    case 1 -> createEmployee(connection, scanner, statement);
                    case 2 -> readEmployee(connection, statement, resultSet);
                    case 3 -> updateEmployee(connection, statement, scanner);
                    case 4 -> deleteEmployee(connection, statement, scanner);
                    default -> System.out.println("Invalid Choice....");
                }
            } while (choice != 5);

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void createTableIfNotExits(Statement statement) throws SQLException {
        String query = "Create table IF NOT EXISTS employee (EMP_ID int PRIMARY KEY AUTO_INCREMENT,First_Name varchar(100),Last_Name varchar(100),Department varchar(100), Location varchar(100),Salary varchar(20))";
        statement.executeUpdate(query);
        System.out.println("Table Created Successfully...");
    }

    private static void createEmployee(Connection connection, Scanner scanner, Statement statement) throws SQLException {
        System.out.println("Enter the Employee First Name:");
        String fname = scanner.nextLine();
        System.out.println("Enter the Employee Last Name:");
        String lname = scanner.nextLine();
        System.out.println("Enter the Employee Department Name:");
        String department = scanner.nextLine();
        System.out.println("Enter the Employee Location:");
        String elocation = scanner.nextLine();
        System.out.println("Enter the Employee Salary:");
        String esal = scanner.nextLine();

        try {
            connection = DriverManager.getConnection(url, user, pass);

            if (connection != null) {
                statement = connection.createStatement();
                if (statement != null) {
                    String sql = String.format("insert into employee (`First_Name`,`Last_Name`,`Department`,`Location`,`Salary`) values('%s','%s','%s','%s','%s')", fname, lname, department, elocation, esal);
                    System.out.println(sql);
                    int rowaffected = statement.executeUpdate(sql);

                    if (rowaffected > 0) {
                        System.out.println("Data Inserted Successfully.....");
                    } else {
                        System.out.println("Data is Not Inserted....");
                    }
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

    private static void readEmployee(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {

        try {
            connection = CRUD_App2.getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                if (statement != null) {
                    String sql = "select * from employee";

                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        System.out.println(resultSet.getInt("emp_id") + " " + resultSet.getString("First_Name") + "  " + resultSet.getString("Last_Name") + "  " + resultSet.getString("Department") + "  " + resultSet.getString("Location") + "  " + resultSet.getString("Salary"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
    }

    private static void updateEmployee(Connection connection, Statement statement, Scanner scanner) throws SQLException {
        System.out.println("Enter the Employee ID that you Want to Update.");
        int eid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Employee First Name:");
        String fname = scanner.nextLine();
        System.out.println("Enter the Employee Last Name:");
        String lname = scanner.nextLine();
        System.out.println("Enter the Employee Department Name:");
        String department = scanner.nextLine();
        System.out.println("Enter the Employee Location:");
        String elocation = scanner.nextLine();
        System.out.println("Enter the Employee Salary:");
        String esal = scanner.nextLine();

        try {
            connection = CRUD_App2.getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                if (statement != null) {
                    // String sql="update employee set First_Name="+fname+",Last_Name="+lname+",Department="+department+",Location="+elocation+",Salary="+esal+" where emp_id="+eid+"";
                    String updateQuery = "UPDATE employee " +
                            "SET First_Name='" + fname + "', " +
                            "Last_Name='" + lname + "', " +
                            "Department='" + department + "', " +
                            "Location='" + elocation + "', " +
                            "Salary=" + esal + " " +
                            "WHERE emp_id=" + eid;
                    int noRowAffected = statement.executeUpdate(updateQuery);
                    if (noRowAffected > 0) {
                        System.out.println("Employee Updated Successfully..");
                    } else {
                        System.out.println("Employee Not Updated.. Try Again!!!");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();

            }
            if (connection != null)
                connection.close();
        }
    }

    private static void deleteEmployee(Connection connection, Statement statement, Scanner scanner) throws SQLException {
        System.out.println("Enter the Employee Id that You Want to Delete.");
        int eid = scanner.nextInt();
        try {
            connection = CRUD_App2.getConnection();

            if (connection != null) {
                statement = connection.createStatement();

                if (statement != null) {
                    String sql = "delete from employee" + " where emp_id=" + eid;
                    int rowDeleted = statement.executeUpdate(sql);
                    if (rowDeleted > 0) {
                        System.out.println("1 Row Deleted Successfully!!!!!!!!");
                    } else {
                        System.out.println("Ooops  Row Not Deleted Try again!!! ");
                    }
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

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
