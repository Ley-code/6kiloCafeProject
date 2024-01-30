package GUI.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminPage extends JFrame {

    private Map<String, List<String>> polls;
    private Map<String, Map<String, Integer>> optionCounts;

    public AdminPage() {
        setTitle("Admin Page - Create and Rate Polls");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        polls = new HashMap<>();
        optionCounts = new HashMap<>();

        JButton createPollButton = createStyledButton("Create Poll");
        createPollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPoll();
            }
        });

        JButton rateCafeButton = createStyledButton("Rate Cafe");
        rateCafeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rateCafe();
            }
        });

        JButton cancelButton = createStyledButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAction();
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Creating a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.add(createPollButton);
        buttonPanel.add(rateCafeButton);
        buttonPanel.add(cancelButton);

        // Adding button panel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.WEST);

        // Setting the content pane to the main panel
        setContentPane(mainPanel);

        // Centering the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setPreferredSize(new Dimension(150, 30));
        return button;
    }

    private void createPoll() {
        String pollQuestion = JOptionPane.showInputDialog("Enter Poll Question:");
        if (pollQuestion != null && !pollQuestion.trim().isEmpty()) {
            String[] options = JOptionPane.showInputDialog("Enter Poll Options (comma-separated):").split(",");
            polls.put(pollQuestion, List.of(options));
            optionCounts.put(pollQuestion, new HashMap<>());
            JOptionPane.showMessageDialog(this, "Poll created successfully!");
        }
    }

    private void rateCafe() {
        // Count the selected options separately
        countSelectedOptions();

        // Display counts in a dialog
        showOptionCountsDialog();
    }
    private void countSelectedOptions() {
        // Reset counts before recounting
        optionCounts.clear();

        for (Map.Entry<String, List<String>> entry : polls.entrySet()) {
            String pollQuestion = entry.getKey();
            //options
            List<String> options = entry.getValue();
            Map<String, Integer> pollOptionCounts = new HashMap<>();

            for (String option : options) {
                pollOptionCounts.put(option, 0);
            }
            for (Map.Entry<String, List<String>> studentEntry : polls.entrySet()) {
                List<String> selectedOptions = studentEntry.getValue();
                if (selectedOptions != null && selectedOptions.equals(options)) {
                    // Increment count for each selected option
                    for (String selectedOption : selectedOptions) {
                        pollOptionCounts.put(selectedOption, pollOptionCounts.get(selectedOption) + 1);
                    }
                }
            }
            optionCounts.put(pollQuestion, pollOptionCounts);
        }
    }

    private void showOptionCountsDialog() {
        StringBuilder message = new StringBuilder("Option Counts:\n");

        for (Map.Entry<String, Map<String, Integer>> entry : optionCounts.entrySet()) {
            String pollQuestion = entry.getKey();
            Map<String, Integer> pollOptionCounts = entry.getValue();

            message.append(pollQuestion).append("\n");

            for (Map.Entry<String, Integer> optionCount : pollOptionCounts.entrySet()) {
                message.append(optionCount.getKey()).append(": ").append(optionCount.getValue()).append("\n");
            }

            message.append("\n");
        }

        JOptionPane.showMessageDialog(this, message.toString(), "Rate Cafe - Option Counts", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cancelAction() {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel?", "Cancel", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            dispose(); // Close the admin page
        }
    }

    public Map<String, List<String>> getPolls() {
        return polls;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AdminPage adminPage = new AdminPage();
                // Pass the adminPage instance to the StudentPage constructor
                new StudentPage(adminPage);
            }
        });
    }
}





