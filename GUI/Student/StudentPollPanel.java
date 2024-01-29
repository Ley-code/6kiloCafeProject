package GUI.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentPollPanel extends JPanel {

    private DefaultListModel<String> pollListModel;
    private JList<String> pollList;
    private Map<String, List<String>> polls;

    private String currentUser;

    public JPanel StudentPollPanel() {

        polls = new HashMap<>();

        pollListModel = new DefaultListModel<>();
        pollList = new JList<>(pollListModel);

        JButton createPollButton = new JButton("Create Poll");
        createPollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPoll();
            }
        });

        JButton participateButton = new JButton("Participate in Poll");
        participateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                participateInPoll();
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Creating a header panel with a label
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel headerLabel = new JLabel("University Cafe Management System");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);

        // Adding header panel to the main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Creating a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.add(createPollButton);
        buttonPanel.add(participateButton);
        buttonPanel.add(loginButton);

        // Adding button panel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Adding a subtle gradient background color to the main panel
        mainPanel.setBackground(new Color(240, 240, 240));
        // Adding the poll list to the main panel
        mainPanel.add(new JScrollPane(pollList), BorderLayout.SOUTH);

        // return the content pane to the main panel
        return mainPanel;

    }

    private void createPoll() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(this, "Please login first.");
            return;
        }

        String pollQuestion = JOptionPane.showInputDialog("Enter Poll Question:");
        if (pollQuestion != null && !pollQuestion.trim().isEmpty()) {
            String[] options = JOptionPane.showInputDialog("Enter Poll Options (comma-separated):").split(",");
            List<String> pollOptions = new ArrayList<>();
            for (String option : options) {
                pollOptions.add(option.trim());
            }
            polls.put(pollQuestion, pollOptions);
            pollListModel.addElement(pollQuestion);
            JOptionPane.showMessageDialog(this, "Poll created successfully!");
        }
    }

    private void participateInPoll() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(this, "Please login first.");
            return;
        }

        String selectedPoll = pollList.getSelectedValue();
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
        } else {
            JOptionPane.showMessageDialog(this, "Please select a poll to participate.");
        }
    }

    private void login() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Validate the username and password (dummy validation for demonstration)
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            if ("admin".equals(username) && "password".equals(new String(password))) {
                currentUser = username;
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentPollPanel();
            }
        });
    }
}




