package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class RefinedSoundex_soundex_4_0_Test {

    private RefinedSoundex refinedSoundex;

    @BeforeEach
    public void setUp() {
        refinedSoundex = RefinedSoundex.US_ENGLISH;
    }

    @Test
    public void testSoundexWithNullInput() {
        assertNull(refinedSoundex.soundex(null));
    }

    @Test
    public void testSoundexWithEmptyString() {
        assertEquals("", refinedSoundex.soundex(""));
    }

    @Test
    public void testSoundexWithNoMatchingCharacters() {
        assertEquals("A", refinedSoundex.soundex("A"));
        assertEquals("B", refinedSoundex.soundex("B"));
        assertEquals("C", refinedSoundex.soundex("C"));
    }

    @Test
    public void testSoundexWithSingleCharacter() {
        assertEquals("A", refinedSoundex.soundex("A"));
        assertEquals("B", refinedSoundex.soundex("B"));
        assertEquals("C", refinedSoundex.soundex("C"));
    }

    @Test
    public void testSoundexWithMultipleCharacters() {
        assertEquals("A530", refinedSoundex.soundex("Ashcraft"));
        assertEquals("H652", refinedSoundex.soundex("Honeyman"));
        assertEquals("T252", refinedSoundex.soundex("Tymczak"));
    }

    @Test
    public void testSoundexWithConsecutiveCharacters() {
        assertEquals("B530", refinedSoundex.soundex("Bashcraft"));
        assertEquals("T254", refinedSoundex.soundex("Tymczak"));
    }

    @Test
    public void testSoundexWithMixedCase() {
        assertEquals("A530", refinedSoundex.soundex("ashcraft"));
        assertEquals("H652", refinedSoundex.soundex("HONEYMAN"));
    }

    @Test
    public void testSoundexWithSpecialCharacters() {
        assertEquals("A530", refinedSoundex.soundex("Ashcraft!"));
        assertEquals("H652", refinedSoundex.soundex("Honeyman#"));
    }

    @Test
    public void testSoundexWithDigits() {
        assertEquals("A530", refinedSoundex.soundex("A1shcraft"));
        assertEquals("H652", refinedSoundex.soundex("H2oneyman"));
    }

    @Test
    public void testSoundexWithLeadingAndTrailingSpaces() {
        assertEquals("A530", refinedSoundex.soundex("  Ashcraft  "));
        assertEquals("H652", refinedSoundex.soundex("  Honeyman "));
    }
}
