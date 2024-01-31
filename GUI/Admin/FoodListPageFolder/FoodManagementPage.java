package GUI.Admin.FoodListPageFolder;
import Database.ConnectionWithDatabase;
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
    private JPanel mainpanel;
    private JPanel sidepanel;
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
    private String ImagePath;
    private JFileChooser fileChooser;
    private JPanel datecontainer;
    private JPanel mealcontainer;
    private JPanel align;
    private JPanel tempcont;
    private JLabel ImageLabel;
    private JPanel placeholder;
    private JPanel FoodInputHolder;
    private JPanel openButtonContainer;
    private JPanel saveButtonContainer;
    private JPanel bottompanel;
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
        datecontainer = new JPanel();
        datecontainer.setBackground(new Color(100, 178, 237));
        datecontainer.add(datelabel);
        datecontainer.add(datebox);
        datecontainer.setBackground(new Color(100, 178, 237));
        mealcontainer = new JPanel();
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

        tempcont = new JPanel();
        tempcont.setBackground(new Color(100, 178, 237));
        tempcont.setLayout(new BorderLayout());

        align = new JPanel();
        align.setLayout(new FlowLayout(FlowLayout.CENTER));
        align.add(previewButton);
        align.setBackground(new Color(100, 178, 237));
        align.setBorder(new EmptyBorder(10,10,10,10));
        tempcont.add(align,BorderLayout.SOUTH);
        tempcont.add(dateAndMealContainer,BorderLayout.NORTH);

        ImageLabel = new JLabel();
        Border border = new LineBorder(Color.GRAY,2,true);
        ImageLabel.setBorder(border);
        ImageLabel.setIcon(FoodIcon.scaledIcon("GUI/icons/elementor-placeholder-image.png",300,300));
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageLabel.setVerticalAlignment(SwingConstants.NORTH);
        ImageLabel.setIconTextGap(10);
        ImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        ImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageLabel.setFont(new Font("Helvici",Font.BOLD,15));

        placeholder= new JPanel();
        placeholder.setLayout(new FlowLayout(FlowLayout.CENTER));
        placeholder.add(ImageLabel);
        previewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------------------------------------------------------------------------
                ArrayList<String> imagevalues = ConnectionWithDatabase.imageExtractor(Date,Mealtime);
                ImageLabel.setIcon(FoodIcon.scaledIcon(imagevalues.get(1),300,300)); // recieves data from Database and Displays it on the imagelabel
                ImageLabel.setText(imagevalues.get(0));
                //-------------------------------------------------------------------------------
            }
        });
        //-------------------------------------------------------
        JLabel foodNameLabel = new JLabel("New Food: ");
        FoodNameField = new JTextField();
        FoodNameField.setColumns(20);

        FoodInputHolder = new JPanel();
        FoodInputHolder.add(foodNameLabel);
        FoodInputHolder.add(FoodNameField);
        FoodInputHolder.setBackground(new Color(100, 178, 237));
        //-------------------------------------------------------
        openButtonContainer = new JPanel();
        openButtonContainer.setBackground(new Color(100, 178, 237));
        openButtonContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
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
                }
            }
        });
        openButtonContainer.add(new JLabel("New Food Image: "));
        openButtonContainer.add(OpenButton);
        saveButtonContainer = new JPanel();
        SaveButton = new JButton("Save");
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FoodNameField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Put the new Food Name first!","Warning",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    ConnectionWithDatabase.imageAdder(FoodNameField.getText(),ImagePath,Date,Mealtime);
                    //adds the selected image to the database
                    JOptionPane.showMessageDialog(null,"saved successfully","save",JOptionPane.INFORMATION_MESSAGE);  //sets the food name and food image to the array
                }
            }
        });
        saveButtonContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        saveButtonContainer.setBackground(new Color(23,56,121));
        saveButtonContainer.add(SaveButton);
        //-------------------------------------------------------
        bottompanel = new JPanel();
        bottompanel.setBackground(new Color(100, 178, 237));
        bottompanel.setLayout(new GridLayout(3,1));
        bottompanel.add(FoodInputHolder);
        bottompanel.add(openButtonContainer);           //the bottom panel which contains the save button label and the two inputs
        bottompanel.add(saveButtonContainer);
        bottompanel.setBorder(new LineBorder(Color.GRAY,2,true));
        //-------------------------------------------------------
        mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout());
        mainpanel.setSize(500,1000);
        mainpanel.setBorder(new EmptyBorder(new Insets(10,10,10,10)));
        mainpanel.setBackground(new Color(90, 116, 204));
        mainpanel.add(tempcont,BorderLayout.NORTH);
        mainpanel.add(placeholder,BorderLayout.CENTER);
        mainpanel.add(bottompanel,BorderLayout.SOUTH);

        sidepanel = new JPanel();
        sidepanel.setSize(500,1000);
        sidepanel.setBackground(Color.cyan);
        //-------------------------------------------------------
        centerPanel.setLayout(new GridLayout(1,2));
        centerPanel.add(mainpanel);
        centerPanel.add(sidepanel);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
    public static void main(String[] args) {
        new FoodManagementPage();
    }
}
