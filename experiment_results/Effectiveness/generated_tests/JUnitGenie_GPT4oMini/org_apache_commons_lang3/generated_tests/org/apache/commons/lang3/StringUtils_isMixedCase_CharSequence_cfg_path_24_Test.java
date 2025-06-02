package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringUtils_isMixedCase_CharSequence_cfg_path_24_Test {

    @Test(timeout = 4000)
    public void testIsMixedCaseWithMixedCaseString() {
        CharSequence input = "TeSt";
        boolean result = StringUtils.isMixedCase(input);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseWithUpperCaseString() {
        CharSequence input = "TEST";
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseWithLowerCaseString() {
        CharSequence input = "test";
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseWithEmptyString() {
        CharSequence input = "";
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseWithNull() {
        CharSequence input = null;
        try {
            boolean result = StringUtils.isMixedCase(input);
            // This line should not be reached because we expect an exception to be thrown
            assertFalse("Expected an exception to be thrown for null input", result);
        } catch (NullPointerException e) {
            // expected behavior
        }
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseWithSingleCharacter() {
        CharSequence input = "A";
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
        
        input = "a";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }
    
    @Test(timeout = 4000)
    public void testIsMixedCaseWithWhitespace() {
        CharSequence input = " ";
        boolean result = StringUtils.isMixedCase(input);
        assertFalse(result);
        
        input = " A ";
        result = StringUtils.isMixedCase(input);
        assertFalse(result);
    }

}