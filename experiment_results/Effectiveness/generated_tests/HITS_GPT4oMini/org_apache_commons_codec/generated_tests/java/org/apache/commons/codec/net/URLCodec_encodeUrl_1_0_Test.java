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
    public void testEncodeUrl_NullBytes() {
        // Test with null byte array
        byte[] result = URLCodec.encodeUrl(null, null);
        assertNull(result, "Expected null result when input byte array is null");
    }

    @Test
    public void testEncodeUrl_EmptyByteArray() {
        // Test with empty byte array
        byte[] result = URLCodec.encodeUrl(new BitSet(), new byte[0]);
        assertArrayEquals(new byte[0], result, "Expected empty byte array as result");
    }

    @Test
    public void testEncodeUrl_OnlySafeCharacters() {
        // Test with safe characters
        BitSet urlsafe = new BitSet();
        for (char c = 'A'; c <= 'Z'; c++) {
            urlsafe.set(c);
        }
        // space is also safe
        urlsafe.set(' ');
        byte[] input = "ABC DEF".getBytes();
        byte[] expected = new byte[] { 'A', 'B', 'C', '+', 'D', 'E', 'F' };
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        assertArrayEquals(expected, result, "Expected encoded byte array with safe characters");
    }

    @Test
    public void testEncodeUrl_UnsafeCharacters() {
        // Test with unsafe characters
        BitSet urlsafe = new BitSet();
        for (char c = 'A'; c <= 'Z'; c++) {
            urlsafe.set(c);
        }
        byte[] input = "A B C".getBytes();
        byte[] expected = new byte[] { // space encoded
        // space encoded
        'A', // space encoded
        '%', // space encoded
        '2', // space encoded
        '0', // space encoded
        'B', // space encoded
        '%', '2', '0', 'C' };
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        assertArrayEquals(expected, result, "Expected encoded byte array with unsafe characters");
    }

    @Test
    public void testEncodeUrl_MixedCharacters() {
        // Test with mixed safe and unsafe characters
        BitSet urlsafe = new BitSet();
        for (char c = 'A'; c <= 'Z'; c++) {
            urlsafe.set(c);
        }
        byte[] input = "A B C!@#".getBytes();
        byte[] expected = new byte[] { // space encoded
        // space encoded
        'A', // space encoded
        '%', // space encoded
        '2', // space encoded
        '0', // space encoded
        'B', // space encoded
        '%', // '!' encoded
        '2', // '!' encoded
        '0', // '!' encoded
        'C', // '!' encoded
        '%', // '@' encoded
        '2', // '@' encoded
        '1', // '@' encoded
        '%', // '#' encoded
        '4', // '#' encoded
        '0', // '#' encoded
        '%', '3', '2' };
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        assertArrayEquals(expected, result, "Expected encoded byte array with mixed characters");
    }
}
