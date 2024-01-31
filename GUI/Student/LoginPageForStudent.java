package GUI.Student;

import Database.ConnectionWithDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginPageForStudent implements ActionListener {
    //-----------------------------------------------------
    //all the objects below are used for making the GUI Components
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel();
    JLabel userPasswordLabel = new JLabel("Student Password:");
    JLabel messageLabel = new JLabel();
    JLabel Title = new JLabel();
    JPanel foreground = new JPanel();
    JPanel topPanel = new JPanel();
    public static String logInStudentID;
    //--------------------------------------------
    LoginPageForStudent() {
        //--------------------------------------------------
        //this customizes the title of the login page
        Title.setText("Cafe Management");
        Title.setBounds(150, 40, 30, 30);
        Title.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        Title.setForeground(Color.BLACK);


        //it customizes the Admin ID text label
        userIDLabel.setText("Student Name: ");
        userIDLabel.setBounds(150, 300, 250, 25);

        userIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        userIDLabel.setForeground(Color.WHITE);
        //----------------------------------------------------

        //it customizes the Admin password text Label
        userPasswordLabel.setBounds(150, 350, 270, 22);

        userPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        userPasswordLabel.setForeground(Color.WHITE);

        //----------------------------------------------------

        // The userID field and the userpasswordField both creates the space to write userID and password
        userIDField.setBounds(400, 300, 200, 25);
        userIDField.setBorder(BorderFactory.createLineBorder(new Color(254, 243, 240)));
        userPasswordField.setBounds(400, 350, 200, 25);
        userPasswordField.setBorder(BorderFactory.createLineBorder(new Color(254, 243, 240)));
        //----------------------------------------------------

        //this Displays the message after we log in
        messageLabel.setBounds(160, 180, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));
        messageLabel.setForeground(Color.BLACK);
        //----------------------------------------------------
        //creates the buttons and designs them accordingly
        loginButton.setBounds(200, 400, 100, 45);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);

        loginButton.setForeground(Color.white);
        loginButton.setBackground(new Color(0, 9, 105));


        resetButton.setBounds(325, 400, 100, 45);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);

        resetButton.setForeground(Color.white);
        resetButton.setBackground(new Color(0, 14, 93));

        //adds the foreground panel which is used to store the above components and sets the background
        foreground.setBackground(new Color(7, 5, 5));
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
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        topPanel.add(Title);

        frame.add(foreground, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); //places it to center

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu Menu = new JMenu("Menu");
        JMenu settingMenu = new JMenu("Setting");
        JMenu helpMenu = new JMenu("Help");
        JMenu exitMenu = new JMenu("Exit");

        // Create menu items

        JMenuItem NotificationMenuItem = new JMenuItem("Notification");
        JMenuItem privacyMenuItem = new JMenuItem("privacy");
        JMenuItem backMenuItem = new JMenuItem("previous Page");


        NotificationMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Notification Menu Item Clicked");
            }
        });

        privacyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "privacy Menu Item Clicked");
            }
        });
        backMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentSignUpPage();
                frame.dispose();
            }
        });
        // Add menu items to the File menu
        settingMenu.add(NotificationMenuItem);
        settingMenu.add(privacyMenuItem);
        settingMenu.addSeparator(); // Adds a separator line
        menuBar.add(backMenuItem);

        // Add menus to the menu bar
        menuBar.add(settingMenu);
        menuBar.add(Menu);
        menuBar.add(helpMenu);
        menuBar.add(exitMenu);

        // Set the menu bar for the JFrame
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void validateLogIn(String password, String userName) throws SQLException {
        HashMap<String, String> list = Database.ConnectionWithDatabase.idsForLogIn();
        System.out.println(list);
        if (list.containsKey(userName)) {
            if (list.get(userName).equals(password)) {
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Login Successful");
                frame.dispose();
                new WelcomePageForStudents();
                logInStudentID = ConnectionWithDatabase.getStudentID(userName);
            } else {
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

                //the above variables store the password and ID of the user
                //----------------------------------------------------
                //below the methods check if the user ID and Password matches and if it doesn't match shows the respective message
                //and if it matches opens a new welcome page as an admin
                try {
                    validateLogIn(userPassword, userID);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                //----------------------------------------------------
        }
            //if the user is a student it creates a studentSigninPage
    }
}
