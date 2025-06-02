package org.apache.commons.codec.net;

import java.util.BitSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encodeUrl_1_0_Test {

    @Test
    public void testEncodeUrlWithNullBytes() {
        byte[] result = URLCodec.encodeUrl(null, null);
        assertNull(result);
    }

    @Test
    public void testEncodeUrlWithNullUrlSafe() {
        byte[] input = "test".getBytes();
        byte[] result = URLCodec.encodeUrl(null, input);
        assertNotNull(result);
        assertArrayEquals(new byte[] { 't', 'e', 's', 't' }, result);
    }

    @Test
    public void testEncodeUrlWithSpace() {
        byte[] input = "test string".getBytes();
        BitSet urlsafe = new BitSet();
        urlsafe.set('t');
        urlsafe.set('e');
        urlsafe.set('s');
        urlsafe.set('r');
        urlsafe.set('i');
        urlsafe.set('n');
        urlsafe.set('g');
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        assertArrayEquals(new byte[] { 't', 'e', 's', 't', '+', 's', 't', 'r', 'i', 'n', 'g' }, result);
    }

    @Test
    public void testEncodeUrlWithSpecialCharacters() {
        byte[] input = "test&string".getBytes();
        BitSet urlsafe = new BitSet();
        urlsafe.set('t');
        urlsafe.set('e');
        urlsafe.set('s');
        urlsafe.set('r');
        urlsafe.set('i');
        urlsafe.set('n');
        urlsafe.set('g');
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        assertNotNull(result);
        // Check that special character '&' is encoded
        assertTrue(result.length > 0);
        assertEquals('%', result[8]);
        assertEquals('3', result[9]);
        assertEquals('8', result[10]);
    }

    @Test
    public void testEncodeUrlWithNegativeBytes() {
        byte[] input = new byte[] { -1, -2, -3, -4 };
        BitSet urlsafe = new BitSet();
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        assertNotNull(result);
        // Check that negative bytes are encoded
        assertEquals('%', result[0]);
        assertEquals('F', result[1]);
        assertEquals('F', result[2]);
        assertEquals('%', result[3]);
        assertEquals('F', result[4]);
        assertEquals('E', result[5]);
        assertEquals('%', result[6]);
        assertEquals('F', result[7]);
        assertEquals('D', result[8]);
        assertEquals('%', result[9]);
        assertEquals('F', result[10]);
        assertEquals('C', result[11]);
    }

    @Test
    public void testEncodeUrlWithEmptyBytes() {
        byte[] input = new byte[] {};
        BitSet urlsafe = new BitSet();
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        assertNotNull(result);
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testEncodeUrlWithAllSafeCharacters() {
        byte[] input = "abcdef".getBytes();
        BitSet urlsafe = new BitSet();
        for (char c = 'a'; c <= 'f'; c++) {
            urlsafe.set(c);
        }
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        assertNotNull(result);
        assertArrayEquals(new byte[] { 'a', 'b', 'c', 'd', 'e', 'f' }, result);
    }

    @Test
    public void testEncodeUrlWithMixedCharacters() {
        byte[] input = "abc def&ghi".getBytes();
        BitSet urlsafe = new BitSet();
        urlsafe.set('a');
        urlsafe.set('b');
        urlsafe.set('c');
        urlsafe.set('d');
        urlsafe.set('e');
        urlsafe.set('g');
        urlsafe.set('h');
        urlsafe.set('i');
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        assertNotNull(result);
        assertArrayEquals(new byte[] { 'a', 'b', 'c', '+', 'd', 'e', 'f', '%', '3', '8', 'g', 'h', 'i' }, result);
    }
}
