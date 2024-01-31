package GUI.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFoodListPage extends JFrame {
    JTabbedPane tabbedPane;
    JPanel Foodpanel;
    JPanel pollpanel;

    StudentFoodListPage(){
        initialize();
    }
    private void initialize(){

        Foodpanel = new JPanel();
        Foodpanel.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(new NewFoodListPage().NewFoodListPage());
        Foodpanel.add(scrollPane,BorderLayout.CENTER);

        //create a menu bar
        JMenuBar MenuBar = new JMenuBar();

        //Create a menu
        JMenu Menu = new JMenu("Menu");

        // Create menu items
        JMenuItem homeMenuItem = new JMenuItem("Home");
        homeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the home panel when "Home" is selected
                new WelcomePageForStudents();
                dispose();
            }
        });
        Menu.add(homeMenuItem);

        MenuBar.add(Menu);
        setJMenuBar(MenuBar);
        add(Foodpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new StudentFoodListPage();
    }
}
