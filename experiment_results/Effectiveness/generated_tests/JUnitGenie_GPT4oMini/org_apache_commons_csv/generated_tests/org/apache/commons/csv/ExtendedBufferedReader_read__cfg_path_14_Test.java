package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testRead() {
        String input = "Hello\nWorld"; // Input string to read
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder();
        
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, true);
        
        try {
            // Read the first character
            int firstChar = reader.read();
            assertEquals('H', firstChar);
            
            // Read the second character
            int secondChar = reader.read();
            assertEquals('e', secondChar);
            
            // Read until the newline character
            int newlineChar = reader.read();
            assertEquals('\n', newlineChar);
            
            // Read the next character after newline
            int nextChar = reader.read();
            assertEquals('W', nextChar);
            
            // Read the last character
            int lastChar = reader.read();
            assertEquals('o', lastChar);
            
            // Read until the end of the input
            while (reader.read() != -1) {
                // Continue reading
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}