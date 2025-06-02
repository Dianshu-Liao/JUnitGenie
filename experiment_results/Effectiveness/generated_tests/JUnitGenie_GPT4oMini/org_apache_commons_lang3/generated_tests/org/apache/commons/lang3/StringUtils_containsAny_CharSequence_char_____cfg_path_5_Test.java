package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndNullArray() {
        try {
            CharSequence cs = null;
            char[] searchChars = null;
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndEmptyArray() {
        try {
            CharSequence cs = null;
            char[] searchChars = new char[0];
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}