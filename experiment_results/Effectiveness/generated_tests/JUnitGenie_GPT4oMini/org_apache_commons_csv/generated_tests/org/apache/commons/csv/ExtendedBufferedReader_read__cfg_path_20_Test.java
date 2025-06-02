package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testRead() {
        String input = "Hello\nWorld"; // Input string to read
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.defaultCharset();
        CharsetEncoder encoder = charset.newEncoder();
        
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, true);
        
        try {
            // Read first character
            int firstChar = reader.read();
            assertEquals('H', firstChar);
            
            // Read until the end of the first line
            reader.read(); // 'e'
            reader.read(); // 'l'
            reader.read(); // 'l'
            reader.read(); // 'o'
            int newlineChar = reader.read(); // '\n'
            assertEquals('\n', newlineChar);
            
            // Read next line
            int secondChar = reader.read(); // 'W'
            assertEquals('W', secondChar);
            
            // Read until the end of the input
            reader.read(); // 'o'
            reader.read(); // 'r'
            reader.read(); // 'l'
            int lastChar = reader.read(); // 'd'
            assertEquals('d', lastChar);
            
            // Read EOF
            int eofChar = reader.read(); // EOF
            assertEquals(-1, eofChar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}