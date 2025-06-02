package org.apache.commons.lang3;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharUtils_toChar_String_char_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToCharWithEmptyString() {
        String str = ""; // This will trigger the default value return
        char defaultValue = 'X';
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals(defaultValue, result);
    }

    @Test(timeout = 4000)
    public void testToCharWithNonEmptyString() {
        String str = "A"; // This will return the first character
        char defaultValue = 'X';
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals('A', result);
    }

    @Test(timeout = 4000)
    public void testToCharWithNullString() {
        String str = null; // This will trigger the default value return
        char defaultValue = 'X';
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals(defaultValue, result);
    }

}