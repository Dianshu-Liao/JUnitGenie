package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_chomp_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testChomp_EmptyString() {
        String input = ""; // This input meets the constraints: length() returns 0
        String expected = ""; // Expected output for an empty string
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_SingleCharacter() {
        String input = "a"; // A single character that is not CR or LF
        String expected = "a"; // Expected output is the same single character
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_SingleCR() {
        String input = "\r"; // A single CR character
        String expected = ""; // Expected output is an empty string
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_SingleLF() {
        String input = "\n"; // A single LF character
        String expected = ""; // Expected output is an empty string
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_CRLF() {
        String input = "\r\n"; // A CR followed by LF
        String expected = ""; // Expected output is an empty string
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_MultipleCharacters() {
        String input = "Hello\n"; // A string ending with LF
        String expected = "Hello"; // Expected output is "Hello"
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_MultipleCharactersWithCR() {
        String input = "Hello\r\n"; // A string ending with CRLF
        String expected = "Hello"; // Expected output is "Hello"
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

}