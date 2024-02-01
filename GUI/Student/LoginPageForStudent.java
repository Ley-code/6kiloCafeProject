package GUI.Student;

import Database.ConnectionWithDatabase;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginPageForStudent implements ActionListener {
    //-----------------------------------------------------
    //all the objects below are used for making the GUI Components
    private JFrame frame = new JFrame();
    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JTextField userIDField = new JTextField();
    private JPasswordField userPasswordField = new JPasswordField();
    private JLabel userIDLabel = new JLabel();
    private JLabel userPasswordLabel = new JLabel("Student Password:");
    private JLabel messageLabel = new JLabel();
    private JLabel Title = new JLabel();
    private JPanel foreground = new JPanel();
    private JPanel topPanel = new JPanel();
    private JLayeredPane layeredPane = new JLayeredPane();

    public static String logInStudentID;
    //--------------------------------------------
    LoginPageForStudent() {
        //--------------------------------------------------
        try {
            Image backgroundImage = ImageIO.read(new File("GUI\\icons\\cafeImage.jfif"));
            setBackgroundImage(backgroundImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this customizes the title of the login page
        Title.setText("Cafe Management");
        Title.setBounds(150, 40, 30, 30);
        Title.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        Title.setForeground(Color.BLACK);


        //it customizes the Admin ID text label
        userIDLabel.setText("Student Name: ");
        userIDLabel.setBounds(150, 300, 250, 25);

        userIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        userIDLabel.setForeground(Color.BLACK);
        //----------------------------------------------------

        //it customizes the Admin password text Label
        userPasswordLabel.setBounds(150, 350, 270, 22);

        userPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        userPasswordLabel.setForeground(Color.BLACK);
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
        //----------------------------------------------------


        // Add components to the top layer of the JLayeredPane
        layeredPane.add(topPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(messageLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(loginButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(resetButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(userIDLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(userPasswordLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(userIDField, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(userPasswordField, JLayeredPane.PALETTE_LAYER);
        topPanel.add(Title);
        // Set up the JFrame with the JLayeredPane
        frame.setLayout(new BorderLayout());
        frame.add(layeredPane, BorderLayout.CENTER);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); //places it to center

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu backMenu = new JMenu("Back");
        JMenu settingMenu = new JMenu("Setting");
        JMenu helpMenu = new JMenu("Help");
        JMenu exitMenu = new JMenu("Exit");

        // Create menu items
        JMenuItem NotificationMenuItem = new JMenuItem("Notification Setting");
        JMenuItem privacyMenuItem = new JMenuItem("privacy Policy");
        JMenuItem helpMenuItem = new JMenuItem("privacy Policy");
        JMenuItem backMenuItem = new JMenuItem("SignUp Page");

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
        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "help Menu Item Clicked");
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
        backMenu.add(backMenuItem);

        // Add menus to the menu bar
        menuBar.add(settingMenu);
        menuBar.add(backMenu);
        menuBar.add(helpMenu);
        menuBar.add(exitMenu);

        // Set the menu bar for the JFrame
        frame.setJMenuBar(menuBar);
        //set the visibility of the frame
        frame.setVisible(true);
        frame.setResizable(false);
    }
    private void setBackgroundImage(Image backgroundImage) {
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 1000, 700);  // Set the size according to your JFrame size
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
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

    public static void main(String[] args) {
        new LoginPageForStudent();
    }
}
