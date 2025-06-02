package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNonNullStringAndPadString() {
        String str = "test";
        int size = 10;
        String padStr = "*";
        String expected = "test******";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithNullString() {
        String str = null;
        int size = 10;
        String padStr = "*";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(null, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithEmptyPadString() {
        String str = "test";
        int size = 10;
        String padStr = "";
        String expected = "test      "; // Default padding with spaces
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithSizeLessThanStringLength() {
        String str = "test";
        int size = 2;
        String padStr = "*";
        String expected = "test"; // Should return original string
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadLengthEqualToPads() {
        String str = "test";
        int size = 8;
        String padStr = "**";
        String expected = "test****"; // Pad length equal to pads
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadLengthGreaterThanPads() {
        String str = "test";
        int size = 8;
        String padStr = "***";
        String expected = "test***"; // Should use only part of the pad string
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadLengthLessThanPads() {
        String str = "test";
        int size = 10;
        String padStr = "ab";
        String expected = "testababab"; // Should repeat the pad string
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

}