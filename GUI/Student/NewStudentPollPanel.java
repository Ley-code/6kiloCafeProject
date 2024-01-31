package GUI.Student;

import Database.ConnectionWithDatabase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class NewStudentPollPanel {
    DefaultListModel<String> questionListModel;
    HashMap<String, String[]> questionOptionsMap;
    JList<String> questionList;
    JList<String> polllist;
    HashMap<String, String[]> amirsquestionoption;
    public JPanel NewStudentPollPanel() {
        /*JLabel titleLabel = new JLabel("Poll Participation");
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
        */
        amirsquestionoption = new HashMap<>();
        amirsquestionoption.put("A", new String[]{"1","2","3","4"});
        amirsquestionoption.put("B", new String[]{"5","6","7","8"});
        amirsquestionoption.put("C",new String[]{"9","10"});
        ArrayList<String> amirsquestions = new ArrayList<>();
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
                //ConnectionWithDatabase.voteAdder(result,getQuestion());
            }
        });
        JLabel titleLabel = new JLabel("Poll Participation");
        titleLabel.setFont(new Font("Helvici", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(questionList, BorderLayout.CENTER);
        return mainPanel;
    }
    private int selectedOption;
    private String question;
    private ArrayList<Integer> optionShower() {
        int selectedQuestionIndex = questionList.getSelectedIndex();
        if (selectedQuestionIndex != -1) {
            String selectedQuestion = questionListModel.getElementAt(selectedQuestionIndex);
            setQuestion(selectedQuestion);
            System.out.println(selectedQuestion);
            //-----------------------------------------------------------------------
            //String[] options = questionOptionsMap.get(selectedQuestion);
            String[] amirsoptions = amirsquestionoption.get(selectedQuestion);
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
                selectedOption = optionsComboBox.getSelectedIndex();
                System.out.println(selectedOption);
                return backEND.backEND.rateResult(selectedOption);
            }

        }
        System.out.println("No selected item");
        return null;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public String getQuestion(){
        return this.question;
    }
}
