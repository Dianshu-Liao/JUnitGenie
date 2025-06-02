package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testContainsAny_NullCharSequenceAndNullSearchChars() {
        // Given
        CharSequence cs = null; // parameter0 must be null
        char[] searchChars = null; // parameter1 can also be null

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result); // Expected: false
    }

    @Test(timeout = 4000)
    public void testContainsAny_NullCharSequenceAndEmptySearchChars() {
        // Given
        CharSequence cs = null; // parameter0 must be null
        char[] searchChars = new char[0]; // parameter1 must be an empty char array

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result); // Expected: false
    }

    @Test(timeout = 4000)
    public void testContainsAny_EmptyCharSequenceAndNullSearchChars() {
        // Given
        CharSequence cs = ""; // An empty CharSequence
        char[] searchChars = null; // parameter1 can also be null

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result); // Expected: false
    }

    @Test(timeout = 4000)
    public void testContainsAny_EmptyCharSequenceAndEmptySearchChars() {
        // Given
        CharSequence cs = ""; // An empty CharSequence
        char[] searchChars = new char[0]; // parameter1 must be an empty char array

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result); // Expected: false
    }

}