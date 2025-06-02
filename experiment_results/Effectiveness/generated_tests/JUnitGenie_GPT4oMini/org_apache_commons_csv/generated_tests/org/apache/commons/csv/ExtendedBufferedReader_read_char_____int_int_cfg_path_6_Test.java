package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read_char_____int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testReadWithValidInput() {
        // Arrange
        String input = "Hello\nWorld";
        char[] buf = new char[10];
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));
        int offset = 0;
        int length = 10;

        try {
            // Act
            int len = reader.read(buf, offset, length);

            // Assert
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

    @Test(timeout = 4000)
    public void testReadWithZeroLength() {
        // Arrange
        char[] buf = new char[10];
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader("Test"));
        int offset = 0;
        int length = 0;

        try {
            // Act
            int len = reader.read(buf, offset, length);

            // Assert
            assertEquals(0, len);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithEOF() {
        // Arrange
        String input = "End of file";
        char[] buf = new char[10];
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));
        int offset = 0;
        int length = 10;

        try {
            // Act
            int len = reader.read(buf, offset, length);

            // Assert
            assertEquals(10, len);
            assertEquals('E', buf[0]);
            assertEquals('n', buf[1]);
            assertEquals('d', buf[2]);
            assertEquals(' ', buf[3]);
            assertEquals('o', buf[4]);
            assertEquals('f', buf[5]);
            assertEquals(' ', buf[6]);
            assertEquals('f', buf[7]);
            assertEquals('i', buf[8]);
            assertEquals('l', buf[9]);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}