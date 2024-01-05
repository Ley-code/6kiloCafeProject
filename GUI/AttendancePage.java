package GUI;

import org.jfree.chart.JFreeChart;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTable;

public class AttendancePage extends WelcomePage {
    private JButton myButton = new JButton("Hello it works");;
    private JTable mytable;

    AttendancePage() {
        centerPanel.setBackground(Color.BLUE);
        centerPanel.add(myButton);
        mytable = new JTable();
        centerPanel.add(mytable);
        // ------------------------------------

        // ------------------------------------

    }
}
