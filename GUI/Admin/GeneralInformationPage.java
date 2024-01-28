package GUI.Admin;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GeneralInformationPage extends WelcomePage {
    JLabel AverageStudent;
    JLabel FavoriteFood;
    JLabel BusyDay;
    JLabel LeastFavoriteFood;

    GeneralInformationPage() {
        AverageStudent = new JLabel();
        AverageStudent.setText("Average Students");
        AverageStudent.setForeground(Color.white);
        AverageStudent.setFont(new Font("Helvici", Font.BOLD, 25));
        AverageStudent.setBackground(new Color(24, 26, 79));
        AverageStudent.setOpaque(true);
        AverageStudent.setHorizontalAlignment(SwingConstants.CENTER);
        AverageStudent.setVerticalAlignment(SwingConstants.CENTER);

        FavoriteFood = new JLabel();
        FavoriteFood.setText("Favorite Food");
        FavoriteFood.setFont(new Font("Helvici", Font.BOLD, 25));
        FavoriteFood.setBackground(new Color(24, 26, 79));
        FavoriteFood.setOpaque(true);
        FavoriteFood.setHorizontalAlignment(SwingConstants.CENTER);
        FavoriteFood.setVerticalAlignment(SwingConstants.CENTER);
        FavoriteFood.setForeground(Color.white);

        BusyDay = new JLabel();
        BusyDay.setText("Busy Day");
        BusyDay.setFont(new Font("Helvici", Font.BOLD, 25));
        BusyDay.setBackground(new Color(24, 26, 79));
        BusyDay.setOpaque(true);
        BusyDay.setHorizontalAlignment(SwingConstants.CENTER);
        BusyDay.setVerticalAlignment(SwingConstants.CENTER);
        BusyDay.setForeground(Color.white);

        LeastFavoriteFood = new JLabel();
        LeastFavoriteFood.setText("Least Favorite Food");
        LeastFavoriteFood.setFont(new Font("Helvici", Font.BOLD, 25));
        LeastFavoriteFood.setBackground(new Color(24, 26, 79));
        LeastFavoriteFood.setOpaque(true);
        LeastFavoriteFood.setHorizontalAlignment(SwingConstants.CENTER);
        LeastFavoriteFood.setVerticalAlignment(SwingConstants.CENTER);
        LeastFavoriteFood.setForeground(Color.white);

        centerPanel.setBackground(new Color(32, 35, 133));
        centerPanel.setLayout(new GridLayout(2, 2));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridLayout layout = (GridLayout) centerPanel.getLayout();
        layout.setHgap(10); // Set horizontal gap between cells
        layout.setVgap(10); // Set vertical gap between cell

        centerPanel.add(AverageStudent);
        centerPanel.add(FavoriteFood);
        centerPanel.add(BusyDay);
        centerPanel.add(LeastFavoriteFood);
    }

}
