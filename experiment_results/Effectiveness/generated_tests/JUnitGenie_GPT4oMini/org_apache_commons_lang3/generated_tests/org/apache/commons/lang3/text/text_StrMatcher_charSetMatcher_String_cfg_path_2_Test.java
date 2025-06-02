package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrMatcher;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrMatcher_charSetMatcher_String_cfg_path_2_Test {

    private static class TestCharMatcher extends StrMatcher {
        @Override
        public int isMatch(char[] buffer, int start, int length, int index) {
            return 0; // Dummy implementation for testing
        }
    }

    @Test(timeout = 4000)
    public void testCharSetMatcherWithSingleCharacter() {
        // Test case for a single character input
        StrMatcher matcher = StrMatcher.charSetMatcher("a");
        assertTrue(matcher instanceof StrMatcher.CharMatcher);
    }

    @Test(timeout = 4000)
    public void testCharSetMatcherWithMultipleCharacters() {
        // Test case for multiple characters input
        StrMatcher matcher = StrMatcher.charSetMatcher("abc");
        assertTrue(matcher instanceof StrMatcher.CharSetMatcher);
    }

    @Test(timeout = 4000)
    public void testCharSetMatcherWithEmptyString() {
        // Test case for empty string input
        StrMatcher matcher = StrMatcher.charSetMatcher("");
        assertTrue(matcher.equals(StrMatcher.noneMatcher())); // Use the public method to get NONE_MATCHER
    }

    @Test(timeout = 4000)
    public void testCharSetMatcherWithNull() {
        // Test case for null input
        try {
            StrMatcher.charSetMatcher((String) null); // Specify the type to avoid ambiguity
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            // Expected exception
        }
    }


}