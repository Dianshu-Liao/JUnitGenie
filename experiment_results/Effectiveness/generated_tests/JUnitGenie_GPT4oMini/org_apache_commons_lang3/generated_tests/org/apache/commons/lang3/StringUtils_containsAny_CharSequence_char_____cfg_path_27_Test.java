package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndEmptySearchChars() {
        CharSequence cs = null; // @parameter0 must be null
        char[] searchChars = new char[0]; // @parameter1 must be an empty array

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}