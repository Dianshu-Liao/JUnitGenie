package org.apache.commons.lang3.text;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrMatcher;
import org.apache.commons.lang3.text.StrMatcher.StringMatcher;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class text_StrMatcher_stringMatcher_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testStringMatcherWithValidString() {
        String testString = "test";
        try {
            StrMatcher matcher = StrMatcher.stringMatcher(testString);
            assertNotNull(matcher);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringMatcherWithEmptyString() {
        String testString = "";
        try {
            StrMatcher matcher = StrMatcher.stringMatcher(testString);
            assertNotNull(matcher); // Should return NONE_MATCHER
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringMatcherWithNullString() {
        String testString = null;
        try {
            StrMatcher matcher = StrMatcher.stringMatcher(testString);
            assertNotNull(matcher); // Should return NONE_MATCHER
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}