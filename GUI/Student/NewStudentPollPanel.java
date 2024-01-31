package GUI.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewStudentPollPanel {
    DefaultListModel<String> listModel;
    JList<String> pollList;

    public JPanel createNewStudentPollPanel() {
        // Create a title label and set its properties
        JLabel titleLabel = new JLabel("Poll Participation");
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 30));

        JButton participateButton = new JButton("Participate");
        JButton cancelButton = new JButton("Cancel");

        // Create a button container
        JPanel buttonContainer = new JPanel(new GridLayout(1, 2));
        buttonContainer.add(participateButton);
        buttonContainer.add(cancelButton);

        // Create and initialize the list model and list
        listModel = new DefaultListModel<>();
        pollList = new JList<>(listModel);

        // Add sample poll questions
        listModel.addElement("This is great - it is working"); // Backend team, do your thing

        // Create a main panel and set its layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(pollList), BorderLayout.CENTER); // Wrap the list in a JScrollPane for better UI
        mainPanel.add(buttonContainer, BorderLayout.SOUTH);

        return mainPanel;
    }

    public static void main(String[] args) {
        // Testing the GUI
        JFrame frame = new JFrame("Test NewStudentPollPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        NewStudentPollPanel newStudentPollPanel = new NewStudentPollPanel();
        JPanel panel = newStudentPollPanel.createNewStudentPollPanel();
        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


