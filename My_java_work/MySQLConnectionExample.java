package My_java_work;
import java.sql.*;
public class MySQLConnectionExample {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Cafe_Database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "000000000";
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // this will execute everything in the static block which will register the driver

            // Establish a connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String student_ID = "456zty";
            String student_name = "Peniel";
            int password = 123456;
            String department = "Political Science";
            String year = "3";
            // Perform SQL queries
            //String sqlQuery = "SELECT * FROM students"; //This query will fetch all the data in your table.
            String sqlQuery = "insert into students values(?,?,?,?,?)";// this is a query that will insert one row in to the database.
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1,student_ID);
            creatingStat.setString(2,student_name);
            creatingStat.setInt(3,password);
            creatingStat.setString(4,department);
            creatingStat.setString(5,year);

            int resultSet = creatingStat.executeUpdate();

            //resultSet.next();//this is a collection.

            System.out.println("row"+resultSet+"was affected");

            // Close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}