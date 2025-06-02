package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_getLineNumber__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetLineNumberAtEOL() {
        // Arrange
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader("Line 1\nLine 2"), StandardCharsets.UTF_8, false);
        // Use reflection to set private fields for testing
        setPrivateField(reader, "lastChar", 13); // Assuming 13 is the constant for CR
        setPrivateField(reader, "lineNumber", 1); // Set lineNumber to 1

        // Act
        long result = reader.getLineNumber();

        // Assert
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testGetLineNumberAtEOF() {
        // Arrange
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader("Line 1\nLine 2"), StandardCharsets.UTF_8, false);
        // Use reflection to set private fields for testing
        setPrivateField(reader, "lastChar", -1); // Assuming -1 is the constant for EOF
        setPrivateField(reader, "lineNumber", 2); // Set lineNumber to 2

        // Act
        long result = reader.getLineNumber();

        // Assert
        assertEquals(2, result);
    }

    @Test(timeout = 4000)
    public void testGetLineNumberAtUndefined() {
        // Arrange
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader("Line 1\nLine 2"), StandardCharsets.UTF_8, false);
        // Use reflection to set private fields for testing
        setPrivateField(reader, "lastChar", 0); // Assuming 0 is the constant for UNDEFINED
        setPrivateField(reader, "lineNumber", 3); // Set lineNumber to 3

        // Act
        long result = reader.getLineNumber();

        // Assert
        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testGetLineNumberNotAtEOL() {
        // Arrange
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader("Line 1\nLine 2"), StandardCharsets.UTF_8, false);
        // Use reflection to set private fields for testing
        setPrivateField(reader, "lastChar", 65); // Assuming 65 is a character code for 'A'
        setPrivateField(reader, "lineNumber", 4); // Set lineNumber to 4

        // Act
        long result = reader.getLineNumber();

        // Assert
        assertEquals(5, result); // Expect lineNumber + 1
    }

    // Helper method to set private fields using reflection
    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}