package GUI.Admin;

import java.awt.*;

import javax.swing.*;
import backEND.backEND;

public class GeneralInformationPage extends WelcomePage {
    JLabel AverageStudent;
    JLabel highestNumber;
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
        JLabel averageValueLabel = new JLabel(""+backEND.averageStudentPresented());//data from backend
        averageValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        averageValueLabel.setVerticalAlignment(SwingConstants.NORTH);
        averageValueLabel.setForeground(Color.WHITE);
        averageValueLabel.setFont(new Font("Helvici",Font.BOLD,20));
        averagePanel.setBackground(new Color(24, 26, 79));
        averagePanel.add(averageValueLabel);
        //----------------------------------------------------------
        highestNumber = new JLabel();
        highestNumber.setText("Highest No of Students");
        highestNumber.setFont(new Font("Helvici", Font.BOLD, 25));
        highestNumber.setBackground(new Color(24, 26, 79));
        highestNumber.setOpaque(true);
        highestNumber.setHorizontalAlignment(SwingConstants.CENTER);
        highestNumber.setVerticalAlignment(SwingConstants.CENTER);
        highestNumber.setForeground(Color.white);
        //----------------------------------------------------------
        JPanel highestPanel = new JPanel();
        highestPanel.setLayout(new GridLayout(2,1));
        highestPanel.add(highestNumber);
        JLabel highestValueLabel = new JLabel(""+backEND.highestNumberOfAtendance());//data from backend
        highestValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        highestValueLabel.setVerticalAlignment(SwingConstants.NORTH);
        highestValueLabel.setForeground(Color.WHITE);
        highestValueLabel.setFont(new Font("Helvici",Font.BOLD,20));
        highestPanel.setBackground(new Color(24, 26, 79));
        highestPanel.add(highestValueLabel);
        //----------------------------------------------------------
        JPanel gridContainer = new JPanel();
        gridContainer.setBackground(new Color(32, 35, 133));
        gridContainer.setLayout(new GridLayout(1, 2,10,10));
        gridContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gridContainer.add(averagePanel);
        gridContainer.add(highestPanel);
        //---------------------------------------------------------------

        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(new Color(32, 35, 133));
        centerPanel.add(gridContainer,BorderLayout.CENTER);
    }

}
