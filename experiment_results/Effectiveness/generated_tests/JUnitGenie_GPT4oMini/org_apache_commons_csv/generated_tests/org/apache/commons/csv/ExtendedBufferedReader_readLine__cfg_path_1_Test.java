package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadLineReturnsNullOnEOF() {
        // Arrange
        StringReader stringReader = new StringReader(""); // Empty input simulates EOF
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

        try {
            // Act
            String result = reader.readLine();

            // Assert
            assertNull(result); // Expecting null when EOF is reached
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLineHandlesLineBreaks() {
        // Arrange
        String input = "Hello\nWorld";
        StringReader stringReader = new StringReader(input);
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

        try {
            // Act
            String firstLine = reader.readLine();
            String secondLine = reader.readLine();

            // Assert
            assertEquals("Hello", firstLine);
            assertEquals("World", secondLine);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLineHandlesCarriageReturn() {
        // Arrange
        String input = "Hello\rWorld";
        StringReader stringReader = new StringReader(input);
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

        try {
            // Act
            String firstLine = reader.readLine();

            // Assert
            assertEquals("Hello", firstLine);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }


}