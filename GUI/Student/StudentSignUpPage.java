package GUI.Student;

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

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Database.Backend;
import Database.SignUp;
import GUI.Admin.ButtonStyle;
import GUI.Admin.LoginPage;

public class StudentSignUpPage extends JFrame implements ActionListener {
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
    private JLabel NewPasswordLabel = new JLabel();
    private JLabel ConfirmPasswordLabel = new JLabel();
    private JTextField FullNameField = new JTextField();
    private JTextField IDNumberField = new JTextField();
    private JTextField YearField = new JTextField(); // Initializes the GUI components
    private JTextField DepartmentField = new JTextField();
    private JTextField PhoneNumberField = new JTextField();
    private JPasswordField NewPasswordField = new JPasswordField();
    private JPasswordField ConfirmPasswordField = new JPasswordField();
    private JButton RegisterButton = new ButtonStyle();
    private JButton ScanIdButton = new ButtonStyle();
    private JLabel MessageLabel = new JLabel();
    private JButton loginButton = new ButtonStyle();
    private Boolean flag = false;
    public static int scanType = 0;
    public static boolean flag1 = false;

    public StudentSignUpPage() {
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
                    SignUp.infoInitialize(fullnameString, newpassword, department, Year, idnumber);

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
                if(flag1){
                    new WelcomePageForStudents();
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
        TopPanel.setBackground(new Color(0, 0, 0));

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
        Topcontainer.setBackground(new Color(0, 0, 0));
        Topcontainer.add(TopPanel, BorderLayout.CENTER);
        // ------------------------------------------------------
        FullNameField.setPreferredSize(new Dimension(200, 30));
        FullnameLabel.setText("Student Name: ");
        FullnameLabel.setForeground(Color.white);
        JPanel row1 = new JPanel();
        row1.setBackground(new Color(0, 0, 0));
        row1.add(FullnameLabel);
        row1.add(FullNameField);
        // -------------------------------------------------------
        IDNumberField.setPreferredSize(new Dimension(200, 30));
        IDNumberLabel.setText("Student ID: ");
        IDNumberLabel.setForeground(Color.white);
        JPanel row2 = new JPanel();
        row2.setBackground(new Color(0, 0, 0));
        row2.add(IDNumberLabel);
        row2.add(IDNumberField);
        // ----------------------------------------------------------
        DepartmentField.setPreferredSize(new Dimension(200, 30));
        DepartmentLabel.setText("Department: ");
        DepartmentLabel.setForeground(Color.white);
        JPanel row3 = new JPanel();
        row3.setBackground(new Color(0, 0, 0));
        row3.add(DepartmentLabel, SwingConstants.CENTER);
        row3.add(DepartmentField);
        // -------------------------------------------------------
        YearField.setPreferredSize(new Dimension(200, 30));
        YearLabel.setText("Year: ");
        YearLabel.setForeground(Color.white);
        JPanel row4 = new JPanel();
        row4.setBackground(new Color(0, 0, 0));
        row4.add(YearLabel);
        row4.add(YearField);
        // -------------------------------------------------------
        NewPasswordField.setPreferredSize(new Dimension(200, 30));
        NewPasswordLabel.setText("New Password: ");
        NewPasswordLabel.setForeground(Color.white);
        JPanel row6 = new JPanel();
        row6.setBackground(new Color(0, 0, 0));
        row6.add(NewPasswordLabel);
        row6.add(NewPasswordField);
        // ----------------------------------------------------------
        ConfirmPasswordField.setPreferredSize(new Dimension(200, 30));
        ConfirmPasswordLabel.setText("Confirm Password: ");
        ConfirmPasswordLabel.setForeground(Color.white);
        JPanel row7 = new JPanel();
        row7.setBackground(new Color(0, 0, 0));
        row7.add(ConfirmPasswordLabel);
        row7.add(ConfirmPasswordField);
        // ----------------------------------------------------------
        JPanel row8 = new JPanel();
        row8.add(MessageLabel);
        row8.setBackground(new Color(0, 0, 0));
        MessageLabel.setFont(new Font("Helvetica", 2, 25));
        MessageLabel.setBackground(new Color(0, 0, 0));
        MessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        MessageLabel.setVerticalAlignment(SwingConstants.CENTER);
        MessageLabel.setOpaque(true);
        MessageLabel.setText("");

        // ----------------------------------------------------------
        JPanel row9 = new JPanel();
        row9.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        row9.setBackground(new Color(0, 0, 0));

        RegisterButton = new ButtonStyle();
        RegisterButton.setText("Register");
        RegisterButton.setMargin(new Insets(5, 15, 5, 15));
        RegisterButton.setBackground(new Color(0, 9, 105));
        RegisterButton.setForeground(Color.WHITE);
        RegisterButton.addActionListener(this);

        ScanIdButton = new ButtonStyle();
        ScanIdButton.setForeground(Color.WHITE);
        ScanIdButton.setText("ScanId");
        ScanIdButton.setMargin(new Insets(5, 15, 5, 15));
        ScanIdButton.setBackground(new Color(0, 14, 93));
        ScanIdButton.addActionListener(this);

        loginButton = new ButtonStyle();
        loginButton.setForeground(Color.WHITE);
        loginButton.setText("LogIn");
        loginButton.setMargin(new Insets(5, 15, 5, 15));
        loginButton.setBackground(new Color(1, 19, 103));
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
        centerPanel.add(row6);
        centerPanel.add(row7);
        centerPanel.add(row8);
        centerPanel.add(row9);

        JMenu menu = new JMenu("Menu");
        menu.setForeground(Color.WHITE);
        JMenuItem PreviousPage = new JMenuItem("PreviousPage");
        PreviousPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });


        rightPanel.setBackground(new Color(0, 0, 0));
        leftPanel.setBackground(new Color(0, 0, 0));
        BottomPanel.setBackground(new Color(0, 0, 0));
        Topcontainer.setBackground(new Color(0, 0, 0));
        centerPanel.setBackground(new Color(0, 0, 0));

        setLayout(new BorderLayout(0, 20));
        JMenuBar menuBar = new JMenuBar();
        menu.add(PreviousPage);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        add(Topcontainer, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(BottomPanel, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);
        add(leftPanel, BorderLayout.WEST);


        this.setSize(900, 790);
        this.getContentPane().setBackground(new Color(7, 7, 7));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new StudentSignUpPage();
    }
}
