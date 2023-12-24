package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInPage extends javax.swing.JFrame implements ActionListener {
    IdandPassword loginIdPassword = new IdandPassword();

    public SignInPage() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ResetButton) {
            AdminUsernameField.setText("");
            AdminPasswordField.setText("");
            // resets the password and IDfield if a user makes a mistake
        }
        if (e.getSource() == LoginButton) {
            String userID = AdminUsernameField.getText();
            System.out.println(userID);
            String userPassword = String.valueOf(AdminPasswordField.getPassword());
            System.out.println();
            // the above variables store the password and ID of the user
            // ----------------------------------------------------
            System.out.println(IdandPassword.getLogInfo());
            // below the methods check if the user ID and Password matches and if it doesnt
            // match shows the respective message
            // and if it matches opens a new welcome page as an admin
            if (IdandPassword.getLogInfo().containsKey(userID)) {
                if (IdandPassword.getLogInfo().get(userID).equals(userPassword)) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");
                    this.dispose();
                    WelcomePage welcomePage = new WelcomePage();
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong Password");
                }
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong username");
            }
            // ----------------------------------------------------
        }
        // if the user is a student it creates a studentsigninpage
        if (e.getSource() == StudentButton) {
            new StudentSignInPage().setVisible(true);
            ;
            this.dispose();
        }
    }

    private void initComponents() {
        //--------------------------------------------------------
        // Declaration of the GUI components
        Pagecontainer = new javax.swing.JPanel();
        Topconatiner = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Middlecontainer = new javax.swing.JPanel();
        AdminButton = new javax.swing.JButton();
        LoginTabContainer = new javax.swing.JPanel();
        AdminUsernameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        ResetButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();
        AdminPasswordField = new javax.swing.JPasswordField();
        StudentButton = new javax.swing.JButton();
        //-------------------------------------------------------------------
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign In page");
        setBackground(new java.awt.Color(0, 255, 102));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(605, 550));
        getContentPane().setLayout(new java.awt.FlowLayout());

        Pagecontainer.setBackground(new java.awt.Color(119, 203, 229));
        Pagecontainer.setPreferredSize(new java.awt.Dimension(605, 550));
        Pagecontainer.setLayout(new java.awt.BorderLayout());

        Topconatiner.setBackground(new java.awt.Color(0, 0, 204));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Welcome to Cafe Management");

        javax.swing.GroupLayout TopconatinerLayout = new javax.swing.GroupLayout(Topconatiner);
        Topconatiner.setLayout(TopconatinerLayout);
        TopconatinerLayout.setHorizontalGroup(
                TopconatinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TopconatinerLayout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(303, Short.MAX_VALUE)));
        TopconatinerLayout.setVerticalGroup(
                TopconatinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TopconatinerLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(Title)
                                .addContainerGap(22, Short.MAX_VALUE)));

        Pagecontainer.add(Topconatiner, java.awt.BorderLayout.NORTH);

        Middlecontainer.setBackground(new java.awt.Color(0, 0, 153));
        Middlecontainer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        AdminButton.setBackground(new java.awt.Color(0, 0, 204));
        AdminButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdminButton.setForeground(new java.awt.Color(255, 255, 255));
        AdminButton.setText("Admin");
        AdminButton.setFocusable(false);
        AdminButton.addActionListener(this);

        LoginTabContainer.setBackground(new java.awt.Color(0, 51, 255));

        passwordLabel.setFont(passwordLabel.getFont().deriveFont(
                passwordLabel.getFont().getStyle() | java.awt.Font.BOLD, passwordLabel.getFont().getSize() + 2));
        passwordLabel.setText("Password:");

        usernameLabel.setFont(usernameLabel.getFont().deriveFont(
                usernameLabel.getFont().getStyle() | java.awt.Font.BOLD, usernameLabel.getFont().getSize() + 2));
        usernameLabel.setText("Username:");

        messageLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(255, 0, 0));

        ResetButton.setBackground(new java.awt.Color(0, 0, 204));
        ResetButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ResetButton.setForeground(new java.awt.Color(255, 255, 255));
        ResetButton.setText("Reset");
        ResetButton.addActionListener(this);

        LoginButton.setBackground(new java.awt.Color(0, 0, 204));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Log In");
        LoginButton.addActionListener(this);

        StudentButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        StudentButton.setText("Student");
        StudentButton.addActionListener(this);
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(LoginTabContainer);
        LoginTabContainer.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout
                                                .createSequentialGroup()
                                                .addGroup(jPanel4Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(passwordLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(AdminPasswordField))
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(usernameLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(AdminUsernameField,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 278,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(29, 29, 29))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout
                                                .createSequentialGroup()
                                                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AdminUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernameLabel))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(AdminPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ResetButton)
                                        .addComponent(LoginButton))
                                .addContainerGap(19, Short.MAX_VALUE)));

        javax.swing.GroupLayout MiddlecontainerLayout = new javax.swing.GroupLayout(Middlecontainer);
        Middlecontainer.setLayout(MiddlecontainerLayout);
        MiddlecontainerLayout.setHorizontalGroup(
                MiddlecontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MiddlecontainerLayout.createSequentialGroup()
                                .addGroup(MiddlecontainerLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MiddlecontainerLayout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(LoginTabContainer, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(MiddlecontainerLayout.createSequentialGroup()
                                                .addGap(105, 105, 105)
                                                .addComponent(AdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(78, 78, 78)
                                                .addComponent(StudentButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(220, Short.MAX_VALUE)));
        MiddlecontainerLayout.setVerticalGroup(
                MiddlecontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MiddlecontainerLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(MiddlecontainerLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AdminButton)
                                        .addComponent(StudentButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LoginTabContainer, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(91, Short.MAX_VALUE)));

        Pagecontainer.add(Middlecontainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(Pagecontainer);

        pack();
        //up to this point is the GUI customization for the login page for the admin
    }//-------------------------------------------------------------------------------------
    // Variables declaration - do not modify
    private javax.swing.JButton AdminButton;
    private javax.swing.JPasswordField AdminPasswordField;
    private javax.swing.JTextField AdminUsernameField;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel Middlecontainer;
    private javax.swing.JPanel Pagecontainer;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton StudentButton;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel Topconatiner;
    private javax.swing.JPanel LoginTabContainer;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration
}
