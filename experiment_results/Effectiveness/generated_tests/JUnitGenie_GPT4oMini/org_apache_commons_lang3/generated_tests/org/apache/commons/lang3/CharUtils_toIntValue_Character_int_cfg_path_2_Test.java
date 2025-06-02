package org.apache.commons.lang3;
import org.apache.commons.lang3.CharUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharUtils_toIntValue_Character_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToIntValue_CharacterIsNull() {
        // Arrange
        Character ch = null;
        int defaultValue = 5;

        // Act
        int result = CharUtils.toIntValue(ch, defaultValue);

        // Assert
        assertEquals(defaultValue, result);
    }

}