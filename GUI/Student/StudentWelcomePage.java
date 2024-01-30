package GUI.Student;

import Database.ConnectionWithDatabase;
import GUI.Admin.FoodListPageFolder.NewFoodListPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentWelcomePage extends JFrame implements ActionListener {
    JTabbedPane tabbedPane;
    JPanel Foodpanel;
    JPanel pollpanel;
    JPanel ratePanel;
    ButtonGroup rateButtons;
    JRadioButton one;
    JRadioButton two;
    JRadioButton three;
    JRadioButton four;
    JRadioButton five;
    StudentWelcomePage(){
        initialize();
    }
    private void initialize(){

        Foodpanel = new JPanel();
        Foodpanel.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(new NewFoodListPage().NewFoodListPage());
        Foodpanel.add(scrollPane,BorderLayout.CENTER);


        pollpanel =new NewStudentPollPanel().NewStudentPollPanel();
        one = RatingIcon.getIcon(1);
        one.addActionListener(this);
        two = RatingIcon.getIcon(2);
        two.addActionListener(this);
        three = RatingIcon.getIcon(3);
        three.addActionListener(this);
        four = RatingIcon.getIcon(4);
        four.addActionListener(this);
        five = RatingIcon.getIcon(5);
        five.addActionListener(this);

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
    @Override
    public void actionPerformed(ActionEvent e) {
        //---------------------------------------------------------------------
        if(e.getSource()==one){
            ConnectionWithDatabase.addRating(1);
        } else if(e.getSource()==two){
            ConnectionWithDatabase.addRating(2);
        } else if (e.getSource()==three) {                      //sends the rating to the database
            ConnectionWithDatabase.addRating(3);
        } else if (e.getSource()==four) {
            ConnectionWithDatabase.addRating(4);
        } else if (e.getSource()==five) {
            ConnectionWithDatabase.addRating(5);
        }
        //---------------------------------------------------------------------
    }
}
