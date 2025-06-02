package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testReadLine() {
        String input = "Hello, World!\nSecond Line\n";
        Reader stringReader = new StringReader(input);
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

        String line1 = null;
        String line2 = null;
        try {
            line1 = reader.readLine(); // Test case for the first line
            line2 = reader.readLine(); // Test case for the second line
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test assert
        assertEquals("Hello, World!", line1);
        assertEquals("Second Line", line2);
    }

    @Test(timeout = 4000)
    public void testReadLineEOF() {
        String input = ""; // Empty input simulates EOF scenario
        Reader stringReader = new StringReader(input);
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

        String line = null;
        try {
            line = reader.readLine(); // This should return null
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test assert
        assertEquals(null, line);
    }

    @Test(timeout = 4000)
    public void testReadLineCRLF() {
        String input = "First Line\r\nSecond Line\r\n";
        Reader stringReader = new StringReader(input);
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

        String line1 = null;
        String line2 = null;
        try {
            line1 = reader.readLine(); // Test case for the first line
            line2 = reader.readLine(); // Test case for the second line
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test assert
        assertEquals("First Line", line1);
        assertEquals("Second Line", line2);
    }

}