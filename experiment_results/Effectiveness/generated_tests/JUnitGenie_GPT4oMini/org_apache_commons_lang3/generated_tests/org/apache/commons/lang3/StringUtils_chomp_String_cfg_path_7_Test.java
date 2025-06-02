package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_chomp_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testChompWithSingleCharacterCR() {
        String input = "\r"; // Input that is a single CR character
        String expected = ""; // Expected output is an empty string
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithSingleCharacterLF() {
        String input = "\n"; // Input that is a single LF character
        String expected = ""; // Expected output is an empty string
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithSingleCharacterOther() {
        String input = "a"; // Input that is a single character other than CR or LF
        String expected = "a"; // Expected output is the same single character
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithMultipleCharacters() {
        String input = "abc\n"; // Input with multiple characters ending with LF
        String expected = "abc"; // Expected output is "abc"
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithCRLF() {
        String input = "abc\r\n"; // Input with multiple characters ending with CRLF
        String expected = "abc"; // Expected output is "abc"
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithNoLineEnding() {
        String input = "abc"; // Input with no line ending
        String expected = "abc"; // Expected output is "abc"
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithEmptyString() {
        String input = ""; // Input is an empty string
        String expected = ""; // Expected output is an empty string
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

}