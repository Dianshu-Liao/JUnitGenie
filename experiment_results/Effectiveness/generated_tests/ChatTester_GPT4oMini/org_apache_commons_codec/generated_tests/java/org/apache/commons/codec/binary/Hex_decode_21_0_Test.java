package org.apache.commons.codec.binary;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;

public class Hex_decode_21_0_Test {

    private Hex hex;

    @BeforeEach
    public void setUp() {
        hex = new Hex();
    }

    @Test
    public void testDecodeString() throws DecoderException {
        // Hex for "Hello"
        String input = "48656c6c6f";
        char[] expected = "Hello".toCharArray();
        Object result = hex.decode(input);
        assertArrayEquals(expected, (char[]) result);
    }

    @Test
    public void testDecodeByteArray() throws DecoderException {
        // Hex for "Hello"
        byte[] input = new byte[] { 0x48, 0x65, 0x6c, 0x6c, 0x6f };
        Object result = hex.decode(input);
        assertEquals("Hello", new String((char[]) result));
    }

    @Test
    public void testDecodeByteBuffer() throws DecoderException {
        // Hex for "Hello"
        ByteBuffer input = ByteBuffer.wrap(new byte[] { 0x48, 0x65, 0x6c, 0x6c, 0x6f });
        Object result = hex.decode(input);
        assertEquals("Hello", new String((char[]) result));
    }

    @Test
    public void testDecodeCharArray() throws DecoderException {
        // Hex for "Hello"
        char[] input = "48656c6c6f".toCharArray();
        Object result = hex.decode(input);
        assertArrayEquals("Hello".toCharArray(), (char[]) result);
    }

    @Test
    public void testDecodeInvalidType() {
        assertThrows(DecoderException.class, () -> {
            hex.decode(new Object());
        });
    }

    @Test
    public void testDecodeClassCastException() {
        assertThrows(DecoderException.class, () -> {
            hex.decode(new Object());
        });
    }
}
