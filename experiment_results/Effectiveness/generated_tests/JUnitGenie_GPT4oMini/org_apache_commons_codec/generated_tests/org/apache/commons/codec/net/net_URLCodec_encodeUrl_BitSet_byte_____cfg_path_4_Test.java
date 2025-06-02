package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertArrayEquals;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEncodeUrlWithValidInput() {
        BitSet urlsafe = new BitSet();
        urlsafe.set('A'); // Example of a URL-safe character
        urlsafe.set('B'); // Another URL-safe character
        byte[] input = new byte[] { 'A', 'B', ' ', 'C' }; // Input with a space

        byte[] expectedOutput = new byte[] { 'A', 'B', '+', 'C' }; // Expected output after encoding
        try {
            byte[] result = URLCodec.encodeUrl(urlsafe, input);
            assertArrayEquals(expectedOutput, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullBytes() {
        BitSet urlsafe = new BitSet();
        byte[] input = null;

        try {
            byte[] result = URLCodec.encodeUrl(urlsafe, input);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullUrlSafe() {
        byte[] input = new byte[] { 'A', 'B', ' ', 'C' }; // Input with a space

        byte[] expectedOutput = new byte[] { 'A', 'B', '+', 'C' }; // Expected output after encoding
        try {
            byte[] result = URLCodec.encodeUrl(null, input);
            assertArrayEquals(expectedOutput, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}