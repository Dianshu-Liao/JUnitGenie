package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndEmptySearchChars() {
        CharSequence cs = null; // This will ensure isEmpty returns false
        char[] searchChars = new char[0]; // This will ensure ArrayUtils.isEmpty returns true

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}