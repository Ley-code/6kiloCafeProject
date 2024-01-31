package Database;

import GUI.Student.StudentSignUpPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class ESPcommunication extends Thread {
    private static Socket socket;
    private static BufferedReader buffer;
    private static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(12345);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String studentID;
    public static void openComm() throws IOException, SQLException {
        System.out.println("I am waiting");
        socket = serverSocket.accept();
        System.out.println("Connected with a client");
        InputStream inputStream = socket.getInputStream();
        buffer = new BufferedReader(new InputStreamReader(inputStream));
        studentID = buffer.readLine();
        System.out.println(studentID);
        socket.close();
        SignUp.accountChecker(studentID);
        StudentSignUpPage.scanType++;
        method(studentID);

    }

    @Override
    public void run(){
        try {
            while(true) {
                System.out.println("I am waiting");
                socket = serverSocket.accept();//This waits for a client connection in the specified port number
                System.out.println("Connected with a client");
                InputStream inputStream = socket.getInputStream();
                buffer = new BufferedReader(new InputStreamReader(inputStream));
                studentID = buffer.readLine();
                socket.close();
                Attendance.accountChecker(studentID);
                System.out.println("I have called the Attendance.accountChecker(studentID)");

            }
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void method(String string){
        System.out.println("Hey there I am method, that is my name. I have a string for you which is from main thread, " +
                "which is cased because you pressed the scan button"+string);
    }
}

