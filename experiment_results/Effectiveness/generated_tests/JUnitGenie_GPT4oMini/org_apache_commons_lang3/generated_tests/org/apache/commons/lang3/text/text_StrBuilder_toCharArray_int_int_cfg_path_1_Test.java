package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class text_StrBuilder_toCharArray_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToCharArray() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello, World!");
        int startIndex = 0;
        int endIndex = 5;

        // Act
        char[] result = strBuilder.toCharArray(startIndex, endIndex);

        // Assert
        char[] expected = {'H', 'e', 'l', 'l', 'o'};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToCharArrayWithEmptyResult() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello, World!");
        int startIndex = 0;
        int endIndex = 0;

        // Act
        char[] result = strBuilder.toCharArray(startIndex, endIndex);

        // Assert
        char[] expected = ArrayUtils.EMPTY_CHAR_ARRAY;
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToCharArrayWithInvalidRange() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello, World!");
        int startIndex = 5;
        int endIndex = 3;

        // Act
        try {
            strBuilder.toCharArray(startIndex, endIndex);
        } catch (Exception e) {
            // Assert
            // You can assert the exception message or type if needed
        }
    }

}