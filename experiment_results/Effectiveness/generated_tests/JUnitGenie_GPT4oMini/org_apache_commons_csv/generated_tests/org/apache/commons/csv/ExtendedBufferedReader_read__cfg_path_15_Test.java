package org.apache.commons.csv;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testRead() {
        // Setup
        String input = "Sample input text"; // Sample input that does not contain CR or LF
        StringReader stringReader = new StringReader(input);
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder();
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, true);
        
        try {
            // Execute
            int result = reader.read();
            
            // Verify
            assertEquals(5, result); // Expecting the lastChar to be returned
            assertEquals(1, reader.getLineNumber()); // Use getter for lineNumber
            assertEquals(5, reader.getBytesRead()); // Use getter for bytesRead
            assertEquals(1, reader.getPosition()); // Use getter for position
            
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }


}