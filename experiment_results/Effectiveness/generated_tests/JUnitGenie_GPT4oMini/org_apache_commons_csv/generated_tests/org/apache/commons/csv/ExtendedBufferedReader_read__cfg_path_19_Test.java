package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testReadWithValidCharacter() {
        String input = "A"; // Valid character input
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.forName("UTF-8"); // Use Charset instead of CharsetEncoder
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, false);
        
        try {
            int result = reader.read();
            assertEquals(65, result); // ASCII value of 'A'
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithCR() {
        String input = "\r"; // Valid character input (CR)
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.forName("UTF-8"); // Use Charset instead of CharsetEncoder
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, false);
        
        try {
            int result = reader.read();
            assertEquals(13, result); // ASCII value of CR
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithLF() {
        String input = "\n"; // Valid character input (LF)
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.forName("UTF-8"); // Use Charset instead of CharsetEncoder
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, false);
        
        try {
            int result = reader.read();
            assertEquals(10, result); // ASCII value of LF
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithEOF() {
        String input = ""; // Empty input to simulate EOF
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.forName("UTF-8"); // Use Charset instead of CharsetEncoder
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, false);
        
        try {
            int result = reader.read();
            assertEquals(-1, result); // EOF should return -1
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}