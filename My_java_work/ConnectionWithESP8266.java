package My_java_work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionWithESP8266 {
    private static Socket socket;
    private static BufferedReader buffer;
    private static ServerSocket serverSocket;
    public static String studentID;

    public static void createServer() throws IOException {
        serverSocket = new ServerSocket(2334);
        System.out.println("Server ccreated");
    }
// if scan=1;
    public static void openCommunication(){
        try {
            while(true) {
                System.out.println("I am waiting");
                socket = serverSocket.accept();//This waits for a client connection in the specified port number
                System.out.println("Connected with a client");
                InputStream inputStream = socket.getInputStream();
                buffer = new BufferedReader(new InputStreamReader(inputStream));
                studentID = buffer.readLine();
                System.out.println(studentID);
                // I don't have to create another class to send this I can create a thread here.
                socket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

 // I think I should create a thread here to keep this loop and go on to the next step



}
