package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read_char_____int_int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testReadWithZeroLength() {
        // Arrange
        char[] buf = new char[10];
        int offset = 0;
        int length = 0;
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader("Test input"));

        try {
            // Act
            int result = reader.read(buf, offset, length);

            // Assert
            assertEquals(0, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}