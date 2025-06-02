package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class BinaryCodec_toAsciiChars_4_0_Test {

    @Test
    public void testToAsciiChars_EmptyInput() {
        byte[] input = {};
        char[] expected = {};
        char[] result = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiChars_SingleByteZero() {
        byte[] input = { 0x00 };
        char[] expected = "00000000".toCharArray();
        char[] result = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiChars_SingleByteMax() {
        // Fixed the buggy line by casting to byte
        byte[] input = { (byte) 0xFF };
        char[] expected = "11111111".toCharArray();
        char[] result = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiChars_MultipleBytes() {
        // Ensure proper casting
        byte[] input = { 0x0F, (byte) 0xF0 };
        char[] expected = "0000111111110000".toCharArray();
        char[] result = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiChars_NegativeByte() {
        byte[] input = { -1 };
        char[] expected = "11111111".toCharArray();
        char[] result = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, result);
    }
}
