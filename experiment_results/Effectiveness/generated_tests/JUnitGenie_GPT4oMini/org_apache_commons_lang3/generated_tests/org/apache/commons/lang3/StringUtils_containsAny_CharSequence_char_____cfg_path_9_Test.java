package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequenceAndEmptySearchChars() {
        CharSequence cs = ""; // meets the condition of length() returning 0
        char[] searchChars = new char[0]; // meets the condition of being an empty character array
        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequenceAndNullSearchChars() {
        CharSequence cs = ""; // meets the condition of length() returning 0
        char[] searchChars = null; // meets the condition of being null
        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}