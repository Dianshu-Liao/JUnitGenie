package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertArrayEquals;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testEncodeUrlWithValidInputs() {
        BitSet urlsafe = new BitSet();
        urlsafe.set('a'); // Example of setting a URL-safe character
        urlsafe.set('b'); // Example of setting another URL-safe character
        byte[] inputBytes = new byte[] { 'a', 'b', ' ', 'c' }; // Input bytes to encode

        byte[] expectedOutput = new byte[] { 'a', 'b', '+', 'c' }; // Expected output after encoding
        byte[] actualOutput = URLCodec.encodeUrl(urlsafe, inputBytes);

        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullBytes() {
        BitSet urlsafe = new BitSet();
        byte[] actualOutput = URLCodec.encodeUrl(urlsafe, null);
        assertArrayEquals(null, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullUrlSafe() {
        byte[] inputBytes = new byte[] { 'a', 'b', ' ', 'c' }; // Input bytes to encode
        byte[] expectedOutput = new byte[] { 'a', 'b', '+', 'c' }; // Expected output after encoding
        byte[] actualOutput = URLCodec.encodeUrl(null, inputBytes);

        assertArrayEquals(expectedOutput, actualOutput);
    }

}