package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Soundex;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.StringEncoder;

class Soundex_encode_1_0_Test {

    private final Soundex soundex = new Soundex();

    @Test
    void testEncodeWithValidString() throws EncoderException {
        String input = "Robert";
        // Example expected output for "Robert"
        String expected = "R163";
        String actual = (String) soundex.encode(input);
        assertEquals(expected, actual);
    }

    @Test
    void testEncodeWithNull() {
        assertThrows(EncoderException.class, () -> soundex.encode(null));
    }

    @Test
    void testEncodeWithNonStringObject() {
        assertThrows(EncoderException.class, () -> soundex.encode(123));
        assertThrows(EncoderException.class, () -> soundex.encode(new Object()));
        assertThrows(EncoderException.class, () -> soundex.encode(new StringBuilder("Test")));
    }

    @Test
    void testEncodeWithEmptyString() throws EncoderException {
        String input = "";
        // Assuming the expected output for an empty string is an empty string
        String expected = "";
        String actual = (String) soundex.encode(input);
        assertEquals(expected, actual);
    }

    @Test
    void testEncodeWithSpecialCharacters() throws EncoderException {
        String input = "O'Connor";
        // Example expected output for "O'Connor"
        String expected = "O256";
        String actual = (String) soundex.encode(input);
        assertEquals(expected, actual);
    }

    @Test
    void testEncodeWithHWCharacters() throws EncoderException {
        String input = "Hannah";
        // Example expected output for "Hannah"
        String expected = "H500";
        String actual = (String) soundex.encode(input);
        assertEquals(expected, actual);
    }
}
