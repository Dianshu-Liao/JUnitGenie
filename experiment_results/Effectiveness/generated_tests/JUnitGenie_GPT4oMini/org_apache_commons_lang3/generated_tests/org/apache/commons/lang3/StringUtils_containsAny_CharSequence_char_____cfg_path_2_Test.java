package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyParameters() {
        // Test when cs is null and searchChars is null
        CharSequence cs = null;
        char[] searchChars = null;

        // Expecting false since both parameters are empty
        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle unexpected exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndEmptyArray() {
        // Test when cs is null and searchChars is empty
        CharSequence cs = null;
        char[] searchChars = new char[0];

        // Expecting false since cs is null and searchChars is empty
        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle unexpected exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequenceAndNullArray() {
        // Test when cs is empty and searchChars is null
        CharSequence cs = "";
        char[] searchChars = null;

        // Expecting false since searchChars is null
        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle unexpected exception
            e.printStackTrace();
        }
    }

}