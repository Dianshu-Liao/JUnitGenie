package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_chomp_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testChompWithSingleCharacterCR() {
        String input = "\r";
        String expected = "";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithSingleCharacterLF() {
        String input = "\n";
        String expected = "";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithMultipleCharacters() {
        String input = "Hello World\n";
        String expected = "Hello World";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithCRLF() {
        String input = "Hello World\r\n";
        String expected = "Hello World";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithNoLineEnding() {
        String input = "Hello World";
        String expected = "Hello World";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithEmptyString() {
        String input = "";
        String expected = "";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithNull() {
        try {
            StringUtils.chomp(null);
        } catch (Exception e) {
            // Handle the exception as needed
        }
    }

}