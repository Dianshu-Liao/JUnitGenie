package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testReadLine() {
        String input = "Hello World"; // Input string to read
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Hello World", result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLineEOF() {
        String input = ""; // Empty input to simulate EOF
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals(null, result); // Expecting null at EOF
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLineWithCRLF() {
        String input = "Line1\r\nLine2"; // Input with CRLF
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result1 = reader.readLine();
            assertEquals("Line1", result1); // First line
            String result2 = reader.readLine();
            assertEquals("Line2", result2); // Second line
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}