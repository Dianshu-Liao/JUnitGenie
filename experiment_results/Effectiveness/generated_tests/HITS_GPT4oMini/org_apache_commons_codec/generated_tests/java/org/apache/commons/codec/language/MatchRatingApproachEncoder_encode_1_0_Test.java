package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.codec.StringEncoder;

public class MatchRatingApproachEncoder_encode_1_0_Test {

    private final MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

    @Test
    public void testEncode_NullInput() {
        assertEquals("", encoder.encode(null));
    }

    @Test
    public void testEncode_EmptyStringInput() {
        assertEquals("", encoder.encode(""));
    }

    @Test
    public void testEncode_SingleCharacterInput() {
        assertEquals("", encoder.encode("A"));
    }

    @Test
    public void testEncode_SpaceInput() {
        assertEquals("", encoder.encode(" "));
    }

    @Test
    public void testEncode_SimpleName() {
        assertEquals("JHN", encoder.encode("John"));
    }

    @Test
    public void testEncode_NameWithVowels() {
        assertEquals("JHN", encoder.encode("Joanne"));
    }

    @Test
    public void testEncode_DoubleConsonants() {
        assertEquals("KNG", encoder.encode("King"));
    }

    @Test
    public void testEncode_NameWithSpecialCharacters() {
        assertEquals("MRT", encoder.encode("Märt"));
    }

    @Test
    public void testEncode_NameWithMixedCase() {
        assertEquals("SMTH", encoder.encode("sMiTh"));
    }

    @Test
    public void testEncode_NonStringInput() {
        assertThrows(EncoderException.class, () -> encoder.encode(123));
    }

    @Test
    public void testEncode_SpecialUnicodeCharacters() {
        assertEquals("SNG", encoder.encode("Söng"));
    }

    @Test
    public void testEncode_LeadingVowel() {
        assertEquals("MRT", encoder.encode("Amit"));
    }

    @Test
    public void testEncode_ComplexName() {
        assertEquals("JHN", encoder.encode("Johnathan"));
    }
}
