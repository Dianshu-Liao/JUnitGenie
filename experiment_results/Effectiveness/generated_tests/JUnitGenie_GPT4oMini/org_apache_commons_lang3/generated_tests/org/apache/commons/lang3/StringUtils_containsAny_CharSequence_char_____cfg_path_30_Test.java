package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_30_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequenceAndNullSearchChars() {
        CharSequence cs = ""; // Empty CharSequence
        char[] searchChars = null; // Null searchChars

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result); // Expecting false since cs is empty and searchChars is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNonEmptyCharSequenceAndEmptySearchChars() {
        CharSequence cs = "test"; // Non-empty CharSequence
        char[] searchChars = new char[0]; // Empty searchChars

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result); // Expecting false since searchChars is empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}