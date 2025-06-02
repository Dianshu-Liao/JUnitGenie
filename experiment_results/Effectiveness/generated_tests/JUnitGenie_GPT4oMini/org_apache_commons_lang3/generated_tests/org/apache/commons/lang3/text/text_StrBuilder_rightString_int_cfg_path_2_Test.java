package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_rightString_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRightStringWithValidLength() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("Hello, World!");
        strBuilder.setLength(13); // Set size to 13
        int length = 5; // Length to extract

        // Act
        String result = strBuilder.rightString(length);

        // Assert
        assertEquals("orld!", result);
    }

    @Test(timeout = 4000)
    public void testRightStringWithLengthEqualToSize() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("Hello, World!");
        strBuilder.setLength(13); // Set size to 13
        int length = 13; // Length equal to size

        // Act
        String result = strBuilder.rightString(length);

        // Assert
        assertEquals("Hello, World!", result);
    }

    @Test(timeout = 4000)
    public void testRightStringWithLengthLessThanZero() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("Hello, World!");
        strBuilder.setLength(13); // Set size to 13
        int length = -1; // Invalid length

        // Act
        String result = strBuilder.rightString(length);

        // Assert
        assertEquals("", result); // Should return empty string
    }

    @Test(timeout = 4000)
    public void testRightStringWithLengthGreaterThanSize() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("Hello, World!");
        strBuilder.setLength(13); // Set size to 13
        int length = 20; // Length greater than size

        // Act
        String result = strBuilder.rightString(length);

        // Assert
        assertEquals("Hello, World!", result); // Should return the whole string
    }

}