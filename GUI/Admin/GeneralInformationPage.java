package GUI.Admin;

import java.awt.*;

import javax.swing.*;

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
        //----------------------------------------------------------
        JPanel averagePanel = new JPanel();
        averagePanel.setLayout(new GridLayout(2,1));
        averagePanel.add(AverageStudent);
        JLabel averageValueLabel = new JLabel(""+"peakTimeAnalysisPage.averageStudentPresented()");//uncomment this
        averageValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        averageValueLabel.setVerticalAlignment(SwingConstants.NORTH);
        averageValueLabel.setForeground(Color.WHITE);
        averageValueLabel.setFont(new Font("Helvici",Font.BOLD,20));
        averagePanel.setBackground(new Color(24, 26, 79));
        averagePanel.add(averageValueLabel);
        //----------------------------------------------------------

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

        JPanel gridContainer = new JPanel();

        gridContainer.setBackground(new Color(32, 35, 133));
        gridContainer.setLayout(new GridLayout(2, 2,10,10));
        gridContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //gridContainer.add(averagePanel); TO BE UNCOMMENTED LATER
        gridContainer.add(AverageStudent);
        gridContainer.add(FavoriteFood);
        gridContainer.add(BusyDay);
        gridContainer.add(LeastFavoriteFood);
        //---------------------------------------------------------------
        JPanel ratepanel = new JPanel();
        int rateresult = peakTimeAnalysisPage.CalculateAverageRating();
        JLabel mylabel = new JLabel();
        mylabel.setText("Rating From Students: "+RatingIcon.getIcon(rateresult).getText());
        mylabel.setFont(new Font("Helvici", Font.BOLD,25));
        mylabel.setOpaque(true);                               //displays the rating
        mylabel.setForeground(Color.YELLOW);
        mylabel.setBackground(new Color(24, 26, 79));
        mylabel.setHorizontalAlignment(SwingConstants.CENTER);
        ratepanel.setBackground(new Color(32,35,133));
        ratepanel.add(mylabel);
        //---------------------------------------------------------------
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(new Color(32, 35, 133));
        centerPanel.add(gridContainer,BorderLayout.CENTER);
        centerPanel.add(ratepanel,BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        new GeneralInformationPage();
    }

}
