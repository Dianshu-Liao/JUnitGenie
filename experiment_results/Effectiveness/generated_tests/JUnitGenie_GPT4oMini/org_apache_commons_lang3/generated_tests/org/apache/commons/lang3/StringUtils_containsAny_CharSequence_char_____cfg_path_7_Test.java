package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptySearchChars() {
        CharSequence cs = "test";
        char[] searchChars = new char[0]; // empty array
        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullSearchChars() {
        CharSequence cs = "test";
        char[] searchChars = null; // null array
        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNonEmptyCharSequence() {
        CharSequence cs = "test";
        char[] searchChars = {'t', 'e', 's', 'x'}; // includes 't' and 'e'
        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result); // This should return true since 't' and 'e' are present
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequence() {
        CharSequence cs = null; // null CharSequence
        char[] searchChars = {'t', 'e', 's'}; // non-empty searchChars
        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result); // This should return false since cs is null
    }

}