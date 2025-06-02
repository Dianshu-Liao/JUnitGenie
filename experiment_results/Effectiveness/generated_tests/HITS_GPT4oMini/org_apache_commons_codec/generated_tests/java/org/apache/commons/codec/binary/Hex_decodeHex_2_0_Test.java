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

public class Hex_decodeHex_2_0_Test {

    @Test
    public void testDecodeHex_ValidLowercaseHex() throws DecoderException {
        // "Hello" in hex
        String input = "48656c6c6f";
        byte[] expected = "Hello".getBytes(Hex.DEFAULT_CHARSET);
        byte[] actual = Hex.decodeHex(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeHex_ValidUppercaseHex() throws DecoderException {
        // "Hello" in hex
        String input = "48656C6C6F";
        byte[] expected = "Hello".getBytes(Hex.DEFAULT_CHARSET);
        byte[] actual = Hex.decodeHex(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeHex_ValidMixedCaseHex() throws DecoderException {
        // "Hello" in hex
        String input = "48656c6c6F";
        byte[] expected = "Hello".getBytes(Hex.DEFAULT_CHARSET);
        byte[] actual = Hex.decodeHex(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeHex_EmptyString() throws DecoderException {
        String input = "";
        // Expect an empty byte array
        byte[] expected = new byte[0];
        byte[] actual = Hex.decodeHex(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeHex_InvalidHexCharacters() {
        // Invalid hex character 'G'
        String input = "G123";
        assertThrows(DecoderException.class, () -> {
            Hex.decodeHex(input);
        });
    }

    @Test
    public void testDecodeHex_OddLengthHex() {
        // Odd length
        String input = "123";
        assertThrows(DecoderException.class, () -> {
            Hex.decodeHex(input);
        });
    }

    @Test
    public void testDecodeHex_NullInput() {
        // Null input
        String input = null;
        assertThrows(NullPointerException.class, () -> {
            Hex.decodeHex(input);
        });
    }
}
