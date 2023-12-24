package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class StudentSignInPage extends javax.swing.JFrame implements ActionListener {

    public StudentSignInPage() {
        initComponents();
        this.setLocationRelativeTo(null);
   
    }
    boolean flag = false;
    @Override
    public void actionPerformed(ActionEvent e) {
        //----------------------------------------------------------------------------------
        String fullnameString = FullNameField.getText();
        String idnumber = IDNumberField.getText();                        //We have the register values for the backend(Sura time to do your magic)
        String department = DepartmentField.getText();
        String Year = YearField.getText();
        String PhoneNumber = PhoneNumberField.getText();
        String newpassword = String.valueOf(NewPasswordField.getPassword()); 
        String confirmpassword = String.valueOf(ConfirmPasswordField.getPassword());
        //----------------------------------------------------------------------------------
        
        if(e.getSource()==RegisterButton){
            if(fullnameString.equals("")||(idnumber.equals("")||(department.equals("")||(Year.equals(""))||PhoneNumber.equals("")||newpassword.equals("")||confirmpassword.equals("")
            ))){
                MessageLabel.setForeground(Color.RED);
                MessageLabel.setText("One or more empty Fields");
            }
            else{                                   // displayes Error message and successful registration message 
                if (newpassword.equals(confirmpassword)) {
                    MessageLabel.setForeground(Color.GREEN);
                    MessageLabel.setText("Registration Successful");
                    flag = true;
                } 
                else{
                    MessageLabel.setForeground(Color.RED);
                    MessageLabel.setText("Wrong Confirmation Password");
                }
            } 
        }
        if(e.getSource()==ScanIdButton){
            if(flag){
                MessageLabel.setForeground(Color.GREEN);
                MessageLabel.setText("Put your ID on the Scanner");
            }
            else{
                MessageLabel.setForeground(Color.RED);
                MessageLabel.setText("Register First");

            }
        }
    }
            //-------------------------------------------------------------------------------

    @SuppressWarnings("unchecked")                          
    private void initComponents() {
        //----------------------------------------------------------------------
        java.awt.GridBagConstraints gridBagConstraints;
        
        BackgroundPanel = new javax.swing.JPanel();
        RegistralContainerPanel = new javax.swing.JPanel();
        FullnameLabel = new javax.swing.JLabel();
        DepartmentLabel = new javax.swing.JLabel();
        YearLabel = new javax.swing.JLabel();
        IDNumberLabel = new javax.swing.JLabel();
        PhoneNumberLabel = new javax.swing.JLabel();
        NewPasswordLabel = new javax.swing.JLabel();
        ConfirmPasswordLabel = new javax.swing.JLabel();
        FullNameField = new javax.swing.JTextField();
        IDNumberField = new javax.swing.JTextField();
        YearField = new javax.swing.JTextField();                        //Initializes the GUI components
        DepartmentField = new javax.swing.JTextField();
        PhoneNumberField = new javax.swing.JTextField();
        NewPasswordField = new javax.swing.JPasswordField();
        ConfirmPasswordField = new javax.swing.JPasswordField();
        RegisterButton = new javax.swing.JButton();
        ScanIdButton = new javax.swing.JButton();
        MessageLabel = new javax.swing.JLabel();
        TitleContainerPanel = new javax.swing.JPanel();
        SubTitle = new javax.swing.JLabel();
        MainTitle = new javax.swing.JLabel();
        //-------------------------------------------------------------------------
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        BackgroundPanel.setBackground(new java.awt.Color(51, 51, 51));

        RegistralContainerPanel.setBackground(new java.awt.Color(51, 51, 255));

        FullnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FullnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        FullnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FullnameLabel.setText("Full Name:");

        DepartmentLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DepartmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        DepartmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DepartmentLabel.setText("Department:");

        YearLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        YearLabel.setForeground(new java.awt.Color(255, 255, 255));
        YearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YearLabel.setText("Year:");

        IDNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        IDNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IDNumberLabel.setText("ID number:");

        PhoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PhoneNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        PhoneNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PhoneNumberLabel.setText("Phone number:");

        NewPasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NewPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        NewPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NewPasswordLabel.setText("New password:");

        ConfirmPasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ConfirmPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConfirmPasswordLabel.setText("Confirm password:");

        RegisterButton.setBackground(new java.awt.Color(0, 51, 255));
        RegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterButton.setText("Register");
        RegisterButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.blue, new java.awt.Color(51, 51, 255)));
        RegisterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RegisterButton.addActionListener(this);

        ScanIdButton.setBackground(new java.awt.Color(0, 51, 255));
        ScanIdButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ScanIdButton.setForeground(new java.awt.Color(255, 255, 255));
        ScanIdButton.setText("SCAN RFID");
        ScanIdButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.blue, new java.awt.Color(51, 51, 255)));
        ScanIdButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ScanIdButton.addActionListener(this);

        MessageLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MessageLabel.setForeground(new java.awt.Color(0, 255, 0));
        MessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(RegistralContainerPanel);
        RegistralContainerPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ConfirmPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(YearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IDNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FullnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DepartmentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PhoneNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NewPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(FullNameField)
                                .addComponent(IDNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addComponent(YearField)
                                .addComponent(DepartmentField)
                                .addComponent(PhoneNumberField)
                                .addComponent(NewPasswordField)
                                .addComponent(ConfirmPasswordField))
                            .addComponent(ScanIdButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FullnameLabel)
                    .addComponent(FullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YearLabel)
                    .addComponent(YearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DepartmentLabel)
                    .addComponent(DepartmentField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PhoneNumberLabel)
                    .addComponent(PhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewPasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmPasswordLabel))
                .addGap(18, 18, 18)
                .addComponent(MessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScanIdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        TitleContainerPanel.setBackground(new java.awt.Color(51, 51, 255));

        SubTitle.setBackground(new java.awt.Color(242, 232, 178));
        SubTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SubTitle.setForeground(new java.awt.Color(255, 204, 51));
        SubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SubTitle.setText("Student Sign Up Page");

        MainTitle.setBackground(new java.awt.Color(242, 232, 178));
        MainTitle.setFont(MainTitle.getFont().deriveFont(MainTitle.getFont().getStyle() | java.awt.Font.BOLD, MainTitle.getFont().getSize()+12));
        MainTitle.setForeground(new java.awt.Color(255, 204, 51));
        MainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainTitle.setText("Cafe Management");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(TitleContainerPanel);
        TitleContainerPanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(MainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(MainTitle)
                .addGap(18, 18, 18)
                .addComponent(SubTitle)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(BackgroundPanel);
        BackgroundPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(RegistralContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(RegistralContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        //up until this point it customizes the required UI for our studentsigninpage
        //---------------------------------------------------------------------------
        gridBagConstraints = new java.awt.GridBagConstraints();             //Uses the gridBagLayout manager
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.ipady = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
        getContentPane().add(BackgroundPanel, gridBagConstraints); //adds the components to the class
        //-----------------------------------------------------------------
        pack();
    }
    //Variable Declaration
    //-------------------------------------------------------------                                                                                     
    private javax.swing.JPasswordField ConfirmPasswordField;
    private javax.swing.JLabel ConfirmPasswordLabel;
    private javax.swing.JTextField DepartmentField;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JTextField FullNameField;
    private javax.swing.JLabel FullnameLabel;
    private javax.swing.JTextField IDNumberField;
    private javax.swing.JLabel IDNumberLabel;
    private javax.swing.JLabel MessageLabel;
    private javax.swing.JPasswordField NewPasswordField;
    private javax.swing.JLabel NewPasswordLabel;
    private javax.swing.JTextField PhoneNumberField;
    private javax.swing.JLabel PhoneNumberLabel;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton ScanIdButton;
    private javax.swing.JTextField YearField;
    private javax.swing.JLabel YearLabel;
    private javax.swing.JLabel SubTitle;
    private javax.swing.JLabel MainTitle;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JPanel RegistralContainerPanel;
    private javax.swing.JPanel TitleContainerPanel;
    //--------------------------------------------------------------
    // End of variables declaration                   
}
