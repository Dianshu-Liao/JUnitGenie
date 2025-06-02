package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertArrayEquals;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testEncodeUrlWithDefaultUrlSafe() {
        // Given
        BitSet urlsafe = null; // This will trigger the use of WWW_FORM_URL_SAFE
        byte[] bytes = "Hello World!".getBytes();

        // When
        byte[] result = URLCodec.encodeUrl(urlsafe, bytes);

        // Then
        byte[] expected = new byte[] { 72, 101, 108, 108, 111, 43, 87, 111, 114, 108, 100, 33 }; // Expected encoded result
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

        byte[] bytes = "Hello World!".getBytes();

        // When
        byte[] result = URLCodec.encodeUrl(urlsafe, bytes);

        // Then
        byte[] expected = new byte[] { 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33 }; // Expected encoded result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullBytes() {
        // Given
        BitSet urlsafe = null; // This will trigger the use of WWW_FORM_URL_SAFE
        byte[] bytes = null; // Testing with null bytes

        // When
        byte[] result = URLCodec.encodeUrl(urlsafe, bytes);

        // Then
        assertArrayEquals(null, result); // Expecting null result
    }

}