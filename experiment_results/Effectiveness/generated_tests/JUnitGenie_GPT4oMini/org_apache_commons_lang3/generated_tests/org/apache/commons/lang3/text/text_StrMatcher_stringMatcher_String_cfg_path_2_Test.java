package org.apache.commons.lang3.text;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrMatcher;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class text_StrMatcher_stringMatcher_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testStringMatcherWithNonEmptyString() {
        String testString = "test";
        StrMatcher result = null;
        try {
            result = StrMatcher.stringMatcher(testString);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        assertNotNull("Expected a non-null StrMatcher for a non-empty string", result);
    }

    @Test(timeout = 4000)
    public void testStringMatcherWithEmptyString() {
        String testString = "";
        StrMatcher result = null;
        try {
            result = StrMatcher.stringMatcher(testString);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        assertNotNull("Expected a non-null StrMatcher for an empty string", result);
        // Since the result should be NONE_MATCHER, we can check for that if needed
    }

    @Test(timeout = 4000)
    public void testStringMatcherWithNullString() {
        String testString = null;
        StrMatcher result = null;
        try {
            result = StrMatcher.stringMatcher(testString);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        assertNotNull("Expected a non-null StrMatcher when passing null", result);
    }

}