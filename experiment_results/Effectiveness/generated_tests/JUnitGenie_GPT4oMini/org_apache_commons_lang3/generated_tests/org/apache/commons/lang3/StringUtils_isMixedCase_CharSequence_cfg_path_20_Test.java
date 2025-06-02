package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_isMixedCase_CharSequence_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testIsMixedCase() {
        // Test case for mixed case input
        CharSequence input = "HelloWorld";
        boolean result = StringUtils.isMixedCase(input);
        assertTrue(result);

        // Test case for all uppercase input
        input = "HELLOWORLD";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case for all lowercase input
        input = "helloworld";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case for single character input (lowercase)
        input = "h";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case for single character input (uppercase)
        input = "H";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case for empty input
        input = "";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case for null input (should not be tested as per constraints)
        try {
            input = null;
            result = StringUtils.isMixedCase(input);
            fail("Expected an exception for null input");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}