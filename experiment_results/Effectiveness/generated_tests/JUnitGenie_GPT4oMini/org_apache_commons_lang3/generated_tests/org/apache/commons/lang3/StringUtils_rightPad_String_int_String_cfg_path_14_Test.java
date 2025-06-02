package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_14_Test {

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
        String expected = "test      "; // space padding
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithSizeLessThanStringLength() {
        String str = "test";
        int size = 2;
        String padStr = "*";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals("test", actual); // should return original string
    }

    @Test(timeout = 4000)
    public void testRightPadWithSingleCharacterPadString() {
        String str = "test";
        int size = 8;
        String padStr = "#";
        String expected = "test####";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadStringLongerThanPads() {
        String str = "test";
        int size = 10;
        String padStr = "##";
        String expected = "test######"; // should use the first 6 characters of padStr
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithExactPadLength() {
        String str = "test";
        int size = 8;
        String padStr = "##";
        String expected = "test##";
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testRightPadWithMultiplePads() {
        String str = "test";
        int size = 12;
        String padStr = "abc";
        String expected = "testabcabca"; // should repeat padStr
        String actual = StringUtils.rightPad(str, size, padStr);
        assertEquals(expected, actual);
    }

}