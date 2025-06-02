package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_isMixedCase_CharSequence_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testIsMixedCase() {
        // Test case where the input is a mixed case string
        CharSequence input = "HelloWorld";
        assertTrue(StringUtils.isMixedCase(input));

        // Test case where the input is all lowercase
        input = "helloworld";
        assertFalse(StringUtils.isMixedCase(input));

        // Test case where the input is all uppercase
        input = "HELLOWORLD";
        assertFalse(StringUtils.isMixedCase(input));

        // Test case where the input is a single character (lowercase)
        input = "h";
        assertFalse(StringUtils.isMixedCase(input));

        // Test case where the input is a single character (uppercase)
        input = "H";
        assertFalse(StringUtils.isMixedCase(input));

        // Test case where the input is empty
        input = "";
        assertFalse(StringUtils.isMixedCase(input));

        // Test case where the input is null
        try {
            StringUtils.isMixedCase(null);
            fail("Expected an exception to be thrown for null input");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}