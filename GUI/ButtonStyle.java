package GUI;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;

public final class ButtonStyle extends JButton {
    ButtonStyle(){
        this.setBackground(new Color(46, 5, 74));
        this.setFont(new java.awt.Font("Segoe Print", 2, 14)); 
        this.setForeground(Color.WHITE);
        this.setMargin(new Insets(15, 15, 20, 20));
        this.setFocusable(false);
    }
    ButtonStyle(String text){
        this.setText(text);
        this.setBackground(new Color(46, 5, 74));
        this.setFont(new java.awt.Font("Segoe Print", 2, 14)); 
        this.setForeground(Color.WHITE);
        this.setMargin(new Insets(15, 15, 20, 20));
        this.setFocusable(false);
    }
        
}
