// Replace with the actual package name if different
package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;

public class Hex_toDigit_18_0_Test {

    @Test
    public void testToDigit_ValidLowerCaseHex() throws DecoderException {
        assertEquals(10, Hex.toDigit('a', 0));
        assertEquals(15, Hex.toDigit('f', 1));
        assertEquals(0, Hex.toDigit('0', 2));
        assertEquals(5, Hex.toDigit('5', 3));
    }

    @Test
    public void testToDigit_ValidUpperCaseHex() throws DecoderException {
        assertEquals(10, Hex.toDigit('A', 0));
        assertEquals(15, Hex.toDigit('F', 1));
        assertEquals(0, Hex.toDigit('0', 2));
        assertEquals(5, Hex.toDigit('5', 3));
    }

    @Test
    public void testToDigit_InvalidHexCharacter() {
        DecoderException exception = assertThrows(DecoderException.class, () -> {
            Hex.toDigit('g', 0);
        });
        assertEquals("Illegal hexadecimal character g at index 0", exception.getMessage());
    }

    @Test
    public void testToDigit_InvalidHexCharacter_AnotherExample() {
        DecoderException exception = assertThrows(DecoderException.class, () -> {
            Hex.toDigit('!', 0);
        });
        assertEquals("Illegal hexadecimal character ! at index 0", exception.getMessage());
    }

    @Test
    public void testToDigit_NegativeIndex() throws DecoderException {
        assertEquals(1, Hex.toDigit('1', -1));
    }
}
