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

public class BinaryCodec_decode_6_0_Test {

    private BinaryCodec binaryCodec;

    @BeforeEach
    public void setUp() {
        binaryCodec = new BinaryCodec();
    }

    @Test
    public void testDecode_EmptyArray() {
        byte[] input = {};
        byte[] expected = {};
        byte[] actual = binaryCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_SingleByte() {
        // 255 in binary
        byte[] input = { '1', '1', '1', '1', '1', '1', '1', '1' };
        byte[] expected = { (byte) 255 };
        byte[] actual = binaryCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_TwoBytes() {
        byte[] input = { // 254
        // 254
        '1', // 254
        '1', // 254
        '1', // 254
        '1', // 254
        '1', // 254
        '1', // 192
        '1', // 192
        '0', // 192
        '1', // 192
        '1', // 192
        '1', // 192
        '1', // 192
        '1', // 192
        '1', '0', '0' };
        byte[] expected = { (byte) 254, (byte) 192 };
        byte[] actual = binaryCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_InvalidInput() {
        // Invalid binary input
        byte[] input = { '2', '1', '0', '1' };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            binaryCodec.decode(input);
        });
    }

    @Test
    public void testDecode_NullInput() {
        byte[] input = null;
        byte[] expected = {};
        byte[] actual = binaryCodec.decode(input);
        assertArrayEquals(expected, actual);
    }
}
