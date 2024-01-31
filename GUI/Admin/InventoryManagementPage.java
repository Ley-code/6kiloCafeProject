package GUI.Admin;

import javax.swing.*;
import java.awt.*;

public class InventoryManagementPage extends WelcomePage {
    private JLabel message;
    InventoryManagementPage(){
        initialize();
    }
    private void initialize(){
        message = new JLabel("COMING SOON");
        message.setFont(new Font("Arial",Font.BOLD,60));
        message.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.setLayout(new GridLayout(1,1));
        centerPanel.add(message);
    }

    public static void main(String[] args) {
        new InventoryManagementPage();
    }
}
