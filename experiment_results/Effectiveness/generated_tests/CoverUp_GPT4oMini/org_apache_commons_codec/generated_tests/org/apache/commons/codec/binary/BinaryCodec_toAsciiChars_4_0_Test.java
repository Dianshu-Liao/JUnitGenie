package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.BinaryCodec;
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
    public void testToAsciiChars_EmptyArray() {
        byte[] input = {};
        char[] expected = {};
        char[] actual = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiChars_NullArray() {
        byte[] input = null;
        char[] expected = {};
        char[] actual = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiChars_SingleByteZero() {
        byte[] input = { 0x00 };
        char[] expected = { '0', '0', '0', '0', '0', '0', '0', '0' };
        char[] actual = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiChars_SingleByteOne() {
        byte[] input = { 0x01 };
        char[] expected = { '0', '0', '0', '0', '0', '0', '0', '1' };
        char[] actual = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiChars_MultipleBytes() {
        byte[] input = { 0x01, 0x02, 0x03 };
        char[] expected = { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '1', '1' };
        char[] actual = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiChars_FullByte() {
        byte[] input = { (byte) 0xFF };
        char[] expected = { '1', '1', '1', '1', '1', '1', '1', '1' };
        char[] actual = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expected, actual);
    }
}
