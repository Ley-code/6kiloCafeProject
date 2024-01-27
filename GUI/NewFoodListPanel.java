package GUI;

import java.awt.*;

import javax.swing.*;

public class NewFoodListPanel extends JPanel{
	
	public String[] topSection = {
			"Breakfast", "Lunch", "Dinner"
	};
	
	private String breakfast;
	private String lunch;
	private String dinner; 
	public int count = 0;
	
	NewFoodListPanel(String breakfast, String lunch, String dinner){
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		initialize();
	}
	
	public void initialize() {
		
		String[] bottomSection = {this.breakfast, this.lunch, this.dinner};
		
//		this.setBackground(new Color(46, 5, 74));
        this.setLayout(new GridLayout(3, 3, 10, 10));
        this.setVisible(false);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel(topSection[i], SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border for clarity
            this.add(label);
        }
		String[] imagepath = {"GUI/icons/Firfir.png","GUI/icons/aynet.png","GUI/icons/cake.jpg"};
		FoodIcon myIcon = new FoodIcon();
		for(int i = 0;i<3;i++){
			JLabel label = new JLabel();
			label.setIcon(myIcon.scaledIcon(imagepath[i]));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.add(label);
		}
        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel(bottomSection[i], SwingConstants.CENTER);
			label.setFont(new Font("Helvetica",Font.BOLD,25));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border for clarity
            this.add(label);
        }
}
}
