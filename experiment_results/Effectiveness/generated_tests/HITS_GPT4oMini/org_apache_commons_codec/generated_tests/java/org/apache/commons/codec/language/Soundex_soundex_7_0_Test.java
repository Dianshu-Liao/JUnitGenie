package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_soundex_7_0_Test {

    @Test
    public void testSoundexWithNull() {
        assertNull(Soundex.US_ENGLISH.soundex(null), "Soundex of null should be null");
    }

    @Test
    public void testSoundexWithEmptyString() {
        assertEquals("", Soundex.US_ENGLISH.soundex(""), "Soundex of an empty string should be empty");
    }

    @Test
    public void testSoundexWithSingleCharacter() {
        assertEquals("A000", Soundex.US_ENGLISH.soundex("A"), "Soundex of 'A' should be 'A000'");
        assertEquals("B000", Soundex.US_ENGLISH.soundex("B"), "Soundex of 'B' should be 'B000'");
    }

    @Test
    public void testSoundexWithMixedCharacters() {
        assertEquals("A543", Soundex.US_ENGLISH.soundex("Ashcraft"), "Soundex of 'Ashcraft' should be 'A543'");
        assertEquals("C500", Soundex.US_ENGLISH.soundex("Catherine"), "Soundex of 'Catherine' should be 'C500'");
        assertEquals("M430", Soundex.US_ENGLISH.soundex("Miller"), "Soundex of 'Miller' should be 'M430'");
        assertEquals("N320", Soundex.US_ENGLISH.soundex("Nash"), "Soundex of 'Nash' should be 'N320'");
    }

    @Test
    public void testSoundexWithSpecialCharacters() {
        assertEquals("B000", Soundex.US_ENGLISH.soundex("B@#"), "Soundex of 'B@#' should be 'B000'");
        assertEquals("A000", Soundex.US_ENGLISH.soundex("A!"), "Soundex of 'A!' should be 'A000'");
    }

    @Test
    public void testSoundexWithSilentCharacters() {
        assertEquals("H000", Soundex.US_ENGLISH.soundex("Hannah"), "Soundex of 'Hannah' should be 'H000'");
        assertEquals("S000", Soundex.US_ENGLISH.soundex("Samantha"), "Soundex of 'Samantha' should be 'S000'");
    }

    @Test
    public void testSoundexWithRepeatedCharacters() {
        assertEquals("T530", Soundex.US_ENGLISH.soundex("Tee"), "Soundex of 'Tee' should be 'T530'");
        assertEquals("L000", Soundex.US_ENGLISH.soundex("Lee"), "Soundex of 'Lee' should be 'L000'");
    }

    @Test
    public void testSoundexWithAllLetters() {
        assertEquals("C000", Soundex.US_ENGLISH.soundex("C"), "Soundex of 'C' should be 'C000'");
        assertEquals("B000", Soundex.US_ENGLISH.soundex("B"), "Soundex of 'B' should be 'B000'");
        assertEquals("A000", Soundex.US_ENGLISH.soundex("A"), "Soundex of 'A' should be 'A000'");
    }
}
