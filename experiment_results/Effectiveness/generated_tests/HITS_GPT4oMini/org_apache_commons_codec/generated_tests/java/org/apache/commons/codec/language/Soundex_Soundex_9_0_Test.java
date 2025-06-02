package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_Soundex_9_0_Test {

    @Test
    public void testSoundexWithValidInput() {
        String input = "Robert";
        // Expected Soundex code for "Robert"
        String expected = "R163";
        String result = Soundex.US_ENGLISH.soundex(input);
        assertEquals(expected, result);
    }

    @Test
    public void testSoundexWithDifferentNames() {
        assertEquals("A263", Soundex.US_ENGLISH.soundex("Alfred"));
        assertEquals("B635", Soundex.US_ENGLISH.soundex("Bobby"));
        assertEquals("C430", Soundex.US_ENGLISH.soundex("Catherine"));
    }

    @Test
    public void testSoundexWithNamesThatHaveSilentLetters() {
        assertEquals("H263", Soundex.US_ENGLISH.soundex("Hannah"));
        assertEquals("J530", Soundex.US_ENGLISH.soundex("John"));
    }

    @Test
    public void testSoundexWithEmptyInput() {
        String input = "";
        // Expected Soundex code for empty input
        String expected = "";
        String result = Soundex.US_ENGLISH.soundex(input);
        assertEquals(expected, result);
    }

    @Test
    public void testSoundexWithSpecialCharacters() {
        assertEquals("M320", Soundex.US_ENGLISH.soundex("M'Kenzie"));
        assertEquals("N320", Soundex.US_ENGLISH.soundex("N'Kosi"));
    }

    @Test
    public void testSoundexWithSingleCharacter() {
        assertEquals("A000", Soundex.US_ENGLISH.soundex("A"));
        assertEquals("B000", Soundex.US_ENGLISH.soundex("B"));
    }
}
