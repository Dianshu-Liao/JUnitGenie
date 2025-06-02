package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_leftPad_String_int_char_cfg_path_2_Test {

    private static final int PAD_LIMIT = 8192; // Assuming this constant is defined as in the original method

    @Test(timeout = 4000)
    public void testLeftPadWithValidInputs() {
        String str = "test";
        int size = 10;
        char padChar = ' ';
        String expected = "      test"; // 6 spaces followed by "test"
        String result = StringUtils.leftPad(str, size, padChar);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testLeftPadWithNullString() {
        String str = null;
        int size = 10;
        char padChar = ' ';
        String result = StringUtils.leftPad(str, size, padChar);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testLeftPadWithSizeLessThanStringLength() {
        String str = "test";
        int size = 2;
        char padChar = ' ';
        String expected = "test"; // Should return original string
        String result = StringUtils.leftPad(str, size, padChar);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testLeftPadWithExceedingPadLimit() {
        String str = "test";
        int size = 10000; // Exceeding the PAD_LIMIT
        char padChar = ' ';
        String expected = StringUtils.leftPad(str, size, String.valueOf(padChar)); // Should call the overloaded method
        String result = StringUtils.leftPad(str, size, padChar);
        assertEquals(expected, result);
    }

}