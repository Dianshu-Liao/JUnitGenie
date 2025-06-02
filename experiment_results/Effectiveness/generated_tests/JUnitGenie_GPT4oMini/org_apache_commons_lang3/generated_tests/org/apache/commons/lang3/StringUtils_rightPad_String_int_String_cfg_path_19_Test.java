package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_19_Test {

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
    public void testRightPadWithSingleCharacterPadString() {
        String str = "test";
        int size = 10;
        String padStr = "*";
        String expected = "test*****";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadStringLongerThanPads() {
        String str = "test";
        int size = 10;
        String padStr = "abcde";
        String expected = "testabcde"; // Only part of padStr is used
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithExactPadLength() {
        String str = "test";
        int size = 8;
        String padStr = "ab";
        String expected = "testab";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithNoPaddingNeeded() {
        String str = "test";
        int size = 4;
        String padStr = ".";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(str, actual); // No padding needed
    }

    @Test(timeout = 4000)
    public void testRightPadWithLargeSize() {
        String str = "test";
        int size = 10000; // Large size
        String padStr = ".";
        String expected = "test" + repeatString(".", 9996); // Padding with 9996 dots
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    private String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }


}