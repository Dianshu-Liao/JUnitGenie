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

public class Hex_decode_19_0_Test {

    private Hex hex;

    @BeforeEach
    public void setUp() {
        hex = new Hex();
    }

    @Test
    public void testDecode_ValidHexLowercase() throws DecoderException {
        byte[] expected = new byte[] { 0x1A, 0x2B, 0x3C };
        byte[] result = hex.decode("1a2b3c".getBytes(Hex.DEFAULT_CHARSET));
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_ValidHexUppercase() throws DecoderException {
        byte[] expected = new byte[] { 0x1A, 0x2B, 0x3C };
        byte[] result = hex.decode("1A2B3C".getBytes(Hex.DEFAULT_CHARSET));
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_ValidHexMixedCase() throws DecoderException {
        byte[] expected = new byte[] { 0x1A, 0x2B, 0x3C };
        byte[] result = hex.decode("1a2B3c".getBytes(Hex.DEFAULT_CHARSET));
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_EmptyInput() throws DecoderException {
        byte[] expected = new byte[] {};
        byte[] result = hex.decode("".getBytes(Hex.DEFAULT_CHARSET));
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_InvalidHexString() {
        assertThrows(DecoderException.class, () -> {
            hex.decode("1g2b3c".getBytes(Hex.DEFAULT_CHARSET));
        });
    }

    @Test
    public void testDecode_OddLengthHexString() {
        assertThrows(DecoderException.class, () -> {
            hex.decode("1a2b3".getBytes(Hex.DEFAULT_CHARSET));
        });
    }
}
