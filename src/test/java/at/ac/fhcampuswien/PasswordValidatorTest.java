package at.ac.fhcampuswien;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @BeforeEach
    void setup() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    @DisplayName("Password to short")
    void checkLength_toShort() {
        assertFalse(passwordValidator.checkLength("Max"));
    }

    @Test
    @DisplayName("Password has valid length")
    void checkLength_valid() {
        assertTrue(passwordValidator.checkLength("MaxMustermann"));
    }

    @Test
    @DisplayName("Password to long")
    void checkLength_toLong() {
        assertFalse(passwordValidator.checkLength("MaxMustermannErikaMustermann"));
    }

    @Test
    @DisplayName("Password has no upper case letter")
    void checkUpperCase_Scenario1() {
        assertFalse(passwordValidator.checkUpperCase("maxmustermann"));
    }

    @Test
    @DisplayName("Password has upper case letter")
    void checkUpperCase_Scenario2() {
        assertTrue(passwordValidator.checkUpperCase("MaxMustermann"));
    }

    @Test
    @DisplayName("Password has no lower case letter")
    void checkLowerCase_Scenario1() {
        assertFalse(passwordValidator.checkLowerCase("MAXMUSTERMANN"));
    }

    @Test
    @DisplayName("Password has lower case letter")
    void checkLowerCase_Scenario2() {
        assertTrue(passwordValidator.checkLowerCase("MaxMustermann"));
    }

    @Test
    @DisplayName("Password has no number")
    void checkNumber_Scenario1() {
        assertFalse(passwordValidator.checkNumber("MaxMustermann"));
    }

    @Test
    @DisplayName("Password has number")
    void checkNumber_Scenario2() {
        assertTrue(passwordValidator.checkNumber("MaxMustermann5"));
    }

    @Test
    @DisplayName("Password has no special character")
    void checkSpecialCharacter_Scenario1() {
        assertFalse(passwordValidator.checkSpecialCharacter("MaxMustermann"));
    }

    @Test
    @DisplayName("Password has allowed special character (")
    void checkSpecialCharacter_Scenario2() {
        assertTrue(passwordValidator.checkSpecialCharacter("MaxMustermann("));
    }

    @Test
    @DisplayName("Password has allowed special character )")
    void checkSpecialCharacter_Scenario3() {
        assertTrue(passwordValidator.checkSpecialCharacter("MaxMusterman)n"));
    }

    @Test
    @DisplayName("Password has allowed special character #")
    void checkSpecialCharacter_Scenario4() {
        assertTrue(passwordValidator.checkSpecialCharacter("MaxMusterma#nn"));
    }

    @Test
    @DisplayName("Password has allowed special character $")
    void checkSpecialCharacter_Scenario5() {
        assertTrue(passwordValidator.checkSpecialCharacter("MaxMusterm$ann"));
    }

    @Test
    @DisplayName("Password has allowed special character ?")
    void checkSpecialCharacter_Scenario6() {
        assertTrue(passwordValidator.checkSpecialCharacter("MaxMuster?mann"));
    }

    @Test
    @DisplayName("Password has allowed special character %")
    void checkSpecialCharacter_Scenario7() {
        assertTrue(passwordValidator.checkSpecialCharacter("MaxMuster%mann"));
    }

    @Test
    @DisplayName("Password has allowed special character /")
    void checkSpecialCharacter_Scenario8() {
        assertTrue(passwordValidator.checkSpecialCharacter("MaxMuste/rmann"));
    }

    @Test
    @DisplayName("Password has allowed special character @")
    void checkSpecialCharacter_Scenario9() {
        assertTrue(passwordValidator.checkSpecialCharacter("@MaxMustermann"));
    }

    @Test
    @DisplayName("Password has not allowed special character |")
    void checkSpecialCharacter_Scenario10() {
        assertFalse(passwordValidator.checkSpecialCharacter("Max|Mustermann"));
    }

    @Test
    @DisplayName("Password has not allowed special character *")
    void checkSpecialCharacter_Scenario11() {
        assertFalse(passwordValidator.checkSpecialCharacter("MaxMustermann*"));
    }

    @Test
    @DisplayName("Password has not allowed special character +")
    void checkSpecialCharacter_Scenario12() {
        assertFalse(passwordValidator.checkSpecialCharacter("Ma+xMustermann"));
    }

    @Test
    @DisplayName("Password has not allowed special character -")
    void checkSpecialCharacter_Scenario13() {
        assertFalse(passwordValidator.checkSpecialCharacter("MaxMuster-mann"));
    }

    @Test
    @DisplayName("Password has not allowed special character .")
    void checkSpecialCharacter_Scenario14() {
        assertFalse(passwordValidator.checkSpecialCharacter("MaxMu.stermann"));
    }

    @Test
    @DisplayName("Password has not allowed special character ,")
    void checkSpecialCharacter_Scenario15() {
        assertFalse(passwordValidator.checkSpecialCharacter("MaxMust,ermann"));
    }

    @Test
    @DisplayName("Password has allowed and not allowed special characters :)")
    void checkSpecialCharacter_Scenario16() {
        assertFalse(passwordValidator.checkSpecialCharacter("MaxMustermann:)"));
    }

    @Test
    @DisplayName("Password has allowed and not allowed special characters (@-->)")
    void checkSpecialCharacter_Scenario17() {
        assertFalse(passwordValidator.checkSpecialCharacter("(@Max-Must-ermann>)"));
    }

    @Test
    @DisplayName("Password has not more than two consecutive numbers")
    void checkConsecutiveNumbers_Scenario1() {
        assertTrue(passwordValidator.checkConsecutiveNumbers("Max56Mustermann"));
    }

    @Test
    @DisplayName("Password has more than two consecutive numbers")
    void checkConsecutiveNumbers_Scenario2() {
        assertFalse(passwordValidator.checkConsecutiveNumbers("Max567Mustermann"));
    }

    @Test
    @DisplayName("Password does not have the same number more than three times in a row")
    void checkSameNumbersInARow_Scenario1() {
        assertTrue(passwordValidator.checkSameNumbersInARow("Max555Mustermann"));
    }

    @Test
    @DisplayName("Password has the same number more than three times in a row")
    void checkSameNumbersInARow_Scenario2() {
        assertFalse(passwordValidator.checkSameNumbersInARow("Max5555Mustermann"));
    }
}
