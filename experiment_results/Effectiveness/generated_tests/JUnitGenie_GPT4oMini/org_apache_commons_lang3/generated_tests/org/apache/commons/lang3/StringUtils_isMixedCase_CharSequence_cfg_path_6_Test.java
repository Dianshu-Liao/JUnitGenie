package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_isMixedCase_CharSequence_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testIsMixedCase_NonNullSingleCharacter() {
        // Test with a single character (should return false)
        CharSequence input = "A"; // or "a"
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsMixedCase_NonNullEmptyString() {
        // Test with an empty string (should return false)
        CharSequence input = "";
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsMixedCase_NonNullMixedCase() {
        // Test with a mixed case string (should return true)
        CharSequence input = "AbC";
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsMixedCase_NonNullAllUppercase() {
        // Test with an all uppercase string (should return false)
        CharSequence input = "ABC";
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsMixedCase_NonNullAllLowercase() {
        // Test with an all lowercase string (should return false)
        CharSequence input = "abc";
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }

}