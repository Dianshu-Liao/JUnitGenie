package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testContainsAny() {
        // Test case where cs is not null and searchChars is empty (should return false)
        CharSequence cs = "example";
        char[] searchChars = {}; // Empty array 

        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_withNullCharSequence() {
        // Test case where cs is null (should return false)
        CharSequence cs = null;
        char[] searchChars = {'a', 'e'};

        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_withEmptySearchChars() {
        // Test case where cs is not null and searchChars is empty (should return false)
        CharSequence cs = "test";
        char[] searchChars = {}; // Empty array 

        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result);
    }
    
    @Test(timeout = 4000)
    public void testContainsAny_withSomeCharacters() {
        // Test case where cs contains some characters and searchChars
        CharSequence cs = "abc";
        char[] searchChars = {'a', 'd'};

        boolean result = StringUtils.containsAny(cs, searchChars);
        assertTrue(result);
    }
    
    @Test(timeout = 4000)
    public void testContainsAny_withNoMatch() {
        // Test case where cs does not contain searchChars
        CharSequence cs = "xyz";
        char[] searchChars = {'a', 'b', 'c'};

        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result);
    }

}