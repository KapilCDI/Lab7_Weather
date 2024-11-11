package com.example.lab1;

import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordComplexityTest {

    private MainActivity mainActivity = new MainActivity();

    @Test
    public void testMissingUpperCase() {
        assertFalse("Password missing uppercase should fail",
                mainActivity.checkPasswordComplexity("password1#"));
    }

    @Test
    public void testMissingLowerCase() {
        assertFalse("Password missing lowercase should fail",
                mainActivity.checkPasswordComplexity("PASSWORD1#"));
    }

    @Test
    public void testMissingNumber() {
        assertFalse("Password missing number should fail",
                mainActivity.checkPasswordComplexity("Password#"));
    }

    @Test
    public void testMissingSpecialCharacter() {
        assertFalse("Password missing special character should fail",
                mainActivity.checkPasswordComplexity("Password1"));
    }

    @Test
    public void testAllRequirementsMet() {
        assertTrue("Password with all requirements should pass",
                mainActivity.checkPasswordComplexity("Password1#"));
    }
}
