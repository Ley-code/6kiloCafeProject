package GUI.Student;

import GUI.Admin.PollPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewStudentPollPanel{
    DefaultListModel<String> listModel;
    JList<String> polllist;
    public JPanel NewStudentPollPanel() {
// Create a title label and set its properties
        JLabel titleLabel = new JLabel("Poll Participation");
        titleLabel.setFont(new Font("Helvici",Font.BOLD,25));
        JButton participateButton = new JButton("Particicpate");
        JButton cancelButton = new JButton("Cancel");
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new GridLayout(1,2));
        buttonContainer.add(participateButton);
        buttonContainer.add(cancelButton);

        listModel = new DefaultListModel<>();
        polllist = new JList<>(listModel);

        listModel.addElement("This is great it is working");//this is where we put the poll questions is displayed //backend team do your thing
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(polllist,BorderLayout.CENTER);
        mainPanel.add(buttonContainer, BorderLayout.SOUTH);
        return mainPanel;
    }
}

