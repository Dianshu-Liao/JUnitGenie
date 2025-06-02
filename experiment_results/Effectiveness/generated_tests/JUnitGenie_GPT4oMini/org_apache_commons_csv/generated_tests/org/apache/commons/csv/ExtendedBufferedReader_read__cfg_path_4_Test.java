package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testReadIncrementsLineNumber() {
        String input = "line1\nline2\nline3";
        StringReader stringReader = new StringReader(input);
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, Charset.forName("UTF-8"), false);
        
        try {
            // Read first line
            reader.read();
            reader.read(); // consumes LF
            assertEquals(1, reader.getLineNumber()); // Use getter method for line number
            
            // Read second line
            reader.read();
            reader.read(); // consumes LF
            assertEquals(2, reader.getLineNumber()); // Use getter method for line number
            
            // Read third line
            reader.read();
            // end of reading
            assertEquals(3, reader.getLineNumber()); // Use getter method for line number
            
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception for testing
        }
    }


}