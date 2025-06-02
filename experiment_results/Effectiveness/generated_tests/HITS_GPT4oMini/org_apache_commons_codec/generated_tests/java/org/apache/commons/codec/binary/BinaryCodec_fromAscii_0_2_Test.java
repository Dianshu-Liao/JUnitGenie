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

public class BinaryCodec_fromAscii_0_2_Test {

    @Test
    public void testFromAscii_EmptyArray() {
        byte[] input = {};
        byte[] expected = {};
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual, "Expected an empty byte array for empty input.");
    }

    @Test
    public void testFromAscii_SingleByteZero() {
        byte[] input = { '0', '0', '0', '0', '0', '0', '0', '0' };
        byte[] expected = { 0 };
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual, "Expected byte array with a single zero byte.");
    }

    @Test
    public void testFromAscii_SingleByteOne() {
        byte[] input = { '1', '1', '1', '1', '1', '1', '1', '1' };
        byte[] expected = { -1 };
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual, "Expected byte array with a single byte of all ones.");
    }

    @Test
    public void testFromAscii_TwoBytes() {
        byte[] input = { '1', '0', '1', '1', '0', '0', '1', '1', '1', '0', '1', '1', '0', '0', '1', '1' };
        byte[] expected = { (byte) 0b10110011, (byte) 0b10110011 };
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual, "Expected byte array for two bytes of mixed bits.");
    }

    @Test
    public void testFromAscii_ComplexInput() {
        byte[] input = { '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '0', '0', '1', '1', '1' };
        byte[] expected = { (byte) 0b11010101, (byte) 0b01111001 };
        byte[] actual = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, actual, "Expected byte array for complex input.");
    }
}
