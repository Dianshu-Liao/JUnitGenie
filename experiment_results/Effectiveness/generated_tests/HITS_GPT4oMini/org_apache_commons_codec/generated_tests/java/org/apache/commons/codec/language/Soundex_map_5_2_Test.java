package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_map_5_2_Test {

    private Soundex soundex;

    @BeforeEach
    public void setUp() {
        soundex = new Soundex();
    }

    private char invokeMap(char ch) throws Exception {
        Method method = Soundex.class.getDeclaredMethod("map", char.class);
        method.setAccessible(true);
        return (char) method.invoke(soundex, ch);
    }

    @Test
    public void testMap_ValidCharacter() throws Exception {
        assertEquals('0', invokeMap('A'));
        assertEquals('0', invokeMap('B'));
        assertEquals('1', invokeMap('C'));
        assertEquals('2', invokeMap('D'));
        assertEquals('3', invokeMap('H'));
        assertEquals('4', invokeMap('K'));
        assertEquals('5', invokeMap('L'));
        assertEquals('6', invokeMap('M'));
        assertEquals('7', invokeMap('N'));
        assertEquals('8', invokeMap('R'));
    }

    @Test
    public void testMap_InvalidCharacter() {
        assertThrows(IllegalArgumentException.class, () -> invokeMap('1'));
        assertThrows(IllegalArgumentException.class, () -> invokeMap('!'));
        assertThrows(IllegalArgumentException.class, () -> invokeMap(' '));
        assertThrows(IllegalArgumentException.class, () -> invokeMap('Z'));
    }
}
