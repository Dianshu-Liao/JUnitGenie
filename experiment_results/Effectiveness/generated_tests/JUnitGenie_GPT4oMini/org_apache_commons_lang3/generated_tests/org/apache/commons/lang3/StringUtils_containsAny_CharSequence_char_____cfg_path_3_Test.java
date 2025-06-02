package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndEmptyCharArray() {
        CharSequence cs = null; // @parameter0 must be null
        char[] searchChars = new char[0]; // @parameter1 must be an empty char array

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result); // Expecting false since cs is null and searchChars is empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}