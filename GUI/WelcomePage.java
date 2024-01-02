package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class WelcomePage {
    protected JButton AttendanceButton;
    protected JLabel CafeManagementLabel;
    protected JPanel topPanel;
    protected JPanel centerPanel;
    protected JFrame frame;
    protected JPanel rightPanel;
    protected JButton cafeFoodsButton;
    protected JButton peakTimeAnalysisButton;
    protected JButton InventoryManagementButton;
    protected JButton pollButton;
    protected JButton studentButton;
    protected JButton generalInformationButton;

    WelcomePage() {
        initialize();
    }

    private void initialize() {
        AttendanceButton = new ButtonStyle();
        AttendanceButton.setText("Attendance Chekcer");
        // a custom listener that creates a new page based on the button clicked
        // ----------------------------------------------------------
        AttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AttendancePage();
                frame.dispose();
            }
        });

        cafeFoodsButton = new ButtonStyle();
        cafeFoodsButton.setText("Cafe Foods");
        cafeFoodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FoodListPage();
                frame.dispose();
            }
        });
        // --------------------------------------------------
        centerPanel = new JPanel(); // the panel that is going to be edited in the children classes
        // --------------------------------------------------

        InventoryManagementButton = new ButtonStyle();
        InventoryManagementButton.setText("Inventory Management");

        pollButton = new ButtonStyle();
        pollButton.setText("Poll");

        studentButton = new ButtonStyle();
        studentButton.setText("Student Feedback");

        generalInformationButton = new ButtonStyle();
        generalInformationButton.setText("General Information");

        peakTimeAnalysisButton = new ButtonStyle();
        peakTimeAnalysisButton.setText("Peak Time Analysis");
        // -----------------------------------------------------------------
        // creates the Title at the top of the frame
        CafeManagementLabel = new JLabel();
        CafeManagementLabel.setText("Cafe Management System");
        CafeManagementLabel.setForeground(Color.WHITE);
        CafeManagementLabel.setFont(new Font("Garamond", 2, 28));
        Border labelBorder = new EmptyBorder(15, 15, 15, 15);
        CafeManagementLabel.setBorder(labelBorder);

        topPanel = new JPanel(); // self discriptive
        topPanel.setBackground(new Color(46, 5, 74));
        topPanel.add(CafeManagementLabel, SwingConstants.CENTER);
        // adds the buttons on the right side of the frame
        // -----------------------------------------------------------
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(7, 1, 10, 10));
        rightPanel.add(AttendanceButton);
        rightPanel.add(peakTimeAnalysisButton);
        rightPanel.add(cafeFoodsButton);
        rightPanel.add(InventoryManagementButton);
        rightPanel.add(pollButton);
        rightPanel.add(studentButton);
        rightPanel.add(generalInformationButton);
        rightPanel.setBackground(new Color(46, 5, 74));
        // ---------------------------------------------------------
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(new Color(46, 5, 74));
        frame.setLocationRelativeTo(null);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(rightPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setBackground(new Color(185, 185, 185));
        frame.setVisible(true);
        frame.setResizable(true);

    }
}
