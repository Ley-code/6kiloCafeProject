package GUI.Student;

import GUI.Admin.ButtonStyle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class NewFoodListPage {
    private JButton mondayButton;
    private JButton tuesdayButton;
    private JButton wednesdayButton;
    private JButton thursdayButton;
    private JButton fridayButton;
    private JButton saturdayButton;
    private JButton sundayButton;
    private JPanel centerPanel;
    public static String[][] FoodNames = {{"Firfir","Aynet","cake"},{"Bread with marmlade","alicha", "siga wot"},{"firfir", "dinch wot", "siga wot"},
            {"Kinche","Key wot","ThereFore"},{"Burger","salad","pizza"},{"amrogn","chicken","shiro wot"},{"Enkulal","French fries","Rice"}};
    public static int daynum = 0;
    public static void main(String[] args) {
    	new NewFoodListPage();
    }

    public JPanel NewFoodListPage() {
        mondayButton = new ButtonStyle("Monday");
        tuesdayButton = new ButtonStyle("Tuesday");
        wednesdayButton = new ButtonStyle("Wednesday");
        thursdayButton = new ButtonStyle("Thursday");
        fridayButton = new ButtonStyle("Friday");
        saturdayButton = new ButtonStyle("Saturday");
        sundayButton = new ButtonStyle("Sunday");
        // -----------------------------------
        ArrayList<JButton> dayButtons = new ArrayList<JButton>();
        dayButtons.add(mondayButton);
        dayButtons.add(tuesdayButton);
        dayButtons.add(wednesdayButton);
        dayButtons.add(thursdayButton);
        dayButtons.add(fridayButton);
        dayButtons.add(saturdayButton);
        dayButtons.add(sundayButton);
        // -----------------------------------
        for (int i = 0; i < dayButtons.size(); i++) {
        	dayButtons.get(i).setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        }
        // -----------------------------------
        ArrayList<NewFoodListPanel> dayPanels = new ArrayList<NewFoodListPanel>();
        for(int i = 0;i< 7;i++){ //for the seven days
                daynum = i;
                NewFoodListPanel dayPanel = new NewFoodListPanel(FoodNames[i][0], FoodNames[i][1],FoodNames[i][2]);
                dayPanels.add(dayPanel);

            }
        // Set actions for the buttons
        mondayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dayPanels.get(0).count % 2 == 0) {
                    displayDayPanel(dayPanels, dayPanels.get(0));
                    
                } else {
                    hideDayPanel(dayPanels.get(0));
                }
            }
        });
        tuesdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dayPanels.get(1).count % 2 == 0) {
                    displayDayPanel(dayPanels, dayPanels.get(1));

                } else {
                    hideDayPanel(dayPanels.get(1));
                }
            }
        });
        wednesdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dayPanels.get(2).count % 2 == 0) {
                    displayDayPanel(dayPanels, dayPanels.get(2));

                } else {
                    hideDayPanel(dayPanels.get(2));
                }
            }
        });
        thursdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dayPanels.get(3).count % 2 == 0) {
                    displayDayPanel(dayPanels, dayPanels.get(3));

                } else {
                    hideDayPanel(dayPanels.get(3));
                }

            }
        });
        fridayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dayPanels.get(4).count % 2 == 0) {
                    displayDayPanel(dayPanels, dayPanels.get(4));

                } else {
                    hideDayPanel(dayPanels.get(4));
                }

            }
        });
        saturdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dayPanels.get(5).count % 2 == 0) {
                    displayDayPanel(dayPanels, dayPanels.get(5));

                } else {
                    hideDayPanel(dayPanels.get(5));
                }

            }
        });
        sundayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dayPanels.get(6).count % 2 == 0) {
                    displayDayPanel(dayPanels, dayPanels.get(6));

                } else {
                    hideDayPanel(dayPanels.get(6));
                }

            }
        });
        // -------------------------------------------
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        for (int i = 0; i < dayPanels.size(); i++) {
        	centerPanel.add(dayButtons.get(i));
        	centerPanel.add(dayPanels.get(i));
        }
        
        centerPanel.setBackground(new Color(46, 5, 74));
        return centerPanel;
    }
    public static void setFoodName(int date,int mealtime,String foodName){
        FoodNames[date][mealtime] = foodName;
    }
    public static String getFoodName(int date, int mealtime){
        return FoodNames[date][mealtime];
    }
    public void displayDayPanel(ArrayList<NewFoodListPanel> dayPanels, NewFoodListPanel dayPanel) {
    	for (int i = 0; i < dayPanels.size(); i++) {
    		NewFoodListPanel current = dayPanels.get(i);
    		if (dayPanels.get(i) == dayPanel) {
    			current.count = 1;
    			current.setVisible(true);
    		}else {
    			current.count = 0;
    			current.setVisible(false);
    		}
    	}

    }
    public void hideDayPanel(NewFoodListPanel dayPanel) {
		dayPanel.count = 0;
		dayPanel.setVisible(false);
    }

}
