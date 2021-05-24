package at.ac.fhcampuswien;

import java.util.regex.Pattern;

public class PasswordValidator {
    private String password;

    public PasswordValidator(String password) {
        this.password = password;
    }

    public boolean checkLength() {
        return password.length() >= 8 && password.length() <= 25;
    }

    public boolean checkLowerCase() {
        return Pattern.compile("[a-z]").matcher(password).find();
    }

    public boolean checkUpperCase() {
        return Pattern.compile("[A-Z]").matcher(password).find();
    }

    public boolean checkNumber() {
        return Pattern.compile("[0-9]").matcher(password).find();
    }
}
