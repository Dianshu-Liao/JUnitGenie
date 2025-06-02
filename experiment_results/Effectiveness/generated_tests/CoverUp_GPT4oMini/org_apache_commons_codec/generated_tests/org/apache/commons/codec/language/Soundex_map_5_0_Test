package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

@ExtendWith(MockitoExtension.class)
class Soundex_map_5_0_Test {

    private Soundex soundex;

    @BeforeEach
    void setUp() {
        soundex = new Soundex(new char[] { '0', '1', '2', '3', '0', '1', '2', '0', '2', '2', '4', '5', '5', '0', '1', '2', '6', '2', '3', '0', '1', '0', '2', '0' });
    }

    @Test
    void testMap_ValidCharacter() throws Exception {
        char input = 'A';
        char expected = '0';
        char result = invokeMapMethod(input);
        assertEquals(expected, result);
    }

    @Test
    void testMap_CharacterNotMapped() {
        char input = '!';
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeMapMethod(input);
        });
        assertEquals("The character is not mapped: ! (index=-33)", thrown.getMessage());
    }

    @Test
    void testMap_CharacterOutOfBounds() {
        char input = 'Z';
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeMapMethod(input);
        });
        assertEquals("The character is not mapped: Z (index=25)", thrown.getMessage());
    }

    private char invokeMapMethod(char ch) throws Exception {
        Method mapMethod = Soundex.class.getDeclaredMethod("map", char.class);
        mapMethod.setAccessible(true);
        return (char) mapMethod.invoke(soundex, ch);
    }
}
