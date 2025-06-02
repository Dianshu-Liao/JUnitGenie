package org.apache.commons.codec.net;

import java.lang.reflect.Method;
import java.util.BitSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class PercentCodec_encode_5_0_Test {

    private PercentCodec percentCodec;

    @BeforeEach
    public void setUp() {
        percentCodec = new PercentCodec();
    }

    @Test
    public void testEncode_NullInput() throws Exception {
        byte[] result = percentCodec.encode(null);
        assertNull(result);
    }

    @Test
    public void testEncode_NoEncodingNeeded() throws Exception {
        byte[] input = "Hello".getBytes();
        byte[] result = percentCodec.encode(input);
        assertArrayEquals(input, result);
    }

    @Test
    public void testEncode_WithEncodingNeeded() throws Exception {
        byte[] input = "Hello World!".getBytes();
        // Assuming space is encoded to %20
        byte[] expected = "Hello%20World!".getBytes();
        percentCodec = new PercentCodec(new byte[] { ' ' }, false);
        byte[] result = percentCodec.encode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncode_WithPlusForSpace() throws Exception {
        byte[] input = "Hello World!".getBytes();
        // Assuming space is replaced with +
        byte[] expected = "Hello+World!".getBytes();
        percentCodec = new PercentCodec(new byte[] { ' ' }, true);
        byte[] result = percentCodec.encode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncode_WithNoPlusForSpace() throws Exception {
        byte[] input = "Hello World!".getBytes();
        // Assuming space is encoded to %20
        byte[] expected = "Hello%20World!".getBytes();
        percentCodec = new PercentCodec(new byte[] { ' ' }, false);
        byte[] result = percentCodec.encode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncode_EmptyInput() throws Exception {
        byte[] input = "".getBytes();
        byte[] result = percentCodec.encode(input);
        assertArrayEquals(input, result);
    }

    @Test
    public void testEncode_WithMultipleSpaces() throws Exception {
        byte[] input = "Hello  World!".getBytes();
        // Assuming multiple spaces are encoded to %20%20
        byte[] expected = "Hello%20%20World!".getBytes();
        percentCodec = new PercentCodec(new byte[] { ' ' }, false);
        byte[] result = percentCodec.encode(input);
        assertArrayEquals(expected, result);
    }

    private byte[] invokeDoEncode(PercentCodec codec, byte[] bytes, int expectedEncodingBytes, boolean willEncode) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("doEncode", byte[].class, int.class, boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(codec, bytes, expectedEncodingBytes, willEncode);
    }
}
