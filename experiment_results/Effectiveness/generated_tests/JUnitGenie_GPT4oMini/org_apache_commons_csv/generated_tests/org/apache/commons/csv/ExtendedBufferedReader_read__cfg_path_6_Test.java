package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.IOException;

public class ExtendedBufferedReader_read__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testReadMethod() {
        String input = "Hello\nWorld"; // Input string, containing CR and LF
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.defaultCharset();
        CharsetEncoder encoder = charset.newEncoder();
        
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, true);
        
        try {
            int firstChar = reader.read(); // Reads 'H'
            // Position and lastChar should be updated, lineNumber remains the same
            assert firstChar == 'H'; // Check correct first char
            assert reader.getPosition() == 1; // Ensure position is incremented
            assert reader.getLastChar() == 'H'; // Check lastChar is set correctly
            
            int secondChar = reader.read(); // Reads 'e'
            assert secondChar == 'e'; // Check correct second char
            assert reader.getPosition() == 2; // Ensure position is incremented
            assert reader.getLastChar() == 'e'; // Check lastChar is updated
            
            // Next read should handle new line
            int newLineChar = reader.read(); // Reads '\n'
            assert newLineChar == '\n'; // Check new line char
            assert reader.getLineNumber() == 1; // lineNumber should increment
            assert reader.getPosition() == 3; // Ensure position is updated
            assert reader.getLastChar() == '\n'; // Check lastChar

        } catch (IOException e) {
            // Since the method throws IOException, we can handle it here
            e.printStackTrace();
        }
    }


}