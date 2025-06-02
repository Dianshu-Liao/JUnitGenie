package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class text_StrBuilder_endsWith_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEndsWith() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        String testString = "World";

        // Act
        boolean result = strBuilder.endsWith(testString);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testEndsWithNull() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        String testString = null;

        // Act
        boolean result = strBuilder.endsWith(testString);

        // Assert
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testEndsWithEmptyString() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        String testString = "";

        // Act
        boolean result = strBuilder.endsWith(testString);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testEndsWithLongerString() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("Hello");
        String testString = "HelloWorld";

        // Act
        boolean result = strBuilder.endsWith(testString);

        // Assert
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testEndsWithDifferentEnding() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        String testString = "Hello";

        // Act
        boolean result = strBuilder.endsWith(testString);

        // Assert
        assertTrue(!result);
    }

}