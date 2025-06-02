package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertArrayEquals;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testEncodeUrlWithDefaultUrlSafe() {
        // Given
        BitSet urlsafe = null; // This will trigger the use of WWW_FORM_URL_SAFE
        byte[] inputBytes = "Hello World!".getBytes();

        // When
        byte[] result = URLCodec.encodeUrl(urlsafe, inputBytes);

        // Then
        byte[] expected = "Hello+World%21".getBytes(); // Expected output based on URL encoding
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithCustomUrlSafe() {
        // Given
        BitSet urlsafe = new BitSet(256);
        urlsafe.set('H');
        urlsafe.set('e');
        urlsafe.set('l');
        urlsafe.set('o');
        urlsafe.set(' ');
        urlsafe.set('W');
        urlsafe.set('r');
        urlsafe.set('d');
        urlsafe.set('!');

        byte[] inputBytes = "Hello World!".getBytes();

        // When
        byte[] result = URLCodec.encodeUrl(urlsafe, inputBytes);

        // Then
        byte[] expected = "Hello+World%21".getBytes(); // Expected output based on URL encoding
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullBytes() {
        // Given
        BitSet urlsafe = null; // This will trigger the use of WWW_FORM_URL_SAFE
        byte[] inputBytes = null;

        // When
        byte[] result = URLCodec.encodeUrl(urlsafe, inputBytes);

        // Then
        assertArrayEquals(null, result); // Expecting null as input bytes are null
    }

}