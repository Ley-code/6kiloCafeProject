package GUI;

import javax.swing.*;
import java.awt.*;

public class FoodListPanel extends JPanel {
    public JLabel breakfastImageLabel;
    public JLabel lunchimagLabel;
    public JLabel dinnerImageLabel;
    public JLabel breakfastLabel;
    public JLabel breakfastFoodName;
    public JLabel dinnerFoodName;
    public JLabel lunchFoodName;

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
        breakfastLabel = new JLabel("Breakfast");
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

        // -----------------------------------------------------------------------

        breakfastImageLabel = new JLabel();
        breakfastImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        breakfastImageLabel.setBackground(new Color(46, 5, 74));
        breakfastImageLabel.setOpaque(true);
        constraints.gridx = 0; // row2 col1
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 5.0;
        constraints.weighty = 5.0;
        this.add(breakfastImageLabel, constraints);
        // breakfast
        // -------------------------------------------------------------------------

        breakfastFoodName = new JLabel();
        breakfastFoodName.setFont(new Font("Times New Roman", 1, 25));
        breakfastFoodName.setForeground(Color.BLACK);
        breakfastFoodName.setBackground(new Color(131, 30, 199));
        breakfastFoodName.setOpaque(true);
        breakfastFoodName.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 2; // row3 col1
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        this.add(breakfastFoodName, constraints);
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
        lunchimagLabel = new JLabel();
        lunchimagLabel.setBackground(new Color(46, 5, 74));
        lunchimagLabel.setOpaque(true);
        lunchimagLabel.setHorizontalAlignment(SwingConstants.CENTER);

        constraints.gridx = 1;
        constraints.gridy = 1; // row2 col2
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 5.0;
        constraints.weighty = 5.0;
        this.add(lunchimagLabel, constraints);
        // lunch
        // -------------------------------------------------------------------------
        lunchFoodName = new JLabel();
        lunchFoodName.setFont(new Font("Times New Roman", 1, 25));
        lunchFoodName.setForeground(Color.BLACK);
        lunchFoodName.setBackground(new Color(131, 30, 199));
        lunchFoodName.setOpaque(true);
        lunchFoodName.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1; // row3 col 2
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
        constraints.gridy = 0; // row1 col 3
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        this.add(dinnerLabel, constraints);
        // -------------------------------------------------------------------------
        dinnerImageLabel = new JLabel();
        dinnerImageLabel.setBackground(new Color(46, 5, 74));
        dinnerImageLabel.setOpaque(true);
        dinnerImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1; // row2 col3
        constraints.gridheight = 1;
        constraints.weightx = 5.0;
        constraints.weighty = 5.0;
        this.add(dinnerImageLabel, constraints);
        // lunch
        // --------------------------------------------
        dinnerFoodName = new JLabel();
        dinnerFoodName.setFont(new Font("Times New Roman", 1, 25));
        dinnerFoodName.setForeground(Color.BLACK);
        dinnerFoodName.setBackground(new Color(131, 30, 199));
        dinnerFoodName.setOpaque(true);
        dinnerFoodName.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 2; // row3 col3
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        this.add(dinnerFoodName, constraints);
    }
}
