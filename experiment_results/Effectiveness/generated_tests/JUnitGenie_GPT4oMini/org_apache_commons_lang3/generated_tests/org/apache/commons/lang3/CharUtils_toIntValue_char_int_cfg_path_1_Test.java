package org.apache.commons.lang3;
import org.apache.commons.lang3.CharUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharUtils_toIntValue_char_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToIntValue_ValidDigit() {
        char ch = '5'; // Valid digit character
        int defaultValue = -1;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(5, result);
    }

    @Test(timeout = 4000)
    public void testToIntValue_InvalidDigit() {
        char ch = 'A'; // Invalid digit character
        int defaultValue = -1;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(defaultValue, result);
    }

    @Test(timeout = 4000)
    public void testToIntValue_Zero() {
        char ch = '0'; // Edge case for zero
        int defaultValue = -1;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testToIntValue_Nine() {
        char ch = '9'; // Edge case for nine
        int defaultValue = -1;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(9, result);
    }

    @Test(timeout = 4000)
    public void testToIntValue_DefaultValue() {
        char ch = 'A'; // Invalid digit character
        int defaultValue = 10;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(defaultValue, result);
    }

}