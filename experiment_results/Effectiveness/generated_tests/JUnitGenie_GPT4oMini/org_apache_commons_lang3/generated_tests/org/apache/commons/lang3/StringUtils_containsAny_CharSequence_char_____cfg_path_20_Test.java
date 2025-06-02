package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequenceAndEmptySearchChars() {
        // Given
        CharSequence cs = ""; // Empty CharSequence
        char[] searchChars = {}; // Empty searchChars

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNonEmptyCharSequenceAndEmptySearchChars() {
        // Given
        CharSequence cs = "test"; // Non-empty CharSequence
        char[] searchChars = {}; // Empty searchChars

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequenceAndNonEmptySearchChars() {
        // Given
        CharSequence cs = ""; // Empty CharSequence
        char[] searchChars = {'t', 'e', 's', 't'}; // Non-empty searchChars

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNonEmptyCharSequenceAndNonEmptySearchChars() {
        // Given
        CharSequence cs = "test"; // Non-empty CharSequence
        char[] searchChars = {'t', 'e', 's', 't'}; // Non-empty searchChars

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

}