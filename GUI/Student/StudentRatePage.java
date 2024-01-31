package GUI.Student;
import Database.ConnectionWithDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRatePage extends JFrame implements ActionListener {
    JPanel ratePanel;
    JPanel topPanel;
    JLabel label_1;
    ButtonGroup rateButtons;
    JRadioButton one;
    JRadioButton two;
    JRadioButton three;
    JRadioButton four;
    JRadioButton five;
    JMenu Menu;
    JMenuBar MenuBar;
    StudentRatePage(){

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
        ratePanel.setBackground(new Color(11,11,11));

        label_1 = new JLabel("Rate the cafe");
        label_1.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        label_1.setForeground(Color.BLACK);
        label_1.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel = new JPanel();
        topPanel.add(label_1);

        MenuBar = new JMenuBar();
        Menu = new JMenu("Menu");
        JMenuItem homeMenuItem = new JMenuItem("Home");
        MenuBar.add(Menu);
        Menu.add(homeMenuItem);
        // Add action listeners to menu items
        homeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomePageForStudents();
                dispose();
            }
        });
        setSize(600,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5,5));
        add(ratePanel,BorderLayout.CENTER);
        add(topPanel,BorderLayout.NORTH);
        setJMenuBar(MenuBar);
        setLocationRelativeTo(null);
        setVisible(true);
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

    public static void main(String[] args) {
        new StudentRatePage();
    }
}
