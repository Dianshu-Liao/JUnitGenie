package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;

public class Hex_decodeHex_1_0_Test {

    @Test
    public void testDecodeHex_ValidInput() throws DecoderException {
        char[] input = { '1', 'a', '2', 'b', '3', 'c' };
        byte[] output = new byte[3];
        int resultLength = Hex.decodeHex(input, output, 0);
        byte[] expectedOutput = new byte[] { 26, 43, 60 };
        assertArrayEquals(expectedOutput, output);
    }

    @Test
    public void testDecodeHex_OddLengthInput() {
        char[] input = { '1', 'a', '2', 'b', '3' };
        byte[] output = new byte[3];
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            Hex.decodeHex(input, output, 0);
        });
        assertEquals("Odd number of characters.", thrown.getMessage());
    }

    @Test
    public void testDecodeHex_InsufficientOutputArraySize() {
        char[] input = { '1', 'a', '2', 'b', '3', 'c' };
        // Not enough space for 3 bytes
        byte[] output = new byte[2];
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            Hex.decodeHex(input, output, 0);
        });
        assertEquals("Output array is not large enough to accommodate decoded data.", thrown.getMessage());
    }

    @Test
    public void testDecodeHex_InvalidHexCharacter() {
        char[] input = { '1', 'g', '2', 'b', '3', 'c' };
        byte[] output = new byte[3];
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            Hex.decodeHex(input, output, 0);
        });
        assertEquals("Illegal hexadecimal character g at index 1", thrown.getMessage());
    }

    @Test
    public void testDecodeHex_EmptyInput() throws DecoderException {
        char[] input = {};
        byte[] output = new byte[0];
        int resultLength = Hex.decodeHex(input, output, 0);
        assertArrayEquals(new byte[0], output);
        assertEquals(0, resultLength);
    }
}
