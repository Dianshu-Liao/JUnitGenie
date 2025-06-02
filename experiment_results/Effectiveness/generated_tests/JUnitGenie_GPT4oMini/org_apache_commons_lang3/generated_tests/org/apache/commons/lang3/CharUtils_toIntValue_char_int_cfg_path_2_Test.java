package org.apache.commons.lang3;
import org.apache.commons.lang3.CharUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharUtils_toIntValue_char_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToIntValue_WithAsciiNumericCharacter() {
        char ch = '5'; // ASCII value 53, which is greater than 48
        int defaultValue = 10;
        int expected = 5; // 53 - 48 = 5
        int actual = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToIntValue_WithNonAsciiNumericCharacter() {
        char ch = 'A'; // ASCII value 65, which is greater than 48
        int defaultValue = 10;
        int expected = defaultValue; // should return defaultValue
        int actual = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(expected, actual);
    }

}