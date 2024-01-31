package GUI.Admin;

import Database.ConnectionWithDatabase;
import backEND.backEND;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PollPage extends WelcomePage {
    private static Map<String, List<String>> polls;
    private static String pollQuestion;
    PollPage(){
        // Create a title label and set its properties
        JLabel titleLabel = new JLabel("Poll Creation");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel titlepanel = new JPanel();
        titlepanel.add(titleLabel);
        // Create three buttons
        JButton createPollButton = new JButton("Create Poll");
        createPollButton.setFocusable(false);
        createPollButton.setFont(new Font("Arial",Font.PLAIN,20));
        createPollButton.setBackground(Color.cyan);
        createPollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPoll();
            }
        });
        JButton viewResultsButton = new JButton("View Results");
        viewResultsButton.setFocusable(false);
        viewResultsButton.setFont(new Font("Arial",Font.PLAIN,20));
        viewResultsButton.setBackground(Color.cyan);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFocusable(false);
        cancelButton.setFont(new Font("Arial",Font.PLAIN,20));
        cancelButton.setBackground(Color.cyan);
        // Create a panel to hold both title and button panels
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,1,10,30));
        buttonPanel.add(createPollButton);
        buttonPanel.add(viewResultsButton);
        buttonPanel.add(cancelButton);
        // Set the content pane to the main panel
        centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
        centerPanel.add(titleLabel,BorderLayout.NORTH);
        centerPanel.add(buttonPanel,BorderLayout.CENTER);
        centerPanel.setBackground(new Color(24, 26, 79));

        // Center the frame on the screen
    }
    //--------------------------------------------------------------------
    private static void createPoll() {
        pollQuestion = JOptionPane.showInputDialog("Enter Poll Question:");
        if (pollQuestion != null && !pollQuestion.trim().isEmpty()) {
            String[] options = JOptionPane.showInputDialog("Enter Poll Options (comma-separated): not more than 4").split(",");
            List<String> pollOptions = new ArrayList<>();
            for (String option : options) {
                pollOptions.add(option.trim());
            }
            //---------------------------------------------------------------------------------------
            backEND.Poll poll= new backEND.Poll(pollQuestion, (ArrayList<String>) pollOptions);
            ConnectionWithDatabase.pollTableCreator(poll.getOptions(),poll.getQuestion());    //passes the options and question to be stored in the database
            //----------------------------------------------------------------------------------------
            //polls.put(pollQuestion, pollOptions);
            //pollListModel.addElement(pollQuestion);
            JOptionPane.showMessageDialog(null, "Poll created successfully!");
        }
    }
    //---------------------------------------------------------------------
    public static void main(String[] args) {
        new PollPage();
    }
}
