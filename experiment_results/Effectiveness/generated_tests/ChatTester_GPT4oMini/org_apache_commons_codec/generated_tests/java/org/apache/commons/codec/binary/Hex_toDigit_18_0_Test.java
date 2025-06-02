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

public class Hex_toDigit_18_0_Test {

    @Test
    public void testToDigit_ValidLowercaseHexCharacter() throws Exception {
        // Arrange
        char ch = 'a';
        int index = 0;
        Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
        method.setAccessible(true);
        // Act
        int result = (int) method.invoke(null, ch, index);
        // Assert
        assertEquals(10, result);
    }

    @Test
    public void testToDigit_ValidUppercaseHexCharacter() throws Exception {
        // Arrange
        char ch = 'A';
        int index = 1;
        Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
        method.setAccessible(true);
        // Act
        int result = (int) method.invoke(null, ch, index);
        // Assert
        assertEquals(10, result);
    }

    @Test
    public void testToDigit_InvalidHexCharacter() throws Exception {
        // Arrange
        char ch = 'g';
        int index = 2;
        Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
        method.setAccessible(true);
        // Act & Assert
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            method.invoke(null, ch, index);
        });
        assertEquals("Illegal hexadecimal character g at index 2", thrown.getMessage());
    }

    @Test
    public void testToDigit_NonHexCharacter() throws Exception {
        // Arrange
        char ch = '!';
        int index = 3;
        Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
        method.setAccessible(true);
        // Act & Assert
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            method.invoke(null, ch, index);
        });
        assertEquals("Illegal hexadecimal character ! at index 3", thrown.getMessage());
    }
}
