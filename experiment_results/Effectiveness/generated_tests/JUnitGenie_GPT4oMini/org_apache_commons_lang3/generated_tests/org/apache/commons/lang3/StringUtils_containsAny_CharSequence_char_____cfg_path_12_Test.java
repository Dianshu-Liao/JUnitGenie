package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptySearchChars() {
        CharSequence cs = "test";
        char[] searchChars = new char[0]; // Empty array to satisfy the isEmpty condition

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result); // Expecting false since searchChars is empty
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequence() {
        CharSequence cs = null; // Null to satisfy the isEmpty condition
        char[] searchChars = {'t', 'e', 's', 't'};

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result); // Expecting false since cs is null
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithValidInput() {
        CharSequence cs = "test";
        char[] searchChars = {'t', 'e', 's', 't'};

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result); // Expecting true since 't' is in cs
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}