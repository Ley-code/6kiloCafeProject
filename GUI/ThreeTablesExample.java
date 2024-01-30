package GUI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class ThreeTablesExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Three Tables Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JTable table1 = createTable("Table 1");
        JTable table2 = createTable("Table 2");
        JTable table3 = createTable("Table 3");

        mainPanel.add(new JScrollPane(table1));
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(new JScrollPane(table2));
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(new JScrollPane(table3));

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static JTable createTable(String tableName) {
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new Object[]{"Column 1", "Column 2"});
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        // Add some data to the table
        model.addRow(new Object[]{"Data 1", "Data 2"});
        model.addRow(new Object[]{"Data 3", "Data 4"});

        return table;
    }
}
