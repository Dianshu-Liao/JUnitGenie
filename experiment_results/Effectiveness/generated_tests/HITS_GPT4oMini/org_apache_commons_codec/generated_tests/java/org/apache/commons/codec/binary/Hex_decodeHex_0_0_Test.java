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

public class Hex_decodeHex_0_0_Test {

    @Test
    public void testDecodeHex_ValidInputLowercase() throws DecoderException {
        // "Hello" in hex
        char[] input = "48656c6c6f".toCharArray();
        byte[] expected = new byte[] { 72, 101, 108, 108, 111 };
        byte[] result = Hex.decodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecodeHex_ValidInputUppercase() throws DecoderException {
        // "Hello" in hex
        char[] input = "48656C6C6F".toCharArray();
        byte[] expected = new byte[] { 72, 101, 108, 108, 111 };
        byte[] result = Hex.decodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecodeHex_OddLengthInput() {
        // Odd length
        char[] input = "48656c6c".toCharArray();
        assertThrows(DecoderException.class, () -> {
            Hex.decodeHex(input);
        });
    }

    @Test
    public void testDecodeHex_InvalidHexCharacters() {
        // Invalid hex character 'g'
        char[] input = "48656g6c6f".toCharArray();
        assertThrows(DecoderException.class, () -> {
            Hex.decodeHex(input);
        });
    }

    @Test
    public void testDecodeHex_EmptyInput() throws DecoderException {
        char[] input = "".toCharArray();
        byte[] expected = new byte[] {};
        byte[] result = Hex.decodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecodeHex_ValidInputWithPadding() throws DecoderException {
        // 0 and 255 in hex
        char[] input = "00ff".toCharArray();
        byte[] expected = new byte[] { 0, -1 };
        byte[] result = Hex.decodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecodeHex_LargeInput() throws DecoderException {
        // 0 to 15 in hex
        char[] input = "000102030405060708090A0B0C0D0E0F".toCharArray();
        byte[] expected = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        byte[] result = Hex.decodeHex(input);
        assertArrayEquals(expected, result);
    }
}
