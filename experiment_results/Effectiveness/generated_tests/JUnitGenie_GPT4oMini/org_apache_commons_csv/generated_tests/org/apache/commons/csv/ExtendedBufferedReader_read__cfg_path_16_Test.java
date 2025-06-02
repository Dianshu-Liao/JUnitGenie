package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testRead() {
        String input = "Hello\nWorld"; // Input string to read
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
            int newlineChar = reader.read();
            assertEquals('\n', newlineChar);
            
            // Read next character
            int nextChar = reader.read();
            assertEquals('W', nextChar);
            
            // Read until end of input
            int endChar = reader.read();
            assertEquals('o', endChar);
            
            // Read remaining characters
            endChar = reader.read();
            assertEquals('r', endChar);
            endChar = reader.read();
            assertEquals('l', endChar);
            endChar = reader.read();
            assertEquals('d', endChar);
            
            // Read past end of input
            endChar = reader.read();
            assertEquals(-1, endChar); // EOF
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}