package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_isMixedCase_CharSequence_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsMixedCase() {
        // Test case for mixed case input
        CharSequence mixedCase = "HelloWorld";
        assertTrue(StringUtils.isMixedCase(mixedCase));

        // Test case for all uppercase input
        CharSequence upperCase = "HELLOWORLD";
        assertFalse(StringUtils.isMixedCase(upperCase));

        // Test case for all lowercase input
        CharSequence lowerCase = "helloworld";
        assertFalse(StringUtils.isMixedCase(lowerCase));

        // Test case for single character input (lowercase)
        CharSequence singleLower = "a";
        assertFalse(StringUtils.isMixedCase(singleLower));

        // Test case for single character input (uppercase)
        CharSequence singleUpper = "A";
        assertFalse(StringUtils.isMixedCase(singleUpper));

        // Test case for empty input
        CharSequence emptyInput = "";
        assertFalse(StringUtils.isMixedCase(emptyInput));

        // Test case for null input
        CharSequence nullInput = null;
        try {
            StringUtils.isMixedCase(nullInput);
            fail("Expected an exception to be thrown for null input");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}