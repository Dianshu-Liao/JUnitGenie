package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.regex.Pattern;
import org.apache.commons.codec.StringEncoder;

class Nysiis_encode_2_0_Test {

    private Nysiis nysiis;

    @BeforeEach
    void setUp() {
        nysiis = new Nysiis();
    }

    @Test
    void testEncodeWithValidString() throws EncoderException {
        String input = "MacDonald";
        String expected = "MCC";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    void testEncodeWithNull() {
        assertThrows(EncoderException.class, () -> nysiis.encode(null));
    }

    @Test
    void testEncodeWithNonStringObject() {
        assertThrows(EncoderException.class, () -> nysiis.encode(123));
    }

    @Test
    void testEncodeWithEmptyString() throws EncoderException {
        String input = "";
        String expected = "";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    void testEncodeWithStringContainingOnlySpaces() throws EncoderException {
        String input = "   ";
        String expected = "";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    void testEncodeWithStringEndingInS() throws EncoderException {
        String input = "Ross";
        String expected = "R";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    void testEncodeWithStringEndingInAY() throws EncoderException {
        String input = "Clay";
        String expected = "C";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    void testEncodeWithStrictMode() throws Exception {
        Constructor<Nysiis> strictConstructor = Nysiis.class.getDeclaredConstructor(boolean.class);
        strictConstructor.setAccessible(true);
        Nysiis strictNysiis = strictConstructor.newInstance(true);
        String input = "MacDonald";
        String expected = "MCC";
        assertEquals(expected, strictNysiis.encode(input));
    }

    @Test
    void testEncodeWithNonStrictMode() throws Exception {
        Constructor<Nysiis> nonStrictConstructor = Nysiis.class.getDeclaredConstructor(boolean.class);
        nonStrictConstructor.setAccessible(true);
        Nysiis nonStrictNysiis = nonStrictConstructor.newInstance(false);
        String input = "MacDonald";
        String expected = "MCC";
        assertEquals(expected, nonStrictNysiis.encode(input));
    }
}
