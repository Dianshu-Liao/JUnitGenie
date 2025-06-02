package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testRead() {
        // Setup
        String input = "Hello\nWorld"; // Input string with CR and LF
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder();
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, true);
        
        try {
            // Execute
            int firstChar = reader.read(); // Read first character
            int secondChar = reader.read(); // Read second character
            
            // Verify
            assertEquals('H', firstChar);
            assertEquals('e', secondChar);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}