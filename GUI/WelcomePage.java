package GUI;
<<<<<<< HEAD
=======

import java.awt.Dimension;
>>>>>>> b87bf9cd95a0128fbd9f54f6775a27dde9bb2bc1

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
<<<<<<< HEAD
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
    protected JButton TimeLineButton;
    protected JButton InventoryManagementButton;
    protected JButton pollButton;
    protected JButton studentButton;
    protected JButton generalInformationButton;
    WelcomePage(){
        initialize();
    }
    private void initialize(){
        AttendanceButton = new ButtonStyle();
        AttendanceButton.setText("Attendance Chekcer");

        cafeFoodsButton = new ButtonStyle();
        cafeFoodsButton.setText("Cafe Foods");

        TimeLineButton = new ButtonStyle();
        TimeLineButton.setText("Inventory Management");
        
        InventoryManagementButton = new ButtonStyle();
        InventoryManagementButton.setText("Inventory Management");

        pollButton = new ButtonStyle();
        pollButton.setText("Poll");

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);

        studentButton = new ButtonStyle();
        studentButton.setText("Student Feedback");

        generalInformationButton = new ButtonStyle();
        generalInformationButton.setText("General Information");

        peakTimeAnalysisButton = new ButtonStyle();
        peakTimeAnalysisButton.setText("Peak Time Analysis");
        
        CafeManagementLabel = new JLabel();
        CafeManagementLabel.setText("Cafe Management System");
        CafeManagementLabel.setFont(new Font("Garamond", 2, 28));
        Border labelBorder = new EmptyBorder(15,15,15,15);
        CafeManagementLabel.setBorder(labelBorder);

        topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 153, 153));
        topPanel.add(CafeManagementLabel,SwingConstants.CENTER);
        
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(8, 1, 10, 10));
        rightPanel.add(AttendanceButton);
        rightPanel.add(peakTimeAnalysisButton);
        rightPanel.add(cafeFoodsButton);
        rightPanel.add(TimeLineButton);
        rightPanel.add(InventoryManagementButton);
        rightPanel.add(pollButton);
        rightPanel.add(studentButton);
        rightPanel.add(generalInformationButton);
    
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(new BorderLayout(10,10));
        frame.setLocationRelativeTo(null);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(rightPanel,BorderLayout.WEST);
        frame.add(centerPanel,BorderLayout.CENTER);
        frame.setBackground(new Color(185,185,185));
        frame.setVisible(true);
=======

public class WelcomePage {
    private JFrame frame = new JFrame();

    WelcomePage() {
        // creates an empty page for the admin "to be customized:)"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println("FIkr is the smartest person i know");
>>>>>>> b87bf9cd95a0128fbd9f54f6775a27dde9bb2bc1

    }
}

