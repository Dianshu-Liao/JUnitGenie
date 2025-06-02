package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_isMixedCase_CharSequence_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testIsMixedCase() {
        // Test case where the input is a mixed case string
        CharSequence input = "HelloWorld";
        boolean result = StringUtils.isMixedCase(input);
        assertTrue(result);

        // Test case where the input is all lowercase
        input = "helloworld";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case where the input is all uppercase
        input = "HELLOWORLD";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case where the input is a single character (lowercase)
        input = "h";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case where the input is a single character (uppercase)
        input = "H";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case where the input is empty
        input = "";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);

        // Test case where the input is null
        try {
            result = StringUtils.isMixedCase(null);
            fail("Expected an exception to be thrown for null input");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}