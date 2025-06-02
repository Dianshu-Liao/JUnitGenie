package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertArrayEquals;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testEncodeUrlWithValidInput() {
        BitSet urlsafe = new BitSet();
        urlsafe.set('a'); // Example of setting a URL-safe character
        urlsafe.set('b'); // Another URL-safe character
        byte[] input = new byte[] { 'a', 'b', ' ', 'c' }; // Input with space to test encoding

        byte[] expectedOutput = new byte[] { 'a', 'b', '+', 'c' }; // Expected output after encoding
        byte[] actualOutput = null;

        try {
            actualOutput = URLCodec.encodeUrl(urlsafe, input);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullBytes() {
        BitSet urlsafe = new BitSet();
        byte[] input = null;

        byte[] actualOutput = null;

        try {
            actualOutput = URLCodec.encodeUrl(urlsafe, input);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertArrayEquals(null, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullUrlSafe() {
        byte[] input = new byte[] { 'a', 'b', ' ', 'c' }; // Input with space to test encoding
        byte[] expectedOutput = new byte[] { 'a', 'b', '+', 'c' }; // Expected output after encoding
        byte[] actualOutput = null;

        try {
            actualOutput = URLCodec.encodeUrl(null, input);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertArrayEquals(expectedOutput, actualOutput);
    }

}