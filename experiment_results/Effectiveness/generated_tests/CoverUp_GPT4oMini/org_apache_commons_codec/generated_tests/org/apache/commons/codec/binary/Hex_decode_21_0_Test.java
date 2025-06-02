package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.Charset;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;

class Hex_decode_21_0_Test {

    private Hex hex;

    @BeforeEach
    void setUp() {
        hex = new Hex();
    }

    @Test
    void testDecodeString() throws DecoderException {
        // Hex for "Hello"
        String input = "48656c6c6f";
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        Object result = hex.decode(input);
        assertArrayEquals(expected, (byte[]) result);
    }

    @Test
    void testDecodeByteArray() throws DecoderException {
        // Hex for "Hello"
        byte[] input = "48656c6c6f".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        Object result = hex.decode(input);
        assertArrayEquals(expected, (byte[]) result);
    }

    @Test
    void testDecodeByteBuffer() throws DecoderException {
        // Hex for "Hello"
        ByteBuffer input = ByteBuffer.wrap("48656c6c6f".getBytes(StandardCharsets.UTF_8));
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        Object result = hex.decode(input);
        assertArrayEquals(expected, (byte[]) result);
    }

    @Test
    void testDecodeCharArray() throws DecoderException {
        // Hex for "Hello"
        char[] input = "48656c6c6f".toCharArray();
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        Object result = hex.decode(input);
        assertArrayEquals(expected, (byte[]) result);
    }

    @Test
    void testDecodeInvalidType() {
        assertThrows(DecoderException.class, () -> {
            // Invalid input type
            hex.decode(123);
        });
    }

    @Test
    void testDecodeClassCastException() {
        assertThrows(DecoderException.class, () -> {
            // Invalid input type
            hex.decode(new Object());
        });
    }
}
