package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
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

public class BinaryCodec_encode_9_0_Test {

    private BinaryCodec binaryCodec;

    @BeforeEach
    public void setUp() {
        binaryCodec = new BinaryCodec();
    }

    @Test
    public void testEncode_ValidByteArray() throws Exception {
        byte[] input = { 0b00000001, 0b00000010, 0b00000011 };
        // Expected ASCII characters
        char[] expectedOutput = { '\u0001', '\u0002', '\u0003' };
        Object result = binaryCodec.encode(input);
        assertArrayEquals(expectedOutput, (char[]) result);
    }

    @Test
    public void testEncode_InvalidInput_NonByteArray() {
        String invalidInput = "Not a byte array";
        Exception exception = assertThrows(EncoderException.class, () -> {
            binaryCodec.encode(invalidInput);
        });
        assertEquals("argument not a byte array", exception.getMessage());
    }

    @Test
    public void testEncode_EmptyByteArray() throws Exception {
        byte[] input = {};
        // Expected empty ASCII character array
        char[] expectedOutput = {};
        Object result = binaryCodec.encode(input);
        assertArrayEquals(expectedOutput, (char[]) result);
    }

    // Reflection test for private method toAsciiChars
    @Test
    public void testToAsciiChars() throws Exception {
        Method method = BinaryCodec.class.getDeclaredMethod("toAsciiChars", byte[].class);
        method.setAccessible(true);
        byte[] input = { 0b00000001, 0b00000010 };
        char[] expectedOutput = { '\u0001', '\u0002' };
        char[] result = (char[]) method.invoke(binaryCodec, (Object) input);
        assertArrayEquals(expectedOutput, result);
    }
}
