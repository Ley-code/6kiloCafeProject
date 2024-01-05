package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import My_java_work.Backend;
import My_java_work.SignUp;

public class StudentSignInPage extends JFrame implements ActionListener {
    private JPanel Topcontainer;
    private JPanel TopPanel;
    private JPanel centerPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel BottomPanel;
    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private ImageIcon SignUpLogo;
    private JLabel spaceLabel;
    private JLabel spaceLabel2;
    private JLabel FullnameLabel = new JLabel();
    private JLabel DepartmentLabel = new JLabel();
    private JLabel YearLabel = new JLabel();
    private JLabel IDNumberLabel = new JLabel();
    private JLabel PhoneNumberLabel = new JLabel();
    private JLabel NewPasswordLabel = new JLabel();
    private JLabel ConfirmPasswordLabel = new JLabel();
    private JTextField FullNameField = new JTextField();
    private JTextField IDNumberField = new JTextField();
    private JTextField YearField = new JTextField(); // Initializes the GUI components
    private JTextField DepartmentField = new JTextField();
    private JTextField PhoneNumberField = new JTextField();
    private JPasswordField NewPasswordField = new JPasswordField();
    private JPasswordField ConfirmPasswordField = new JPasswordField();
    private JButton RegisterButton = new JButton();
    private JButton ScanIdButton = new JButton();
    private JLabel MessageLabel = new JLabel();
    private JButton loginButton = new JButton();
    private Boolean flag = false;
    public static int scanType = 0;

    public StudentSignInPage() {
        initialize();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ----------------------------------------------------------------------------------
        String fullnameString = FullNameField.getText();
        String idnumber = IDNumberField.getText(); // We have the register values for the backend(Sura time to do your
                                                   // magic)
        String department = DepartmentField.getText();
        String Year = YearField.getText();
        String PhoneNumber = PhoneNumberField.getText();
        String newpassword = String.valueOf(NewPasswordField.getPassword());
        String confirmpassword = String.valueOf(ConfirmPasswordField.getPassword());
        // ----------------------------------------------------------------------------------

        if (e.getSource() == RegisterButton) {
            if (fullnameString.equals("") || (idnumber.equals("") || (department.equals("") || (Year.equals(""))
                    || PhoneNumber.equals("") || newpassword.equals("") || confirmpassword.equals("")))) {
                MessageLabel.setForeground(Color.RED);
                MessageLabel.setText("One or more empty Fields");
            } else { // displayes Error message and successful registration message
                if (newpassword.equals(confirmpassword)) {
                    MessageLabel.setForeground(Color.GREEN);
                    MessageLabel.setText("Registration Successful");
                    this.flag = true;
                    SignUp.infoInitialize(fullnameString, newpassword, department, Year);

                } else {
                    MessageLabel.setForeground(Color.RED);
                    MessageLabel.setText("Wrong Confirmation Password");
                }
            }
        } else if (e.getSource() == ScanIdButton) {
            MessageLabel.setOpaque(true);
            if (this.flag) {
                MessageLabel.setForeground(Color.GREEN);
                MessageLabel.setText("Put your ID on the Scanner");
                try {
                    Backend.scan();
                    scanType++;
                    Backend.scan();
                } catch (InterruptedException | IOException | SQLException e1) {
                    System.out.println("didnt found the backend");
                    e1.printStackTrace();
                }

            } else {
                MessageLabel.setForeground(Color.RED);
                MessageLabel.setText("Register First");

            }
        } else if (e.getSource() == loginButton){
            new LoginPageForStudent();
            dispose();
            //------------------------------------------
            //currently no task
        }
    }

    private void initialize() {
        SignUpLogo = new ImageIcon("C:\\6kiloCafeProject\\GUI\\icons\\signup.png");
        // Resize the image to the desired dimensions
        Image image = SignUpLogo.getImage();
        Image scaledImage = image.getScaledInstance(64, 64, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Create a JLabel and set the scaled icon

        titleLabel = new JLabel("Cafe Management");
        titleLabel.setFont(new Font("Helvetica", 2, 25));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setIcon(scaledIcon);
        Border labelBorder = new EmptyBorder(15, 15, 0, 15);
        titleLabel.setBorder(labelBorder);

        subtitleLabel = new JLabel("Sign up Page for students");
        subtitleLabel.setFont(new Font("Helvetica", 2, 20));
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setBorder(labelBorder);

        TopPanel = new JPanel();
        TopPanel.setLayout(new BorderLayout());
        TopPanel.add(titleLabel, BorderLayout.NORTH);
        TopPanel.add(subtitleLabel, BorderLayout.SOUTH);
        TopPanel.setBackground(new Color(51, 10, 122));

        Border spaceborder = new EmptyBorder(20, 60, 20, 60);
        spaceLabel = new JLabel();
        spaceLabel2 = new JLabel();
        spaceLabel2.setBorder(spaceborder);
        spaceLabel.setBorder(spaceborder);

        rightPanel = new JPanel();
        rightPanel.add(spaceLabel);
        rightPanel.setBackground(Color.ORANGE);

        leftPanel = new JPanel();
        leftPanel.add(spaceLabel2);
        leftPanel.setBackground(Color.ORANGE);

        BottomPanel = new JPanel();
        BottomPanel.setPreferredSize(new Dimension(500, 20));

        Topcontainer = new JPanel();
        Topcontainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        Topcontainer.setBackground(new Color(0, 153, 153));
        Topcontainer.add(TopPanel, BorderLayout.CENTER);
        // ------------------------------------------------------
        FullNameField.setPreferredSize(new Dimension(200, 30));
        FullnameLabel.setText("Student Name: ");
        FullnameLabel.setForeground(Color.white);
        JPanel row1 = new JPanel();
        row1.setBackground(new Color(131, 30, 199));
        row1.add(FullnameLabel);
        row1.add(FullNameField);
        // -------------------------------------------------------
        IDNumberField.setPreferredSize(new Dimension(200, 30));
        IDNumberLabel.setText("Student ID: ");
        IDNumberLabel.setForeground(Color.white);
        JPanel row2 = new JPanel();
        row2.setBackground(new Color(131, 30, 199));
        row2.add(IDNumberLabel);
        row2.add(IDNumberField);
        // ----------------------------------------------------------
        DepartmentField.setPreferredSize(new Dimension(200, 30));
        DepartmentLabel.setText("Department: ");
        DepartmentLabel.setForeground(Color.white);
        JPanel row3 = new JPanel();
        row3.setBackground(new Color(131, 30, 199));
        row3.add(DepartmentLabel, SwingConstants.CENTER);
        row3.add(DepartmentField);
        // -------------------------------------------------------
        YearField.setPreferredSize(new Dimension(200, 30));
        YearLabel.setText("Year: ");
        YearLabel.setForeground(Color.white);
        JPanel row4 = new JPanel();
        row4.setBackground(new Color(131, 30, 199));
        row4.add(YearLabel);
        row4.add(YearField);
        // ----------------------------------------------------------
        PhoneNumberField.setPreferredSize(new Dimension(200, 30));
        PhoneNumberLabel.setText("PhoneNumber: ");
        PhoneNumberLabel.setForeground(Color.white);
        JPanel row5 = new JPanel();
        row5.setBackground(new Color(131, 30, 199));
        row5.add(PhoneNumberLabel);
        row5.add(PhoneNumberField);
        // -------------------------------------------------------
        NewPasswordField.setPreferredSize(new Dimension(200, 30));
        NewPasswordLabel.setText("New Password: ");
        NewPasswordLabel.setForeground(Color.white);
        JPanel row6 = new JPanel();
        row6.setBackground(new Color(131, 30, 199));
        row6.add(NewPasswordLabel);
        row6.add(NewPasswordField);
        // ----------------------------------------------------------
        ConfirmPasswordField.setPreferredSize(new Dimension(200, 30));
        ConfirmPasswordLabel.setText("Confirm Password: ");
        ConfirmPasswordLabel.setForeground(Color.white);
        JPanel row7 = new JPanel();
        row7.setBackground(new Color(131, 30, 199));
        row7.add(ConfirmPasswordLabel);
        row7.add(ConfirmPasswordField);
        // ----------------------------------------------------------
        JPanel row8 = new JPanel();
        row8.add(MessageLabel);
        row8.setBackground(new Color(131, 30, 200));
        MessageLabel.setFont(new Font("Helvetica", 2, 25));
        MessageLabel.setBackground(new Color(131, 30, 199));
        MessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        MessageLabel.setVerticalAlignment(SwingConstants.CENTER);
        MessageLabel.setOpaque(true);
        MessageLabel.setText("");

        // ----------------------------------------------------------
        JPanel row9 = new JPanel();
        row9.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        row9.setBackground(new Color(131, 30, 199));

        RegisterButton = new ButtonStyle();
        RegisterButton.setText("Register");
        RegisterButton.setMargin(new Insets(5, 15, 5, 15));
        RegisterButton.setBackground(new Color(46, 5, 74));
        RegisterButton.setForeground(Color.WHITE);
        RegisterButton.addActionListener(this);

        ScanIdButton = new ButtonStyle();
        ScanIdButton.setForeground(Color.WHITE);
        ScanIdButton.setText("ScanId");
        ScanIdButton.setMargin(new Insets(5, 15, 5, 15));
        ScanIdButton.setBackground(new Color(46, 5, 74));
        ScanIdButton.addActionListener(this);

        loginButton = new ButtonStyle();
        loginButton.setForeground(Color.WHITE);
        loginButton.setText("LogIn");
        loginButton.setMargin(new Insets(5, 15, 5, 15));
        loginButton.setBackground(new Color(46, 5, 74));
        loginButton.addActionListener(this);

        row9.add(RegisterButton);
        row9.add(ScanIdButton);
        row9.add(loginButton);
        // -------------------------------------------------------------------
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(9, 1, 0, -5));
        centerPanel.add(row1);
        centerPanel.add(row2);
        centerPanel.add(row3);
        centerPanel.add(row4);
        centerPanel.add(row5);
        centerPanel.add(row6);
        centerPanel.add(row7);
        centerPanel.add(row8);
        centerPanel.add(row9);

        rightPanel.setBackground(new Color(46, 5, 74));
        leftPanel.setBackground(new Color(46, 5, 74));
        BottomPanel.setBackground(new Color(51, 10, 122));
        Topcontainer.setBackground(new Color(51, 10, 122));
        centerPanel.setBackground(new Color(131, 30, 199));
        setLayout(new BorderLayout(0, 20));
        add(Topcontainer, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(BottomPanel, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);
        add(leftPanel, BorderLayout.WEST);

        this.setSize(900, 790);
        this.getContentPane().setBackground(new Color(131, 30, 199));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
