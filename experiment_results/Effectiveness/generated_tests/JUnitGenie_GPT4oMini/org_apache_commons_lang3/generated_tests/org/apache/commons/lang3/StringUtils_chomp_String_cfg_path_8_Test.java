package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_chomp_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testChompWithEmptyString() {
        String input = ""; // Input that meets the constraint (not null)
        String expected = ""; // Expected output for an empty string
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChompWithSingleCharacter() {
        String input = "a"; // Input that meets the constraint (not null)
        String expected = "a"; // Expected output for a single character that is not CR or LF
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChompWithCarriageReturn() {
        String input = "\r"; // Input that meets the constraint (not null)
        String expected = ""; // Expected output for a single CR character
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChompWithLineFeed() {
        String input = "\n"; // Input that meets the constraint (not null)
        String expected = ""; // Expected output for a single LF character
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChompWithCRLF() {
        String input = "\r\n"; // Input that meets the constraint (not null)
        String expected = ""; // Expected output for CRLF
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChompWithNormalString() {
        String input = "Hello"; // Input that meets the constraint (not null)
        String expected = "Hello"; // Expected output for a normal string
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

}