package GUI.Admin;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;

public final class ButtonStyle extends JButton {
    public ButtonStyle(){
        this.setBackground(new Color(32, 35, 133));
        this.setFont(new java.awt.Font("Segoe Print", 2, 14)); 
        this.setForeground(Color.WHITE);
        this.setMargin(new Insets(15, 15, 20, 20));
        this.setFocusable(false);
    }
    public ButtonStyle(String text){
        this.setText(text);
        this.setBackground(new Color(32, 35, 133));
        this.setFont(new java.awt.Font("Segoe Print", 2, 14)); 
        this.setForeground(Color.WHITE);
        this.setMargin(new Insets(15, 15, 20, 20));
        this.setFocusable(false);
    }
        
}
