package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class Soundex_map_5_0_Test {

    private Soundex soundex;

    @BeforeEach
    void setUp() {
        // Fixed Buggy Line: Initialize with a valid mapping
        soundex = new Soundex();
    }

    @Test
    void testMap_ValidCharacter() throws Exception {
        // Arrange
        char input = 'A';
        // Based on the US_ENGLISH_MAPPING_STRING
        char expectedOutput = '0';
        // Act
        char result = invokeMapMethod(soundex, input);
        // Assert
        assertEquals(expectedOutput, result);
    }

    @Test
    void testMap_CharacterNotMapped() {
        // Arrange
        char input = 'Z';
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeMapMethod(soundex, input);
        });
        assertEquals("The character is not mapped: Z (index=25)", thrown.getMessage());
    }

    @Test
    void testMap_NegativeIndex() {
        // Arrange
        // ASCII value is less than 'A'
        char input = '@';
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeMapMethod(soundex, input);
        });
        assertEquals("The character is not mapped: @ (index=-32)", thrown.getMessage());
    }

    @Test
    void testMap_IndexOutOfBounds() {
        // Arrange
        // Lowercase character
        char input = 'a';
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeMapMethod(soundex, input);
        });
        assertEquals("The character is not mapped: a (index=32)", thrown.getMessage());
    }

    private char invokeMapMethod(Soundex soundex, char ch) throws Exception {
        Method mapMethod = Soundex.class.getDeclaredMethod("map", char.class);
        mapMethod.setAccessible(true);
        return (char) mapMethod.invoke(soundex, ch);
    }
}
