package Database;

import GUI.Student.StudentSignUpPage;

import java.io.IOException;
import java.sql.SQLException;


public class Backend {
// we should put the RFID scanned ID as a private static in the class.
    public static String stuID;
    public static String studentName;
    public static String password;
    public static String Department;
    public static String year;
    public static String school_ID;

    // This method would be called in the action listener of the scan Your ID button.
    // Remember the Action Listener there must also have a public variable called scanType-->
    //Which is initially zero.
// This method would be called in the action listener of the scan Your ID button.
// Remember the Action Listener there must also have a public variable called scanType-->
//Which is initially zero.
    public static void scan() throws InterruptedException, IOException, SQLException {
        if (StudentSignUpPage.scanType % 2 == 0){
            ESPcommunication thread = new ESPcommunication();
            System.out.println("I am creating new thread for you to run");
            thread.start();
        }
        else{
            ESPcommunication.openComm();
            Thread.currentThread().getPriority();
            System.out.println("I run on the main Thread, I will get priority");
            Thread.sleep(10);
        }
    }
// This method check if an Id is already registered in the database.
// This method is used in many other methods.
    public static boolean existanceChecker(String stuID) throws SQLException {
        if (ConnectionWithDatabase.idsForSignUp().contains(stuID)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean existanceChecker(String stuID,String sqlQuery) throws SQLException {
        if (ConnectionWithDatabase.idsForAttendance(sqlQuery).contains(stuID)) {
            return true;
        }
        else {
            return false;
        }
    }
}
//What you did on the server-client connection need some fixing!!