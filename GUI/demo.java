package GUI;

import javax.swing.*;
import java.awt.*;

public class demo{
    public static void main(String[] args) {


        JFrame myframe = new JFrame();
        myframe.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
        for (int i = 0; i < 30; i++) {
            JButton mybutton = new JButton("button" + i);
            myframe.add(mybutton);
        }

        myframe.setSize(500,500);
        myframe.setVisible(true);
    }
}
