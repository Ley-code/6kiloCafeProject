package GUI.Admin;

import Database.ConnectionWithDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AttendancePage extends WelcomePage {
    private JTable table1;
    private JTable table2;
    private JTable table3;
    public AttendancePage() throws SQLException {
        DefaultTableModel tableModel1 = new DefaultTableModel(new Object[][]{},new Object[]{"No", "Student_Name", "Student_ID", "Department","Year","BreakFast"});
        DefaultTableModel tableModel2 = new DefaultTableModel(new Object[][]{},new Object[]{"No", "Student_Name", "Student_ID", "Department","Year","Lunch"});
        DefaultTableModel tableModel3 = new DefaultTableModel(new Object[][]{},new Object[]{"No", "Student_Name", "Student_ID", "Department","Year","Dinner"});
        // Create a JTable with the table model
        table1 = TableStyle(tableModel1);
        table2 = TableStyle(tableModel2);
        table3 = TableStyle(tableModel3);

        JPanel tablepanel = new JPanel();
        tablepanel.setLayout(new BoxLayout(tablepanel,BoxLayout.Y_AXIS));
        tablepanel.add(new JScrollPane(table1));
        tablepanel.add(new JScrollPane(table2));
        tablepanel.add(new JScrollPane(table3));
        // Create a JTable with the table model
        JButton updateButton = new ButtonStyle("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectionWithDatabase.breakfastAttendance(tableModel1);
                ConnectionWithDatabase.lunchAttendance(tableModel2); //displays the table on the GUI reading data from the database
                ConnectionWithDatabase.dinnerAttendance(tableModel3);
            }
        });
        // Create a JScrollPane to add the JTable to and make it scrollable
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(updateButton,BorderLayout.NORTH);
        centerPanel.add(tablepanel,BorderLayout.CENTER);
        centerPanel.setBackground(Color.BLUE);
    }
    public JTable TableStyle(DefaultTableModel tableModel){
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);
        table.setGridColor(Color.BLUE);
        table.setBackground(Color.cyan);
        table.setShowVerticalLines(true);
        return table;
    }

    public static void main(String[] args) {
        try {
            new AttendancePage();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
