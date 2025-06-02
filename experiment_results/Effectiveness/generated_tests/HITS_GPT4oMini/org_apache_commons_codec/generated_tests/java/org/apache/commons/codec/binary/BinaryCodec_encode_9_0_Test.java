package org.apache.commons.codec.binary;

import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;

public class BinaryCodec_encode_9_0_Test {

    private final BinaryCodec binaryCodec = new BinaryCodec();

    @Test
    public void testEncode_withValidByteArray() throws EncoderException {
        // Example byte array
        byte[] input = new byte[] { 0b00000001, 0b00000010 };
        char[] expectedOutput = new char[] { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0' };
        Object result = binaryCodec.encode(input);
        assertTrue(result instanceof char[]);
        assertArrayEquals(expectedOutput, (char[]) result);
    }

    @Test
    public void testEncode_withEmptyByteArray() throws EncoderException {
        byte[] input = new byte[] {};
        char[] expectedOutput = new char[] {};
        Object result = binaryCodec.encode(input);
        assertTrue(result instanceof char[]);
        assertArrayEquals(expectedOutput, (char[]) result);
    }

    @Test
    public void testEncode_withNonByteArrayInput() {
        String input = "Not a byte array";
        EncoderException exception = assertThrows(EncoderException.class, () -> {
            binaryCodec.encode(input);
        });
        assertEquals("argument not a byte array", exception.getMessage());
    }

    @Test
    public void testEncode_withNullInput() {
        assertThrows(EncoderException.class, () -> {
            binaryCodec.encode(null);
        });
    }
}
