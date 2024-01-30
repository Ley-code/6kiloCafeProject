package GUI.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class StudentPage extends JFrame {
    private Map<String, List<String>> polls;
    public StudentPage(AdminPage adminPage) {
        this.polls = adminPage.getPolls(); // Get the polls from the AdminPage
        setTitle("Student Page - Participate in Polls");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton participateButton = createStyledButton("Participate in Poll");
        participateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                participateInPoll();
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
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.add(participateButton);
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
        button.setPreferredSize(new Dimension(100, 30));
        return button;
    }

    private void participateInPoll() {
        String[] pollQuestions = polls.keySet().toArray(new String[0]);
        String selectedPoll = (String) JOptionPane.showInputDialog(
                this,
                "Choose a poll to participate:",
                "Participate in Poll",
                JOptionPane.PLAIN_MESSAGE,
                null,
                pollQuestions,
                pollQuestions[0]
        );

        if (selectedPoll != null) {
            List<String> options = polls.get(selectedPoll);

            if (options != null) {
                String[] optionArray = options.toArray(new String[0]);
                String selectedOption = (String) JOptionPane.showInputDialog(
                        this,
                        "Choose an option:",
                        "Participate in Poll",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        optionArray,
                        optionArray[0]
                );

                if (selectedOption != null) {
                    // Implement logic to record the user's response
                    JOptionPane.showMessageDialog(this, "You selected: " + selectedOption);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error: Poll options not found.");
            }
        }
    }

    private void cancelAction() {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel?", "Cancel", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            dispose(); // Close the student page
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // For demonstration, create an instance of StudentPage with some sample polls
                Map<String, List<String>> samplePolls = Map.of(
                        "Favorite Beverage", List.of("Coffee", "Tea", "Juice"),
                        "Best Dessert", List.of("Cake", "Ice Cream", "Pie")
                );

                // Create an AdminPage instance and pass it to StudentPage
                AdminPage adminPage = new AdminPage();
                new StudentPage(adminPage);
            }
        });
    }
}

