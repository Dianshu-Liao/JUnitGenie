package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.PercentCodec;
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

class PercentCodec_encode_5_0_Test {

    private PercentCodec percentCodec;

    @BeforeEach
    void setUp() {
        percentCodec = new PercentCodec();
    }

    @Test
    void testEncode_NullInput() throws EncoderException {
        byte[] result = percentCodec.encode(null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    void testEncode_EmptyInput() throws EncoderException {
        byte[] result = percentCodec.encode(new byte[0]);
        assertArrayEquals(new byte[0], result, "Encoding an empty byte array should return an empty byte array");
    }

    @Test
    void testEncode_NoEncodingNeeded() throws EncoderException {
        byte[] input = new byte[] { 'a', 'b', 'c' };
        byte[] result = percentCodec.encode(input);
        assertArrayEquals(input, result, "Encoding should return the same byte array when no encoding is needed");
    }

    @Test
    void testEncode_EncodeNeeded() throws EncoderException {
        byte[] input = new byte[] { 'a', ' ', 'c' };
        byte[] expected = new byte[] { 'a', '+', 'c' };
        byte[] result = percentCodec.encode(input);
        assertArrayEquals(expected, result, "Encoding should replace spaces with '+' when plusForSpace is true");
    }

    @Test
    void testEncode_EncodeSpecialCharacter() throws Exception {
        // Create a PercentCodec instance with alwaysEncodeChars
        byte[] alwaysEncodeChars = new byte[] { '!', '@', '#' };
        PercentCodec percentCodecWithSpecialChars = new PercentCodec(alwaysEncodeChars, false);
        byte[] input = new byte[] { '!', 'a', '@' };
        byte[] expected = new byte[] { '%', '2', '1', 'a', '%', '4', '0' };
        byte[] result = invokeEncode(percentCodecWithSpecialChars, input);
        assertArrayEquals(expected, result, "Encoding should encode special characters");
    }

    private byte[] invokeEncode(PercentCodec codec, byte[] input) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("encode", byte[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(codec, (Object) input);
    }
}
