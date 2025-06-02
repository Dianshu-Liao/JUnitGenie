package org.apache.commons.csv;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testRead() {
        String input = "\r\n"; // Input that will trigger the line number increment
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder();
        
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, true);
        
        try {
            // Instead of directly accessing lastChar, we will read from the reader
            int result = reader.read();
            assertEquals(13, result); // Expecting to read CR
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}