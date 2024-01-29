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
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new Object[]{"Student_ID", "Student_Name", "Department", "Year","Breakfast", "Lunch", "Dinner"});

        // Create a JTable with the table model
        table = new JTable(tableModel);
        table.setBackground(new Color(34,12,56));
        table.setFont(new Font("Helvici", Font.BOLD,15));
        table.setForeground(Color.WHITE);
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
            String department = result.getString(4);
            String year = result.getString(5);
            System.out.println(studentID + " " + studentName);
            // Add the data to the table model
            tableModel.addRow(new Object[]{studentID, studentName, department,year});
        }
        result.close();
        statement.close();
        myconnection.close();
    }
    public static void main(String[] args) {
        try {
            new AttendancePage();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
