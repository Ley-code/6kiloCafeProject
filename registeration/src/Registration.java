
public class Registration {

    private String RFID_id;


    private String Student_name;


    private String Department;


    private String Phone_number;


    private String Email;


    private String Password;


    private String Confirm_Password;


    private String Year_of_study;

    public Registration(String RFID_id, String student_name,
                        String department, String phone_number ,
                        String password, String confirm_Password, String year_of_study) {
        this.RFID_id = RFID_id;
        Student_name = student_name;
        Department = department;
        Phone_number = phone_number;

        Password = password;
        Confirm_Password = confirm_Password;
        Year_of_study = year_of_study;
    }

    public String getRFID_id() {
        return RFID_id;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public String getDepartment() {
        return Department;
    }

    public String getPhone_number() {
        return Phone_number;
    }



    public String getPassword() {
        return Password;
    }

    public String getConfirm_Password() {
        return Confirm_Password;
    }

    public void setRFID_id(String RFID_id) {
        this.RFID_id = RFID_id;
    }

    public void setStudent_name(String student_name) {
        Student_name = student_name;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }



    public void setPassword(String password) {
        Password = password;
    }

    public void setConfirm_Password(String confirm_Password) {
        Confirm_Password = confirm_Password;
    }

    public void setYear_of_study(String year_of_study) {
        Year_of_study = year_of_study;
    }

    public String getYear_of_study() {
        return Year_of_study;

    }
}

