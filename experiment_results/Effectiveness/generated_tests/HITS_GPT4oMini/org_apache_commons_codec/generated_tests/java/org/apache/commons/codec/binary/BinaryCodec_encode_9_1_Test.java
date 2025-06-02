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

public class BinaryCodec_encode_9_1_Test {

    private final BinaryCodec binaryCodec = new BinaryCodec();

    @Test
    public void testEncode_ValidByteArray() throws EncoderException {
        byte[] input = { 0b00000001, 0b00000010 };
        char[] expectedOutput = { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0' };
        Object actualOutputObj = binaryCodec.encode(input);
        assertTrue(actualOutputObj instanceof char[], "Output should be of type char[]");
        char[] actualOutput = (char[]) actualOutputObj;
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncode_EmptyByteArray() throws EncoderException {
        byte[] input = {};
        char[] expectedOutput = {};
        Object actualOutputObj = binaryCodec.encode(input);
        assertTrue(actualOutputObj instanceof char[], "Output should be of type char[]");
        char[] actualOutput = (char[]) actualOutputObj;
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncode_NullInput() {
        assertThrows(EncoderException.class, () -> {
            binaryCodec.encode(null);
        });
    }

    @Test
    public void testEncode_InvalidInputType() {
        assertThrows(EncoderException.class, () -> {
            binaryCodec.encode("Not a byte array");
        });
    }
}
