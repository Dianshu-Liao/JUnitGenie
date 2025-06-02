package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class Validate_matchesPattern_CharSequence_String_String_Object_____cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testMatchesPatternThrowsException() {
        // Given
        CharSequence input = "invalidInput";
        String pattern = "\\d+"; // Pattern expects digits
        String message = "Input does not match the pattern";
        Object[] values = {}; // No additional values

        // When
        try {
            Validate.matchesPattern(input, pattern, message, values);
        } catch (IllegalArgumentException e) {
            // Then
            // Exception is expected, we can assert the message if needed
            assert e.getMessage().equals("Input does not match the pattern");
            throw e; // Rethrow to satisfy the expected exception in the test annotation
        }
    }

}