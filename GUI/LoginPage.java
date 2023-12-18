package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class LoginPage implements ActionListener {
    //-----------------------------------------------------
    //all the objects below are used for making the GUI Components
    JFrame frame = new JFrame();
    JButton signInButton = new JButton("Sign in");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Admin ID:");
    JLabel userPasswordLabel = new JLabel("Admin Password:");
    JLabel messageLabel = new JLabel();
    JLabel Title = new JLabel();
    JLabel createAccountMessage = new JLabel("Are you a Student?");
    JPanel foreground = new JPanel();
    //--------------------------------------------
    LoginPage() {
        //--------------------------------------------------
        //this customizes the title of the login page
        Title.setText("6KILO CAFE");
        Title.setBounds(150, 40, 300, 30);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 25));   
        Title.setForeground(Color.RED);
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
        loginButton.setBounds(125, 230, 100, 25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        loginButton.setForeground(Color.white);
        loginButton.setBackground(Color.BLACK);

        resetButton.setBounds(250, 230, 100, 25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        resetButton.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        resetButton.setForeground(Color.white);
        resetButton.setBackground(Color.BLACK);

        signInButton.setBounds(300, 300, 100, 25);
        signInButton.addActionListener(this);
        signInButton.setFocusable(false);
        signInButton.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        signInButton.setForeground(Color.white);
        signInButton.setBackground(Color.BLACK);
        //----------------------------------------------------

        //adds the foreground panel which is used to store the above components and sets the background"
        foreground.setBackground(new Color(12, 55, 67));
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
            if (IdandPassword.getLogInfo().containsKey(userID)) {
                if (IdandPassword.getLogInfo().get(userID).equals(userPassword)) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");          
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage();
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
            StudentSignInPage studentsigninpage = new StudentSignInPage();
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
