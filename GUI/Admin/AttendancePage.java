package GUI.Admin;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AttendancePage extends WelcomePage {
    private JTable table;
    private JScrollPane scrollPane;

    public AttendancePage() throws SQLException {
        // Create a table model with no data and column names
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new Object[]{"Student_ID", "Studnet_Name", "Password", "Department", "Year","Breakfast", "Lunch", "Dinner"});

        // Create a JTable with the table model
        table = new JTable(tableModel);

        // Create a JScrollPane to add the JTable to and make it scrollable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        loadDataFromDatabase(tableModel);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.setBackground(Color.BLUE);

    }
    private void loadDataFromDatabase(DefaultTableModel tableModel) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cafe_database";
        String username = "root";
        String Password = "00000000";
        Connection myconnection = DriverManager.getConnection(url,username, Password);
        Statement statement = myconnection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM students");
        while (result.next()) {
            String studentID = result.getString(1);
            String studentName = result.getString(2);
            String password = result.getString(3);
            String department = result.getString(4);
            String year = result.getString(5);
            System.out.println(studentID + " " + studentName);
            // Add the data to the table model
            tableModel.addRow(new Object[]{studentID, studentName, password, department,year});
        }
        result.close();
        statement.close();
        myconnection.close();
    }
}
