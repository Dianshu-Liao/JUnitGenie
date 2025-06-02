package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.util.BitSet;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testEncodeUrlWithValidInput() {
        BitSet urlsafe = new BitSet();
        urlsafe.set('a'); // Example of setting a URL-safe character
        urlsafe.set('b');
        urlsafe.set(' '); // Space should be converted to '+'

        byte[] input = new byte[] { 'a', 'b', ' ' };
        byte[] expectedOutput = new byte[] { 'a', 'b', '+' };

        byte[] actualOutput = URLCodec.encodeUrl(urlsafe, input);
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
        byte[] input = new byte[] { 'a', 'b', ' ' };
        byte[] expectedOutput = new byte[] { 'a', 'b', '+' };

        byte[] actualOutput = URLCodec.encodeUrl(null, input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNonUrlSafeCharacters() {
        BitSet urlsafe = new BitSet();
        urlsafe.set('a');
        urlsafe.set('b');

        byte[] input = new byte[] { 'a', 'b', '!', '@' }; // '!' and '@' are not URL-safe
        byte[] expectedOutput = new byte[] { 'a', 'b', '%', '2', '1', '%', '4', '0' }; // Expected hex encoding

        byte[] actualOutput = URLCodec.encodeUrl(urlsafe, input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

}