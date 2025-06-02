package org.apache.commons.codec.binary;

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
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Hex_toAlphabet_16_0_Test {

    @Test
    public void testToAlphabetLowerCase() throws Exception {
        // Arrange
        boolean toLowerCase = true;
        char[] expected = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        // Act
        char[] result = invokeToAlphabet(toLowerCase);
        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAlphabetUpperCase() throws Exception {
        // Arrange
        boolean toLowerCase = false;
        char[] expected = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        // Act
        char[] result = invokeToAlphabet(toLowerCase);
        // Assert
        assertArrayEquals(expected, result);
    }

    private char[] invokeToAlphabet(boolean toLowerCase) throws Exception {
        Method method = Hex.class.getDeclaredMethod("toAlphabet", boolean.class);
        method.setAccessible(true);
        return (char[]) method.invoke(null, toLowerCase);
    }
}
