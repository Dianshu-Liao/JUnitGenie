package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;

class Hex_decodeHex_1_0_Test {

    private final Hex hex = new Hex();

    @Test
    void testDecodeHex_ValidInput() throws DecoderException {
        // "Hello" in hex
        char[] input = "48656c6c6f".toCharArray();
        byte[] output = new byte[5];
        int result = hex.decodeHex(input, output, 0);
        assertEquals(5, result);
        assertArrayEquals("Hello".getBytes(StandardCharsets.UTF_8), output);
    }

    @Test
    void testDecodeHex_OddLengthInput() {
        // Odd length
        char[] input = "48656c6c6f1".toCharArray();
        byte[] output = new byte[5];
        DecoderException exception = assertThrows(DecoderException.class, () -> {
            hex.decodeHex(input, output, 0);
        });
        assertEquals("Odd number of characters.", exception.getMessage());
    }

    @Test
    void testDecodeHex_OutputArrayTooSmall() {
        // "Hello" in hex
        char[] input = "48656c6c6f".toCharArray();
        // Too small
        byte[] output = new byte[4];
        DecoderException exception = assertThrows(DecoderException.class, () -> {
            hex.decodeHex(input, output, 0);
        });
        assertEquals("Output array is not large enough to accommodate decoded data.", exception.getMessage());
    }

    @Test
    void testDecodeHex_InvalidHexCharacter() {
        // Invalid hex character 'g'
        char[] input = "48656g6c6f".toCharArray();
        byte[] output = new byte[5];
        DecoderException exception = assertThrows(DecoderException.class, () -> {
            hex.decodeHex(input, output, 0);
        });
        assertTrue(exception.getMessage().contains("Illegal hexadecimal character g"));
    }

    @Test
    void testDecodeHex_ValidInputWithOffset() throws DecoderException {
        // "Hello" in hex
        char[] input = "48656c6c6f".toCharArray();
        byte[] output = new byte[10];
        int result = hex.decodeHex(input, output, 2);
        assertEquals(5, result);
        assertArrayEquals("Hello".getBytes(StandardCharsets.UTF_8), new byte[] { output[2], output[3], output[4], output[5], output[6] });
    }
}
