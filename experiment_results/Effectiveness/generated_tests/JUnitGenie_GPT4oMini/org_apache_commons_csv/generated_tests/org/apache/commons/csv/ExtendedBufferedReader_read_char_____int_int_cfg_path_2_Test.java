package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read_char_____int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRead() {
        // Setup
        String input = "Hello\nWorld\r\n";
        char[] buf = new char[1024];
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));
        
        try {
            // Execute
            int len = reader.read(buf, 0, 1024);
            
            // Verify
            assertEquals(13, len); // 13 characters read
            assertEquals('H', buf[0]);
            assertEquals('e', buf[1]);
            assertEquals('l', buf[2]);
            assertEquals('l', buf[3]);
            assertEquals('o', buf[4]);
            assertEquals('\n', buf[5]);
            assertEquals('W', buf[6]);
            assertEquals('o', buf[7]);
            assertEquals('r', buf[8]);
            assertEquals('l', buf[9]);
            assertEquals('d', buf[10]);
            assertEquals('\r', buf[11]);
            assertEquals('\n', buf[12]);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}