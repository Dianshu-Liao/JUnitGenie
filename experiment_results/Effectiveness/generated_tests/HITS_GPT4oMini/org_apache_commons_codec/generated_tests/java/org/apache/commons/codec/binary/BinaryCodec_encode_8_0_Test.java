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

public class BinaryCodec_encode_8_0_Test {

    @Test
    public void testEncode_EmptyArray() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = {};
        byte[] expectedOutput = {};
        assertArrayEquals(expectedOutput, codec.encode(input));
    }

    @Test
    public void testEncode_SingleByteZero() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = { 0 };
        byte[] expectedOutput = { '0', '0', '0', '0', '0', '0', '0', '0' };
        assertArrayEquals(expectedOutput, codec.encode(input));
    }

    @Test
    public void testEncode_SingleByteOne() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = { 1 };
        byte[] expectedOutput = { '0', '0', '0', '0', '0', '0', '0', '1' };
        assertArrayEquals(expectedOutput, codec.encode(input));
    }

    @Test
    public void testEncode_SingleByte255() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = { (byte) 255 };
        byte[] expectedOutput = { '1', '1', '1', '1', '1', '1', '1', '1' };
        assertArrayEquals(expectedOutput, codec.encode(input));
    }

    @Test
    public void testEncode_MultipleBytes() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = { 1, 2, 3 };
        byte[] expectedOutput = { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '1', '0' };
        assertArrayEquals(expectedOutput, codec.encode(input));
    }

    @Test
    public void testEncode_NegativeByte() {
        BinaryCodec codec = new BinaryCodec();
        // -1 is 255 in unsigned
        byte[] input = { (byte) -1 };
        byte[] expectedOutput = { '1', '1', '1', '1', '1', '1', '1', '1' };
        assertArrayEquals(expectedOutput, codec.encode(input));
    }
}
