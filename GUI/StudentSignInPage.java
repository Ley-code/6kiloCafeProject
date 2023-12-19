package GUI;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class StudentSignInPage implements ActionListener {
    JFrame myframe = new JFrame();

    StudentSignInPage(){
        //creates a student sign in page to be customized :)
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setSize(new Dimension(500,500));
        myframe.setVisible(true);
        myframe.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    

    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");}
     
}
