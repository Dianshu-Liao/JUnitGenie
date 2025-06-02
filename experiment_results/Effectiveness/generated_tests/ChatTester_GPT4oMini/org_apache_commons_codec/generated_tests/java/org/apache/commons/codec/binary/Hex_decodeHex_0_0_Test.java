package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;

public class Hex_decodeHex_0_0_Test {

    @Test
    public void testDecodeHex_ValidHexString() throws Exception {
        char[] input = { '1', 'a', '2', 'b' };
        byte[] expected = { 0x1A, 0x2B };
        byte[] result = invokeDecodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecodeHex_EmptyInput() throws Exception {
        char[] input = {};
        byte[] expected = {};
        byte[] result = invokeDecodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecodeHex_InvalidHexString() {
        char[] input = { 'g', 'h' };
        assertThrows(DecoderException.class, () -> invokeDecodeHex(input));
    }

    @Test
    public void testDecodeHex_SingleByteHex() throws Exception {
        char[] input = { 'f', 'f' };
        // Fixed Buggy Line
        byte[] expected = { (byte) 0xFF };
        byte[] result = invokeDecodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecodeHex_LeadingZeros() throws Exception {
        char[] input = { '0', '0', '1', 'a' };
        byte[] expected = { 0x00, 0x1A };
        byte[] result = invokeDecodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecodeHex_UpperCaseHex() throws Exception {
        char[] input = { 'A', 'B', 'C', 'D' };
        // Fixed Buggy Line
        byte[] expected = { (byte) 0xAB, (byte) 0xCD };
        byte[] result = invokeDecodeHex(input);
        assertArrayEquals(expected, result);
    }

    private byte[] invokeDecodeHex(char[] data) throws Exception {
        Method method = Hex.class.getDeclaredMethod("decodeHex", char[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, (Object) data);
    }
}
