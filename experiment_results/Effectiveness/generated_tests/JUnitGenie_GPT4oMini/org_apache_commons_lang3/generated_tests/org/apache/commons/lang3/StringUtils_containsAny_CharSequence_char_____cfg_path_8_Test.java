package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptySearchChars() {
        // Given
        CharSequence cs = "test";
        char[] searchChars = new char[0]; // Empty array

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequence() {
        // Given
        CharSequence cs = null;
        char[] searchChars = {'t', 'e', 's', 't'};

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequence() {
        // Given
        CharSequence cs = "";
        char[] searchChars = {'t', 'e', 's', 't'};

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNonEmptyCharSequenceAndEmptySearchChars() {
        // Given
        CharSequence cs = "test";
        char[] searchChars = new char[0]; // Empty array

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

}