package org.apache.commons.codec.net;

import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encode_6_1_Test {

    private final URLCodec urlCodec = new URLCodec();

    @Test
    public void testEncode_NullInput() {
        // Test case for null input
        byte[] result = urlCodec.encode((byte[]) null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_EmptyInput() {
        // Test case for empty byte array
        byte[] result = urlCodec.encode(new byte[] {});
        assertArrayEquals(new byte[] {}, result, "Encoding an empty array should return an empty array");
    }

    @Test
    public void testEncode_SimpleAsciiInput() {
        // Test case for simple ASCII input
        byte[] input = "Hello World".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello+World".getBytes(StandardCharsets.UTF_8);
        byte[] result = urlCodec.encode(input);
        assertArrayEquals(expected, result, "Encoding 'Hello World' should return 'Hello+World'");
    }

    @Test
    public void testEncode_SpecialCharacters() {
        // Test case for input with special characters
        byte[] input = "Hello World! @#$%^&*()".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello+World%21+%40%23%24%25%5E%26%2A%28%29".getBytes(StandardCharsets.UTF_8);
        byte[] result = urlCodec.encode(input);
        assertArrayEquals(expected, result, "Encoding 'Hello World! @#$%^&*()' should return 'Hello+World%21+%40%23%24%25%5E%26%2A%28%29'");
    }

    @Test
    public void testEncode_NonAsciiInput() {
        // Test case for non-ASCII input
        byte[] input = "你好".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "%E4%BD%A0%E5%A5%BD".getBytes(StandardCharsets.UTF_8);
        byte[] result = urlCodec.encode(input);
        assertArrayEquals(expected, result, "Encoding '你好' should return '%E4%BD%A0%E5%A5%BD'");
    }
}
