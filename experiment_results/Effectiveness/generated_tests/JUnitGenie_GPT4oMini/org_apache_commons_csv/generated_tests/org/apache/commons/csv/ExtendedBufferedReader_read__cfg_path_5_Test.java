package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testRead() {
        String input = "Hello\nWorld"; // Input string for testing
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder();
        
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, true);
        
        try {
            // Read first character
            int firstChar = reader.read();
            assertEquals('H', firstChar);
            
            // Read second character
            int secondChar = reader.read();
            assertEquals('e', secondChar);
            
            // Read until newline
            for (int i = 0; i < 10; i++) {
                reader.read(); // Read characters until the newline
            }
            
            // Read after newline
            int afterNewlineChar = reader.read();
            assertEquals('W', afterNewlineChar);
            
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException
        }
    }

}