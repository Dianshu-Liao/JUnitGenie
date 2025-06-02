package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read_char_____int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRead() {
        // Setup
        String input = "Hello\nWorld\r\n";
        char[] buffer = new char[1024];
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));
        
        try {
            // Execute
            int bytesRead = reader.read(buffer, 0, 10);
            
            // Verify
            assertEquals(10, bytesRead);
            assertEquals('H', buffer[0]);
            assertEquals('e', buffer[1]);
            assertEquals('l', buffer[2]);
            assertEquals('l', buffer[3]);
            assertEquals('o', buffer[4]);
            assertEquals('\n', buffer[5]);
            assertEquals('W', buffer[6]);
            assertEquals('o', buffer[7]);
            assertEquals('r', buffer[8]);
            assertEquals('l', buffer[9]);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}