package org.apache.commons.lang3;
import org.apache.commons.lang3.CharUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class CharUtils_toIntValue_char_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToIntValue_ValidDigit() {
        char input = '5';
        int expected = 5;
        int result = CharUtils.toIntValue(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToIntValue_InvalidCharacter() {
        char input = 'a';
        try {
            CharUtils.toIntValue(input);
            fail("Expected IllegalArgumentException for input: " + input);
        } catch (IllegalArgumentException e) {
            assertEquals("The character " + input + " is not in the range '0' - '9'", e.getMessage());
        }
    }

}