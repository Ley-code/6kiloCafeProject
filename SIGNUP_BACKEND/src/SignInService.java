public class SignInService {
    private StudentDatabase studentDatabase;

    public SignInService(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    public String signIn(String username, String password) {
        String validationMessage = validateInput(username, password);
        if (validationMessage != null) {
            return validationMessage  ;
        }

        Student student = studentDatabase.getStudentByUsername(username);
        if (student != null && student.getPassword().equals(password)) {
            return "Sign-in successful!";;
        }

        return "Incorrect username or password.";
    }

    private String validateInput(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return "Invalid input. Please enter both username and password." ;
        }

        return null;
    }
}