package GUI;

import javax.swing.*;
import java.awt.*;

public class FoodListPanel extends JPanel {
    public JLabel imagLabel;
    FoodListPanel() {
        initialize();
    }

    private void initialize() {
        this.setBackground(new Color(46, 5, 74));
        this.setLayout(new GridBagLayout());
        this.setVisible(false);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets.top = 5;
        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.fill = GridBagConstraints.BOTH;
        // ------------------------------------------------------------------------
        JLabel breakfastLabel = new JLabel("Breakfast");
        breakfastLabel.setFont(new Font("Times New Roman", 1, 25));
        breakfastLabel.setForeground(Color.WHITE);
        breakfastLabel.setBackground(new Color(131, 30, 199));
        breakfastLabel.setOpaque(true);
        breakfastLabel.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 0; // row1 column1
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        this.add(breakfastLabel, constraints);

        // ------------------------------------------------------------------------
        ImageIcon breakfastIcon = new ImageIcon("C:\\6kiloCafeProject\\GUI\\icons\\firfir.png");
        Image image = breakfastIcon.getImage();
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        imagLabel = new JLabel();
        imagLabel.setIcon(scaledIcon);
        imagLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagLabel.setBackground(new Color(46, 5, 74));
        imagLabel.setOpaque(true);
        constraints.gridx = 0; // row2 col1
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 5.0;
        constraints.weighty = 5.0;
        this.add(imagLabel, constraints);
        // breakfast
        // -------------------------------------------------------------------------

        JLabel Foodname = new JLabel("FirFir");
        Foodname.setFont(new Font("Times New Roman", 1, 25));
        Foodname.setForeground(Color.BLACK);
        Foodname.setBackground(new Color(131, 30, 199));
        Foodname.setOpaque(true);
        Foodname.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 2; // row3 col1
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        this.add(Foodname, constraints);
        // -------------------------------------------------------------------------
        JLabel lunchLabel = new JLabel("Lunch");
        lunchLabel.setFont(new Font("Times New Roman", 1, 25));
        lunchLabel.setForeground(Color.WHITE);
        lunchLabel.setBackground(new Color(131, 30, 199));
        lunchLabel.setOpaque(true);
        lunchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 1;
        constraints.gridy = 0; // row1 col2
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        this.add(lunchLabel, constraints);
        // -------------------------------------------------------------------------
        ImageIcon lunchIcon = new ImageIcon("C:\\6kiloCafeProject\\GUI\\icons\\alicha.png");
        Image lunchImage = lunchIcon.getImage();
        Image lunchscaled = lunchImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon lunchscaledIcon = new ImageIcon(lunchscaled);
        JLabel lunchimagLabel = new JLabel();
        lunchimagLabel.setBackground(new Color(46, 5, 74));
        lunchimagLabel.setOpaque(true);
        lunchimagLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lunchimagLabel.setIcon(lunchscaledIcon);
        constraints.gridx = 1;
        constraints.gridy = 1;                         //row2 col2
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 5.0;
        constraints.weighty = 5.0;
        this.add(lunchimagLabel, constraints);
        // lunch
              // -------------------------------------------------------------------------
        JLabel lunchFoodName = new JLabel("Alicha Wot");
        lunchFoodName.setFont(new Font("Times New Roman", 1, 25));
        lunchFoodName.setForeground(Color.BLACK);
        lunchFoodName.setBackground(new Color(131, 30, 199));
        lunchFoodName.setOpaque(true);
        lunchFoodName.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;                    //row3 col2
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        this.add(lunchFoodName, constraints);
        // -------------------------------------------------------------------------
        JLabel dinnerLabel = new JLabel("Dinner");
        dinnerLabel.setFont(new Font("Times New Roman", 1, 25));
        dinnerLabel.setForeground(Color.WHITE);
        dinnerLabel.setBackground(new Color(131, 30, 199));
        dinnerLabel.setOpaque(true);
        dinnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        this.add(dinnerLabel, constraints);
         // -------------------------------------------------------------------------
        ImageIcon dinnerIcon = new ImageIcon("C:\\6kiloCafeProject\\GUI\\icons\\dinch.png");
        Image dinnerImage = dinnerIcon.getImage();
        Image dinnerScaled = dinnerImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon dinnerScaledIcon = new ImageIcon(dinnerScaled);
        JLabel dinnerImageLabel = new JLabel();
        dinnerImageLabel.setBackground(new Color(46, 5, 74));
        dinnerImageLabel.setOpaque(true);
        dinnerImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dinnerImageLabel.setIcon(dinnerScaledIcon);
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 5.0;
        constraints.weighty = 5.0;
        this.add(dinnerImageLabel, constraints);
        // lunch
        // --------------------------------------------
        JLabel dinnerFoodName = new JLabel("Dinch Wot");
        dinnerFoodName.setFont(new Font("Times New Roman", 1, 25));
        dinnerFoodName.setForeground(Color.BLACK);
        dinnerFoodName.setBackground(new Color(131, 30, 199));
        dinnerFoodName.setOpaque(true);
        dinnerFoodName.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        this.add(dinnerFoodName, constraints);
    }
}
