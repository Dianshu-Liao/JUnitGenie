package org.apache.commons.codec.net;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class PercentCodec_expectedEncodingBytes_8_0_Test {

    private PercentCodec percentCodec;

    @BeforeEach
    public void setUp() {
        percentCodec = new PercentCodec();
    }

    @Test
    public void testExpectedEncodingBytes_NoEncodingNeeded() throws Exception {
        // Characters that don't need encoding
        byte[] input = new byte[] { 'a', 'b', 'c' };
        // Each byte is 1 byte
        int expected = 3;
        int actual = invokeExpectedEncodingBytes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testExpectedEncodingBytes_WithEncodingNeeded() throws Exception {
        // '%' needs encoding, ' ' if plusForSpace is true
        byte[] input = new byte[] { 'a', '%', ' ' };
        // 'a' (1) + '%' (3) + ' ' (3 if plusForSpace is true)
        int expected = 5;
        // plusForSpace is true
        percentCodec = new PercentCodec(new byte[] { '%' }, true);
        int actual = invokeExpectedEncodingBytes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testExpectedEncodingBytes_EmptyArray() throws Exception {
        // Empty array
        byte[] input = new byte[] {};
        // No bytes to encode
        int expected = 0;
        int actual = invokeExpectedEncodingBytes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testExpectedEncodingBytes_SingleByteEncoding() throws Exception {
        // Single byte that needs encoding
        byte[] input = new byte[] { '%' };
        // '%' needs encoding
        int expected = 3;
        int actual = invokeExpectedEncodingBytes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testExpectedEncodingBytes_SpaceEncoding() throws Exception {
        // Single space character
        byte[] input = new byte[] { ' ' };
        // Space should be encoded to '%20' if plusForSpace is true
        int expected = 3;
        // plusForSpace is true
        percentCodec = new PercentCodec(new byte[] { '%' }, true);
        int actual = invokeExpectedEncodingBytes(input);
        assertEquals(expected, actual);
    }

    private int invokeExpectedEncodingBytes(byte[] bytes) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("expectedEncodingBytes", byte[].class);
        method.setAccessible(true);
        return (int) method.invoke(percentCodec, (Object) bytes);
    }
}
