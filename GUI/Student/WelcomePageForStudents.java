package GUI.Student;

import Database.ConnectionWithDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePageForStudents extends JFrame {

    JPanel Panel_1 = new JPanel();
    JPanel Panel_2 = new JPanel();
    JButton PollButton = new JButton("Poll page");
    JButton FoodButton = new JButton("Food Page");
    JButton rateButton = new JButton("Cafe Ratting");
    JLabel label_1 = new JLabel();
    JLabel label_2 = new JLabel("This is a Welcome Page for Students");
    JButton button_4 = new JButton("Poll Page");
    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();

    // Create menus
    JMenu editMenu = new JMenu("Home");
    JMenu fileMenu = new JMenu("Setting");
    JMenu helpMenu = new JMenu("Help");
    JMenu exitMenu = new JMenu("Exit");
    WelcomePageForStudents(){

        Panel_1.setBackground(new Color(179,168,238));

        PollButton.setBackground(new Color(1,0,7));
        PollButton.setForeground(Color.WHITE);
        PollButton.setSize(30,50);
        PollButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        PollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentPollPage();
                dispose();
            }
        });

        FoodButton.setBackground(new Color(1,0,7));
        FoodButton.setForeground(Color.WHITE);
        FoodButton.setSize(30,50);
        FoodButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        FoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectionWithDatabase.imageDisplayExtractor();
                new StudentFoodListPage();
                dispose();
            }
        });

        rateButton.setBackground(new Color(1,0,7));
        rateButton.setForeground(Color.WHITE);
        rateButton.setMargin(new Insets(10,100,100,100));
        rateButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentRatePage();
                dispose();
            }
        });

        setLayout(new BorderLayout(5,10));
        add(Panel_1,BorderLayout.WEST);
        add(Panel_2,BorderLayout.CENTER);
        add(label_2,BorderLayout.NORTH);
        Panel_1.setLayout(new GridLayout(3,1));
        Panel_1.add(PollButton);
        Panel_1.add(FoodButton);
        Panel_1.add(rateButton);
        Panel_2.add(label_1);
        ImageIcon photo = new ImageIcon("GUI\\icons\\cafeImage.jfif");
        label_1.setIcon(photo);
        label_2.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        label_2.setForeground(Color.BLACK);
        label_2.setHorizontalAlignment(SwingConstants.CENTER);

        fileMenu.addSeparator(); // Adds a separator line

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        menuBar.add(exitMenu);

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
/*class ImageLabel extends JLabel {

    private String text;

    public ImageLabel (String imagePath, String text) {
        // Load the image from the file path
        ImageIcon icon = new ImageIcon(imagePath);
        setIcon(icon);
        this.text = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the text on the labeled image
        if (text != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.BLACK); // Set text color
            g2d.setFont(new Font("Arial", Font.BOLD, 30)); // Set font
            int x = 600; // X-coordinate of the text
            int y = getHeight() - 700; // Y-coordinate of the text (adjust as needed)
            g2d.drawString(text, x, y);
            g2d.dispose();
        }
    }
}*/
