package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_1_Test {

    private static final String SPACE = " ";
    private static final int PAD_LIMIT = 8192;

    @Test(timeout = 4000)
    public void testRightPadWithValidInputs() {
        String str = "test";
        int size = 10;
        String padStr = ".";
        String expected = "test.....";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithNullString() {
        String str = null;
        int size = 10;
        String padStr = ".";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(null, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithEmptyPadString() {
        String str = "test";
        int size = 10;
        String padStr = "";
        String expected = "test     "; // SPACE is used as padStr
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithSingleCharacterPad() {
        String str = "test";
        int size = 10;
        String padStr = "x";
        String expected = "testxxxxxx";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadLengthGreaterThanPads() {
        String str = "test";
        int size = 10;
        String padStr = "xyz";
        String expected = "testxy";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithExactPadLength() {
        String str = "test";
        int size = 8;
        String padStr = "xy";
        String expected = "testxy";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadsLessThanOne() {
        String str = "test";
        int size = 4;
        String padStr = ".";
        String expected = "test"; // returns original String
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

}