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
        Hex hex = new Hex();
        char inputChar = 'a';
        int index = 0;
        // Act
        Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(hex, inputChar, index);
        // Assert
        assertEquals(10, result);
    }

    @Test
    public void testToDigit_ValidUppercaseHexCharacter() throws Exception {
        // Arrange
        Hex hex = new Hex();
        char inputChar = 'A';
        int index = 1;
        // Act
        Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(hex, inputChar, index);
        // Assert
        assertEquals(10, result);
    }

    @Test
    public void testToDigit_InvalidHexCharacter() throws Exception {
        // Arrange
        Hex hex = new Hex();
        char inputChar = 'g';
        int index = 2;
        // Act & Assert
        Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
        method.setAccessible(true);
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            method.invoke(hex, inputChar, index);
        });
        assertEquals("Illegal hexadecimal character g at index 2", thrown.getMessage());
    }

    @Test
    public void testToDigit_NonHexCharacter() throws Exception {
        // Arrange
        Hex hex = new Hex();
        char inputChar = '#';
        int index = 3;
        // Act & Assert
        Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
        method.setAccessible(true);
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            method.invoke(hex, inputChar, index);
        });
        assertEquals("Illegal hexadecimal character # at index 3", thrown.getMessage());
    }
}
