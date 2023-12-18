package GUI;
import java.awt.Dimension;

import javax.swing.JFrame;
public class WelcomePage {
    private JFrame frame = new JFrame();
    WelcomePage(){
        //creates an empty page for the admin "to be customized:)"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}
