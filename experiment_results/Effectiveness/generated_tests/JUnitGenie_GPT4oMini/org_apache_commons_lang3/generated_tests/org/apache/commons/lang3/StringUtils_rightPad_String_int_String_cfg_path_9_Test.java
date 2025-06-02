package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_9_Test {

    private static final String SPACE = " ";
    private static final int PAD_LIMIT = 8192;

    @Test(timeout = 4000)
    public void testRightPadWithValidInputs() {
        String str = "test";
        int size = 10;
        String padStr = "*";
        String expected = "test*****";
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
        String expected = "test     "; // SPACE is used for padding
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadLengthGreaterThanPads() {
        String str = "test";
        int size = 10;
        String padStr = "abc";
        String expected = "testabc";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadLengthEqualToPads() {
        String str = "test";
        int size = 8;
        String padStr = "ab";
        String expected = "testab";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadLengthLessThanPads() {
        String str = "test";
        int size = 10;
        String padStr = "ab";
        String expected = "testabab";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithSingleCharacterPad() {
        String str = "test";
        int size = 10;
        String padStr = "#";
        String expected = "test######";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadsExceedingLimit() {
        String str = "test";
        int size = 8200; // Exceeding PAD_LIMIT
        String padStr = "*";
        String expected = "test" + getRepeatedString("*", 8192); // Should pad with 8192 '*' characters
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    private String getRepeatedString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

}