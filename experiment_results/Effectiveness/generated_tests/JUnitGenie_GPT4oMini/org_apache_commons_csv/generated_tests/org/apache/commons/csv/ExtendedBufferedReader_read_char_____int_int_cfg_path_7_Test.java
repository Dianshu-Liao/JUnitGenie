package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read_char_____int_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testRead() {
        // Setup
        String input = "Hello\nWorld";
        char[] buf = new char[10];
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));
        int offset = 0;
        int length = 10;

        try {
            // Execute
            int len = reader.read(buf, offset, length);

            // Verify
            assertEquals(10, len);
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
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}