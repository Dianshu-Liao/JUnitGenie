package org.apache.commons.codec.binary;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.DecoderException;
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

public class Hex_decode_19_0_Test {

    private Hex hex;

    @BeforeEach
    public void setUp() {
        hex = new Hex();
    }

    @Test
    public void testDecode_ValidHexString() throws DecoderException {
        // Hex for "Hello"
        byte[] input = "48656c6c6f".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] result = hex.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_EmptyInput() throws DecoderException {
        byte[] input = "".getBytes(StandardCharsets.UTF_8);
        byte[] expected = new byte[0];
        byte[] result = hex.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_InvalidHexString() {
        byte[] input = "xyz".getBytes(StandardCharsets.UTF_8);
        assertThrows(DecoderException.class, () -> {
            hex.decode(input);
        });
    }

    @Test
    public void testDecode_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed the ambiguous reference by explicitly casting to byte[]
            hex.decode((byte[]) null);
        });
    }

    @Test
    public void testDecode_ValidHexUppercase() throws DecoderException {
        // Hex for "Hello"
        byte[] input = "48656C6C6F".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] result = hex.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_WhitespaceHexString() throws DecoderException {
        // Hex for " "
        byte[] input = "20".getBytes(StandardCharsets.UTF_8);
        byte[] expected = " ".getBytes(StandardCharsets.UTF_8);
        byte[] result = hex.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_ValidHexWithMixedCase() throws DecoderException {
        // Hex for "Hello"
        byte[] input = "48656c6C6f".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] result = hex.decode(input);
        assertArrayEquals(expected, result);
    }
}
