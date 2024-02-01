package GUI.Student;


import Database.ConnectionWithDatabase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentPollPage {
    DefaultListModel<String> questionListModel;
    JList<String> questionList;
    HashMap<String, ArrayList<String>> amirsquestionoption;
    JFrame mainframe;
    StudentPollPage(){
        initialize();
    }
    private void initialize() {
        amirsquestionoption = ConnectionWithDatabase.pollOptionDisplay();
        mainframe = new JFrame();
        mainframe.setSize(600,700);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //----------------------------------------------
        //access the questions list by for loop to put in string
        String[] questioninstring = amirsquestionoption.keySet().toArray(new String[0]);
        questionListModel = new DefaultListModel<>();
        questionListModel.setSize(50);
        for(int i = 0; i<questioninstring.length;i++){
            questionListModel.addElement(questioninstring[i]);
        }
        questionList = new JList<>(questionListModel);
        questionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        questionList.setBackground(Color.cyan);
        questionList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ArrayList<Integer> result = optionShower();
                ConnectionWithDatabase.voteAdder(result,getQuestion());
            }
        });
        JLabel titleLabel = new JLabel("Poll Participation");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(questionList, BorderLayout.CENTER);
        mainframe.add(mainPanel);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Back");
        JMenuItem homeMenuItem = new JMenuItem("Home Page");
        homeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomePageForStudents();
                mainframe.dispose();
            }
        });
        menuBar.add(menu);
        menu.add(homeMenuItem);
        mainframe.setJMenuBar(menuBar);
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
    }

    private String question;
    String selectedQuestion;
    private ArrayList<Integer> optionShower() {
        int selectedQuestionIndex = questionList.getSelectedIndex();
        if (selectedQuestionIndex != -1) {
            selectedQuestion = questionListModel.getElementAt(selectedQuestionIndex);
            setQuestion(selectedQuestion);
            System.out.println(selectedQuestion);
            //-----------------------------------------------------------------------
            ArrayList<String> result = amirsquestionoption.get(selectedQuestion);
            //String[] options = questionOptionsMap.get(selectedQuestion);
            String[] amirsoptions = new String[4];
            for(int i =0;i<4;i++){
                amirsoptions[i] = result.get(i);
            }
            //-----------------------------------------------------------------------
            JComboBox<String> optionsComboBox = new JComboBox<>(amirsoptions);

            int optionDialogResult = JOptionPane.showOptionDialog(
                    null,
                    optionsComboBox,
                    selectedQuestion,
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null
            );

            if (optionDialogResult == JOptionPane.OK_OPTION) {
                int selectedOption = optionsComboBox.getSelectedIndex();
                System.out.println(selectedOption);
                return backEND.backEND.rateResult(selectedOption);
            } else if (optionDialogResult == JOptionPane.CANCEL_OPTION) {
                new StudentPollPage();
                mainframe.dispose();
            }
        }
        else {
            System.out.println("No selected item");
            new StudentPollPage();
            mainframe.dispose();
        }
        System.out.println("Hello");
        return null;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public String getQuestion(){
        return this.question;
    }
}