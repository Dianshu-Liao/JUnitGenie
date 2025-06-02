package org.apache.commons.codec.binary;

import org.apache.commons.codec.EncoderException;
import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BinaryCodec_encode_9_0_Test {

    private final BinaryCodec binaryCodec = new BinaryCodec();

    @Test
    public void testEncodeWithValidByteArray() throws Exception {
        // binary representation of 1 and 2
        byte[] input = { 0b00000001, 0b00000010 };
        char[] expectedOutput = { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0' };
        // Use reflection to invoke the private method
        char[] actualOutput = (char[]) invokeEncode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeWithEmptyByteArray() throws Exception {
        byte[] input = {};
        char[] expectedOutput = {};
        // Use reflection to invoke the private method
        char[] actualOutput = (char[]) invokeEncode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeWithInvalidInput() {
        String invalidInput = "Not a byte array";
        EncoderException thrown = assertThrows(EncoderException.class, () -> {
            binaryCodec.encode(invalidInput);
        });
        assertEquals("argument not a byte array", thrown.getMessage());
    }

    @Test
    public void testEncodeWithNullInput() {
        assertThrows(EncoderException.class, () -> {
            binaryCodec.encode(null);
        });
    }

    private Object invokeEncode(Object input) throws Exception {
        Method method = BinaryCodec.class.getDeclaredMethod("encode", Object.class);
        method.setAccessible(true);
        return method.invoke(binaryCodec, input);
    }
}
