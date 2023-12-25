public class SignupService {
    public String signUp(String name, String password, String confirmPassword, String department, String yearOfStudy, String phone, String rfidId) {
        String validationMessage = validateInput(name, password, confirmPassword, department, yearOfStudy, phone, rfidId);
        if (validationMessage != null) {
            return validationMessage;
        }
        if (!checkExistingUser(rfidId)) {
            return "User with RFID ID already exists.";
        }
        // Save user data
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.saveStudent(rfidId, name, password, department, yearOfStudy, phone);
        return "Sign-up successful!";
    }

    private String validateInput(String name, String password, String confirmPassword, String department, String yearOfStudy, String phone, String rfidId) {
        if (name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || department.isEmpty() || phone.isEmpty() || rfidId.isEmpty()) {
            return "Please fill in all the required fields.";
        }
        if (password.length() < 6) {
            return "Password should be at least 6 characters long.";
        }
        try {
            int year = Integer.parseInt(yearOfStudy);
            if (year < 1 || year > 5) {
                return "Invalid year of study. Please enter a value between 1 and 5.";
            }
        } catch (NumberFormatException e) {
            return "Invalid year of study. Please enter a valid number.";
        }
        if (!password.equals(confirmPassword)) {
            return "Password and confirm password do not match.";
        }
        return null;
    }

    private boolean checkExistingUser(String rfidId) {
        // Placeholder method to check if user already exists in the database
        DatabaseManager databaseManager = new DatabaseManager();
        return databaseManager.checkExistingUser(rfidId);
    }
}