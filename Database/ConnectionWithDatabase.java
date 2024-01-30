package Database;

import GUI.Admin.graphAndChartPage;
import GUI.Student.LoginPageForStudent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
            int flag = graphAndChartPage.getFlag();
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
    // This only creates a poll table write the code that add values to the table after Esube finished the GUI
    public static void  pollTableCreator(List<String> foods,String tableName){
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQueryF = "CREATE TABLE " + tableName + " (" +
                    "Number INT AUTO_INCREMENT PRIMARY KEY " +
                    "Question VARCHAR(200) );"; // CHECK THIS wHEN YOU FINISH
            PreparedStatement creatingStat = connection.prepareStatement(sqlQueryF);
            System.out.println("is it here");
            creatingStat.execute();
            System.out.println("What is wrong with excuteing the query");
        }
        catch (SQLException e){
            System.out.println("Just for the one");
        }
        try(Connection connectionNew = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);){
            Iterator<String> iterator = foods.iterator();
            System.out.println(foods);
            while(iterator.hasNext()){
                String sqlQueryNew = " ALTER TABLE " + tableName + " ADD COLUMN " + iterator.next() + " INT";
                System.out.println(sqlQueryNew);
                PreparedStatement creatingStatment = connectionNew.prepareStatement(sqlQueryNew);
                creatingStatment.execute();
                System.out.println("Tell me it works now");
            }
        }
        catch (SQLException e){
            System.out.println("Same here");
        }
    }
    // IN the meantime lets write the JDBC for Attendance
    public static void attendanceInfo(DefaultTableModel tableModel){
        List<List<Object>> attendanceInfo = new ArrayList<>();//I dont think this is necessary From leykun

        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            System.out.println("I am here");
            String sqlQuery = "SELECT breakfast.givenNumber, students.student_full_name, students.School_ID, students.Department, students.year," +
                    " breakfast.entrytime, lunch.entrytime, dinner.entrytime " +
                    " FROM breakfast " +
                    " JOIN students ON breakfast.student_ID = students.student_ID " +
                    " JOIN lunch ON breakfast.student_ID = lunch.student_ID " +
                    " JOIN dinner ON breakfast.student_ID = dinner.student_ID;";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            ResultSet result = creatingStat.executeQuery();
            System.out.println("I have executed the query, now I have the data ");
            result.next();
            System.out.println(result.getString(1));
            System.out.println(result.getString(2));
            System.out.println(result.getString(3));
            System.out.println(result.getString(4));
            System.out.println(result.getString(5));
            while(result.next()){
                // You have to add it each row at a time
                int studentID = result.getInt(1);
                String studentName = result.getString(2);
                String School_ID = result.getString(3);
                String department = result.getString(4);
                String year = result.getString(5);
                Timestamp breakfastTime = result.getTimestamp(6);
                Timestamp lunchTime = result.getTimestamp(7);
                Timestamp dinnerTime = result.getTimestamp(8);
                System.out.println("I am in the loop," + studentName +  studentID);
                // Add the data to the table model
                tableModel.addRow(new Object[]{studentName, School_ID, department, year, breakfastTime, lunchTime, dinnerTime});
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Same here");
        }
    }
    public static String getStudentID(String studentName){
        String logInStudentID = null;
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            System.out.println("I am before the query");
            String sqlQuery = "SELECT student_ID FROM students WHERE student_full_name = ?";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1,studentName);
            System.out.println("If not it is before executing the query ");
            ResultSet result = creatingStat.executeQuery();
            System.out.println("It must be here");
            if (result.next()) {
                logInStudentID = result.getString("student_ID");
                System.out.println(logInStudentID);
            }
            else
                System.out.println("I don't have any data");
        }
        catch (SQLException e){
            System.out.println("What is wrong with that");
            e.printStackTrace();
        }
        return logInStudentID;
    }

    public static boolean rateChecker(){
        boolean bool = false;
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQuery = "SELECT student_ID FROM rating WHERE student_ID = ? ";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1,LoginPageForStudent.logInStudentID);
            ResultSet result = creatingStat.executeQuery();
            if (result.next()){
                bool = true;
            }
        }
        catch(SQLException e){
            System.out.println("same here");
            e.printStackTrace();

        }
        return bool;
    }
    public static void  addRating(int rate){
        if (rateChecker()){
            try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
                String sqlQuery = "INSERT INTO rating (Number, Rates, student_ID) VALUES (?,?,?)";
                PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
                creatingStat.setInt(1,0);
                creatingStat.setInt(2,rate);
                creatingStat.setString(3, LoginPageForStudent.logInStudentID);
                Integer result = creatingStat.executeUpdate();
                if (result != 0) {
                    // Leykun show add some page to show you have rated successfully
                    JOptionPane.showMessageDialog(null,"You have Rated Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch (SQLException e){
                System.out.println("Same here");
                e.printStackTrace();
            }
        }
        else{
            //Leykun should create a page that will we displayed to show he has already rated the cafe
            JOptionPane.showMessageDialog(null,"You have already rated the cafe","Message",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static ArrayList<Integer> rateExtractor(){
        ArrayList<Integer> rates = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQuery = "SELECT Rates FROM rating";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            ResultSet result = creatingStat.executeQuery();
            while(result.next()){
                rates.add(result.getInt("Rates"));
            }
        }
        catch(SQLException e){
            System.out.println("Problem in rate extractor");
            e.printStackTrace();
        }
        return rates;
    }
    // I need those Arguments.
    public static boolean imageAdder(String imageName, String imagePath, String Day, String Meal){
        boolean bool = false;
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQuery = "UPDATE Foods SET Number = ?, Food_Name = ?, Food_File_Path = ?, Days = ?, Meal = ? WHERE Days = ? AND Meals = ?";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setInt(1,0);
            creatingStat.setString(2,imageName);
            creatingStat.setString(3,imagePath);
            creatingStat.setString(4,Day);
            creatingStat.setString(5,Meal);
            creatingStat.setString(6,Day);
            creatingStat.setString(7,Meal);

            int result = creatingStat.executeUpdate();
            if (result != 0){
                bool = true;
                // Leykun can use this to display something on the GUI
                //This will call Leykun's Method with the specified Image name and Image File path
            }
        }
        catch (SQLException e){
            System.out.println("when adding an image");
            e.printStackTrace();
        }
        return bool;
    }

    public static ArrayList<String> imageExtractor(String Day, String Meal){
        ArrayList<String> imageInfo  = new ArrayList<>();
        try(Connection connection  = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQuery = "SELECT Food_Name, Food_File_Path FROM Foods WHERE Days = ? AND Meals = ? ";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1,Day);
            creatingStat.setString(2,Meal);
            ResultSet result = creatingStat.executeQuery();
            imageInfo.add(result.getString("Food_Name"));
            imageInfo.add(result.getString("Food_File_Path"));
        }
        catch(SQLException e){
            System.out.println("When Extracting Image");
            e.printStackTrace();
        }
        return imageInfo;
    }
}







