package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
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

public class Hex_decodeHex_0_0_Test {

    private Hex hex;

    @BeforeEach
    public void setUp() {
        hex = new Hex();
    }

    @Test
    public void testDecodeHex_ValidInput() throws DecoderException {
        char[] input = { '1', 'a', '2', 'b' };
        // 1a -> 26, 2b -> 43
        byte[] expectedOutput = { 26, 43 };
        byte[] actualOutput = hex.decodeHex(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDecodeHex_EmptyInput() throws DecoderException {
        char[] input = {};
        byte[] expectedOutput = {};
        byte[] actualOutput = hex.decodeHex(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDecodeHex_OddLengthInput() {
        char[] input = { '1', 'a', '2' };
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            hex.decodeHex(input);
        });
        assertEquals("Odd number of characters.", thrown.getMessage());
    }

    @Test
    public void testDecodeHex_InvalidCharacterInput() {
        char[] input = { 'g', 'h' };
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            hex.decodeHex(input);
        });
        assertEquals("Invalid hexadecimal digit 'g'", thrown.getMessage());
    }

    @Test
    public void testDecodeHex_OutputArrayTooSmall() {
        char[] input = { '1', 'a', '2', 'b' };
        // Intentionally small
        byte[] output = new byte[1];
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            invokeDecodeHex(input, output, 0);
        });
        assertEquals("Output array is not large enough to accommodate decoded data.", thrown.getMessage());
    }

    private int invokeDecodeHex(char[] data, byte[] out, int outOffset) throws Exception {
        Method method = Hex.class.getDeclaredMethod("decodeHex", char[].class, byte[].class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, data, out, outOffset);
    }
}
