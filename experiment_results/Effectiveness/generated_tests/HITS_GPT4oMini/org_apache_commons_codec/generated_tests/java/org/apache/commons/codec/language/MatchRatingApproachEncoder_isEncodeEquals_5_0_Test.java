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

public class MatchRatingApproachEncoder_isEncodeEquals_5_0_Test {

    private MatchRatingApproachEncoder encoder;

    @BeforeEach
    public void setUp() {
        encoder = new MatchRatingApproachEncoder();
    }

    @Test
    public void testIsEncodeEquals_NullInput1() {
        assertFalse(encoder.isEncodeEquals(null, "John"));
    }

    @Test
    public void testIsEncodeEquals_NullInput2() {
        assertFalse(encoder.isEncodeEquals("John", null));
    }

    @Test
    public void testIsEncodeEquals_EmptyInput1() {
        assertFalse(encoder.isEncodeEquals("", "John"));
    }

    @Test
    public void testIsEncodeEquals_EmptyInput2() {
        assertFalse(encoder.isEncodeEquals("John", ""));
    }

    @Test
    public void testIsEncodeEquals_SpaceInput1() {
        assertFalse(encoder.isEncodeEquals(" ", "John"));
    }

    @Test
    public void testIsEncodeEquals_SpaceInput2() {
        assertFalse(encoder.isEncodeEquals("John", " "));
    }

    @Test
    public void testIsEncodeEquals_SingleCharacterInput1() {
        assertFalse(encoder.isEncodeEquals("A", "B"));
    }

    @Test
    public void testIsEncodeEquals_SingleCharacterInput2() {
        assertFalse(encoder.isEncodeEquals("B", "A"));
    }

    @Test
    public void testIsEncodeEquals_SameNames() {
        assertTrue(encoder.isEncodeEquals("John", "John"));
    }

    @Test
    public void testIsEncodeEquals_DifferentNames() {
        assertFalse(encoder.isEncodeEquals("John", "Doe"));
    }

    @Test
    public void testIsEncodeEquals_SimilarNames() {
        assertTrue(encoder.isEncodeEquals("Jon", "John"));
    }

    @Test
    public void testIsEncodeEquals_DoubleConsonants() {
        assertTrue(encoder.isEncodeEquals("Smith", "Smyth"));
    }

    @Test
    public void testIsEncodeEquals_VowelRemoval() {
        assertTrue(encoder.isEncodeEquals("Alice", "Alic"));
    }

    @Test
    public void testIsEncodeEquals_LengthDifference() {
        assertFalse(encoder.isEncodeEquals("John", "Johny"));
    }

    @Test
    public void testIsEncodeEquals_SimilarAccents() {
        assertTrue(encoder.isEncodeEquals("Café", "Cafe"));
    }

    @Test
    public void testIsEncodeEquals_VaryingCases() {
        assertTrue(encoder.isEncodeEquals("john", "JOHN"));
    }

    @Test
    public void testIsEncodeEquals_SpecialCharacters() {
        assertTrue(encoder.isEncodeEquals("O'Connor", "OConnor"));
    }

    @Test
    public void testIsEncodeEquals_NonMatchingLength() {
        assertFalse(encoder.isEncodeEquals("abcdefg", "abc"));
    }
}
