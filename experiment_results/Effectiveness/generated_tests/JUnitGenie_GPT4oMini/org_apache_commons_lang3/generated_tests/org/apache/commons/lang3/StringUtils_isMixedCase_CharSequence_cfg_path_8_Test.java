package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_isMixedCase_CharSequence_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testIsMixedCase() {
        // Test case where the input is a mixed case string
        CharSequence mixedCase = "HelloWorld";
        assertTrue(StringUtils.isMixedCase(mixedCase));

        // Test case where the input is all lowercase
        CharSequence lowerCase = "helloworld";
        assertFalse(StringUtils.isMixedCase(lowerCase));

        // Test case where the input is all uppercase
        CharSequence upperCase = "HELLOWORLD";
        assertFalse(StringUtils.isMixedCase(upperCase));

        // Test case where the input is a single character (lowercase)
        CharSequence singleLower = "a";
        assertFalse(StringUtils.isMixedCase(singleLower));

        // Test case where the input is a single character (uppercase)
        CharSequence singleUpper = "A";
        assertFalse(StringUtils.isMixedCase(singleUpper));

        // Test case where the input is empty
        CharSequence empty = "";
        assertFalse(StringUtils.isMixedCase(empty));

        // Test case where the input is null
        CharSequence nullInput = null;
        try {
            StringUtils.isMixedCase(nullInput);
            fail("Expected an exception to be thrown for null input");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}