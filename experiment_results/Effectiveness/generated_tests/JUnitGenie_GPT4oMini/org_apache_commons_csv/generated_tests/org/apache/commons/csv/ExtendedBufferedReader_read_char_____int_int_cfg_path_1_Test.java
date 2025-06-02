package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read_char_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRead() {
        // Setup
        String input = "Hello\nWorld\n";
        char[] buf = new char[1024];
        int offset = 0;
        int length = 1024;

        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            // Execute
            int len = reader.read(buf, offset, length);

            // Verify
            assertEquals(12, len); // "Hello\nWorld\n" has 12 characters
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
            assertEquals('\n', buf[11]);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}