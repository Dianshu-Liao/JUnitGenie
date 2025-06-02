package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_leftPad_String_int_char_cfg_path_1_Test {

    private static final int PAD_LIMIT = 8192;

    @Test(timeout = 4000)
    public void testLeftPad_WithValidInputs() {
        String str = "Hello";
        int size = 10;
        char padChar = '*';
        String expected = "*****Hello";
        
        String result = StringUtils.leftPad(str, size, padChar);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testLeftPad_WithNullString() {
        String str = null;
        int size = 10;
        char padChar = '*';
        
        String result = StringUtils.leftPad(str, size, padChar);
        
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testLeftPad_WithSizeLessThanStringLength() {
        String str = "Hello";
        int size = 3;
        char padChar = '*';
        
        String result = StringUtils.leftPad(str, size, padChar);
        
        assertEquals(str, result);
    }

    @Test(timeout = 4000)
    public void testLeftPad_WithPadsGreaterThanPAD_LIMIT() {
        String str = "Hello";
        int size = 8200; // Greater than PAD_LIMIT
        char padChar = '*';
        String expected = StringUtils.repeat(padChar, 8200 - str.length()).concat(str);
        
        String result = StringUtils.leftPad(str, size, padChar);
        
        assertEquals(expected, result);
    }

}