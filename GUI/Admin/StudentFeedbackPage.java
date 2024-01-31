package GUI.Admin;

import GUI.Admin.WelcomePage;
import GUI.Student.RatingIcon;
import backEND.backEND;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StudentFeedbackPage extends WelcomePage {
    StudentFeedbackPage(){
        initialize();
    }
    private void initialize(){
        JPanel ratepanel = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        ratepanel.setLayout(new BoxLayout(ratepanel,BoxLayout.Y_AXIS));
        ratepanel.setAlignmentY(SwingConstants.CENTER);
        int rateresult = backEND.CalculateAverageRating();
        JLabel mylabel = new JLabel();
        JLabel mylabel2 = new JLabel(RatingIcon.getIcon(rateresult).getText());

        JPanel mylabel2Container = new JPanel();
        mylabel2.setFont(new Font("Helvici",Font.BOLD,40));//displays the rating
        mylabel2.setForeground(Color.BLACK);
        mylabel2.setBackground(new Color(24, 26, 79));
        mylabel2.setHorizontalAlignment(SwingConstants.CENTER);
        mylabel2Container.setLayout(new FlowLayout(FlowLayout.CENTER));
        mylabel2Container.add(mylabel2);
        mylabel2Container.setBorder(new LineBorder(Color.BLACK,5));

        JPanel mylabelContainer = new JPanel();
        mylabelContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        mylabelContainer.add(mylabel);
        mylabelContainer.setBorder(new LineBorder(Color.BLACK,5));
        mylabel.setText("Rating From Students");
        mylabel.setFont(new Font("Helvici", Font.BOLD,40));                             //displays the rating
        mylabel.setForeground(Color.BLACK);
        mylabel.setBackground(new Color(24, 26, 79));
        mylabel.setHorizontalAlignment(SwingConstants.CENTER);

        ratepanel.setBorder(new LineBorder(Color.BLACK,5,true));
        ratepanel.setBackground(new Color(32,35,133));
        ratepanel.add(mylabelContainer);
        ratepanel.add(mylabel2Container);
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(ratepanel,gbc);
        centerPanel.setBackground(new Color(32,35,133));
    }
}
