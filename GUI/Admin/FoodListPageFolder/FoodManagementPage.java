package GUI.Admin.FoodListPageFolder;
import Database.ConnectionWithDatabase;
import GUI.Admin.ButtonStyle;
import GUI.Admin.WelcomePage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class FoodManagementPage extends WelcomePage {
    private JPanel panel1;
    private JPanel panel2;
    private JButton previewButton;
    private JButton changeFoodButton;
    private final JComboBox datebox;
    private final JComboBox mealtimebox;
    private JLabel datelabel;
    private JLabel meallabel;
    private JPanel dateAndMealContainer;
    private int Mealtime;
    private int Date;
    private JTextField FoodNameField;
    private JButton OpenButton;
    private JButton SaveButton;
    private JButton ChangeButton;
    private String ImagePath;
    private JFileChooser fileChooser;
    private String FoodName;
    public FoodManagementPage(){
        //----------------------------------------------------------
        datelabel = new JLabel("Date: ");
        datelabel.setHorizontalAlignment(SwingConstants.TRAILING);
        meallabel = new JLabel("Meal Time: ");
        meallabel.setHorizontalAlignment(SwingConstants.TRAILING);
        mealtimebox = new JComboBox(new Object[]{"Breakfast","Lunch","Dinner"});
        mealtimebox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Mealtime = mealtimebox.getSelectedIndex();
            }
        });
        datebox = new JComboBox(new Object[]{"Monday","Tuesday","Wednesday"});
        datebox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date = datebox.getSelectedIndex();
            }
        });
        JPanel datecontainer = new JPanel();
        datecontainer.setBackground(new Color(100, 178, 237));
        datecontainer.add(datelabel);
        datecontainer.add(datebox);
        JPanel mealcontainer = new JPanel();
        datecontainer.setBackground(new Color(100, 178, 237));
        mealcontainer.add(meallabel);
        mealcontainer.add(mealtimebox);
        //-------------------------------------------------------
        dateAndMealContainer = new JPanel();
        dateAndMealContainer.setLayout(new GridLayout(2,1,10,20));
        dateAndMealContainer.add(datecontainer);
        dateAndMealContainer.add(mealcontainer);
        dateAndMealContainer.setBorder(new LineBorder(Color.LIGHT_GRAY,3,true));
        dateAndMealContainer.setBackground(new Color(100, 178, 237));
        //----------------------------------------------------------
        previewButton = new JButton("Preview");
        previewButton.setMargin(new Insets(0,20,0,20));
        previewButton.setFocusable(false);
        previewButton.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel tempcont = new JPanel();
        tempcont.setBackground(new Color(100, 178, 237));
        tempcont.setLayout(new BorderLayout());
        JPanel align = new JPanel();
        align.setLayout(new FlowLayout(FlowLayout.CENTER));
        align.add(previewButton);
        align.setBackground(new Color(100, 178, 237));
        align.setBorder(new EmptyBorder(10,10,10,10));
        tempcont.add(align,BorderLayout.SOUTH);
        tempcont.add(dateAndMealContainer,BorderLayout.NORTH);

        JLabel ImageLabel = new JLabel();
        Border border = new LineBorder(Color.GRAY,2,true);
        ImageLabel.setBorder(border);
        ImageLabel.setIcon(FoodIcon.scaledIcon("GUI/icons/elementor-placeholder-image.png",300,300));
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageLabel.setVerticalAlignment(SwingConstants.NORTH);
        ImageLabel.setIconTextGap(10);
        ImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        ImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageLabel.setFont(new Font("Helvici",Font.BOLD,15));
        JPanel placeholder= new JPanel();
        placeholder.setLayout(new FlowLayout(FlowLayout.CENTER));
        placeholder.add(ImageLabel);
        previewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> imagevalues = ConnectionWithDatabase.imageExtractor(Date,Mealtime);
                ImageLabel.setIcon(FoodIcon.scaledIcon(imagevalues.get(1),300,300));
                ImageLabel.setText(imagevalues.get(0));
            }
        });
        //-------------------------------------------------------
        JLabel foodNameLabel = new JLabel("NewFood Name: ");
        FoodNameField = new JTextField();
        FoodNameField.setColumns(20);
        JPanel placeholder1 = new JPanel();
        placeholder1.add(foodNameLabel);
        placeholder1.add(FoodNameField);
        placeholder1.setBackground(new Color(100, 178, 237));
        //-------------------------------------------------------
        JPanel placeholder2 = new JPanel();
        placeholder2.setBackground(new Color(100, 178, 237));
        placeholder2.setLayout(new FlowLayout(FlowLayout.CENTER));
        OpenButton = new JButton("Open Image");

        OpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();                                //opens image from the local files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("All images","png","jpg","jpeg");//and displays it on the image label
                fileChooser.addChoosableFileFilter(filter);
                fileChooser.setCurrentDirectory(new File("GUI/icons"));
                int response = fileChooser.showOpenDialog(null);
                if(response==JFileChooser.APPROVE_OPTION){
                    ImagePath = fileChooser.getSelectedFile().getPath();
                    //ImageLabel.setIcon(FoodIcon.scaledIcon(ImagePath,300,300));
                }
            }
        });
        placeholder2.add(new JLabel("New Food Image: "));
        placeholder2.add(OpenButton);
        //-----------------------------------------------------
        JPanel placeholder3 = new JPanel();
        SaveButton = new JButton("Save");
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FoodNameField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Put the new Food Name first!","Warning",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    ConnectionWithDatabase.imageAdder(FoodNameField.getText(),ImagePath,Date,Mealtime);
                    JOptionPane.showMessageDialog(null,"saved successfully","save",JOptionPane.INFORMATION_MESSAGE);  //sets the food name and food image to the array
                    //-------------------------------------------------------------------
                    //NewFoodListPage.setFoodName(Date,Mealtime,FoodNameField.getText());
                    //NewFoodListPanel.setFoodImage(Date,Mealtime, ImagePath);        //worked with local data
                    //-------------------------------------------------------------------
                }
            }
        });
        placeholder3.setLayout(new FlowLayout(FlowLayout.CENTER));
        placeholder3.setBackground(new Color(23,56,121));
        placeholder3.add(SaveButton);
        //-------------------------------------------------------
        JPanel bottompanel = new JPanel();
        bottompanel.setBackground(new Color(100, 178, 237));
        bottompanel.setLayout(new GridLayout(3,1));
        bottompanel.add(placeholder1);
        bottompanel.add(placeholder2);           //the bottom panel which contains the save button label and the two inputs
        bottompanel.add(placeholder3);
        bottompanel.setBorder(new LineBorder(Color.GRAY,2,true));
        //-------------------------------------------------------
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setSize(500,1000);
        panel1.setBorder(new EmptyBorder(new Insets(10,10,10,10)));
        panel1.setBackground(new Color(90, 116, 204));
        panel1.add(tempcont,BorderLayout.NORTH);
        panel1.add(placeholder,BorderLayout.CENTER);
        panel1.add(bottompanel,BorderLayout.SOUTH);

        panel2 = new JPanel();
        panel2.setSize(500,1000);
        panel2.setBackground(Color.GRAY);
        //-------------------------------------------------------
        centerPanel.setLayout(new GridLayout(1,2));
        centerPanel.add(panel1);
        centerPanel.add(panel2);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);

    }
    public static void main(String[] args) {
        new FoodManagementPage();
    }
}
