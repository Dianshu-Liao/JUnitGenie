package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNonNullPadStr() {
        String str = "test";
        int size = 10;
        String padStr = "0";
        String expected = "test000000";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithNullPadStr() {
        String str = "test";
        int size = 10;
        String padStr = null; // This will trigger the default SPACE padding
        String expected = "test      "; // Assuming SPACE is a single space character
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithEmptyPadStr() {
        String str = "test";
        int size = 10;
        String padStr = ""; // This will also trigger the default SPACE padding
        String expected = "test      "; // Assuming SPACE is a single space character
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithSizeLessThanStrLength() {
        String str = "test";
        int size = 3; // Size is less than the length of str
        String padStr = "0";
        String expected = "test"; // Should return original string
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithSingleCharPadStr() {
        String str = "test";
        int size = 8;
        String padStr = "x";
        String expected = "testxxx";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithLongPadStr() {
        String str = "test";
        int size = 10;
        String padStr = "abc";
        String expected = "testabca"; // Should repeat the padStr
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

}