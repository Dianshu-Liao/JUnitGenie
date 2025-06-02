package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_char_cfg_path_1_Test {

    private static final int PAD_LIMIT = 8192; // Assuming this is defined somewhere in the actual class

    @Test(timeout = 4000)
    public void testRightPad() {
        String str = "test";
        int size = 8; // size > str.length()
        char padChar = ' ';
        
        // Expected output: "test    "
        String result = StringUtils.rightPad(str, size, padChar);
        assertEquals("test    ", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithNull() {
        String str = null;
        int size = 5;
        char padChar = ' ';
        
        // Expected output: null
        String result = StringUtils.rightPad(str, size, padChar);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithNoPaddingNeeded() {
        String str = "test";
        int size = 4; // size == str.length()
        char padChar = ' ';
        
        // Expected output: "test"
        String result = StringUtils.rightPad(str, size, padChar);
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithExceedingPadLimit() {
        String str = "test";
        int size = 8200; // size > str.length() and exceeds PAD_LIMIT
        char padChar = ' ';
        
        // Expected output: "test" followed by 8196 spaces
        String result = StringUtils.rightPad(str, size, padChar);
        assertEquals("test" + StringUtils.repeat(padChar, 8196), result);
    }

}