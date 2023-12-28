package GUI;

import java.awt.Color;

import javax.swing.JButton;


public class AttendancePage extends WelcomePage {
    private JButton myButton;
    AttendancePage(){
        myButton = new JButton("Hello it works");
        centerPanel.setBackground(Color.BLUE);
        centerPanel.add(myButton);
    }    
    }


