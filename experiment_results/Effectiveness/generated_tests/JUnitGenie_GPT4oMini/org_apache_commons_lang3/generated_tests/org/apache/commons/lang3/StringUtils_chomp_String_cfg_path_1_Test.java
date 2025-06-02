package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_chomp_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testChompWithSingleCharacterNotCRorLF() {
        String input = "a";
        String expected = "a";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

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
    public void testChompWithMultipleCharactersEndingWithLF() {
        String input = "hello\n";
        String expected = "hello";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithMultipleCharactersEndingWithCRLF() {
        String input = "hello\r\n";
        String expected = "hello";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithMultipleCharactersEndingWithCR() {
        String input = "hello\r";
        String expected = "hello";
        String result = StringUtils.chomp(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testChompWithNoLineEnding() {
        String input = "hello";
        String expected = "hello";
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

}