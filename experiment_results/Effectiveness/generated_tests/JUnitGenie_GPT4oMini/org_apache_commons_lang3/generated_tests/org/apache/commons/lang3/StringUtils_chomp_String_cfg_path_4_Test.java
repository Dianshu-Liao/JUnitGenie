package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_chomp_String_cfg_path_4_Test {

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
    public void testChompWithSingleCharacterOther() {
        String input = "a";
        String expected = "a";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithMultipleCharactersEndingWithLF() {
        String input = "Hello\n";
        String expected = "Hello";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithMultipleCharactersEndingWithCRLF() {
        String input = "Hello\r\n";
        String expected = "Hello";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithMultipleCharactersEndingWithOther() {
        String input = "Hello!";
        String expected = "Hello!";
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
        String input = null;
        String expected = null;
        try {
            String result = StringUtils.chomp(input);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}