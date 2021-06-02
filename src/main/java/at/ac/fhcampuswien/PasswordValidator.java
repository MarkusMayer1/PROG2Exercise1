package at.ac.fhcampuswien;

import java.util.regex.Pattern;

public class PasswordValidator {
    public boolean checkLength(String password) {
        return password.length() >= 8 && password.length() <= 25;
    }

    public boolean checkLowerCase(String password) {
        return Pattern.compile("[a-z]").matcher(password).find();
    }

    public boolean checkUpperCase(String password) {
        return Pattern.compile("[A-Z]").matcher(password).find();
    }

    public boolean checkNumber(String password) {
        return Pattern.compile("[0-9]").matcher(password).find();
    }

    public boolean checkSpecialCharacter(String password) {
        if (!password.replaceAll("[a-zA-Z0-9()#$?!%/@]", "").equals("")) return false;
        return Pattern.compile("[()#$?!%/@]").matcher(password).find();
    }

    public boolean checkConsecutiveNumbers(String password) {
        return !Pattern.compile("(012|123|234|345|456|567|789)").matcher(password).find();
    }

    public boolean checkSameNumbersInARow(String password) {
        return !Pattern.compile("(0000|1111|2222|3333|4444|5555|6666|7777|8888|9999)").matcher(password).find();
    }
}
