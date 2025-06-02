package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.net.Utils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.util.BitSet;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testEncodeUrl() {
        // Prepare the input parameters
        BitSet urlsafe = new BitSet();
        // Set the URL-safe characters (for example, ASCII characters from 0 to 127)
        for (int i = 0; i < 128; i++) {
            urlsafe.set(i);
        }
        
        byte[] inputBytes = "Hello World!".getBytes(); // Example input

        // Expected output after encoding
        byte[] expectedOutput = "Hello+World%21".getBytes(); // Expected encoded output

        // Call the focal method
        byte[] actualOutput = null;
        try {
            actualOutput = URLCodec.encodeUrl(urlsafe, inputBytes);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert the expected output matches the actual output
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullBytes() {
        BitSet urlsafe = new BitSet();
        byte[] inputBytes = null; // Test with null bytes

        // Call the focal method
        byte[] actualOutput = null;
        try {
            actualOutput = URLCodec.encodeUrl(urlsafe, inputBytes);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert the output is null
        assertArrayEquals(null, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullUrlSafe() {
        byte[] inputBytes = "Hello World!".getBytes(); // Example input

        // Expected output after encoding
        byte[] expectedOutput = "Hello+World%21".getBytes(); // Expected encoded output

        // Call the focal method
        byte[] actualOutput = null;
        try {
            actualOutput = URLCodec.encodeUrl(null, inputBytes);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert the expected output matches the actual output
        assertArrayEquals(expectedOutput, actualOutput);
    }

}