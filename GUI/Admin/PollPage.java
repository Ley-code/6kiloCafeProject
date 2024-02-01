package GUI.Admin;

import Database.ConnectionWithDatabase;
import backEND.backEND;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollPage extends WelcomePage {
    private static JList<String> resultList;
    private static DefaultListModel<String> resultListModel;
    private static String pollQuestion;
    private static HashMap<String,ArrayList<String>> questionMap;
    private static String[] questioninstring;
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
        // Create a panel to hold both title and button panels
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,1,10,30));
        buttonPanel.setBackground(new Color(24, 26, 79));
        buttonPanel.add(titleLabel);
        buttonPanel.add(createPollButton);
        buttonPanel.add(viewResultsButton);

        questionMap = ConnectionWithDatabase.pollOptionDisplay();
        questioninstring = questionMap.keySet().toArray(new String[0]);
        //----------------------------------------------
        //access the questions list by for loop to put in string

        // Set the content pane to the main panel

        resultListModel = new DefaultListModel<>();
        for(int i = 0; i<questioninstring.length;i++){
            resultListModel.addElement(questioninstring[i]);
        }
        resultListModel.setSize(50);
        resultList = new JList<>(resultListModel);
        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultList.setBackground(Color.WHITE);
        resultList.setVisible(false);
        resultList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                displayOptions();
            }
        });

        centerPanel.setLayout(new GridLayout(2,1));
        centerPanel.add(buttonPanel);
        centerPanel.add(resultList);
        centerPanel.setBackground(new Color(24, 26, 79));
        viewResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultList.setVisible(true);
            }
        });

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
    private static void displayOptions() {
        StringBuilder message = new StringBuilder("Option Counts:\n");
        int selectedQuestionIndex = resultList.getSelectedIndex();
        if (selectedQuestionIndex != -1) {
            String selectedQuestion = resultListModel.getElementAt(selectedQuestionIndex);
            //setQuestion(selectedQuestion);
            System.out.println(selectedQuestion);
            message.append(selectedQuestion).append("\n");

            ArrayList<String> options = questionMap.get(selectedQuestion);
            int[] voteResult = ConnectionWithDatabase.voteExtractor(options,selectedQuestion);
            System.out.println(voteResult[1]);
            message.append("Total Vote").append(voteResult[4]).append("\n");
            for(int i = 0; i<4;i++){
                message.append(options.get(i)).append(" : ").append(voteResult[i]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null,message.toString(),"Result",JOptionPane.INFORMATION_MESSAGE);
    }
}
