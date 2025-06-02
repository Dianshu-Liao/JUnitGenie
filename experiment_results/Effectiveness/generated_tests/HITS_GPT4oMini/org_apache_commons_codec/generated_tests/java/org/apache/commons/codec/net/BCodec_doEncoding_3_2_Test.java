// Change to your actual package name
package org.apache.commons.codec.net;

import org.apache.commons.codec.binary.Base64;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_doEncoding_3_2_Test {

    private final BCodec bCodec = new BCodec();

    @Test
    public void testDoEncoding_NullInput() {
        // Test with null input
        byte[] result = bCodec.doEncoding(null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testDoEncoding_EmptyInput() {
        // Test with empty byte array
        byte[] input = new byte[0];
        byte[] expected = Base64.encodeBase64(input);
        byte[] result = bCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Encoding empty byte array should return empty byte array");
    }

    @Test
    public void testDoEncoding_SingleByteInput() {
        // Test with a single byte
        // ASCII for 'A'
        byte[] input = new byte[] { 65 };
        byte[] expected = Base64.encodeBase64(input);
        byte[] result = bCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Encoding single byte should return correct Base64 encoded result");
    }

    @Test
    public void testDoEncoding_MultipleBytesInput() {
        // Test with multiple bytes
        // ASCII for 'Hello'
        byte[] input = new byte[] { 72, 101, 108, 108, 111 };
        byte[] expected = Base64.encodeBase64(input);
        byte[] result = bCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Encoding multiple bytes should return correct Base64 encoded result");
    }

    @Test
    public void testDoEncoding_NonASCIIInput() {
        // Test with non-ASCII bytes
        // Unicode character '✓'
        byte[] input = new byte[] { (byte) 0xE2, (byte) 0x9C, (byte) 0x94 };
        byte[] expected = Base64.encodeBase64(input);
        byte[] result = bCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Encoding non-ASCII bytes should return correct Base64 encoded result");
    }

    @Test
    public void testDoEncoding_LargeInput() {
        // Test with a larger byte array
        byte[] input = new byte[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = (byte) (i % 256);
        }
        byte[] expected = Base64.encodeBase64(input);
        byte[] result = bCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Encoding large byte array should return correct Base64 encoded result");
    }
}
