package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NewFoodListPage extends WelcomePage{
    private JButton mondayButton;
    private JButton tuesdayButton;
    private JButton wednesdayButton;
    private JButton thursdayButton;
    private JButton fridayButton;
    private JButton saturdayButton;
    private JButton sundayButton;

    public static void main(String[] args) {
    	new NewFoodListPage();
    }
    
    NewFoodListPage() {
        initialize();
    }

    private void initialize() {
        frame.setResizable(true);
        
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
        
        NewFoodListPanel mondayPanel = new NewFoodListPanel("Firfir", "aynet", "cake");
        NewFoodListPanel tuesdayPanel = new NewFoodListPanel("Bread with marmlade","alicha", "siga wot");
        NewFoodListPanel wednesdayPanel = new NewFoodListPanel("firfir", "dinch wot", "siga wot");
        
        // Create a list of panels to use when setting one visible over the others
        ArrayList<NewFoodListPanel> dayPanels = new ArrayList<NewFoodListPanel>();
        dayPanels.add(mondayPanel);
        dayPanels.add(tuesdayPanel);
        dayPanels.add(wednesdayPanel);
        
        // Set actions for the buttons
        
        mondayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mondayPanel.count % 2 == 0) {
                    displayDayPanel(dayPanels, mondayPanel);
                    
                } else {
                    hideDayPanel(mondayPanel);
                }
            }
        });
        tuesdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tuesdayPanel.count % 2 == 0) {                   
                    displayDayPanel(dayPanels, tuesdayPanel);

                } else {
                    hideDayPanel(tuesdayPanel);
                }
            }
        });
        wednesdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wednesdayPanel.count % 2 == 0) {                   
                    displayDayPanel(dayPanels, wednesdayPanel);

                } else {
                    hideDayPanel(wednesdayPanel);
                }
            }
        });

        // -------------------------------------------
        
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        for (int i = 0; i < dayPanels.size(); i++) {
        	centerPanel.add(dayButtons.get(i));
        	centerPanel.add(dayPanels.get(i));
        }
        
        centerPanel.setBackground(new Color(46, 5, 74));

    }

    
    public void displayDayPanel(ArrayList<NewFoodListPanel> dayPanels, NewFoodListPanel dayPanel) {
    	
    	for (int i = 0; i < dayPanels.size(); i++) {
    		NewFoodListPanel current = dayPanels.get(i);
    		
    		if (dayPanels.get(i) == dayPanel) {
    			current.count = 1;
    			current.setVisible(true);
    		} else {
    			current.count = 0;
    			current.setVisible(false);
    		}
    	}
    }
    
    public void hideDayPanel(NewFoodListPanel dayPanel) {
    	
		dayPanel.count = 0;
		dayPanel.setVisible(false);

    }
    
    public void resizeButton(ArrayList<JButton> dayButtons) {
    	
    	// DOESN'T WORK YET BUT IT IS GOING TO BE USED TO RESIZE THE BUTTONS FOR WHEN THEY ARE CLICKED
    	// It is a bug I will fix later.
    	
        for (int i = 0; i < dayButtons.size(); i++) {
        	dayButtons.get(i).setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        }
    }

}
