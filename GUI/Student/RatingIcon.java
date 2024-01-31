package GUI.Student;

import javax.swing.*;
import java.awt.*;

public class RatingIcon {
    public static JRadioButton getIcon(int starNum) {
        JRadioButton ratingIcon = new JRadioButton();
        if (starNum == 1) {
            ratingIcon.setText("⭐️");
        } else if (starNum == 2) {
            ratingIcon.setText("⭐️⭐️");
        } else if (starNum == 3) {
            ratingIcon.setText("⭐️⭐️⭐️");
        } else if (starNum == 4) {
            ratingIcon.setText("⭐️⭐️⭐️⭐️");
        } else if (starNum == 5) {
            ratingIcon.setText("⭐️⭐️⭐️⭐️⭐️");
        }
        ratingIcon.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        ratingIcon.setForeground(Color.YELLOW);
        ratingIcon.setHorizontalAlignment(SwingConstants.CENTER);
        ratingIcon.setHorizontalTextPosition(SwingConstants.LEADING);
        return ratingIcon;
    }
}