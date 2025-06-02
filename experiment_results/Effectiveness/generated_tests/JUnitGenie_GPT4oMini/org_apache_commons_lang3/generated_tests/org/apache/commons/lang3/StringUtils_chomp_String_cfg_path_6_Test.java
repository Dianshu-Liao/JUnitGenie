package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_chomp_String_cfg_path_6_Test {
    
    @Test(timeout = 4000)
    public void testChomp_withSingleCharacterNotCRLF() {
        String input = "a";
        String expected = "a";
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_withSingleCharacterCR() {
        String input = "\r";
        String expected = "";
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_withSingleCharacterLF() {
        String input = "\n";
        String expected = "";
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_withTwoCharactersCRLF() {
        String input = "\r\n";
        String expected = "";
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_withStringEndingWithLF() {
        String input = "hello\n";
        String expected = "hello";
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_withStringEndingWithCR() {
        String input = "world\r";
        String expected = "world";
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testChomp_withStringEndingWithMixedCRLF() {
        String input = "hello\r\n";
        String expected = "hello";
        String actual = StringUtils.chomp(input);
        assertEquals(expected, actual);
    }

}