// Replace with the actual package name where Utils class is located
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
        // Testing valid hexadecimal digits
        assertEquals(0, Utils.digit16((byte) '0'));
        assertEquals(1, Utils.digit16((byte) '1'));
        assertEquals(10, Utils.digit16((byte) 'A'));
        assertEquals(11, Utils.digit16((byte) 'B'));
        assertEquals(15, Utils.digit16((byte) 'F'));
    }

    @Test
    void testDigit16_InvalidHexDigit() {
        // Testing invalid hexadecimal digits
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'G'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'H'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'I'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'J'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'K'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'L'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'M'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'N'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'O'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'P'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'Q'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'R'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'S'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'T'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'U'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'V'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'W'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'X'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'Y'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'Z'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'a'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'b'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'c'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'd'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'e'));
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) 'f'));
        // space
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) ' '));
        // special character
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) '!'));
        // negative byte
        assertThrows(DecoderException.class, () -> Utils.digit16((byte) -1));
    }
}
