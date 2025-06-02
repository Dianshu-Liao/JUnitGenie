package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_Soundex_10_2_Test {

    private Soundex soundex;

    @BeforeEach
    public void setUp() {
        soundex = Soundex.US_ENGLISH;
    }

    @Test
    public void testSoundexInitialization() {
        // Since we cannot access private fields, we will not check them directly.
        // We can assume that the Soundex.US_ENGLISH is initialized correctly by testing its output.
        assertEquals("R163", soundex.soundex("Robert"));
    }

    @Test
    public void testSoundexMapping() {
        String input = "Robert";
        // Expected Soundex code for "Robert"
        String expectedOutput = "R163";
        assertEquals(expectedOutput, soundex.soundex(input));
    }

    @Test
    public void testSoundexWithDifferentInputs() {
        assertEquals("A163", soundex.soundex("Arobert"));
        assertEquals("B635", soundex.soundex("Bobby"));
        assertEquals("C530", soundex.soundex("Cathy"));
        assertEquals("D300", soundex.soundex("Daisy"));
    }

    @Test
    public void testSoundexWithEmptyString() {
        assertEquals("0000", soundex.soundex(""));
    }

    @Test
    public void testSoundexWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            soundex.soundex(null);
        });
    }

    @Test
    public void testSoundexWithSpecialCharacters() {
        assertEquals("S000", soundex.soundex("S@ndy"));
        assertEquals("J000", soundex.soundex("J#ohn"));
    }

    @Test
    public void testSoundexWithSingleLetter() {
        assertEquals("A000", soundex.soundex("A"));
        assertEquals("B000", soundex.soundex("B"));
    }

    @Test
    public void testSoundexWithNumbers() {
        assertEquals("N000", soundex.soundex("1234"));
        assertEquals("Z000", soundex.soundex("Z1"));
    }
}
