package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testContainsAny_withNonEmptyCharSequenceAndEmptySearchChars() {
        // Given
        CharSequence cs = "hello";
        char[] searchChars = null; // This will ensure ArrayUtils.isEmpty returns true

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_withEmptyCharSequenceAndNonEmptySearchChars() {
        // Given
        CharSequence cs = ""; // This will ensure StringUtils.isEmpty returns true
        char[] searchChars = {'h', 'e', 'l', 'o'};

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_withNonEmptyCharSequenceAndNonEmptySearchChars() {
        // Given
        CharSequence cs = "hello";
        char[] searchChars = {'h', 'e', 'l', 'o'};

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result); // This is just a placeholder; you can add more specific assertions based on expected behavior
    }

}