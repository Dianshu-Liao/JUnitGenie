package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.StringEncoder;

class Soundex_Soundex_8_0_Test {

    private final Soundex soundex = new Soundex();

    @Test
    void testSoundexWithNull() {
        assertNull(soundex.soundex(null));
    }

    @Test
    void testSoundexWithEmptyString() {
        assertEquals("", soundex.soundex(""));
    }

    @Test
    void testSoundexWithSingleCharacter() {
        assertEquals("A000", soundex.soundex("A"));
        assertEquals("B000", soundex.soundex("B"));
        assertEquals("C000", soundex.soundex("C"));
    }

    @Test
    void testSoundexWithRepeatedCharacters() {
        assertEquals("A000", soundex.soundex("AA"));
        assertEquals("A000", soundex.soundex("AAA"));
    }

    @Test
    void testSoundexWithSpecialCaseHW() {
        assertEquals("A000", soundex.soundex("AH"));
        assertEquals("A000", soundex.soundex("AW"));
        assertEquals("B000", soundex.soundex("BHW"));
    }

    @Test
    void testSoundexWithVowels() {
        assertEquals("A000", soundex.soundex("AIEOU"));
        assertEquals("B000", soundex.soundex("BIEOU"));
    }

    @Test
    void testSoundexWithDifferentLetters() {
        assertEquals("A530", soundex.soundex("Ashcraft"));
        assertEquals("A263", soundex.soundex("Atchison"));
        assertEquals("B430", soundex.soundex("Baird"));
    }

    @Test
    void testSoundexWithSilentMarker() {
        assertEquals("A000", soundex.soundex("A-B"));
        assertEquals("B000", soundex.soundex("B--C"));
    }

    @Test
    void testSoundexWithNonAlphabeticCharacters() {
        assertEquals("A000", soundex.soundex("A1234"));
        assertEquals("B000", soundex.soundex("B@#$%"));
    }

    @Test
    void testSoundexWithLongString() {
        assertEquals("A263", soundex.soundex("Atchison"));
        assertEquals("A260", soundex.soundex("Atchison123"));
    }

    @Test
    void testSoundexWithDifferentMappings() {
        Soundex customSoundex = new Soundex(new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' });
        assertEquals("A000", customSoundex.soundex("A"));
    }

    @Test
    void testSoundexWithInvalidCharacter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            soundex.soundex("Z!");
        });
        assertEquals("The character is not mapped: Z (index=25)", exception.getMessage());
    }
}
