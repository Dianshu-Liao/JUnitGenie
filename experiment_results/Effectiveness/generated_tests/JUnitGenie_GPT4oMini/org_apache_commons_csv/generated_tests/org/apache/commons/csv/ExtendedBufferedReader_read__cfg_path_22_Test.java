package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testRead() {
        String input = "Hello\nWorld"; // Input string to read
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.defaultCharset();
        CharsetEncoder encoder = charset.newEncoder();
        
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, true);
        
        try {
            // Read the first character
            int firstChar = reader.read();
            assertEquals('H', firstChar);
            
            // Read until the end of the first line
            reader.read(); // Read 'e'
            reader.read(); // Read 'l'
            reader.read(); // Read 'l'
            reader.read(); // Read 'o'
            int newlineChar = reader.read(); // Read '\n'
            assertEquals('\n', newlineChar);
            
            // Read the first character of the second line
            int secondLineFirstChar = reader.read();
            assertEquals('W', secondLineFirstChar);
            
            // Read the rest of the second line
            reader.read(); // Read 'o'
            reader.read(); // Read 'r'
            reader.read(); // Read 'l'
            reader.read(); // Read 'd'
            int eofChar = reader.read(); // Read EOF
            assertEquals(-1, eofChar); // Check for EOF
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}