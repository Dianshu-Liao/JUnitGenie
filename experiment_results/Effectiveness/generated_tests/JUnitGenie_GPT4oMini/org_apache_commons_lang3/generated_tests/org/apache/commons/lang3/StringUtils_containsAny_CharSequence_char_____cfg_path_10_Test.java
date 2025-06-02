package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndEmptySearchChars() {
        // Given
        CharSequence cs = null;
        char[] searchChars = new char[0]; // empty array

        // When
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Then
        assertFalse(result);
    }

}