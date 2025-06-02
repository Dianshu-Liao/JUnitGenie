package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNonEmptyCharSequenceAndEmptyCharArray() {
        CharSequence cs = "hello";
        char[] searchChars = new char[0]; // represents an empty array
        
        // executing the method under test
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        // asserting that the result is false
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCharSequenceAndNullCharArray() {
        CharSequence cs = null; // represents a null CharSequence
        char[] searchChars = null; // represents a null char array
        
        // executing the method under test
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        // asserting that the result is false
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNonEmptyCharSequenceAndNullCharArray() {
        CharSequence cs = "hello";
        char[] searchChars = null; // represents a null char array
        
        // executing the method under test
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        // asserting that the result is false
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithEmptyCharSequenceAndEmptyCharArray() {
        CharSequence cs = ""; // represents an empty CharSequence
        char[] searchChars = new char[0]; // represents an empty array
        
        // executing the method under test
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        // asserting that the result is false
        assertFalse(result);
    }

}