package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

final class Utils_digit16_0_0_Test {

    @Test
    void testDigit16_ValidHexDigit() throws DecoderException {
        // Test valid hex digits
        // 'A' -> 10
        assertEquals(10, Utils.digit16((byte) 'A'));
        // 'B' -> 11
        assertEquals(11, Utils.digit16((byte) 'B'));
        // 'C' -> 12
        assertEquals(12, Utils.digit16((byte) 'C'));
        // 'D' -> 13
        assertEquals(13, Utils.digit16((byte) 'D'));
        // 'E' -> 14
        assertEquals(14, Utils.digit16((byte) 'E'));
        // 'F' -> 15
        assertEquals(15, Utils.digit16((byte) 'F'));
        // '0' -> 0
        assertEquals(0, Utils.digit16((byte) '0'));
        // '1' -> 1
        assertEquals(1, Utils.digit16((byte) '1'));
        // '2' -> 2
        assertEquals(2, Utils.digit16((byte) '2'));
        // '3' -> 3
        assertEquals(3, Utils.digit16((byte) '3'));
        // '4' -> 4
        assertEquals(4, Utils.digit16((byte) '4'));
        // '5' -> 5
        assertEquals(5, Utils.digit16((byte) '5'));
        // '6' -> 6
        assertEquals(6, Utils.digit16((byte) '6'));
        // '7' -> 7
        assertEquals(7, Utils.digit16((byte) '7'));
        // '8' -> 8
        assertEquals(8, Utils.digit16((byte) '8'));
        // '9' -> 9
        assertEquals(9, Utils.digit16((byte) '9'));
    }

    @Test
    void testDigit16_InvalidHexDigit() {
        // Test invalid hex digits
        assertThrows(DecoderException.class, () -> {
            // 'G' is invalid
            Utils.digit16((byte) 'G');
        });
        assertThrows(DecoderException.class, () -> {
            // 'g' is invalid
            Utils.digit16((byte) 'g');
        });
        assertThrows(DecoderException.class, () -> {
            // 'Z' is invalid
            Utils.digit16((byte) 'Z');
        });
        assertThrows(DecoderException.class, () -> {
            // 'z' is invalid
            Utils.digit16((byte) 'z');
        });
        assertThrows(DecoderException.class, () -> {
            // '!' is invalid
            Utils.digit16((byte) '!');
        });
        assertThrows(DecoderException.class, () -> {
            // space is invalid
            Utils.digit16((byte) ' ');
        });
    }
}
