package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testReadLine() {
        String input = "Hello World\n";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Hello World", result);
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
        String input = "Hello World\r\n";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Hello World", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}