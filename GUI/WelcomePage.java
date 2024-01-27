package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
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
    public JPanel centerPanel;
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
                new NewFoodListPage();
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
        pollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PollPage();
                frame.dispose();
            }
        });

        studentButton = new ButtonStyle();
        studentButton.setText("Student Feedback");

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
        public void actionPerformed(ActionEvent e){
            new peakTimeAnalysisPage();
            frame.dispose();
        }
        });
       
        // -----------------------------------------------------------------
        // creates the Title and Icon at the top of the frame
        ImageIcon logo = new ImageIcon("C:\\6kiloCafeProject\\GUI\\icons\\restaurant.png");
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
        topPanel.add(CafeManagementLabel, SwingConstants.CENTER);
        // adds the buttons on the right side of the frame
        // -----------------------------------------------------------
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(7, 1, 10, 10));
        JButton[] buttonGroup = {AttendanceButton,peakTimeAnalysisButton,cafeFoodsButton,InventoryManagementButton,pollButton,studentButton,generalInformationButton};
        for(int i = 0;i<7;i++){
            rightPanel.add(buttonGroup[i]);
        }
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
        frame.setBackground(new Color(185, 185, 185));
        frame.setResizable(true);;
        frame.setVisible(true);
    }
}
