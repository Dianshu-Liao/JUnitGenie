package org.apache.commons.lang3;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharUtils_toChar_String_char_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToCharWithNonEmptyString() {
        String str = "Hello";
        char defaultValue = 'X';
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals('H', result);
    }

    @Test(timeout = 4000)
    public void testToCharWithEmptyString() {
        String str = "";
        char defaultValue = 'X';
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals(defaultValue, result);
    }

    @Test(timeout = 4000)
    public void testToCharWithNullString() {
        String str = null;
        char defaultValue = 'X';
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals(defaultValue, result);
    }

}