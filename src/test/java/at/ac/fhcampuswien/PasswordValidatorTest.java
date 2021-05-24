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

    @Test
    @DisplayName("Password has no special character")
    void checkSpecialCharacter_Scenario1() {
        passwordValidator = new PasswordValidator("MaxMustermann");
        assertFalse(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed special character (")
    void checkSpecialCharacter_Scenario2() {
        passwordValidator = new PasswordValidator("MaxMustermann(");
        assertTrue(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed special character )")
    void checkSpecialCharacter_Scenario3() {
        passwordValidator = new PasswordValidator("MaxMusterman)n");
        assertTrue(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed special character #")
    void checkSpecialCharacter_Scenario4() {
        passwordValidator = new PasswordValidator("MaxMusterma#nn");
        assertTrue(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed special character $")
    void checkSpecialCharacter_Scenario5() {
        passwordValidator = new PasswordValidator("MaxMusterm$ann");
        assertTrue(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed special character ?")
    void checkSpecialCharacter_Scenario6() {
        passwordValidator = new PasswordValidator("MaxMuster?mann");
        assertTrue(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed special character %")
    void checkSpecialCharacter_Scenario7() {
        passwordValidator = new PasswordValidator("MaxMuster%mann");
        assertTrue(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed special character /")
    void checkSpecialCharacter_Scenario8() {
        passwordValidator = new PasswordValidator("MaxMuste/rmann");
        assertTrue(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed special character @")
    void checkSpecialCharacter_Scenario9() {
        passwordValidator = new PasswordValidator("@MaxMustermann");
        assertTrue(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has not allowed special character |")
    void checkSpecialCharacter_Scenario10() {
        passwordValidator = new PasswordValidator("Max|Mustermann");
        assertFalse(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has not allowed special character *")
    void checkSpecialCharacter_Scenario11() {
        passwordValidator = new PasswordValidator("MaxMustermann*");
        assertFalse(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has not allowed special character +")
    void checkSpecialCharacter_Scenario12() {
        passwordValidator = new PasswordValidator("Ma+xMustermann");
        assertFalse(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has not allowed special character -")
    void checkSpecialCharacter_Scenario13() {
        passwordValidator = new PasswordValidator("MaxMuster-mann");
        assertFalse(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has not allowed special character .")
    void checkSpecialCharacter_Scenario14() {
        passwordValidator = new PasswordValidator("MaxMu.stermann");
        assertFalse(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has not allowed special character ,")
    void checkSpecialCharacter_Scenario15() {
        passwordValidator = new PasswordValidator("MaxMust,ermann");
        assertFalse(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed and not allowed special characters :)")
    void checkSpecialCharacter_Scenario16() {
        passwordValidator = new PasswordValidator("MaxMustermann:)");
        assertFalse(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has allowed and not allowed special characters (@-->)")
    void checkSpecialCharacter_Scenario17() {
        passwordValidator = new PasswordValidator("(@Max-Must-ermann>)");
        assertFalse(passwordValidator.checkSpecialCharacter());
    }

    @Test
    @DisplayName("Password has not more than two consecutive numbers")
    void checkConsecutiveNumbers_Scenario1() {
        passwordValidator = new PasswordValidator("Max56Mustermann");
        assertTrue(passwordValidator.checkConsecutiveNumbers());
    }

    @Test
    @DisplayName("Password has more than two consecutive numbers")
    void checkConsecutiveNumbers_Scenario2() {
        passwordValidator = new PasswordValidator("Max567Mustermann");
        assertFalse(passwordValidator.checkConsecutiveNumbers());
    }

    @Test
    @DisplayName("Password does not have the same number more than three times in a row")
    void checkSameNumbersInARow_Scenario1() {
        passwordValidator = new PasswordValidator("Max555Mustermann");
        assertTrue(passwordValidator.checkSameNumbersInARow());
    }

    @Test
    @DisplayName("Password has the same number more than three times in a row")
    void checkSameNumbersInARow_Scenario2() {
        passwordValidator = new PasswordValidator("Max5555Mustermann");
        assertFalse(passwordValidator.checkSameNumbersInARow());
    }
}
