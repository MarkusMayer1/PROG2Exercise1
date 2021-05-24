package at.ac.fhcampuswien;

public class PasswordValidator {
    private String password;

    public PasswordValidator(String password) {
        this.password = password;
    }

    public boolean checkLength() {
        return password.length() >= 8 && password.length() <= 25;
    }
}
