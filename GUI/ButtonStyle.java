package GUI;

import java.awt.Insets;

import javax.swing.JButton;

public final class ButtonStyle extends JButton {
    ButtonStyle(){
        this.setBackground(new java.awt.Color(0, 153, 153));
        this.setFont(new java.awt.Font("Segoe Print", 2, 14)); // NOI18N
        this.setForeground(new java.awt.Color(0, 0, 0));
        this.setMargin(new Insets(15, 15, 20, 20));
        this.setFocusable(false);
    }
        
}
