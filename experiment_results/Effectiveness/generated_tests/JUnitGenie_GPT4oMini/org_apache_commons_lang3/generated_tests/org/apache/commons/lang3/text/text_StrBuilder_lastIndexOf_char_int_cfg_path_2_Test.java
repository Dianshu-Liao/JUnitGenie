package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_lastIndexOf_char_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testLastIndexOf() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("hello");
        char ch = 'l';
        int startIndex = 4; // valid index

        // Act
        int result = strBuilder.lastIndexOf(ch, startIndex);

        // Assert
        assertEquals(3, result); // 'l' is found at index 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOfWithStartIndexOutOfBounds() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("hello");
        char ch = 'h';
        int startIndex = 10; // out of bounds, should be adjusted to size - 1

        // Act
        int result = strBuilder.lastIndexOf(ch, startIndex);

        // Assert
        assertEquals(0, result); // 'h' is found at index 0
    }

    @Test(timeout = 4000)
    public void testLastIndexOfWithNegativeStartIndex() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("hello");
        char ch = 'o';
        int startIndex = -1; // negative index

        // Act
        int result = strBuilder.lastIndexOf(ch, startIndex);

        // Assert
        assertEquals(-1, result); // should return -1 for negative start index
    }

    @Test(timeout = 4000)
    public void testLastIndexOfCharacterNotFound() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("hello");
        char ch = 'x';
        int startIndex = 4; // valid index

        // Act
        int result = strBuilder.lastIndexOf(ch, startIndex);

        // Assert
        assertEquals(-1, result); // character 'x' is not found
    }

}