package GUI.Admin;

import GUI.Student.StudentSignUpPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class LoginPage implements ActionListener {
    IdandPassword myid = new IdandPassword();
    //-----------------------------------------------------
    //all the objects below are used for making the GUI Components
    private JFrame frame = new JFrame();
    private JButton signInButton;
    private JButton loginButton;
    private JButton resetButton;
    private JTextField userIDField = new JTextField();
    private JPasswordField userPasswordField = new JPasswordField();
    private JLabel userIDLabel = new JLabel("Admin ID:");
    private JLabel userPasswordLabel = new JLabel("Admin Password:");
    private JLabel messageLabel = new JLabel();
    private JLabel Title = new JLabel();
    private JLabel createAccountMessage = new JLabel("Are you a Student?");
    private JPanel foreground = new JPanel();
    private JLayeredPane layeredPane = new JLayeredPane();
    //--------------------------------------------
    public LoginPage() {
        //--------------------------------------------------
        try {
            Image backgroundImage = ImageIO.read(new File("GUI\\icons\\cafeImage.jfif"));
            setBackgroundImage(backgroundImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this customizes the title of the login page
        Title.setText("Cafe Management");
        Title.setBounds(150, 40, 300, 30);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 25));   
        Title.setForeground(Color.BLACK);
        //-------------------------------------------------
        
        //it customizes the Admin ID text label
        userIDLabel.setText("Admin ID: ");
        userIDLabel.setBounds(50, 100, 100, 25);
        userIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        userIDLabel.setForeground(Color.BLACK);
        //----------------------------------------------------

        //it customizes the Admin password text Label
        userPasswordLabel.setBounds(50, 150, 150, 25);
        userPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        userPasswordLabel.setForeground(Color.BLACK);
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
        createAccountMessage.setForeground(Color.BLACK);
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
        // Add components to the top layer of the JLayeredPane

        layeredPane.add(Title, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(messageLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(loginButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(resetButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(signInButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(createAccountMessage, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(userIDLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(userPasswordLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(userIDField, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(userPasswordField, JLayeredPane.PALETTE_LAYER);

        // Set up the JFrame with the JLayeredPane
        frame.setLayout(new BorderLayout());
        frame.add(layeredPane, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null); //places it to center
        frame.setVisible(true);
        frame.setResizable(false);
        //----------------------------------------------------
    }
    private void setBackgroundImage(Image backgroundImage) {
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 1000, 700);  // Set the size according to your JFrame size
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
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
            new StudentSignUpPage();
            frame.dispose();
        }
    }
}
