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

public class MatchRatingApproachEncoder_encode_2_0_Test {

    private final MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

    @Test
    public void testEncode_NullInput() {
        assertEquals("", encoder.encode(null));
    }

    @Test
    public void testEncode_EmptyString() {
        assertEquals("", encoder.encode(""));
    }

    @Test
    public void testEncode_SingleCharacter() {
        assertEquals("", encoder.encode("A"));
        assertEquals("", encoder.encode("B"));
    }

    @Test
    public void testEncode_Whitespace() {
        assertEquals("", encoder.encode(" "));
        assertEquals("", encoder.encode("   "));
    }

    @Test
    public void testEncode_VowelOnly() {
        assertEquals("A", encoder.encode("A"));
        assertEquals("E", encoder.encode("E"));
        assertEquals("I", encoder.encode("I"));
        assertEquals("O", encoder.encode("O"));
        assertEquals("U", encoder.encode("U"));
    }

    @Test
    public void testEncode_SimpleName() {
        assertEquals("BRT", encoder.encode("Brett"));
        assertEquals("JHN", encoder.encode("John"));
    }

    @Test
    public void testEncode_NameWithVowels() {
        assertEquals("JHN", encoder.encode("Johnathan"));
        assertEquals("CRS", encoder.encode("Carter"));
    }

    @Test
    public void testEncode_DoubleConsonants() {
        assertEquals("SNG", encoder.encode("Singing"));
        assertEquals("BLK", encoder.encode("Balloon"));
    }

    @Test
    public void testEncode_NameWithAccents() {
        assertEquals("CST", encoder.encode("Céline"));
        assertEquals("PST", encoder.encode("Pâté"));
    }

    @Test
    public void testEncode_LongName() {
        assertEquals("JONDOE", encoder.encode("Jonathan Doe"));
        assertEquals("LNDNBRG", encoder.encode("London Bridge"));
    }

    @Test
    public void testEncode_MixedCase() {
        assertEquals("JHN", encoder.encode("jOhN"));
        assertEquals("SMTH", encoder.encode("sMiTh"));
    }

    @Test
    public void testEncode_SpecialCharacters() {
        assertEquals("HLL", encoder.encode("Hello!"));
        assertEquals("WLD", encoder.encode("World."));
    }
}
