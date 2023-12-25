package GUI;

public class Main {
    public static void main(String[] args) {
    IdandPassword myIdandPassword = new IdandPassword();
    //--------------------------------------------------------------------------------------
    /* Customizes the Look and Feel of the GUI it is a custom UI Manager. it is like a finishing touch to make 
     * the graphics pop up
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(SignInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(SignInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(SignInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(SignInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //---------------------------------------------------------------------------------------------------
    new SignInPage().setVisible(true); //launches the sign in page

}

}