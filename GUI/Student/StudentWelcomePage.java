package GUI.Student;

import GUI.Admin.FoodListPageFolder.NewFoodListPage;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StudentWelcomePage extends JFrame {
    JTabbedPane tabbedPane;
    JPanel Foodpanel;
    JPanel pollpanel;

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

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Food Lists", Foodpanel);
        tabbedPane.addTab("Student poll", pollpanel);

        //create a menu bar
        JMenuBar MenuBar = new JMenuBar();

        //Create a menu
        JMenu Menu = new JMenu("Menu");

        // Create menu items
        JMenuItem logOutMenuItem = new JMenuItem("logOut");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        Menu.add(logOutMenuItem);
        Menu.add(exitMenuItem);

        MenuBar.add(Menu);
        setJMenuBar(MenuBar);
        add(tabbedPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new StudentWelcomePage();
    }
}
