package GUI.Student;

import Database.ConnectionWithDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePageForStudents extends JFrame {

    private JPanel buttonPanel = new JPanel();
    private JPanel imagePanel = new JPanel();
    private JButton pollButton = new JButton("Poll Page");
    private JButton foodButton = new JButton("Food Page");
    private JButton cafeRattingButton = new JButton("Cafe Ratting");
    private JLabel imageLabel = new JLabel();
    private JLabel textLabel = new JLabel("This is a Welcome Page for Students");
    private JMenuBar menuBar = new JMenuBar();

    private JMenu homeMenu = new JMenu("Back");
    private JMenuItem homeMenuItem = new JMenuItem("Login Page");

    WelcomePageForStudents() {

        buttonPanel.setBackground(new Color(179, 168, 238));

        pollButton.setBackground(new Color(1, 0, 7));
        pollButton.setForeground(Color.WHITE);
        pollButton.setSize(30, 50);
        pollButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        pollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentPollPage();
                dispose();
            }
        });

        foodButton.setBackground(new Color(1, 0, 7));
        foodButton.setForeground(Color.WHITE);
        foodButton.setSize(30, 50);
        foodButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectionWithDatabase.imageDisplayExtractor();
                new StudentFoodListPage();
                dispose();
            }
        });

        cafeRattingButton.setBackground(new Color(1, 0, 7));
        cafeRattingButton.setForeground(Color.WHITE);
        cafeRattingButton.setMargin(new Insets(10, 100, 100, 100));
        cafeRattingButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        cafeRattingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentRatePage();
                dispose();
            }
        });

        setLayout(new BorderLayout(5, 10));
        add(buttonPanel, BorderLayout.WEST);
        add(imagePanel, BorderLayout.CENTER);
        add(textLabel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(pollButton);
        buttonPanel.add(foodButton);
        buttonPanel.add(cafeRattingButton);
        imagePanel.add(imageLabel);
        ImageIcon photo = new ImageIcon("GUI\\icons\\cafeImage_4.jpg");
        imageLabel.setIcon(photo);
        textLabel.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        textLabel.setForeground(Color.BLACK);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);

        homeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the home panel when "Home" is selected
                new LoginPageForStudent();
                dispose();
            }
        });
        // Add menu to the menu bar
        menuBar.add(homeMenu);

        //Add menuBar to menu
        homeMenu.add(homeMenuItem);

        // Set the menu bar for the JFrame
        setJMenuBar(menuBar);
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new WelcomePageForStudents();
    }
}