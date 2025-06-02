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

public class BinaryCodec_fromAscii_1_0_Test {

    @Test
    public void testFromAscii_NullInput() {
        assertArrayEquals(new byte[] {}, BinaryCodec.fromAscii((char[]) null));
    }

    @Test
    public void testFromAscii_EmptyInput() {
        assertArrayEquals(new byte[] {}, BinaryCodec.fromAscii(new char[] {}));
    }

    @Test
    public void testFromAscii_OneByte() {
        char[] ascii = { '0', '1', '0', '1', '0', '1', '0', '1' };
        // 01010101 in binary
        byte[] expected = { 85 };
        assertArrayEquals(expected, BinaryCodec.fromAscii(ascii));
    }

    @Test
    public void testFromAscii_TwoBytes() {
        char[] ascii = { '1', '1', '1', '1', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0' };
        // 11110000 01010101 in binary
        byte[] expected = { (byte) 240, 85 };
        assertArrayEquals(expected, BinaryCodec.fromAscii(ascii));
    }

    @Test
    public void testFromAscii_ThreeBytes() {
        char[] ascii = { '1', '1', '1', '1', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0' };
        // 11110000 01010101 11110000 in binary
        byte[] expected = { (byte) 240, 85, (byte) 240 };
        assertArrayEquals(expected, BinaryCodec.fromAscii(ascii));
    }

    @Test
    public void testFromAscii_IncompleteByte() {
        char[] ascii = { '1', '1', '1', '1', '0', '0', '0', '0', '1', '0', '1' };
        // 11110000 00100000 in binary
        byte[] expected = { (byte) 240, 32 };
        assertArrayEquals(expected, BinaryCodec.fromAscii(ascii));
    }

    @Test
    public void testFromAscii_OnlyZeros() {
        char[] ascii = { '0', '0', '0', '0', '0', '0', '0', '0' };
        // 00000000 in binary
        byte[] expected = { 0 };
        assertArrayEquals(expected, BinaryCodec.fromAscii(ascii));
    }

    @Test
    public void testFromAscii_OnlyOnes() {
        char[] ascii = { '1', '1', '1', '1', '1', '1', '1', '1' };
        // 11111111 in binary
        byte[] expected = { -1 };
        assertArrayEquals(expected, BinaryCodec.fromAscii(ascii));
    }
}
