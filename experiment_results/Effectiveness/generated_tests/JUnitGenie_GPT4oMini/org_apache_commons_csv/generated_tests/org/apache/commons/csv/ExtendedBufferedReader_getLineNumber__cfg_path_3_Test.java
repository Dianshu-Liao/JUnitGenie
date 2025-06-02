package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_getLineNumber__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetLineNumberAtEOL() throws IOException {
        // Arrange
        String input = "Hello\nWorld";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), StandardCharsets.UTF_8, false);
        
        // Act
        reader.readLine(); // Read the first line to set the line number correctly
        long result = reader.getLineNumber();

        // Assert
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testGetLineNumberAtEOF() throws IOException {
        // Arrange
        String input = "Hello\nWorld";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), StandardCharsets.UTF_8, false);
        
        // Act
        reader.readLine(); // Read the first line
        reader.readLine(); // Read the second line to set the line number correctly
        long result = reader.getLineNumber();

        // Assert
        assertEquals(2, result);
    }

    @Test(timeout = 4000)
    public void testGetLineNumberAtUndefined() throws IOException {
        // Arrange
        String input = "Hello\nWorld";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), StandardCharsets.UTF_8, false);
        
        // Act
        reader.readLine(); // Read the first line
        reader.readLine(); // Read the second line
        long result = reader.getLineNumber(); // This should be 2, as we read two lines

        // Assert
        assertEquals(2, result);
    }

    @Test(timeout = 4000)
    public void testGetLineNumberNotAtEOL() throws IOException {
        // Arrange
        String input = "Hello\nWorld";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), StandardCharsets.UTF_8, false);
        
        // Act
        reader.read(); // Read a single character
        long result = reader.getLineNumber(); // This should still be 1, as we haven't reached EOL

        // Assert
        assertEquals(1, result); // Expecting lineNumber to remain the same
    }

}