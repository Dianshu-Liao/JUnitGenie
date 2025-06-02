package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_31_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequence() {
        CharSequence cs = ""; // Empty CharSequence
        char[] searchChars = {'a', 'b', 'c'};
        
        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequence() {
        CharSequence cs = null; // Null CharSequence
        char[] searchChars = {'a', 'b', 'c'};
        
        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}