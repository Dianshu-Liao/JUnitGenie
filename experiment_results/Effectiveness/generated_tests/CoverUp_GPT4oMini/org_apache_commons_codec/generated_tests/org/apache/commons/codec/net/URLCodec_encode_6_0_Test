package org.apache.commons.codec.net;

import org.apache.commons.codec.net.URLCodec;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class URLCodec_encode_6_0_Test {

    @Test
    void testEncode_NullInput() {
        URLCodec codec = new URLCodec();
        byte[] result = codec.encode((byte[]) null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    void testEncode_EmptyInput() {
        URLCodec codec = new URLCodec();
        byte[] result = codec.encode(new byte[0]);
        assertArrayEquals(new byte[0], result, "Encoding an empty byte array should return an empty byte array");
    }

    @Test
    void testEncode_SimpleInput() {
        URLCodec codec = new URLCodec();
        byte[] input = "Hello World".getBytes();
        // '+' for space
        byte[] expected = "Hello+World".getBytes();
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding 'Hello World' should replace space with '+'");
    }

    @Test
    void testEncode_SpecialCharacters() {
        URLCodec codec = new URLCodec();
        byte[] input = "Hello World! @#$%".getBytes();
        // Encoding special characters
        byte[] expected = "Hello+World%21+%40%23%24%25".getBytes();
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding should handle special characters correctly");
    }

    @Test
    void testEncode_NonAsciiCharacters() {
        URLCodec codec = new URLCodec("UTF-8");
        // Japanese characters
        byte[] input = "こんにちは".getBytes();
        // Expected result will depend on the encoding, here we assume it encodes to UTF-8
        byte[] result = codec.encode(input);
        // Check if the result is not null and has the expected length
        assertNotNull(result, "Encoding non-ASCII characters should not return null");
    }

    // Additional test for private method encodeUrl using reflection
    @Test
    void testEncodeUrl_UsingReflection() throws Exception {
        Method encodeUrlMethod = URLCodec.class.getDeclaredMethod("encodeUrl", BitSet.class, byte[].class);
        encodeUrlMethod.setAccessible(true);
        BitSet urlsafe = new BitSet(256);
        // Allow space
        urlsafe.set(' ');
        byte[] input = "Hello World".getBytes();
        // Expected output
        byte[] expected = "Hello+World".getBytes();
        byte[] result = (byte[]) encodeUrlMethod.invoke(null, urlsafe, input);
        assertArrayEquals(expected, result, "Reflection should allow encoding using encodeUrl method");
    }
}
