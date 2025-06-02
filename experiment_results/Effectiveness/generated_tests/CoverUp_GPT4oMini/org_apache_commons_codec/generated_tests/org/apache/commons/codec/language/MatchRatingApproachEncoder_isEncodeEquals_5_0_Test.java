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
    public void testIsEncodeEquals_NullInput() {
        assertFalse(encoder.isEncodeEquals(null, null));
        assertFalse(encoder.isEncodeEquals("John", null));
        assertFalse(encoder.isEncodeEquals(null, "Doe"));
    }

    @Test
    public void testIsEncodeEquals_EmptyInput() {
        assertFalse(encoder.isEncodeEquals("", ""));
        assertFalse(encoder.isEncodeEquals("John", ""));
        assertFalse(encoder.isEncodeEquals("", "Doe"));
        assertFalse(encoder.isEncodeEquals(" ", "Doe"));
        assertFalse(encoder.isEncodeEquals("John", " "));
    }

    @Test
    public void testIsEncodeEquals_SingleCharacterInput() {
        assertFalse(encoder.isEncodeEquals("J", "Doe"));
        assertFalse(encoder.isEncodeEquals("John", "D"));
    }

    @Test
    public void testIsEncodeEquals_IdenticalNames() {
        assertTrue(encoder.isEncodeEquals("John", "John"));
        assertTrue(encoder.isEncodeEquals("Doe", "Doe"));
    }

    @Test
    public void testIsEncodeEquals_SimilarNames() {
        assertTrue(encoder.isEncodeEquals("Johnathan", "Jonathon"));
        assertTrue(encoder.isEncodeEquals("Katherine", "Catherine"));
    }

    @Test
    public void testIsEncodeEquals_DissimilarNames() {
        assertFalse(encoder.isEncodeEquals("John", "Doe"));
        assertFalse(encoder.isEncodeEquals("Alice", "Bob"));
    }

    @Test
    public void testIsEncodeEquals_DifferentLengths() {
        assertFalse(encoder.isEncodeEquals("Jonathan", "John"));
        assertFalse(encoder.isEncodeEquals("Alexandra", "Alex"));
    }

    @Test
    public void testIsEncodeEquals_VowelRemoval() {
        assertTrue(encoder.isEncodeEquals("Avery", "Avry"));
        assertTrue(encoder.isEncodeEquals("Eleanor", "Elanor"));
    }

    @Test
    public void testIsEncodeEquals_DoubleConsonantRemoval() {
        assertTrue(encoder.isEncodeEquals("Bobby", "Boby"));
        assertTrue(encoder.isEncodeEquals("Silly", "Sily"));
    }

    @Test
    public void testIsEncodeEquals_LengthDifference() {
        assertFalse(encoder.isEncodeEquals("John", "Johny"));
        assertFalse(encoder.isEncodeEquals("Katherine", "Katy"));
    }

    @Test
    public void testIsEncodeEquals_MinimumRating() {
        // Single character
        assertTrue(encoder.isEncodeEquals("A", "A"));
        // Different characters
        assertFalse(encoder.isEncodeEquals("A", "B"));
        // Same characters
        assertTrue(encoder.isEncodeEquals("AA", "AA"));
    }
}
