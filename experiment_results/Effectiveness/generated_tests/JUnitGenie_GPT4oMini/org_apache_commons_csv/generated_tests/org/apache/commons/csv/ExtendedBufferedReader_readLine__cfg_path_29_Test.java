package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testReadLine() {
        String input = "Hello, World!\n";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Hello, World!", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLineEOF() {
        String input = "";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals(null, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadLineWithCRLF() {
        String input = "Line 1\r\nLine 2\r\n";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result1 = reader.readLine();
            assertEquals("Line 1", result1);
            String result2 = reader.readLine();
            assertEquals("Line 2", result2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}