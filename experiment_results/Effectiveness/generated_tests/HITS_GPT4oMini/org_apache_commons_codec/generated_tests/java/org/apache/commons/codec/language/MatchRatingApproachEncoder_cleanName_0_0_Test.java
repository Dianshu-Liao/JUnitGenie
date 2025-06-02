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

public class MatchRatingApproachEncoder_cleanName_0_0_Test {

    private final MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

    @Test
    public void testCleanName_WithSpaces() {
        String input = " John Doe ";
        String expected = "JOHNDOE";
        assertEquals(expected, encoder.cleanName(input));
    }

    @Test
    public void testCleanName_WithSpecialCharacters() {
        String input = "J@ne-Doe!";
        String expected = "JANEDOE";
        assertEquals(expected, encoder.cleanName(input));
    }

    @Test
    public void testCleanName_WithAccents() {
        String input = "José García";
        String expected = "JOSEGARCIA";
        assertEquals(expected, encoder.cleanName(input));
    }

    @Test
    public void testCleanName_WithDoubleConsonants() {
        String input = "Bobby";
        String expected = "BOBY";
        assertEquals(expected, encoder.cleanName(input));
    }

    @Test
    public void testCleanName_WithEmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, encoder.cleanName(input));
    }

    @Test
    public void testCleanName_WithNullInput() {
        String input = null;
        String expected = null;
        assertEquals(expected, encoder.cleanName(input));
    }

    @Test
    public void testCleanName_WithMultipleSpaces() {
        String input = "   Alice   Smith   ";
        String expected = "ALICESMITH";
        assertEquals(expected, encoder.cleanName(input));
    }

    @Test
    public void testCleanName_WithPunctuation() {
        String input = "O'Connor";
        String expected = "OCONNOR";
        assertEquals(expected, encoder.cleanName(input));
    }

    @Test
    public void testCleanName_WithMixedCharacters() {
        String input = "Müller-Ann!";
        String expected = "MUELLERANN";
        assertEquals(expected, encoder.cleanName(input));
    }
}
