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
        // Test with an empty byte array
        byte[] input = {};
        byte[] expected = {};
        byte[] result = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, result, "Expected an empty byte array when input is empty.");
    }

    @Test
    public void testFromAscii_NullArray() {
        // Test with a null byte array
        byte[] input = null;
        byte[] expected = {};
        byte[] result = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, result, "Expected an empty byte array when input is null.");
    }

    @Test
    public void testFromAscii_ValidInput() {
        // Test with a valid ASCII representation of binary
        byte[] input = new byte[] { '1', '0', '1', '1', '0', '1', '0', '1' };
        // Expected byte representation
        byte[] expected = new byte[] { (byte) 0b10110101 };
        byte[] result = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, result, "The byte array should match the expected binary representation.");
    }

    @Test
    public void testFromAscii_ValidInputMultipleBytes() {
        // Test with multiple bytes of valid ASCII representation
        byte[] input = new byte[] { '1', '1', '1', '1', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0' };
        // Expected byte representation
        byte[] expected = new byte[] { (byte) 0b11110000, (byte) 0b10101010 };
        byte[] result = BinaryCodec.fromAscii(input);
        assertArrayEquals(expected, result, "The byte array should match the expected binary representation for multiple bytes.");
    }
}
