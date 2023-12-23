import java.util.ArrayList;
import java.util.List;

public class RegistrationBackend {
    private List<Registration> registrations;

    public RegistrationBackend() {
        registrations = new ArrayList<>();
    }

    public boolean registerUser(Registration registration) {
        // Validate the registration data
        if (!isRegistrationValid(registration)) {
            return false;
        }

        // Check if the user already exists
        if (isUserRegistered(registration.getRFID_id())) {
            return false;
        }

        // Add the user to the registrations list
        registrations.add(registration);
        return true;
    }

    public Registration getUserByRFID(String rfid) {
        for (Registration registration : registrations) {
            if (registration.getRFID_id().equals(rfid)) {
                return registration;
            }
        }
        return null;
    }

    public List<Registration> getAllRegistrations() {
        return registrations;
    }

    private boolean isRegistrationValid(Registration registration) {
        // Perform any necessary validation checks here
        if (registration.getRFID_id() == null || registration.getRFID_id().isEmpty()) {
            return false;
        }

        if (registration.getStudent_name() == null || registration.getStudent_name().isEmpty()) {
            return false;
        }

        if (registration.getDepartment() == null || registration.getDepartment().isEmpty()) {
            return false;
        }

        if (registration.getPhone_number() == null || registration.getPhone_number().isEmpty()) {
            return false;
        }



        if (registration.getPassword() == null || registration.getPassword().isEmpty()) {
            return false;
        }

        if (!registration.getPassword().equals(registration.getConfirm_Password())) {
            return false;
        }

        if (registration.getYear_of_study() == null || registration.getYear_of_study().isEmpty()) {
            return false;
        }

        // Add more validation checks as needed
        return true;
    }

    private boolean isUserRegistered(String rfid) {
        // Check if the user with the given RFID is already registered
        for (Registration registration : registrations) {
            if (registration.getRFID_id().equals(rfid)) {
                return true;
            }
        }
        return false;
    }
}
