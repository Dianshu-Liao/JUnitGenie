package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_char_cfg_path_2_Test {

    private static final int PAD_LIMIT = 8192; // Assuming PAD_LIMIT is defined as 8192

    @Test(timeout = 4000)
    public void testRightPadWithValidInputs() {
        String str = "test";
        int size = 10;
        char padChar = ' ';
        String expected = "test      "; // Expected output with right padding
        String result = StringUtils.rightPad(str, size, padChar);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithNullString() {
        String str = null;
        int size = 10;
        char padChar = ' ';
        String result = StringUtils.rightPad(str, size, padChar);
        assertEquals(null, result); // Expected output is null
    }

    @Test(timeout = 4000)
    public void testRightPadWithSizeLessThanStringLength() {
        String str = "test";
        int size = 2;
        char padChar = ' ';
        String expected = "test"; // Expected output is the original string
        String result = StringUtils.rightPad(str, size, padChar);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithExceedingPadLimit() {
        String str = "test";
        int size = 10000; // Exceeding the PAD_LIMIT
        char padChar = ' ';
        String expected = "test" + StringUtils.repeat(padChar, size - str.length()); // Expected output with right padding
        String result = StringUtils.rightPad(str, size, padChar);
        assertEquals(expected, result);
    }

}