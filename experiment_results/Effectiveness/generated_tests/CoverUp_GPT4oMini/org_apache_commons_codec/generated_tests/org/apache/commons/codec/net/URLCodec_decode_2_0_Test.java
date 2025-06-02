package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import java.lang.reflect.Method;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class URLCodec_decode_2_0_Test {

    @Test
    void testDecode_NullInput() throws DecoderException {
        URLCodec codec = new URLCodec();
        byte[] result = codec.decode((byte[]) null);
        assertNull(result, "Decoding null should return null");
    }

    @Test
    void testDecode_EmptyInput() throws DecoderException {
        URLCodec codec = new URLCodec();
        byte[] result = codec.decode(new byte[] {});
        assertArrayEquals(new byte[] {}, result, "Decoding empty byte array should return empty byte array");
    }

    @Test
    void testDecode_SimpleEncoding() throws DecoderException {
        URLCodec codec = new URLCodec();
        byte[] input = "Hello%20World".getBytes();
        byte[] expected = "Hello World".getBytes();
        byte[] result = codec.decode(input);
        assertArrayEquals(expected, result, "Decoded byte array should match expected value");
    }

    @Test
    void testDecode_ComplexEncoding() throws DecoderException {
        URLCodec codec = new URLCodec();
        byte[] input = "This%20is%20a%20test%21".getBytes();
        byte[] expected = "This is a test!".getBytes();
        byte[] result = codec.decode(input);
        assertArrayEquals(expected, result, "Decoded byte array should match expected value");
    }

    @Test
    void testDecode_InvalidEncoding() {
        URLCodec codec = new URLCodec();
        byte[] input = "Invalid%2".getBytes();
        DecoderException exception = assertThrows(DecoderException.class, () -> {
            codec.decode(input);
        });
        assertEquals("Invalid URL encoding: ", exception.getMessage().substring(0, 27), "Exception message should indicate invalid encoding");
    }

    @Test
    void testDecode_PlusSignEncoding() throws DecoderException {
        URLCodec codec = new URLCodec();
        byte[] input = "Hello+World".getBytes();
        byte[] expected = "Hello World".getBytes();
        byte[] result = codec.decode(input);
        assertArrayEquals(expected, result, "Decoded byte array should replace '+' with space");
    }

    @Test
    void testDecode_EscapedChars() throws DecoderException {
        URLCodec codec = new URLCodec();
        // !@#$%^&*()
        byte[] input = "%21%40%23%24%25%5E%26%2A%28%29".getBytes();
        byte[] expected = "!@#$%^&*()".getBytes();
        byte[] result = codec.decode(input);
        assertArrayEquals(expected, result, "Decoded byte array should match expected escaped characters");
    }

    // Reflection test for private method if needed
    @Test
    void testDecodeUrl() throws Exception {
        Method method = URLCodec.class.getDeclaredMethod("decodeUrl", byte[].class);
        method.setAccessible(true);
        URLCodec codec = new URLCodec();
        byte[] input = "Hello%20World".getBytes();
        byte[] expected = "Hello World".getBytes();
        byte[] result = (byte[]) method.invoke(codec, input);
        assertArrayEquals(expected, result, "Decoded byte array should match expected value using reflection");
    }
}
