package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testReadLineWithCarriageReturn() {
        // Arrange
        String input = "Hello, World!\r\nThis is a test.";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            // Act
            String result = reader.readLine();

            // Assert
            assertEquals("Hello, World!", result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLineWithEndOfFile() {
        // Arrange
        String input = "\r\n";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            // Act
            String result = reader.readLine();

            // Assert
            assertEquals("", result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLineReturnsNullAtEOF() {
        // Arrange
        String input = "";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            // Act
            String result = reader.readLine();

            // Assert
            assertEquals(null, result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}