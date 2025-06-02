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

public class BinaryCodec_fromAscii_0_0_Test {

    @Test
    public void testFromAscii_EmptyArray() {
        byte[] input = {};
        byte[] expected = {};
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFromAscii_NullArray() {
        byte[] input = null;
        byte[] expected = {};
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFromAscii_SingleByte() {
        // 0 in binary
        byte[] input = { '0', '0', '0', '0', '0', '0', '0', '0' };
        byte[] expected = { 0 };
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFromAscii_OneByteInput() {
        // 255 in binary
        byte[] input = { '1', '1', '1', '1', '1', '1', '1', '1' };
        // 255 as signed byte
        byte[] expected = { -1 };
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFromAscii_TwoBytesInput() {
        byte[] input = { // 170 in binary
        // 170 in binary
        '1', // 170 in binary
        '0', // 170 in binary
        '1', // 170 in binary
        '0', // 170 in binary
        '1', // 170 in binary
        '0', // 255 in binary
        '1', // 255 in binary
        '0', // 255 in binary
        '1', // 255 in binary
        '1', // 255 in binary
        '1', // 255 in binary
        '1', // 255 in binary
        '1', // 255 in binary
        '1', '1', '1' };
        // 170 as signed byte, 255 as signed byte
        byte[] expected = { -86, -1 };
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFromAscii_ComplexInput() {
        byte[] input = { // 0xB2
        // 0xB2
        '1', // 0xB2
        '0', // 0xB2
        '1', // 0xB2
        '1', // 0xB2
        '0', // 0xB2
        '1', // 0xBA
        '0', // 0xBA
        '1', // 0xBA
        '1', // 0xBA
        '0', // 0xBA
        '1', // 0xBA
        '1', // 0xBA
        '1', // 0xBA
        '1', '1', '0' };
        // -75 (0xB2), -86 (0xBA)
        byte[] expected = { -75, -86 };
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual);
    }
}
