package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class RefinedSoundex_encode_1_0_Test {

    private final RefinedSoundex refinedSoundex = RefinedSoundex.US_ENGLISH;

    @Test
    public void testEncodeWithValidString() throws EncoderException {
        String input = "Robert";
        // Example expected output based on the soundex algorithm
        String expected = "R163";
        assertEquals(expected, refinedSoundex.encode(input));
    }

    @Test
    public void testEncodeWithEmptyString() throws EncoderException {
        String input = "";
        // Expected output for an empty string
        String expected = "";
        assertEquals(expected, refinedSoundex.encode(input));
    }

    @Test
    public void testEncodeWithNull() throws EncoderException {
        String input = null;
        // Expected output for null input
        assertNull(refinedSoundex.encode(input));
    }

    @Test
    public void testEncodeWithNonStringObject() {
        Integer input = 123;
        Exception exception = assertThrows(EncoderException.class, () -> {
            refinedSoundex.encode(input);
        });
        assertEquals("Parameter supplied to RefinedSoundex encode is not of type java.lang.String", exception.getMessage());
    }

    @Test
    public void testEncodeWithSingleCharacter() throws EncoderException {
        String input = "A";
        // Expected output for single character
        String expected = "A";
        assertEquals(expected, refinedSoundex.encode(input));
    }

    @Test
    public void testEncodeWithRepeatedCharacters() throws EncoderException {
        String input = "Bobby";
        // Example expected output based on the soundex algorithm
        String expected = "B100";
        assertEquals(expected, refinedSoundex.encode(input));
    }

    @Test
    public void testEncodeWithDifferentCases() throws EncoderException {
        String input = "robert";
        // Soundex should be case insensitive
        String expected = "R163";
        assertEquals(expected, refinedSoundex.encode(input));
    }

    @Test
    public void testEncodeWithNumbersInString() throws EncoderException {
        String input = "Robert123";
        // Soundex ignores numbers, expected output based on the soundex algorithm
        String expected = "R163";
        assertEquals(expected, refinedSoundex.encode(input));
    }
}
