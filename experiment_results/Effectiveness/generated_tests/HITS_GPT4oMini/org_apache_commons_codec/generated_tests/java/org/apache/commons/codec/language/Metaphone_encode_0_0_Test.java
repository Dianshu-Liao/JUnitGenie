package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.StringEncoder;

public class Metaphone_encode_0_0_Test {

    private final Metaphone metaphone = new Metaphone();

    @Test
    public void testEncode_WithValidString() throws EncoderException {
        assertEquals("M", metaphone.encode("Mike"));
        assertEquals("N", metaphone.encode("Nancy"));
        assertEquals("S", metaphone.encode("Smith"));
        assertEquals("K", metaphone.encode("Klein"));
        assertEquals("J", metaphone.encode("John"));
    }

    @Test
    public void testEncode_WithEmptyString() throws EncoderException {
        assertEquals("", metaphone.encode(""));
    }

    @Test
    public void testEncode_WithNull() {
        assertThrows(EncoderException.class, () -> metaphone.encode(null));
    }

    @Test
    public void testEncode_WithSingleCharacter() throws EncoderException {
        assertEquals("A", metaphone.encode("A"));
        assertEquals("B", metaphone.encode("B"));
        assertEquals("C", metaphone.encode("C"));
        assertEquals("D", metaphone.encode("D"));
        assertEquals("E", metaphone.encode("E"));
    }

    @Test
    public void testEncode_WithNonStringObject() {
        assertThrows(EncoderException.class, () -> metaphone.encode(123));
        assertThrows(EncoderException.class, () -> metaphone.encode(new Object()));
    }

    @Test
    public void testEncode_WithVowelHandling() throws EncoderException {
        assertEquals("A", metaphone.encode("Avery"));
        assertEquals("E", metaphone.encode("Eve"));
        assertEquals("I", metaphone.encode("Ivy"));
        assertEquals("O", metaphone.encode("Owen"));
        assertEquals("U", metaphone.encode("Ulysses"));
    }

    @Test
    public void testEncode_WithSilentLetters() throws EncoderException {
        assertEquals("N", metaphone.encode("Klein"));
        assertEquals("S", metaphone.encode("Schmidt"));
        assertEquals("F", metaphone.encode("Phantom"));
        assertEquals("K", metaphone.encode("Knock"));
    }

    @Test
    public void testEncode_WithMaxCodeLength() throws EncoderException {
        metaphone.setMaxCodeLen(4);
        assertEquals("S", metaphone.encode("Smith"));
        assertEquals("K", metaphone.encode("Klein"));
        assertEquals("M", metaphone.encode("Mike"));
        assertEquals("N", metaphone.encode("Nancy"));
    }

    @Test
    public void testEncode_WithLongString() throws EncoderException {
        metaphone.setMaxCodeLen(4);
        assertEquals("S", metaphone.encode("Smithsonian"));
        assertEquals("K", metaphone.encode("Kleinman"));
        assertEquals("M", metaphone.encode("Mikesh"));
    }
}
