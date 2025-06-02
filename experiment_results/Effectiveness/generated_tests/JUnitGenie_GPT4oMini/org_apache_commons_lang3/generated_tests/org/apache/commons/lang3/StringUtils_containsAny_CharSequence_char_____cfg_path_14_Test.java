package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndEmptySearchChars() {
        CharSequence cs = null; // This satisfies the condition for isEmpty(CharSequence)
        char[] searchChars = new char[0]; // This satisfies the condition for ArrayUtils.isEmpty(char[])

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}