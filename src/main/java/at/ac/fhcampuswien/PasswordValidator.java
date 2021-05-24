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

    public boolean checkSpecialCharacter() {
        if (!password.replaceAll("[a-zA-Z0-9()#$?!%/@]", "").equals("")) return false;
        return Pattern.compile("[()#$?!%/@]").matcher(password).find();
    }

    public boolean checkConsecutiveNumbers() {
        return !Pattern.compile("(012|123|234|345|456|567|789)").matcher(password).find();
    }
}
