package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_isAllUpperCase_CharSequence_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithEmptyString() {
        // Test with an empty CharSequence
        CharSequence input = "";
        boolean result = StringUtils.isAllUpperCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithNull() {
        // Test with a null CharSequence
        CharSequence input = null;
        boolean result = StringUtils.isAllUpperCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithAllUpperCase() {
        // Test with a CharSequence that is all upper case
        CharSequence input = "HELLO";
        boolean result = StringUtils.isAllUpperCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithMixedCase() {
        // Test with a CharSequence that has mixed case
        CharSequence input = "Hello";
        boolean result = StringUtils.isAllUpperCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithAllLowerCase() {
        // Test with a CharSequence that is all lower case
        CharSequence input = "hello";
        boolean result = StringUtils.isAllUpperCase(input);
        assertFalse(result);
    }

}