package Database;

import java.sql.SQLException;

public class SignUp extends Backend{
    public static void accountChecker(String stuID) throws SQLException {
        if(Backend.existanceChecker(stuID)){
            //This means the student Id is already in the database.
            System.out.println("You already have an account");
            // Shows account already exist on the GUI.
        }
        else{
            Backend.stuID = stuID;
            System.out.println("I am in accountChecker and I didn't have an account");
            SignUp.arrayCreator();
        }
    }
    // This method will add our total information to database.
    // and return if we did register correctly.
    public static void arrayCreator() throws SQLException {
        String[] studentInfo = new String[6];
        // here you put the condition.
        studentInfo[0] = Backend.stuID;
        studentInfo[1] = Backend.studentName;
        studentInfo[2] = Backend.password;
        studentInfo[3] = Backend.Department;
        studentInfo[4] = Backend.year;
        studentInfo[5] = Backend.school_ID;

        int result = ConnectionWithDatabase.signingUp(studentInfo);// what does resultSet will return if no row is affected
        System.out.println("row affected"+result);
        // Write your condition here
        //if true You will return You have signed up and load the next page
    }
    // This method would be called in th Action Listener of the SignUp button.
    public static void infoInitialize(String studentName, String password, String Department, String year, String school_ID){
        Backend.studentName = studentName;
        Backend.password = password;
        Backend.Department = Department;
        Backend.year = year;
        Backend.school_ID = school_ID;

    }
}
