package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testReadLine() {
        String input = "Hello World"; // Input that does not contain CR or LF
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Hello World", result);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

    @Test(timeout = 4000)
    public void testReadLineWithCR() {
        String input = "Hello World\rNext Line"; // Input with CR
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Hello World", result);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

    @Test(timeout = 4000)
    public void testReadLineWithLF() {
        String input = "Hello World\nNext Line"; // Input with LF
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Hello World", result);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

    @Test(timeout = 4000)
    public void testReadLineWithEOF() {
        String input = ""; // Empty input to simulate EOF
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals(null, result); // Expecting null for EOF
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

}