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
        // Test with null input
        byte[] result = BinaryCodec.fromAscii((char[]) null);
        assertArrayEquals(new byte[] {}, result, "Expected empty byte array for null input");
    }

    @Test
    public void testFromAscii_EmptyInput() {
        // Test with empty char array
        byte[] result = BinaryCodec.fromAscii(new char[] {});
        assertArrayEquals(new byte[] {}, result, "Expected empty byte array for empty input");
    }

    @Test
    public void testFromAscii_SingleByteInput() {
        // Test with input representing a single byte
        // Represents 0xAA
        char[] input = { '1', '0', '1', '0', '1', '0', '1', '0' };
        byte[] expected = { (byte) 0xAA };
        byte[] result = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, result, "Expected byte array representing 0xAA");
    }

    @Test
    public void testFromAscii_MultipleBytesInput() {
        // Test with input representing multiple bytes
        char[] input = { '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1' };
        byte[] expected = { (byte) 0xAA, (byte) 0xFF };
        byte[] result = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, result, "Expected byte array representing 0xAA and 0xFF");
    }

    @Test
    public void testFromAscii_IncompleteByteInput() {
        // Test with incomplete byte representation
        char[] input = { '1', '0', '1', '0', '1', '0', '1' };
        byte[] expected = { (byte) 0xA0 };
        byte[] result = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, result, "Expected byte array representing 0xA0 for incomplete byte input");
    }

    @Test
    public void testFromAscii_AllZeros() {
        // Test with input of all zeros
        char[] input = { '0', '0', '0', '0', '0', '0', '0', '0' };
        byte[] expected = { (byte) 0x00 };
        byte[] result = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, result, "Expected byte array representing 0x00");
    }

    @Test
    public void testFromAscii_AllOnes() {
        // Test with input of all ones
        char[] input = { '1', '1', '1', '1', '1', '1', '1', '1' };
        byte[] expected = { (byte) 0xFF };
        byte[] result = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, result, "Expected byte array representing 0xFF");
    }
}
