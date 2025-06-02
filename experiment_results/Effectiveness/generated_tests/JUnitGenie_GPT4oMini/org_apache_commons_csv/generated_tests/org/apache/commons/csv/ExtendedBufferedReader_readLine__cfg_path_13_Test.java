package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertNull;

public class ExtendedBufferedReader_readLine__cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testReadLine_EndOfStream() {
        // Arrange
        StringReader stringReader = new StringReader("");
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

        try {
            // Act
            String result = reader.readLine();

            // Assert
            assertNull(result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLine_ReturnsNullOnEOF() {
        // Arrange
        StringReader stringReader = new StringReader("\n");
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

        try {
            // Act
            reader.read(); // Read the first character (which is LF)
            String result = reader.readLine(); // Should return null since EOF is reached

            // Assert
            assertNull(result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}