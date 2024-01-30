package Database;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ConnectionWithDatabase {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cafe_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "000000000";

    public static int signingUp(String studentInfo[]) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Your code to work with the database goes here
            System.out.println("Connected to the database.");
            String student_ID = studentInfo[0];
            String student_name = studentInfo[1];
            String password = studentInfo[2];
            String department = studentInfo[3];
            String year = studentInfo[4];

            String sqlQuery = "INSERT into students values(?,?,?,?,?)";// this is a query that will insert one row in to the database.
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1,student_ID);
            creatingStat.setString(2,student_name);
            creatingStat.setString(3,password);
            creatingStat.setString(4,department);
            creatingStat.setString(5,year);
            int resultSet = creatingStat.executeUpdate();
            connection.close();
            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 3;
    }
    // THis will give you all the student IDs in Student Table
    public static ArrayList<String> idsForSignUp() throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Your code to work with the database goes here
            System.out.println("Connected to the database.");
            String sqlQuery = "SELECT student_ID FROM Students";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = creatingStat.executeQuery();
            ArrayList<String> studentIDs = new ArrayList<String>();
            while(resultSet.next()) {
                studentIDs.add(resultSet.getString("student_ID"));
            }
            connection.close();
            System.out.println("I am return arrays of ID");
            return studentIDs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // This will give you student IDs in one of the meal corresponding date
    public static ArrayList<String> idsForAttendance(String sqlQuery) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Your code to work with the database goes here
            System.out.println("Connected to the database.");
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = creatingStat.executeQuery();
            ArrayList<String> studentIDs = new ArrayList<String>();
            while(resultSet.next()) {
                studentIDs.add(resultSet.getString("student_ID"));
            }
            connection.close();
            return studentIDs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int addAttendance(String sqlQuery, List<Object> attendance) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Your code to work with the database goes here
            System.out.println("Connected to the database.");
            String student_ID = (String)attendance.get(1);
            Timestamp timestamp = (Timestamp)attendance.get(0);
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setInt(1,0);
            creatingStat.setString(2,student_ID);
            creatingStat.setTimestamp(3,timestamp);
            int resultSet = creatingStat.executeUpdate();
            connection.close();
            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 3;
    }
    public static HashMap<String, String> idsForLogIn() throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            System.out.println("Connected to the database.");
            HashMap<String, String> dictionary = new HashMap<>();
            String sqlQuery = "SELECT student_full_name, password FROM Students";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            ResultSet result = creatingStat.executeQuery();
            while(result.next()){
                dictionary.put(result.getString("student_full_name"),result.getString("password"));
            }
            return dictionary;
        }
    }
    public static ArrayList<Integer> numOfStudent() {
        ArrayList<Integer> numOfStudent = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            int count = 0;
            int anothercount = 0;
            String sqlQueryB = "SELECT * FROM breakfast WHERE DATE(entrytime) = '2033-02-11'";
            String sqlQueryL = "SELECT * FROM lunch WHERE DATE(entrytime) = '2033-02-11'";
            String sqlQueryD = "SELECT * FROM dinner WHERE DATE(entrytime) = '2033-02-11'";
            ResultSet result;
            numOfStudent = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if (count == 0) {
                    PreparedStatement creatingStat = connection.prepareStatement(sqlQueryB);
                    result = creatingStat.executeQuery();
                } else if (count == 1) {
                    PreparedStatement creatingStat = connection.prepareStatement(sqlQueryL);
                    result = creatingStat.executeQuery();
                } else {
                    PreparedStatement creatingStat = connection.prepareStatement(sqlQueryD);
                    result = creatingStat.executeQuery();
                }
                count++;
                while (result.next()) {
                    anothercount++;
                }
                numOfStudent.add(anothercount);
                anothercount = 0;
            }
        } catch (SQLException e) {
            System.out.println("Put here what you want the exception to say");
        }
        return numOfStudent;
    }
    public static ArrayList<LocalTime> timeForPeakAnalysis() {
        ArrayList timeForPeak = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            timeForPeak = new ArrayList();
            int flag = GUI.Admin.peakTimeAnalysisPage.getFlag();
            String sqlQueryB = null;
            if (flag ==0){
                sqlQueryB = "SELECT * FROM breakfast WHERE DATE(entrytime) = '2033-02-11'"; // The date should be the current date
            }
            else if (flag ==1 ){
                sqlQueryB = "SELECT * FROM lunch WHERE DATE(entrytime) = '2033-02-11'";
            }
            else if (flag == 2){
                sqlQueryB = "SELECT * FROM dinner WHERE DATE(entrytime) = '2033-02-11'";
            }
            PreparedStatement creatingStat = connection.prepareStatement(sqlQueryB);
            ResultSet result = creatingStat.executeQuery();
            while (result.next()) {
                timeForPeak.add(result.getTime("entrytime"));
            }
        } catch (SQLException e) {
            System.out.println("Same here");
        }
        return timeForPeak;
    }
    public static HashMap<String, Integer> numofStudentInDepartment(){
        HashMap<String, Integer> studentInDepartment = null;
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sqlQuery = "SELECT Department FROM students ";
            PreparedStatement crestingStat = connection.prepareStatement(sqlQuery);
            String key;
            ResultSet result = crestingStat.executeQuery();
            result.next();
            studentInDepartment.put(result.getString("Department"), 0);
            while (result.next()){
                if (studentInDepartment.containsKey(result.getString("Department"))){
                    key = result.getString("Department");
                    studentInDepartment.put(key,studentInDepartment.get(key)+1);
                }
                else{
                    studentInDepartment.put(result.getString("Department"),0);
                }
            }
        }
        catch(SQLException e){
            System.out.println("Same here");
        }
        return studentInDepartment;
    }
    /*public static boolean pollTableCreator(List<String> foods,String tableName){
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQueryF = "CREATE TABLE " + tableName + " (" +
                    "Row Number INT AUTO_INCREMENT PRIMARY KEY, " +
                    "student_ID VARCHAR(15) " +
                    "FOREIGN KEY(student_ID) REFERENCES students (student_ID) ";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQueryF);
            int resultF = creatingStat.executeUpdate();
            

        }
        catch (SQLException e){

        }

    }
<<<<<<< HEAD

=======
>>>>>>> 90300935aed25c27243aeff9f964403719ffc15e
     */
}







