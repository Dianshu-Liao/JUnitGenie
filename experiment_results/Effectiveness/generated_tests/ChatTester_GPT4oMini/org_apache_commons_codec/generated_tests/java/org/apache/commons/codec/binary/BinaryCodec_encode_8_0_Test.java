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

public class BinaryCodec_encode_8_0_Test {

    @Test
    public void testEncode_withValidInput() throws Exception {
        // Arrange
        BinaryCodec codec = new BinaryCodec();
        // ASCII for 'A', 'B', 'C'
        byte[] input = { 65, 66, 67 };
        // Assuming this method exists
        byte[] expectedOutput = toAsciiBytes(input);
        // Act
        byte[] result = codec.encode(input);
        // Assert
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testEncode_withEmptyInput() throws Exception {
        // Arrange
        BinaryCodec codec = new BinaryCodec();
        byte[] input = {};
        // Act
        byte[] result = codec.encode(input);
        // Assert
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testEncode_withNullInput() {
        // Arrange
        BinaryCodec codec = new BinaryCodec();
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            codec.encode(null);
        });
    }

    @Test
    public void testEncode_withSpecialCharacters() throws Exception {
        // Arrange
        BinaryCodec codec = new BinaryCodec();
        // Special characters
        byte[] input = { 0, 1, 2, 3, 4, 5 };
        // Assuming this method exists
        byte[] expectedOutput = toAsciiBytes(input);
        // Act
        byte[] result = codec.encode(input);
        // Assert
        assertArrayEquals(expectedOutput, result);
    }

    // Reflection method to call private 'toAsciiBytes' method
    private byte[] toAsciiBytes(byte[] raw) throws Exception {
        Method method = BinaryCodec.class.getDeclaredMethod("toAsciiBytes", byte[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(new BinaryCodec(), (Object) raw);
    }
}
