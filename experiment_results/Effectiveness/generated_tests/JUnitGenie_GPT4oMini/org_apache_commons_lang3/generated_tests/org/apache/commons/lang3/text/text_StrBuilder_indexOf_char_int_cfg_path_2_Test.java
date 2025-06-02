package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_indexOf_char_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIndexOf() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("hello");
        char ch = 'e';
        int startIndex = 0;

        // Act
        int result = strBuilder.indexOf(ch, startIndex);

        // Assert
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOfWithStartIndexGreaterThanSize() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("hello");
        char ch = 'e';
        int startIndex = 10; // startIndex is greater than size

        // Act
        int result = strBuilder.indexOf(ch, startIndex);

        // Assert
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOfWithNegativeStartIndex() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("hello");
        char ch = 'h';
        int startIndex = -1; // startIndex is negative

        // Act
        int result = strBuilder.indexOf(ch, startIndex);

        // Assert
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testIndexOfCharacterNotFound() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("hello");
        char ch = 'x';
        int startIndex = 0;

        // Act
        int result = strBuilder.indexOf(ch, startIndex);

        // Assert
        assertEquals(-1, result);
    }

}