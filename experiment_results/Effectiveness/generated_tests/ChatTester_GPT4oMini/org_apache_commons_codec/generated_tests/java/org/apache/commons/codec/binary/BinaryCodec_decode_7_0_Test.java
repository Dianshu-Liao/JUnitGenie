package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

class BinaryCodec_decode_7_0_Test {

    private final BinaryCodec binaryCodec = new BinaryCodec();

    @Test
    void testDecodeWithNullInput() throws Exception {
        Object result = binaryCodec.decode(null);
        assertArrayEquals(new byte[] {}, (byte[]) result);
    }

    @Test
    void testDecodeWithByteArray() throws Exception {
        // ASCII for 'A', 'B', 'C'
        byte[] input = { 65, 66, 67 };
        Object result = binaryCodec.decode(input);
        assertArrayEquals(new byte[] { 65, 66, 67 }, (byte[]) result);
    }

    @Test
    void testDecodeWithCharArray() throws Exception {
        char[] input = { 'A', 'B', 'C' };
        Object result = binaryCodec.decode(input);
        assertArrayEquals(new byte[] { 65, 66, 67 }, (byte[]) result);
    }

    @Test
    void testDecodeWithString() throws Exception {
        String input = "ABC";
        Object result = binaryCodec.decode(input);
        assertArrayEquals(new byte[] { 65, 66, 67 }, (byte[]) result);
    }

    @Test
    void testDecodeWithInvalidInput() {
        Exception exception = assertThrows(DecoderException.class, () -> {
            // Invalid input type
            binaryCodec.decode(123);
        });
        assertEquals("argument not a byte array", exception.getMessage());
    }
}
