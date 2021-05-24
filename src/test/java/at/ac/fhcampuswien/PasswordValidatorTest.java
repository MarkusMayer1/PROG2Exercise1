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
}
