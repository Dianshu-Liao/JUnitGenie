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

    // Test for normal hex string
    @Test
    public void testDecodeHex_ValidHex() throws DecoderException {
        // "Hello" in hex
        String hex = "48656c6c6f";
        byte[] expected = "Hello".getBytes(Hex.DEFAULT_CHARSET);
        byte[] result = Hex.decodeHex(hex);
        assertArrayEquals(expected, result);
    }

    // Test for empty string
    @Test
    public void testDecodeHex_EmptyString() throws DecoderException {
        String hex = "";
        byte[] expected = new byte[0];
        byte[] result = Hex.decodeHex(hex);
        assertArrayEquals(expected, result);
    }

    // Test for invalid hex string (odd length)
    @Test
    public void testDecodeHex_InvalidHex_OddLength() {
        // Invalid hex
        String hex = "123";
        assertThrows(DecoderException.class, () -> Hex.decodeHex(hex));
    }

    // Test for invalid hex string (non-hex characters)
    @Test
    public void testDecodeHex_InvalidHex_NonHexCharacters() {
        // Invalid hex
        String hex = "GHIJKL";
        assertThrows(DecoderException.class, () -> Hex.decodeHex(hex));
    }

    // Test for null input
    @Test
    public void testDecodeHex_NullInput() {
        String hex = null;
        assertThrows(DecoderException.class, () -> Hex.decodeHex(hex));
    }
}
