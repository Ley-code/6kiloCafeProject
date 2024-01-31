package GUI.Admin.FoodListPageFolder;
import javax.swing.JOptionPane;

public class JOptionPaneExample {
    public static void main(String[] args) {
        // Concatenate the strings to display in a row
        String text1 = "Hello";
        String text2 = "World";
        String rowText = text1 + " " + text2;

        // Display the text in a row using JOptionPane
        JOptionPane.showMessageDialog(null, rowText, "Text in a Row", JOptionPane.INFORMATION_MESSAGE);
    }
}
