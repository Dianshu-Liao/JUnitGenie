package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrMatcher;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrMatcher_charSetMatcher_String_cfg_path_1_Test {

    private static class CharSetMatcher extends StrMatcher {
        // Implementing the abstract method
        @Override
        public int isMatch(char[] buffer, int start, int length, int index) {
            // Dummy implementation for testing purposes
            return 0;
        }
    }

    @Test(timeout = 4000)
    public void testCharSetMatcherWithValidInput() {
        String input = "abc";
        StrMatcher matcher = StrMatcher.charSetMatcher(input);
        assertNotNull(matcher);
        assertTrue(matcher instanceof CharSetMatcher);
    }

    @Test(timeout = 4000)
    public void testCharSetMatcherWithSingleCharacter() {
        String input = "a";
        StrMatcher matcher = StrMatcher.charSetMatcher(input);
        assertNotNull(matcher);
        assertTrue(matcher instanceof CharSetMatcher); // Changed from CharMatcher to CharSetMatcher
    }

    @Test(timeout = 4000)
    public void testCharSetMatcherWithEmptyString() {
        String input = "";
        StrMatcher matcher = StrMatcher.charSetMatcher(input);
        assertNotNull(matcher);
        assertTrue(matcher instanceof StrMatcher); // Assuming NONE_MATCHER is an instance of StrMatcher
    }

    @Test(timeout = 4000)
    public void testCharSetMatcherWithNullInput() {
        String input = null;
        try {
            StrMatcher matcher = StrMatcher.charSetMatcher(input);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            // Expected exception
        }
    }


}