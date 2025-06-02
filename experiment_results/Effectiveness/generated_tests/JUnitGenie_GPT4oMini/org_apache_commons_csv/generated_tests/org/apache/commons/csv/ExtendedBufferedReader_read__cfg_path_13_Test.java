package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testReadMethod() {
        String input = "Hello\nWorld"; // Input string for testing
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
            
            // Read until the end of the line
            for (int i = 0; i < 4; i++) {
                reader.read(); // Read 'l', 'l', 'o'
            }
            int lineBreak = reader.read(); // Read '\n'
            assertEquals('\n', lineBreak);
            
            // Read the next line
            int nextChar = reader.read(); // Read 'W'
            assertEquals('W', nextChar);
            
            // Read the rest of the characters
            for (int i = 0; i < 4; i++) {
                reader.read(); // Read 'o', 'r', 'l', 'd'
            }
            int eof = reader.read(); // Read EOF
            assertEquals(-1, eof);
            
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}