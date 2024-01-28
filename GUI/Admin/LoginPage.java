package GUI.Admin;

import GUI.Student.StudentSignInPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.SQLException;

public class LoginPage implements ActionListener {
    IdandPassword myid = new IdandPassword();
    //-----------------------------------------------------
    //all the objects below are used for making the GUI Components
    JFrame frame = new JFrame();
    JButton signInButton;
    JButton loginButton;
    JButton resetButton;
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Admin ID:");
    JLabel userPasswordLabel = new JLabel("Admin Password:");
    JLabel messageLabel = new JLabel();
    JLabel Title = new JLabel();
    JLabel createAccountMessage = new JLabel("Are you a Student?");
    JPanel foreground = new JPanel();
    //--------------------------------------------
    public LoginPage() {
        //--------------------------------------------------
        //this customizes the title of the login page
        Title.setText("Cafe Management");
        Title.setBounds(150, 40, 300, 30);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 25));   
        Title.setForeground(Color.WHITE);
        //-------------------------------------------------
        
        //it customizes the Admin ID text label
        userIDLabel.setText("Admin ID: ");
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

        //this Displays the message after we login
        messageLabel.setBounds(160, 180, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));
        messageLabel.setForeground(Color.WHITE);
        //----------------------------------------------------

        //asks if the user is a student or not
        createAccountMessage.setText("Are you a student?");
        createAccountMessage.setBounds(140, 300, 200, 25);
        createAccountMessage.setFont(new Font("Times New Roman", Font.BOLD, 16));
        createAccountMessage.setForeground(Color.WHITE);
        //----------------------------------------------------

        //creates the buttons and designs them accordingly
        loginButton = new ButtonStyle("Login");
        loginButton.setBounds(80, 230, 150, 25);
        loginButton.addActionListener(this);

        resetButton = new ButtonStyle("Reset");
        resetButton.setBounds(250, 230, 150, 25);
        resetButton.addActionListener(this);

        signInButton = new ButtonStyle("Sign In");
        signInButton.setBounds(300, 300, 150, 25);
        signInButton.addActionListener(this);
        //----------------------------------------------------

        //adds the foreground panel which is used to store the above components and sets the background"
        foreground.setBackground(new Color(24, 26, 79));
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
        foreground.add(createAccountMessage);
        foreground.add(signInButton);
        //----------------------------------------------------

        //finally we add the foreground panel to the Frame
        frame.add(foreground);
        frame.setUndecorated(true); //removes the minimize,maximize and close tabs
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null); //places it to center
        frame.setVisible(true);
        frame.setResizable(true);
        //----------------------------------------------------
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
            
            //resets the password and IDfield if a user makes a mistake
        }
        if (e.getSource() == loginButton) {
            
            String userID = userIDField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());
            //the above variables store the password and ID of the user
            //----------------------------------------------------

            //below the methods check if the user ID and Password matches and if it doesnt match shows the respective message
            //and if it matches opens a new welcome page as an admin
            if (myid.getLogInfo().containsKey(userID)) {
                if (myid.getLogInfo().get(userID).equals(userPassword)) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");          
                    frame.dispose();
                    try {
                        new AttendancePage();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong Password");
                } 
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong username");
            }
            //----------------------------------------------------
        }
        //if the user is a student it creates a studentsigninpage
        if (e.getSource() == signInButton) {
            new StudentSignInPage();
            frame.dispose();
        }
    }
}
