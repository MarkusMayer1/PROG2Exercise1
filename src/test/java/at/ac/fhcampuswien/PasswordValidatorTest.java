package at.ac.fhcampuswien;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @Test
    @DisplayName("Password to short")
    void checkLength_toShort() {
        passwordValidator = new PasswordValidator("Max");
        assertFalse(passwordValidator.checkLength());
    }

    @Test
    @DisplayName("Password has valid length")
    void checkLength_valid() {
        passwordValidator = new PasswordValidator("MaxMustermann");
        assertTrue(passwordValidator.checkLength());
    }

    @Test
    @DisplayName("Password to long")
    void checkLength_toLong() {
        passwordValidator = new PasswordValidator("MaxMustermannErikaMustermann");
        assertFalse(passwordValidator.checkLength());
    }

    @Test
    @DisplayName("Password has no upper case letter")
    void checkUpperCase_Scenario1() {
        passwordValidator = new PasswordValidator("maxmustermann");
        assertFalse(passwordValidator.checkUpperCase());
    }

    @Test
    @DisplayName("Password has upper case letter")
    void checkUpperCase_Scenario2() {
        passwordValidator = new PasswordValidator("MaxMustermann");
        assertTrue(passwordValidator.checkUpperCase());
    }

    @Test
    @DisplayName("Password has no lower case letter")
    void checkLowerCase_Scenario1() {
        passwordValidator = new PasswordValidator("MAXMUSTERMANN");
        assertFalse(passwordValidator.checkLowerCase());
    }

    @Test
    @DisplayName("Password has lower case letter")
    void checkLowerCase_Scenario2() {
        passwordValidator = new PasswordValidator("MaxMustermann");
        assertTrue(passwordValidator.checkLowerCase());
    }

    @Test
    @DisplayName("Password has no number")
    void checkNumber_Scenario1() {
        passwordValidator = new PasswordValidator("MaxMustermann");
        assertFalse(passwordValidator.checkNumber());
    }

    @Test
    @DisplayName("Password has number")
    void checkNumber_Scenario2() {
        passwordValidator = new PasswordValidator("MaxMustermann5");
        assertTrue(passwordValidator.checkNumber());
    }
}
