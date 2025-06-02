package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadWithCR() {
        String input = "\r"; // Input containing Carriage Return
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), Charset.forName("UTF-8"), false);
        try {
            int result = reader.read();
            assertEquals('\r', result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithLF() {
        String input = "\n"; // Input containing Line Feed
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), Charset.forName("UTF-8"), false);
        try {
            int result = reader.read();
            assertEquals('\n', result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithEOF() {
        String input = ""; // Empty input to simulate EOF
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), Charset.forName("UTF-8"), false);
        try {
            int result = reader.read();
            assertEquals(-1, result); // EOF should return -1
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithEncoder() {
        String input = "A"; // Input containing a valid character
        Charset charset = Charset.forName("UTF-8");
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), charset, false);
        try {
            int result = reader.read();
            assertEquals('A', result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}