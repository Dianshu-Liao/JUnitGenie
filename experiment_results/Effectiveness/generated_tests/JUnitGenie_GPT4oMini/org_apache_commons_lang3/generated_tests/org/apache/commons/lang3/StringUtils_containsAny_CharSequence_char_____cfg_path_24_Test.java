package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_24_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequenceAndEmptyArray() {
        // Arrange
        CharSequence cs = null; // meets the constraint for isEmpty(CharSequence)
        char[] searchChars = new char[0]; // meets the constraint for isEmpty(char[])

        // Act
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequenceAndNonEmptyArray() {
        // Arrange
        CharSequence cs = null; // meets the constraint for isEmpty(CharSequence)
        char[] searchChars = new char[] {'a'}; // meets the non-null constraint and is an array

        // Act
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNonEmptyCharSequenceAndEmptyArray() {
        // Arrange
        CharSequence cs = "test"; // non-null and non-empty
        char[] searchChars = new char[0]; // meets the constraint for isEmpty(char[])

        // Act
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNonEmptyCharSequenceAndNonEmptyArray() {
        // Arrange
        CharSequence cs = "test"; // non-null and non-empty
        char[] searchChars = new char[] {'a', 'e', 'i', 'o', 'u'}; // non-null and contains vowels

        // Act
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Assert
        assertFalse(result); // 'test' does not contain any vowels
    }

}