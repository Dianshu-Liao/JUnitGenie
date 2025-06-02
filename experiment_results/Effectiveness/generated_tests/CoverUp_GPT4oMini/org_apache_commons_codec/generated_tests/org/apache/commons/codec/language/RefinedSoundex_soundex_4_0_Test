package org.apache.commons.codec.language;

import org.apache.commons.codec.language.RefinedSoundex;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

class RefinedSoundex_soundex_4_0_Test {

    private final RefinedSoundex refinedSoundex = new RefinedSoundex();

    @Test
    void testSoundexWithNullInput() {
        assertNull(refinedSoundex.soundex(null));
    }

    @Test
    void testSoundexWithEmptyString() {
        assertEquals("", refinedSoundex.soundex(""));
    }

    @Test
    void testSoundexWithSingleLetter() {
        assertEquals("A", refinedSoundex.soundex("A"));
        assertEquals("B", refinedSoundex.soundex("B"));
    }

    @Test
    void testSoundexWithRepeatedLetters() {
        assertEquals("A", refinedSoundex.soundex("AAA"));
        assertEquals("B", refinedSoundex.soundex("BBB"));
    }

    @Test
    void testSoundexWithMixedLetters() {
        assertEquals("A530", refinedSoundex.soundex("Aash530"));
        assertEquals("B650", refinedSoundex.soundex("Bash650"));
    }

    @Test
    void testSoundexWithSpecialCharacters() {
        assertEquals("A", refinedSoundex.soundex("A@#$%^&*()"));
        assertEquals("B", refinedSoundex.soundex("B!@#$%^"));
    }

    @Test
    void testSoundexWithNumbers() {
        assertEquals("A", refinedSoundex.soundex("A123"));
        assertEquals("B", refinedSoundex.soundex("B456"));
    }

    @Test
    void testSoundexWithUpperAndLowerCase() {
        assertEquals("A530", refinedSoundex.soundex("aAsH530"));
        assertEquals("B650", refinedSoundex.soundex("bAsH650"));
    }

    @Test
    void testSoundexWithAllLetters() {
        assertEquals("A", refinedSoundex.soundex("A"));
        assertEquals("B", refinedSoundex.soundex("B"));
        assertEquals("C", refinedSoundex.soundex("C"));
        assertEquals("D", refinedSoundex.soundex("D"));
        assertEquals("E", refinedSoundex.soundex("E"));
        assertEquals("F", refinedSoundex.soundex("F"));
        assertEquals("G", refinedSoundex.soundex("G"));
        assertEquals("H", refinedSoundex.soundex("H"));
        assertEquals("I", refinedSoundex.soundex("I"));
        assertEquals("J", refinedSoundex.soundex("J"));
        assertEquals("K", refinedSoundex.soundex("K"));
        assertEquals("L", refinedSoundex.soundex("L"));
        assertEquals("M", refinedSoundex.soundex("M"));
        assertEquals("N", refinedSoundex.soundex("N"));
        assertEquals("O", refinedSoundex.soundex("O"));
        assertEquals("P", refinedSoundex.soundex("P"));
        assertEquals("Q", refinedSoundex.soundex("Q"));
        assertEquals("R", refinedSoundex.soundex("R"));
        assertEquals("S", refinedSoundex.soundex("S"));
        assertEquals("T", refinedSoundex.soundex("T"));
        assertEquals("U", refinedSoundex.soundex("U"));
        assertEquals("V", refinedSoundex.soundex("V"));
        assertEquals("W", refinedSoundex.soundex("W"));
        assertEquals("X", refinedSoundex.soundex("X"));
        assertEquals("Y", refinedSoundex.soundex("Y"));
        assertEquals("Z", refinedSoundex.soundex("Z"));
    }
}
