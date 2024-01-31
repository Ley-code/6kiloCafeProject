package GUI.Admin;

import GUI.Admin.FoodListPageFolder.FoodManagementPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class WelcomePage {
    protected JFrame frame;
    protected JLabel CafeManagementLabel;
    protected JPanel topPanel;
    public JPanel centerPanel;
    protected JPanel rightPanel;
    protected JButton AttendanceButton;
    protected JButton peakTimeAnalysisButton;
    protected JButton cafeFoodsButton;
    protected JButton InventoryManagementButton;
    protected JButton pollButton;
    protected JButton studentButton;
    protected JButton generalInformationButton;

    protected JButton logoutButton;

    public WelcomePage() {
        initialize();
    }

    private void initialize() {
        AttendanceButton = new ButtonStyle();
        AttendanceButton.setText("Attendance Checker");
        // a custom listener that creates a new page based on the button clicked
        // ----------------------------------------------------------
        AttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AttendancePage();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                frame.dispose();
            }
        });
        cafeFoodsButton = new ButtonStyle();
        cafeFoodsButton.setText("Cafe Foods");
        cafeFoodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FoodManagementPage();
                frame.dispose();
            }
        });
        // --------------------------------------------------
        centerPanel = new JPanel(); // the panel that is going to be edited in the children classes
        // --------------------------------------------------
        InventoryManagementButton = new ButtonStyle();
        InventoryManagementButton.setText("Inventory Management");
        InventoryManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InventoryManagementPage();
                frame.dispose();
            }
        });

        pollButton = new ButtonStyle();
        pollButton.setText("Poll");
        pollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PollPage();
                frame.dispose();
            }
        });

        studentButton = new ButtonStyle();
        studentButton.setText("Student Feedback");
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentFeedbackPage();
                frame.dispose();
            }
        });

        generalInformationButton = new ButtonStyle();
        generalInformationButton.setText("General Information");
        generalInformationButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new GeneralInformationPage();
                frame.dispose();
            }

        });
        peakTimeAnalysisButton = new ButtonStyle();
        peakTimeAnalysisButton.setText("Peak Time Analysis");
        peakTimeAnalysisButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new graphAndChartPage();
                frame.dispose();
            }
        });
        JLabel copyrightLabel1 = new JLabel("Copyright @ Addis Ababa Institute of Technology");
        JLabel copyrightLabel2 = new JLabel("2024 All rights reserved");
        copyrightLabel1.setVerticalAlignment(SwingConstants.BOTTOM);
        copyrightLabel2.setVerticalAlignment(SwingConstants.TOP);
        copyrightLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        copyrightLabel2.setForeground(Color.WHITE);
        copyrightLabel1.setForeground(Color.WHITE);
        copyrightLabel1.setFont(new Font("Helvetica", Font.BOLD, 12));
        copyrightLabel2.setFont(new Font("Helvetica", Font.BOLD, 12));

        JPanel copyrightContainer = new JPanel();
        copyrightContainer.setBackground(new Color(24, 26, 79));
        copyrightContainer.setLayout(new GridLayout(2, 1));
        copyrightContainer.add(copyrightLabel1);
        copyrightContainer.add(copyrightLabel2);
        // -----------------------------------------------------------------
        // creates the Title and Icon at the top of the frame

        ImageIcon logo = new ImageIcon("GUI\\icons\\restaurant.png");
        CafeManagementLabel = new JLabel();
        CafeManagementLabel.setIcon(logo);
        CafeManagementLabel.setIconTextGap(20);
        CafeManagementLabel.setText("Cafe Management System");
        CafeManagementLabel.setForeground(Color.WHITE);
        CafeManagementLabel.setFont(new Font("Garamond", 2, 28));
        Border labelBorder = new EmptyBorder(15, 15, 15, 15);
        CafeManagementLabel.setBorder(labelBorder);
        topPanel = new JPanel(); // self discriptive
        topPanel.setBackground(new Color(24, 26, 79));
        topPanel.setLayout(new BorderLayout());
        topPanel.add(CafeManagementLabel, BorderLayout.CENTER);
        // adds the buttons on the right side of the frame
        // -----------------------------------------------------------
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(8, 1, 10, 10));
        JButton[] buttonGroup = {AttendanceButton, peakTimeAnalysisButton, cafeFoodsButton, InventoryManagementButton, pollButton, studentButton, generalInformationButton};
        for (int i = 0; i < 7; i++) {
            rightPanel.add(buttonGroup[i]);
        }
        rightPanel.add(copyrightContainer);
        rightPanel.setBackground(new Color(24, 26, 79));
        //        // ---------------------------------------------------------
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane();
        frame.setLocationRelativeTo(null);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(rightPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);

        JMenu settingsMenu = new JMenu("Settings");
        JMenuItem logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginPage();
            }
        });
        JMenuItem ExitItem = new JMenuItem("Exit");
        ExitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        settingsMenu.add(logoutItem);
        settingsMenu.add(ExitItem);
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenuBar menubar = new JMenuBar();
        menubar.add(settingsMenu);
        menubar.add(editMenu);
        menubar.add(helpMenu);
        frame.setJMenuBar(menubar);
        frame.setBackground(new Color(185, 185, 185));
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
