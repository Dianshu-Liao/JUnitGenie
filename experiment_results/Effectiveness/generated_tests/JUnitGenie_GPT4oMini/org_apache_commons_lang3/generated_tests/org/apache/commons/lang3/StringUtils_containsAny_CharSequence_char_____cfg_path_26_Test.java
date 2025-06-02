package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndEmptySearchChars() {
        CharSequence cs = null; // @parameter0 must be null
        char[] searchChars = new char[0]; // @parameter1 must be an empty char array

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result); // Expecting false since cs is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndNullSearchChars() {
        CharSequence cs = null; // @parameter0 must be null
        char[] searchChars = null; // @parameter1 must be null

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result); // Expecting false since cs is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}