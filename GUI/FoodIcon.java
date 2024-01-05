package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FoodIcon extends ImageIcon {

    public ImageIcon scaledIcon(String path) {
        ImageIcon myIcon = new ImageIcon(path);
        Image lunchImage = myIcon.getImage();
        Image lunch_scaled = lunchImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        return new ImageIcon(lunch_scaled);
    }
}
