package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.BinaryCodec;
import java.lang.reflect.Method;
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

    private final BinaryCodec binaryCodec = new BinaryCodec();

    @Test
    public void testEncodeWithEmptyArray() throws Exception {
        byte[] input = {};
        // Expected output for empty input
        byte[] expected = {};
        byte[] result = invokeEncode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeWithSingleByte() throws Exception {
        // Binary: 00000101
        byte[] input = { 5 };
        // Expected ASCII representation
        byte[] expected = { '0', '0', '0', '0', '0', '1', '0', '1' };
        byte[] result = invokeEncode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeWithMultipleBytes() throws Exception {
        // Binary: 00000101, 00001010
        byte[] input = { 5, 10 };
        byte[] expected = { // 5
        // 5
        // 5
        '0', // 5
        '0', // 5
        '0', // 5
        '0', // 5
        '0', // 5
        '1', // 10
        '0', // 10
        '1', // 10
        '0', // 10
        '0', // 10
        '0', // 10
        '0', // 10
        '1', // 10
        '0', '1', '0' };
        // Expected ASCII representation
        byte[] result = invokeEncode(input);
        assertArrayEquals(expected, result);
    }

    private byte[] invokeEncode(byte[] input) throws Exception {
        Method encodeMethod = BinaryCodec.class.getDeclaredMethod("encode", byte[].class);
        encodeMethod.setAccessible(true);
        return (byte[]) encodeMethod.invoke(binaryCodec, (Object) input);
    }
}
