package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_isAllUpperCase_CharSequence_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithUpperCase() {
        // Test a CharSequence with all uppercase characters
        CharSequence input = "HELLO";
        boolean result = StringUtils.isAllUpperCase(input);
        assertTrue(result);
    }
    
    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithMixedCase() {
        // Test a CharSequence with mixed case characters
        CharSequence input = "Hello";
        boolean result = StringUtils.isAllUpperCase(input);
        assertFalse(result);
    }
    
    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithLowerCase() {
        // Test a CharSequence with all lowercase characters
        CharSequence input = "hello";
        boolean result = StringUtils.isAllUpperCase(input);
        assertFalse(result);
    }
    
    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithEmptyString() {
        // Test an empty CharSequence
        CharSequence input = "";
        boolean result = StringUtils.isAllUpperCase(input);
        assertFalse(result);
    }
    
    @Test(timeout = 4000)
    public void testIsAllUpperCase_WithNull() {
        // We expect a NullPointerException when input is null
        CharSequence input = null;
        try {
            StringUtils.isAllUpperCase(input);
            fail("Expected a NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // expected
        }
    }

}