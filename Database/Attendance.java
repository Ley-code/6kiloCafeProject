package Database;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import GUI.Student.StudentSignUpPage;

public class Attendance extends Backend {
    private static Timestamp scanTimeStamp;
    private static LocalTime localTime;
    private static LocalDateTime dateTime;
    private static LocalDate date;
    private static int hour;

    public static void accountChecker(String stuID) throws SQLException {
        scanTimeStamp = new Timestamp(System.currentTimeMillis());
        dateTime = scanTimeStamp.toLocalDateTime();
        date = dateTime.toLocalDate();
        localTime = dateTime.toLocalTime();
        hour = localTime.getHour();
        List<Object> attendance = new ArrayList<>();
        attendance.add(scanTimeStamp);
        attendance.add(stuID);
        String sqlQuerySB = "SELECT student_ID FROM breakfast";//used for Attendance
        String sqlQuerySL = "SELECT student_ID FROM lunch";
        String sqlQuerySD = "SELECT student_ID FROM dinner";
        String sqlQueryIB = "INSERT into breakfast values(?,?,?)";
        String sqlQueryIL = "INSERT into lunch values(?,?,?)";
        String sqlQueryID = "INSERT into dinner values(?,?,?)";
// If someone tries to eat two times in one meal.
        if (Backend.existanceChecker(stuID)) {
            System.out.println("You already have an account so You are here to eat");
//Now we can proceed to the next condition.
//We need to check whether you are not eating again or not.
            if (7 <= hour && hour <=9){
// He came to eat his breakfast.
                if (Backend.existanceChecker(stuID,sqlQuerySB)){
// This means he has already eaten his breakfast Kick him out.
                    System.out.println("Why are you trying to eat again");
                }
                else {
                    int result  = ConnectionWithDatabase.addAttendance(sqlQueryIB,attendance);//Use resultSet to return some value
                    System.out.println("row affected"+result);
// Record the attendance and let him in.
                }
            }
            else if (11 <= hour && hour <=15){
// He came to eat his lunch.
                if (Backend.existanceChecker(stuID,sqlQuerySL)){
                    System.out.println("Why are you trying to eat again");
                    System.out.println("Yaa you are in");
// This means he has already eaten his Lunch Kick him out.
                }
                else {
                    int result = ConnectionWithDatabase.addAttendance(sqlQueryIL,attendance);//Use resultSet to return some value
                    System.out.println("row affected"+result);
                    System.out.println("Yaa you are in");
// Record the attendance and let him in.
                }
            }
            else if (2 <= hour && hour <= 3){//change it to 19 after u checked
// He came to eat his dinner.
                if (Backend.existanceChecker(stuID,sqlQuerySD)){
                    System.out.println("Why are you trying to eat again");
// This means he has already eaten his Dinner Kick him out.
                }
                else {
                    int result = ConnectionWithDatabase.addAttendance(sqlQueryID,attendance);//Use resultSet to return some value
                    System.out.println("row affected"+result);
// Record the attendance and let him in.
                    System.out.println("Yaa you are in");
                }
            }
        }
        else {
            System.out.println("You don't have an account. I am loading the signUp page now");
            // This will Load the signUp page and tell you to signUP
            new StudentSignUpPage();
        }
    }
}

