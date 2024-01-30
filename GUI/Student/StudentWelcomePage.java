package GUI.Student;

import GUI.Admin.FoodListPageFolder.NewFoodListPage;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StudentWelcomePage extends JFrame {
    JTabbedPane tabbedPane;
    JPanel Foodpanel;
    JPanel pollpanel;
    JPanel ratePanel;
    ButtonGroup rateButtons;
    StudentWelcomePage(){
        initialize();
    }
    private void initialize(){

        Foodpanel = new JPanel();
        Foodpanel.setLayout(new BorderLayout());
        Foodpanel.add(new NewFoodListPage().NewFoodListPage(),BorderLayout.CENTER);

        pollpanel = new JPanel();
        pollpanel.setBorder(new LineBorder(Color.BLACK,2,true));
        pollpanel.add(new StudentPollPanel().StudentPollPanel());

        JRadioButton one = RatingIcon.getIcon(1);
        JRadioButton two = RatingIcon.getIcon(2);
        JRadioButton three = RatingIcon.getIcon(3);
        JRadioButton four = RatingIcon.getIcon(4);
        JRadioButton five = RatingIcon.getIcon(5);

        rateButtons = new ButtonGroup();
        rateButtons.add(one);
        rateButtons.add(two);
        rateButtons.add(three);
        rateButtons.add(four);
        rateButtons.add(five);

        ratePanel = new JPanel();
        ratePanel.setLayout(new GridLayout(5,1));
        ratePanel.add(one);
        ratePanel.add(two);
        ratePanel.add(three);
        ratePanel.add(four);
        ratePanel.add(five);
        ratePanel.setBackground(Color.YELLOW);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Food Lists", Foodpanel);
        tabbedPane.addTab("Student poll", pollpanel);
        tabbedPane.addTab("Rate Cafe", ratePanel);

        add(tabbedPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new StudentWelcomePage();
    }
}
