package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import java.lang.reflect.Method;
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

    private Hex hex;

    @BeforeEach
    public void setUp() {
        hex = new Hex();
    }

    @Test
    public void testDecodeHex_ValidInput() throws Exception {
        char[] input = { '1', 'a', '2', 'b', '3', 'c' };
        byte[] output = new byte[3];
        int outOffset = 0;
        int result = invokeDecodeHex(input, output, outOffset);
        assertArrayEquals(new byte[] { 0x1a, 0x2b, 0x3c }, output);
        assertEquals(3, result);
    }

    @Test
    public void testDecodeHex_OddNumberOfCharacters() {
        char[] input = { '1', 'a', '2', 'b', '3' };
        byte[] output = new byte[3];
        int outOffset = 0;
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            invokeDecodeHex(input, output, outOffset);
        });
        assertEquals("Odd number of characters.", thrown.getMessage());
    }

    @Test
    public void testDecodeHex_OutputArrayTooSmall() {
        char[] input = { '1', 'a', '2', 'b', '3', 'c' };
        byte[] output = new byte[2];
        int outOffset = 0;
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            invokeDecodeHex(input, output, outOffset);
        });
        assertEquals("Output array is not large enough to accommodate decoded data.", thrown.getMessage());
    }

    private int invokeDecodeHex(char[] data, byte[] out, int outOffset) throws Exception {
        Method method = Hex.class.getDeclaredMethod("decodeHex", char[].class, byte[].class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, data, out, outOffset);
    }
}
