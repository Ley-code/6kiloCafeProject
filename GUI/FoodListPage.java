package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class FoodListPage extends WelcomePage {
    private JButton mondayButton;
    private JButton tuesdayButton;
    private JButton wednesdayButton;
    private int count = 0;
    private int countT = 0;
    private int countW = 0;

    FoodListPage() {
        initialize();
    }

    private void initialize() {
        frame.setResizable(false);
        mondayButton = new ButtonStyle("Monday");
        mondayButton.setBounds(0, 0, 800, 30);
        tuesdayButton = new ButtonStyle("Tuesday");
        tuesdayButton.setBounds(0, 30, 800, 30);
        wednesdayButton = new ButtonStyle("Wednesday");
        wednesdayButton.setBounds(0, 60, 800, 30);
        // -----------------------------------
        FoodListPanel mondayPanel = new FoodListPanel();
        mondayPanel.imagLabel.setText("no bebe");
        FoodListPanel TuesdayPanel = new FoodListPanel();
        FoodListPanel wednesdaypanel = new FoodListPanel();
        // --------------------------------------
        TuesdayPanel.setBounds(0, 60, 800, 200);
        mondayPanel.setBounds(0, 30, 800, 200);
        wednesdaypanel.setBounds(0, 90, 800, 200);
        mondayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count % 2 == 0) {
                    tuesdayButton.setBounds(0, 230, 800, 30);
                    wednesdayButton.setBounds(0, 260, 800, 30);
                    count++;
                    // mondaypanel.setVisible(true);
                    mondayPanel.setVisible(true);
                    TuesdayPanel.setVisible(false);
                    wednesdaypanel.setVisible(false);
                } else {
                    tuesdayButton.setBounds(0, 30, 800, 30);
                    wednesdayButton.setBounds(0, 60, 800, 30);
                    count++;
                    // mondaypanel.setVisible(false);
                    mondayPanel.setVisible(false);
                }
            }
        });
        tuesdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countT % 2 == 0) {
                    tuesdayButton.setBounds(0, 30, 800, 30);
                    wednesdayButton.setBounds(0, 260, 800, 30);
                    countT++;
                    TuesdayPanel.setVisible(true);
                    wednesdaypanel.setVisible(false);
                    mondayPanel.setVisible(false);
                } else {
                    wednesdayButton.setBounds(0, 60, 800, 30);
                    countT++;
                    TuesdayPanel.setVisible(false);
                }
            }
        });
        wednesdayButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (countW % 2 == 0) {

                    countW++;
                    wednesdaypanel.setVisible(true);
                    TuesdayPanel.setVisible(false);
                    mondayPanel.setVisible(false);
                    tuesdayButton.setBounds(0, 30, 800, 30);
                    wednesdayButton.setBounds(0, 60, 800, 30);
                } else {
                    countW++;
                    wednesdaypanel.setVisible(false);
                }
            }

        });

        // -------------------------------------------
        centerPanel.setLayout(null);
        // centerPanel.add(mondaypanel);
        centerPanel.add(mondayButton);
        centerPanel.add(tuesdayButton);
        centerPanel.add(wednesdayButton);
        centerPanel.add(mondayPanel);
        centerPanel.add(TuesdayPanel);
        centerPanel.add(wednesdaypanel);

    }

    public static void main(String[] args) {
        new FoodListPage();
    }
}
