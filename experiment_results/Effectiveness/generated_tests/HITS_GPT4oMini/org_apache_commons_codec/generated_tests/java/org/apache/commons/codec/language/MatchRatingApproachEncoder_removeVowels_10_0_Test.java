package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

class MatchRatingApproachEncoder_removeVowels_10_0_Test {

    private final MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

    @Test
    void testRemoveVowels_WithVowels() {
        assertEquals("Hll", encoder.removeVowels("Hello"));
        assertEquals("Wrl", encoder.removeVowels("World"));
        assertEquals("Ths s", encoder.removeVowels("This is"));
        assertEquals("N", encoder.removeVowels("An"));
    }

    @Test
    void testRemoveVowels_WithoutVowels() {
        assertEquals("H", encoder.removeVowels("H"));
        assertEquals("W", encoder.removeVowels("W"));
        assertEquals("Th", encoder.removeVowels("Th"));
    }

    @Test
    void testRemoveVowels_EmptyString() {
        assertEquals("", encoder.removeVowels(""));
    }

    @Test
    void testRemoveVowels_SingleVowel() {
        assertEquals("", encoder.removeVowels("A"));
        assertEquals("", encoder.removeVowels("E"));
        assertEquals("", encoder.removeVowels("I"));
        assertEquals("", encoder.removeVowels("O"));
        assertEquals("", encoder.removeVowels("U"));
    }

    @Test
    void testRemoveVowels_FirstLetterIsVowel() {
        assertEquals("A", encoder.removeVowels("Apple"));
        assertEquals("E", encoder.removeVowels("Eagle"));
        assertEquals("I", encoder.removeVowels("Ice"));
    }

    @Test
    void testRemoveVowels_FirstLetterIsNotVowel() {
        assertEquals("B", encoder.removeVowels("Banana"));
        assertEquals("C", encoder.removeVowels("Cucumber"));
        assertEquals("D", encoder.removeVowels("Date"));
    }

    @Test
    void testRemoveVowels_ConsecutiveSpaces() {
        assertEquals("Hll Wrl", encoder.removeVowels("Hello  World"));
        assertEquals("Ths s", encoder.removeVowels("This   is"));
    }
}
