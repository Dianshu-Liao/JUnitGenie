package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNonNullStringAndEmptyPadStr() {
        String str = "test";
        int size = 10;
        String padStr = ""; // This will trigger the condition to use SPACE as padding

        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("test      ", result); // Expecting "test" followed by 6 spaces
    }

    @Test(timeout = 4000)
    public void testRightPadWithNonNullStringAndSingleCharPadStr() {
        String str = "test";
        int size = 10;
        String padStr = "x"; // Single character padding

        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("testxxxxxx", result); // Expecting "test" followed by 6 'x'
    }

    @Test(timeout = 4000)
    public void testRightPadWithNonNullStringAndLongPadStr() {
        String str = "test";
        int size = 10;
        String padStr = "abc"; // Longer padding string

        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("testabcab", result); // Expecting "test" followed by "abcab"
    }

    @Test(timeout = 4000)
    public void testRightPadWithExactSize() {
        String str = "test";
        int size = 4; // Size is equal to the string length
        String padStr = "abc";

        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("test", result); // Expecting original string
    }

    @Test(timeout = 4000)
    public void testRightPadWithSizeLessThanStringLength() {
        String str = "test";
        int size = 2; // Size is less than the string length
        String padStr = "abc";

        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("test", result); // Expecting original string
    }

}