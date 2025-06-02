package org.apache.commons.lang3;
import org.apache.commons.lang3.CharUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharUtils_toIntValue_Character_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToIntValue_withNullCharacter() {
        int defaultValue = 5;
        Character ch = null;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(defaultValue, result);
    }

    @Test(timeout = 4000)
    public void testToIntValue_withValidCharacter() {
        int defaultValue = 5;
        Character ch = 'A'; // Example of a valid character
        int expectedValue = CharUtils.toIntValue(ch.charValue(), defaultValue);
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(expectedValue, result);
    }

}