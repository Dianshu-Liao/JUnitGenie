package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read_char_____int_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testRead() {
        // Arrange
        String input = "Hello\nWorld";
        char[] buf = new char[10];
        int offset = 0;
        int length = 10;
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        // Act
        int len = 0;
        try {
            len = reader.read(buf, offset, length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(10, len);
        assertEquals("Hello\nWorld", new String(buf, offset, len));
    }

}