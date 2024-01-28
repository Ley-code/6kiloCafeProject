package GUI.Admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PollPage extends WelcomePage {
    JButton setPollButton;
    JLabel descriptionLabel;
    JTextField descriptionField;
    PollPage(){
        setPollButton = new JButton();
        ImageIcon myIcon = new ImageIcon("GUI\\icons\\plus.png");
        Image lunchImage = myIcon.getImage();
        Image lunch_scaled = lunchImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon finalicon = new ImageIcon(lunch_scaled);
        setPollButton.setIcon(finalicon);
        setPollButton.setText("Create Poll");
        setPollButton.setIconTextGap(15);
        setPollButton.setFocusable(false);
        setPollButton.setBackground(new Color(24,122,56));
        setPollButton.setForeground(Color.WHITE);
        setPollButton.setFont(new Font("TimesNewRoman",Font.BOLD,25));

        descriptionField = new JTextField();
        descriptionField.setSize(300,35);
        descriptionLabel = new JLabel();
        descriptionLabel.setText("Description");
        descriptionLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        descriptionLabel.setBorder(new EmptyBorder(0,0,0,30));
        JPanel descriptionholder = new JPanel();
        descriptionholder.setLayout(new GridLayout(1,2));
        descriptionholder.add(descriptionLabel);
        descriptionholder.add(descriptionField);

        
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.add(descriptionholder);


        centerPanel.setLayout(new BorderLayout(10,10));
        centerPanel.add(setPollButton,BorderLayout.NORTH);
        centerPanel.add(descriptionPanel,BorderLayout.CENTER);
        centerPanel.setBackground(new Color(32, 35, 133));

    }

    public static void main(String[] args) {
        new PollPage();
    }
}
