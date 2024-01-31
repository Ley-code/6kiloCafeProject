package GUI.Admin.FoodListPageFolder;
import java.awt.Image;

import javax.swing.ImageIcon;
public class FoodIcon extends ImageIcon {

    public static ImageIcon scaledIcon(String path) {
        ImageIcon myIcon = new ImageIcon(path);
        Image lunchImage = myIcon.getImage();
        Image lunch_scaled = lunchImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        return new ImageIcon(lunch_scaled);
    }
    public static ImageIcon scaledIcon(String path,int width,int height){
        ImageIcon myIcon = new ImageIcon(path);
        Image lunchImage = myIcon.getImage();
        Image lunch_scaled = lunchImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(lunch_scaled);
    }
}
//this class scales the image based on the user input or if there is no user input by default sets the size 150 by 150
