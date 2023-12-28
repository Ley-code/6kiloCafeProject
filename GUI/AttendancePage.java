package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTable;

public class AttendancePage extends Welcomepage {
    private JTable attendanceTable;
    private JLabel tabelname;
    AttendancePage(){
        tabelname = new JLabel();

        cafeFoodsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
            
        })
        tabelname.setText("Amir is great");
        centerPanel.setBackground(Color.BLUE);
        centerPanel.add(tabelname);
    }
    
    
}
