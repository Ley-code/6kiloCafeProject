package GUI.Student;

import Database.ConnectionWithDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePageForStudents extends JFrame {

    JPanel buttonPanel = new JPanel();
    JPanel imagePanel = new JPanel();
    JButton pollButton = new JButton("Poll Page");
    JButton foodButton = new JButton("Food Page");
    JButton cafeRattingButton = new JButton("Cafe Ratting");
    JLabel imageLabel = new JLabel();
    JLabel textLabel = new JLabel("This is a Welcome Page for Students");
    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();

    // Create menu
    JMenu helpMenu = new JMenu("Help");
    JMenu exitMenu = new JMenu("Exit");
    WelcomePageForStudents(){

        buttonPanel.setBackground(new Color(179,168,238));

        pollButton.setBackground(new Color(1,0,7));
        pollButton.setForeground(Color.WHITE);
        pollButton.setSize(30,50);
        pollButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        pollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentPollPage();
                dispose();
            }
        });

        foodButton.setBackground(new Color(1,0,7));
        foodButton.setForeground(Color.WHITE);
        foodButton.setSize(30,50);
        foodButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectionWithDatabase.imageDisplayExtractor();
                new StudentFoodListPage();
                dispose();
            }
        });

        cafeRattingButton.setBackground(new Color(1,0,7));
        cafeRattingButton.setForeground(Color.WHITE);
        cafeRattingButton.setMargin(new Insets(10,100,100,100));
        cafeRattingButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        cafeRattingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentRatePage();
                dispose();
            }
        });

        setLayout(new BorderLayout(5,10));
        add(buttonPanel,BorderLayout.WEST);
        add(imagePanel,BorderLayout.CENTER);
        add(textLabel,BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(3,1));
        buttonPanel.add(pollButton);
        buttonPanel.add(foodButton);
        buttonPanel.add(cafeRattingButton);
        imagePanel.add(imageLabel);
        ImageIcon photo = new ImageIcon("GUI\\icons\\cafeImage.jfif");
        imageLabel.setIcon(photo);
        textLabel.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        textLabel.setForeground(Color.BLACK);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add menus to the menu bar

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
