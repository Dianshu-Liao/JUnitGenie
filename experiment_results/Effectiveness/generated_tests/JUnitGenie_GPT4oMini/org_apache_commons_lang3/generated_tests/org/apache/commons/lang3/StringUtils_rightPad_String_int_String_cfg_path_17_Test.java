package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNonNullStringAndDefaultPadding() {
        String str = "test";
        int size = 10;
        String padStr = null; // This will trigger the default padding (SPACE)
        
        String result = StringUtils.rightPad(str, size, padStr);
        
        assertEquals("test      ", result); // Expecting "test      " (6 spaces)
    }

    @Test(timeout = 4000)
    public void testRightPadWithNonNullStringAndCustomPadding() {
        String str = "test";
        int size = 10;
        String padStr = "*"; // Custom padding
        
        String result = StringUtils.rightPad(str, size, padStr);
        
        assertEquals("test*****", result); // Expecting "test*****"
    }

    @Test(timeout = 4000)
    public void testRightPadWithExactSize() {
        String str = "test";
        int size = 4; // Same size as the string
        String padStr = "*"; 
        
        String result = StringUtils.rightPad(str, size, padStr);
        
        assertEquals("test", result); // Expecting "test"
    }

    @Test(timeout = 4000)
    public void testRightPadWithLargerSize() {
        String str = "test";
        int size = 12; // Larger size
        String padStr = "ab"; // Custom padding
        
        String result = StringUtils.rightPad(str, size, padStr);
        
        assertEquals("testababab", result); // Expecting "testababab"
    }

    @Test(timeout = 4000)
    public void testRightPadWithSingleCharacterPadding() {
        String str = "test";
        int size = 10;
        String padStr = "#"; // Single character padding
        
        String result = StringUtils.rightPad(str, size, padStr);
        
        assertEquals("test######", result); // Expecting "test######"
    }

    @Test(timeout = 4000)
    public void testRightPadWithNullString() {
        String str = null;
        int size = 10;
        String padStr = "*"; 
        
        String result = StringUtils.rightPad(str, size, padStr);
        
        assertEquals(null, result); // Expecting null
    }

}