package GUI.Student;

import GUI.Admin.FoodListPageFolder.FoodIcon;

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
	public static String[][] imagepath = {{"GUI/icons/Firfir.png","GUI/icons/aynet.png","GUI/icons/cake.jpg"},{"GUI/icons/bread.jpg","GUI/icons/sigawot.jpg","GUI/icons/dinch.png"},
			{"GUI/icons/firfir.png","GUI/icons/dinch.png","GUI/icons/sigawot.png"},{"GUI/icons/firfir.png","GUI/icons/dinch.png","GUI/icons/sigawot.png"},{"GUI/icons/firfir.png","GUI/icons/dinch.png","GUI/icons/sigawot.png"},
			{"GUI/icons/firfir.png","GUI/icons/dinch.png","GUI/icons/sigawot.png"},{"GUI/icons/firfir.png","GUI/icons/dinch.png","GUI/icons/sigawot.png"},};

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
        //--------------------------------------------------------------------------------------------
        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel(topSection[i], SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border for clarity
            this.add(label);                                   //Top section it is constant
        }
		//---------------------------------------------------------------------------------------------
		//need which day it is
		for(int i = 0;i<3;i++){
			JLabel label = new JLabel();
			label.setIcon(FoodIcon.scaledIcon(imagepath[NewFoodListPage.daynum][i]));
			label.setHorizontalAlignment(JLabel.CENTER);                        //Middle section changes the image
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.add(label);
        }
		for(int i=0;i<3;i++){
			JLabel namelabel = new JLabel(bottomSection[i], SwingConstants.CENTER);
			namelabel.setFont(new Font("Helvetica",Font.BOLD,25));
			namelabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border for clarity
			this.add(namelabel);
		}


	}
	/*public static String getFoodImage(int date,int mealtime){
		return imagepath[date][mealtime];
	}
	public static void setFoodImage(int date,int mealtime,String path){
		imagepath[date][mealtime] = path;
	}*/
}
