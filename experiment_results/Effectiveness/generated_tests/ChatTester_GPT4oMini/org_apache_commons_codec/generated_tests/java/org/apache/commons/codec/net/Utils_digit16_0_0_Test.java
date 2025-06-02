package org.apache.commons.codec.net;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.DecoderException;

class Utils_digit16_0_0_Test {

    @Test
    void testDigit16_ValidHexDigitLowercase() throws DecoderException {
        assertEquals(10, Utils.digit16((byte) 'a'));
        assertEquals(11, Utils.digit16((byte) 'b'));
        assertEquals(12, Utils.digit16((byte) 'c'));
        assertEquals(13, Utils.digit16((byte) 'd'));
        assertEquals(14, Utils.digit16((byte) 'e'));
        assertEquals(15, Utils.digit16((byte) 'f'));
    }

    @Test
    void testDigit16_ValidHexDigitUppercase() throws DecoderException {
        assertEquals(10, Utils.digit16((byte) 'A'));
        assertEquals(11, Utils.digit16((byte) 'B'));
        assertEquals(12, Utils.digit16((byte) 'C'));
        assertEquals(13, Utils.digit16((byte) 'D'));
        assertEquals(14, Utils.digit16((byte) 'E'));
        assertEquals(15, Utils.digit16((byte) 'F'));
    }

    @Test
    void testDigit16_ValidHexDigitNumeric() throws DecoderException {
        assertEquals(0, Utils.digit16((byte) '0'));
        assertEquals(1, Utils.digit16((byte) '1'));
        assertEquals(2, Utils.digit16((byte) '2'));
        assertEquals(3, Utils.digit16((byte) '3'));
        assertEquals(4, Utils.digit16((byte) '4'));
        assertEquals(5, Utils.digit16((byte) '5'));
        assertEquals(6, Utils.digit16((byte) '6'));
        assertEquals(7, Utils.digit16((byte) '7'));
        assertEquals(8, Utils.digit16((byte) '8'));
        assertEquals(9, Utils.digit16((byte) '9'));
    }

    @Test
    void testDigit16_InvalidHexDigit() {
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'g'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'G'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'z'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'Z'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) '!'));
        // Out of valid range
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 128));
    }

    @Test
    void testDigit16_InvalidByte() {
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) -1));
    }
}
