package My_java_work;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static int scanType = 0;
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        // I am using this as GUI
        // Remember That!!!
        SignUp.infoInitialize("Lemi","helloworld","software","3");
        Backend.scan();
        scanType++;
        Backend.scan();
    }
}