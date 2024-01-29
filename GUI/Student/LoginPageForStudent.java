package GUI.Student;

import GUI.Admin.IdandPassword;
import GUI.Admin.WelcomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginPageForStudent implements ActionListener {
    IdandPassword myid = new IdandPassword();
    //-----------------------------------------------------
    //all the objects below are used for making the GUI Components
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel();
    JLabel userPasswordLabel = new JLabel("Student Pass:");
    JLabel messageLabel = new JLabel();
    JLabel Title = new JLabel();
    JPanel foreground = new JPanel();
    //--------------------------------------------
    LoginPageForStudent() {
        //--------------------------------------------------
        //this customizes the title of the login page
        Title.setText("Cafe Management");
        Title.setBounds(150, 40, 300, 30);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 25));   
        Title.setForeground(Color.RED);
        //-------------------------------------------------
        
        //it customizes the Admin ID text label
        userIDLabel.setText("Student Name: ");
        userIDLabel.setBounds(50, 100, 100, 25);
        userIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        userIDLabel.setForeground(Color.WHITE);
        //----------------------------------------------------

        //it customizes the Admin password text Label
        userPasswordLabel.setBounds(50, 150, 150, 25);
        userPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        userPasswordLabel.setForeground(Color.WHITE);
        //----------------------------------------------------

        // The userID field and the userpasswordField both creates the space to write userID and password
        userIDField.setBounds(180, 100, 200, 25);
        userIDField.setBorder(BorderFactory.createLineBorder(new Color(56, 43, 0), 5, false));
        userPasswordField.setBounds(180, 150, 200, 25);
        userPasswordField.setBorder(BorderFactory.createLineBorder(new Color(56, 43, 0), 5, false));
        //----------------------------------------------------

        //this Displays the message after we log in
        messageLabel.setBounds(160, 180, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));
        messageLabel.setForeground(Color.WHITE);
        //----------------------------------------------------

        //creates the buttons and designs them accordingly
        loginButton.setBounds(125, 230, 100, 25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        loginButton.setForeground(Color.white);
        loginButton.setBackground(Color.BLACK);

        resetButton.setBounds(250, 230, 100, 25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        resetButton.setForeground(Color.white);
        resetButton.setBackground(Color.BLACK);

        //----------------------------------------------------

        //adds the foreground panel which is used to store the above components and sets the background"
        foreground.setBackground(new Color(46, 5, 74));
        foreground.setOpaque(true);
        foreground.setBounds(0, 0, 500, 500);
        foreground.setLayout(null);
        foreground.add(Title);
        foreground.add(userIDLabel);
        foreground.add(userPasswordLabel);
        foreground.add(userIDField);
        foreground.add(userPasswordField);
        foreground.add(messageLabel);
        foreground.add(loginButton);
        foreground.add(resetButton);
        //----------------------------------------------------

        //finally we add the foreground panel to the Frame
        frame.add(foreground);
        frame.setUndecorated(true); //removes to minimize,maximize and close tabs
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null); //places it to center
        frame.setVisible(true);
        frame.setResizable(true);
        //----------------------------------------------------
    }
    public void validateLogIn(String password, String userName) throws SQLException {
        HashMap<String, String> list = Database.ConnectionWithDatabase.idsForLogIn();
        System.out.println(list);
        if (list.containsKey(userName)) {
            if (list.get(userName).equals(password)) {
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Login Successful");
                frame.dispose();
                new StudentWelcomePage();
            }else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Wrong Password");
            }
        } else {
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Wrong username");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());
<<<<<<< HEAD
            if (myid.getLogInfo().containsKey(userID)) {
                if (myid.getLogInfo().get(userID).equals(userPassword)) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");          
                    frame.dispose();
                    new StudentWelcomePage();
                }else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong Password");
                } 
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong username");
=======
            //the above variables store the password and ID of the user
            //----------------------------------------------------

            //below the methods check if the user ID and Password matches and if it doesnt match shows the respective message
            //and if it matches opens a new welcome page as an admin
            try {
                validateLogIn(userPassword,userID);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
>>>>>>> 5958cfc084f0e27c5fd23c60dca8c0dabc5ab304
            }
            //----------------------------------------------------
        }
        //if the user is a student it creates a studentsigninpage
    }
}
