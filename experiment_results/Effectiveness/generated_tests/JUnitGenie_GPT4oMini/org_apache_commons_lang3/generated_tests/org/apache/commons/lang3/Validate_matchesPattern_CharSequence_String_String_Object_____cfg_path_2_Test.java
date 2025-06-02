package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.fail;

public class Validate_matchesPattern_CharSequence_String_String_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMatchesPatternValidInput() {
        // Test case to cover the path where input matches the pattern
        String input = "test@example.com";
        String pattern = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        String message = "Input does not match the expected pattern.";
        Object[] values = new Object[] {};

        try {
            Validate.matchesPattern(input, pattern, message, values);
        } catch (IllegalArgumentException e) {
            // Handle the unexpected exception
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testMatchesPatternInvalidInput() {
        // Test case to cover the throw statement by providing invalid input
        String input = "invalid-email";
        String pattern = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        String message = "Input does not match the expected pattern.";
        Object[] values = new Object[] {};

        try {
            Validate.matchesPattern(input, pattern, message, values);
            fail("Expected IllegalArgumentException to be thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception, test passes.
        }
    }


}