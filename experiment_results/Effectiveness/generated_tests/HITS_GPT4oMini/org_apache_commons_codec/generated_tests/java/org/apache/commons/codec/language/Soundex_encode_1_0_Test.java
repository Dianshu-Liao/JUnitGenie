package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_encode_1_0_Test {

    private final Soundex soundex = new Soundex();

    @Test
    public void testEncodeValidString() throws EncoderException {
        assertEquals("A530", soundex.encode("Ashcraft"));
        assertEquals("H630", soundex.encode("Honeyman"));
        assertEquals("C040", soundex.encode("Catherine"));
        assertEquals("S532", soundex.encode("Smith"));
    }

    @Test
    public void testEncodeEmptyString() throws EncoderException {
        assertEquals("", soundex.encode(""));
    }

    @Test
    public void testEncodeNull() {
        assertThrows(EncoderException.class, () -> soundex.encode(null));
    }

    @Test
    public void testEncodeNonStringObject() {
        assertThrows(EncoderException.class, () -> soundex.encode(123));
        assertThrows(EncoderException.class, () -> soundex.encode(new Object()));
    }

    @Test
    public void testEncodeSingleCharacter() throws EncoderException {
        assertEquals("A000", soundex.encode("A"));
        assertEquals("B000", soundex.encode("B"));
        assertEquals("C000", soundex.encode("C"));
    }

    @Test
    public void testEncodeSpecialCharacters() throws EncoderException {
        assertEquals("A000", soundex.encode("A@!#"));
        assertEquals("B000", soundex.encode("B$%^"));
    }

    @Test
    public void testEncodeWithHW() throws EncoderException {
        assertEquals("H000", soundex.encode("H"));
        assertEquals("W000", soundex.encode("W"));
        // H and W should be ignored
        assertEquals("A530", soundex.encode("Ashcraft"));
    }
}
