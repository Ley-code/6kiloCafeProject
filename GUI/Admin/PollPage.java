package GUI.Admin;

import backEND.backEND;

import javax.swing.*;
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
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Create three buttons
        JButton createPollButton = new JButton("Create Poll");

        createPollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPoll();
            }
        });
        JButton viewResultsButton = new JButton("View Results");
        JButton cancelButton = new JButton("Cancel");
        // Create a panel for the title and set its layout
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(titleLabel, BorderLayout.NORTH);

        // Create a panel to hold both title and button panels
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,1,10,30));
        buttonPanel.add(createPollButton);
        buttonPanel.add(viewResultsButton);
        buttonPanel.add(cancelButton);

        // Set the content pane to the main panel
        centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
        centerPanel.add(titlePanel);
        centerPanel.add(createPollButton);
        centerPanel.add(viewResultsButton);
        centerPanel.add(cancelButton);

        // Center the frame on the screen
    }
    //--------------------------------------------------------------------
    private static void createPoll() {
        pollQuestion = JOptionPane.showInputDialog("Enter Poll Question:");
        if (pollQuestion != null && !pollQuestion.trim().isEmpty()) {
            String[] options = JOptionPane.showInputDialog("Enter Poll Options (comma-separated):").split(",");
            List<String> pollOptions = new ArrayList<>();
            for (String option : options) {
                pollOptions.add(option.trim());
            }
            backEND.Poll poll= new backEND.Poll(pollQuestion, (ArrayList<String>) pollOptions);
            polls.put(pollQuestion, pollOptions);
            //pollListModel.addElement(pollQuestion);
            JOptionPane.showMessageDialog(null, "Poll created successfully!");
        }
    }
    //---------------------------------------------------------------------
    public static String getPollQuestion(){
        return pollQuestion;
        //currently not working you can remove it
    }
    public static void main(String[] args) {
        new PollPage();
    }
}
