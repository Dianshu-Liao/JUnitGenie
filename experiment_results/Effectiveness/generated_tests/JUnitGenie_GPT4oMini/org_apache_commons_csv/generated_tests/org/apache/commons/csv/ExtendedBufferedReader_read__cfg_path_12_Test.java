package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_12_Test {

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
            reader.read(); // 'e'
            reader.read(); // 'l'
            reader.read(); // 'l'
            reader.read(); // 'o'
            reader.read(); // '\n'
            
            // Read the first character of the second line
            int secondLineFirstChar = reader.read();
            assertEquals('W', secondLineFirstChar);
            
            // Read the rest of the second line
            reader.read(); // 'o'
            reader.read(); // 'r'
            reader.read(); // 'l'
            reader.read(); // 'd'
            
            // Read beyond the end of the input
            int endChar = reader.read();
            assertEquals(-1, endChar); // Expecting -1 for EOF
            
        } catch (IOException e) {
            e.printStackTrace(); // Handle the IOException
        }
    }

}