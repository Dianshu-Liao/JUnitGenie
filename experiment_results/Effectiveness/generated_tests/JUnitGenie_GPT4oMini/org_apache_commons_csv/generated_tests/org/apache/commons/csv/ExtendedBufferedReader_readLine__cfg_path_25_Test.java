package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import static org.mockito.Mockito.*;
import java.io.IOException;
import java.io.StringReader;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testReadLine() {
        String input = "Hello, World!\n";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Hello, World!", result); // Checks if the output is as expected
        } catch (IOException e) {
            // Handle exception as per requirement
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLineEOF() {
        String input = "\n";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("", result); // Expected to return an empty string
        } catch (IOException e) {
            // Handle exception as per requirement
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testReadLineCRLF() {
        String input = "Line1\r\nLine2";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result1 = reader.readLine();
            String result2 = reader.readLine();
            assertEquals("Line1", result1); // First line should be "Line1"
            assertEquals("Line2", result2); // Second line should be "Line2"
        } catch (IOException e) {
            // Handle exception as per requirement
            e.printStackTrace();
        }
    }

}