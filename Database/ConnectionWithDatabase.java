package Database;

import GUI.Student.NewFoodListPage;
import GUI.Student.NewFoodListPanel;
import GUI.Admin.graphAndChartPage;
import GUI.Student.LoginPageForStudent;
import GUI.Student.StudentSignUpPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class ConnectionWithDatabase {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cafe_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "000000000";
    static String logInStudentID;

    public static int signingUp(String studentInfo[]) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
// Your code to work with the database goes here
            System.out.println("Connected to the database.");
            String student_ID = studentInfo[0];
            String student_name = studentInfo[1];
            String password = studentInfo[2];
            String department = studentInfo[3];
            String year = studentInfo[4];
            String school_ID = studentInfo[5];

            String sqlQuery = "INSERT into students values(?,?,?,?,?,?)";// this is a query that will insert one row in to the database.
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1,student_ID);
            creatingStat.setString(2,student_name);
            creatingStat.setString(3,password);
            creatingStat.setString(4,department);
            creatingStat.setString(5,year);
            creatingStat.setString(6,school_ID);
            int resultSet = creatingStat.executeUpdate();
            if (resultSet != 0){
                //You can call the page Fikir is working on here
            }
            connection.close();
            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Login successful");
        StudentSignUpPage.flag1 = true;
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
    public static int addAttendance(String sqlQuery, List<Object> attendance) {
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
    //retrieving
    public static ArrayList<Integer> numOfStudent() {
        LocalDate date = LocalDate.now();
        ArrayList<Integer> numOfStudent = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            int count = 0;
            int anothercount = 0;
            String sqlQueryB = "SELECT * FROM breakfast WHERE DATE(entrytime) = ?";
            String sqlQueryL = "SELECT * FROM lunch WHERE DATE(entrytime) = ?";
            String sqlQueryD = "SELECT * FROM dinner WHERE DATE(entrytime) = ?";
            ResultSet result;
            numOfStudent = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if (count == 0) {
                    PreparedStatement creatingStat = connection.prepareStatement(sqlQueryB);
                    creatingStat.setString(1,String.valueOf(date));
                    result = creatingStat.executeQuery();
                } else if (count == 1) {
                    PreparedStatement creatingStat = connection.prepareStatement(sqlQueryL);
                    creatingStat.setString(1,String.valueOf(date));
                    result = creatingStat.executeQuery();
                } else {
                    PreparedStatement creatingStat = connection.prepareStatement(sqlQueryD);
                    creatingStat.setString(1,String.valueOf(date));
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
        LocalDate date = LocalDate.now();
        ArrayList timeForPeak = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            timeForPeak = new ArrayList();
            int flag = graphAndChartPage.getFlag();
            String sqlQueryB = null;
            if (flag ==0){
                sqlQueryB = "SELECT * FROM breakfast WHERE DATE(entrytime) = ?"; // The date should be the current date
            }
            else if (flag ==1 ){
                sqlQueryB = "SELECT * FROM lunch WHERE DATE(entrytime) = ?";
            }
            else if (flag == 2){
                sqlQueryB = "SELECT * FROM dinner WHERE DATE(entrytime) = ?";
            }
            PreparedStatement creatingStat = connection.prepareStatement(sqlQueryB);
            creatingStat.setString(1,String.valueOf(date));
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
    // This will be called in the Admin part of poll creator
    public static void  pollTableCreator(ArrayList<String> foods,String question){
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQueryF = "CREATE TABLE " + question + " ( " +
                    "Number INT AUTO_INCREMENT PRIMARY KEY, " +
                    foods.get(0) + " INT, " +
                    foods.get(1) + " INT, " +
                    foods.get(2) + " INT, " +
                    foods.get(3) + " INT, " +
                    "student_ID VARCHAR(15), " +
                    "FOREIGN KEY (student_ID) REFERENCES students(student_ID) );"; // CHECK THIS wHEN YOU FINISH
            PreparedStatement creatingStat = connection.prepareStatement(sqlQueryF);
            System.out.println(sqlQueryF);
            System.out.println("is it here");
            creatingStat.execute();
            System.out.println("What is wrong with excuteing the query");
            pollComplement(foods,question);
        }
        catch (SQLException e){
            System.out.println("Just for the one");
            e.printStackTrace();
        }
    }
    public static void pollComplement(ArrayList<String> foods,String question){
        System.out.println("I told you leykun it is not woring");
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQuery = "INSERT INTO Polls (Number, Questions, Food_A, Food_B, Food_C, Food_D) VALUES (?,?,?,?,?,?) ";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setInt(1,0);
            creatingStat.setString(2,question);
            creatingStat.setString(3,foods.get(0));
            creatingStat.setString(4,foods.get(1));
            creatingStat.setString(5,foods.get(2));
            creatingStat.setString(6,foods.get(3));
            System.out.println(sqlQuery);
            creatingStat.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Complement");
        }
    }
    public static HashMap<String, ArrayList<String>> pollOptionDisplay(){
        HashMap<String, ArrayList<String>> pollOption = new HashMap<>();
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQuery = "SELECT Questions, Food_A, Food_B, Food_C, Food_D FROM Polls";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            ResultSet result = creatingStat.executeQuery();
            while(result.next()){
                ArrayList<String> optionsArray= new ArrayList<>();
                System.out.println(result.getString("Questions"));
                System.out.println(result.getString("Food_A"));
                optionsArray.add(result.getString("Food_A"));
                optionsArray.add(result.getString("Food_B"));
                optionsArray.add(result.getString("Food_C"));
                optionsArray.add(result.getString("Food_D"));
                pollOption.put(result.getString("Questions"), optionsArray);
            }
        }
        catch(SQLException e){
            System.out.println("poll displayer");
            e.printStackTrace();
        }
        System.out.println(pollOption);
        return pollOption;
    }
    //You have stated the number of poll is limited
    public static void voteAdder(ArrayList<Integer> votes,String pollName){
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQuery = "INSERT INTO " + pollName + " VALUES (?,?,?,?,?,?)";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setInt(1,0);
            creatingStat.setInt(2,votes.get(0));
            creatingStat.setInt(3,votes.get(1));
            creatingStat.setInt(4,votes.get(2));
            creatingStat.setInt(5,votes.get(3));
            creatingStat.setString(6,ConnectionWithDatabase.logInStudentID);
            System.out.println(sqlQuery);
            int result = creatingStat.executeUpdate();
            System.out.println(sqlQuery);
            if (result != 0){
                JOptionPane.showMessageDialog(null,"You voted Successfuly","Message",JOptionPane.INFORMATION_MESSAGE);
                // You have voted successfully.
                // Some message will be Displayed on the GUI
            }
        }
        catch(SQLException e){
            System.out.println("Our last feature");
            e.printStackTrace();
        }
    }
    public static int[] voteExtractor(ArrayList<String> foods, String Question){
        System.out.println(foods);
        System.out.println(Question);
        int[] vote = {0,0,0,0,0}; //This will return array with total vote on each food, Since the food and the number occupy
                                     // the same index, you can access them easily, and the 4th index is the total number of vote
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQuery = "SELECT " + foods.get(0) + " , " + foods.get(1) + " , " + foods.get(2) + " , " + foods.get(3) + " FROM " + Question;
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            System.out.println("Before");
            ResultSet result = creatingStat.executeQuery();

            System.out.println(result.getType());

            while (result.next()){
                System.out.println("after");
                vote[4]++;
                if (result.getInt(foods.get(0)) == 1){
                    vote[0]++;
                }
                else if (result.getInt(foods.get(1)) == 1){
                    vote[1]++;
                }
                else if (result.getInt(foods.get(2)) == 1){
                    vote[2]++;
                }
                else if (result.getInt(foods.get(3)) == 1){
                    vote[3]++;
                }
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Vote extractor exception");
        }
        System.out.println("Finnnay");
        return vote;
    }
        // BREAKFAST
    public static void breakfastAttendance(DefaultTableModel tableModel) {
        LocalDate currentDate = LocalDate.now();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sqlQuery = "SELECT breakfast.givenNumber, students.student_full_name, students.School_ID, " +
                    "students.Department, students.year, breakfast.entrytime " +
                    "FROM breakfast " +
                    "JOIN students ON breakfast.student_ID = students.student_ID " +
                    "WHERE DATE(entrytime) = ? ";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1, String.valueOf(currentDate));
            ResultSet result = creatingStat.executeQuery();
            while(result.next()){
                int Number = result.getInt(1);
                String studentName = result.getString(2);
                String School_ID = result.getString(3);
                String department = result.getString(4);
                String year = result.getString(5);
                Timestamp breakfastTime = result.getTimestamp(6);
                tableModel.addRow(new Object[]{Number, studentName, School_ID, department, year, breakfastTime});
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("New one");
        }
    }
    public static void lunchAttendance(DefaultTableModel tableModel) {
        LocalDate currentDate = LocalDate.now();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sqlQuery = "SELECT lunch.givenNumber, students.student_full_name, students.School_ID, " +
                    "students.Department, students.year, lunch.entrytime " +
                    "FROM lunch " +
                    "JOIN students ON lunch.student_ID = students.student_ID " +
                    "WHERE DATE(entrytime) = ? ";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1, String.valueOf(currentDate));
            ResultSet result = creatingStat.executeQuery();
            while(result.next()){
                int Number = result.getInt(1);
                String studentName = result.getString(2);
                String School_ID = result.getString(3);
                String department = result.getString(4);
                String year = result.getString(5);
                Timestamp breakfastTime = result.getTimestamp(6);
                tableModel.addRow(new Object[]{Number, studentName, School_ID, department, year, breakfastTime});
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("New one");
        }
    }
    public static void dinnerAttendance(DefaultTableModel tableModel) {
        LocalDate currentDate = LocalDate.now();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sqlQuery = "SELECT dinner.givenNumber, students.student_full_name, students.School_ID, " +
                    "students.Department, students.year, dinner.entrytime " +
                    "FROM dinner " +
                    "JOIN students ON dinner.student_ID = students.student_ID " +
                    "WHERE DATE(entrytime) = ? ";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1, String.valueOf(currentDate));
            ResultSet result = creatingStat.executeQuery();
            while(result.next()){
                int Number = result.getInt(1);
                String studentName = result.getString(2);
                String School_ID = result.getString(3);
                String department = result.getString(4);
                String year = result.getString(5);
                Timestamp breakfastTime = result.getTimestamp(6);
                tableModel.addRow(new Object[]{Number, studentName, School_ID, department, year, breakfastTime});
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("New one");
        }
    }
    // IN the meantime lets write the JDBC for Attendance
    public static String getStudentID(String studentName){

        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            System.out.println("I am before the query");
            String sqlQuery = "SELECT student_ID FROM students WHERE student_full_name = ?";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setString(1,studentName);
            System.out.println("If not it is before executing the query ");
            ResultSet result = creatingStat.executeQuery();
            System.out.println("It must be here");
            if (result.next()) {
                ConnectionWithDatabase.logInStudentID = result.getString("student_ID");
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
    public static void addRating(int rate){
        if (!rateChecker()){
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
    public static boolean imageAdder(String imageName, String imagePath, int Day, int Meal){
        boolean bool = false;
        try(Connection connectionI = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQueryI = "SELECT Days, Meals FROM foods WHERE Days = ? AND Meals = ?";
            PreparedStatement creatingStatI = connectionI.prepareStatement(sqlQueryI);
            creatingStatI.setInt(1,Day);
            creatingStatI.setInt(2,Meal);
            ResultSet resultI = creatingStatI.executeQuery();
            if(resultI.next()){
                try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
                    String sqlQuery = "UPDATE foods SET Number = ?, Food_Name = ?, Food_File_Path = ? WHERE Days = ? AND Meals = ? ";
                    PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
                    creatingStat.setInt(1,0);
                    creatingStat.setString(2,imageName);
                    creatingStat.setString(3,imagePath);
                    creatingStat.setInt(4,Day);
                    creatingStat.setInt(5,Meal);
                    int result = creatingStat.executeUpdate();
                    if (result != 0){
                        bool = true;
                        // Leykun can use this to display something on the GUI
                        //This will call Leykun's Method with the specified Image name and Image File path
                    }
                }
                catch (SQLException e){
                    e.printStackTrace();
                    System.out.println("Is There an error");
                }
            }
            else{
                try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
                    String sqlQueryF = "INSERT INTO foods (Number, Food_Name, Food_File_Path, Days, Meals) VALUES (?,?,?,?,?) ";
                    PreparedStatement creatingStatF = connection.prepareStatement(sqlQueryF);
                    creatingStatF.setInt(1,0);
                    creatingStatF.setString(2,imageName);
                    creatingStatF.setString(3,imagePath);
                    creatingStatF.setInt(4,Day);
                    creatingStatF.setInt(5,Meal);
                    int resultF = creatingStatF.executeUpdate();
                    if (resultF != 0){
                        bool = true;
                        //Some row is affected
                        System.out.println("Some row is affected");
                    }
                }
                catch (SQLException e){
                    System.out.println("when adding an image");
                    e.printStackTrace();
                }
            }
        }
        catch (SQLException e){
            System.out.println("Another Error");
            e.printStackTrace();
        }
        return bool;
    }
    public static ArrayList<String> imageExtractor(int Day, int Meal){
        ArrayList<String> imageInfo  = new ArrayList<>();
        try(Connection connection  = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            String sqlQuery = "SELECT Food_Name, Food_File_Path FROM foods WHERE Days = ? AND Meals = ? ";
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            creatingStat.setInt(1,Day);
            creatingStat.setInt(2,Meal);
            ResultSet result = creatingStat.executeQuery();
            result.next();
            imageInfo.add(result.getString("Food_Name"));
            imageInfo.add(result.getString("Food_File_Path"));
            System.out.println();
        }
        catch(SQLException e){
            System.out.println("When Extracting Image");
            e.printStackTrace();
        }
        return imageInfo;
    }
    //This Method is called when FoodList button is pushed.
    public static void imageDisplayExtractor(){
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){
            HashMap<String, String> names = new HashMap<>();
            HashMap<String, String> paths = new HashMap<>();
            String [][] arrayForNames = new String[7][3];
            String [][] arrayForPath = new String[7][3];
            Set<String> keysNames = names.keySet();
            Set<String> keysPath = paths.keySet();

            String sqlQuery = "SELECT Food_Name, Food_File_Path, Days, Meals FROM foods" ;
            PreparedStatement creatingStat = connection.prepareStatement(sqlQuery);
            ResultSet result = creatingStat.executeQuery();

            while(result.next()){
                names.put(result.getString("Days")+ "#" + result.getString("Meals"),result.getString("Food_Name"));
                paths.put(result.getString("Days")+ "#" + result.getString("Meals"),result.getString("Food_File_Path"));
            }
            for (String key : keysNames){
                StringTokenizer tokenizer = new StringTokenizer(key,"#");
                int row = Integer.parseInt(tokenizer.nextToken());
                int column = Integer.parseInt(tokenizer.nextToken());
                arrayForNames[row][column] = names.get(key);
            }
            for (String key : keysPath){
                StringTokenizer tokenizer = new StringTokenizer(key,"#");
                int row = Integer.parseInt(tokenizer.nextToken());
                int column = Integer.parseInt(tokenizer.nextToken());
                arrayForPath[row][column] = paths.get(key);
            }
            NewFoodListPage.FoodNames = arrayForNames;
            System.out.println(Arrays.deepToString(arrayForNames));
            NewFoodListPanel.imagepath = arrayForPath;
            System.out.println(Arrays.deepToString(arrayForPath));
        }
        catch(SQLException e){
            System.out.println("Extractor Failed");
        }
    }
}







