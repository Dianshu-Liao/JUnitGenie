package org.apache.commons.codec.net;

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
import org.apache.commons.codec.EncoderException;

public class PercentCodec_doEncode_4_0_Test {

    private PercentCodec percentCodec;

    @BeforeEach
    public void setUp() {
        percentCodec = new PercentCodec();
    }

    @Test
    public void testDoEncode_WithEncodedCharacters() throws Exception {
        // ASCII for 'A', 'B', 'C'
        byte[] input = { 65, 66, 67 };
        // 3 bytes encoded to 6 bytes + original 3 bytes
        int expectedLength = 9;
        boolean willEncode = true;
        byte[] expectedOutput = { '%', '4', '1', '%', '4', '2', '%', '4', '3' };
        byte[] result = invokeDoEncode(input, expectedLength, willEncode);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testDoEncode_WithSpaceEncoding() throws Exception {
        byte[] input = { 'A', ' ', 'B', 'C' };
        // 4 bytes: 'A', ' ', 'B', 'C' -> 'A', '+', 'B', 'C'
        int expectedLength = 9;
        boolean willEncode = true;
        // Expecting 'A', '+', 'B', 'C'
        byte[] expectedOutput = { 'A', '+', 'B', 'C' };
        PercentCodec codecWithPlusForSpace = new PercentCodec(null, true);
        byte[] result = invokeDoEncode(input, expectedLength, willEncode, codecWithPlusForSpace);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testDoEncode_NoEncoding() throws Exception {
        // ASCII for 'A', 'B', 'C'
        byte[] input = { 65, 66, 67 };
        // No encoding, just original bytes
        int expectedLength = 3;
        boolean willEncode = false;
        // 'A', 'B', 'C'
        byte[] expectedOutput = { 65, 66, 67 };
        byte[] result = invokeDoEncode(input, expectedLength, willEncode);
        assertArrayEquals(expectedOutput, result);
    }

    private byte[] invokeDoEncode(byte[] bytes, int expectedLength, boolean willEncode) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("doEncode", byte[].class, int.class, boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(percentCodec, bytes, expectedLength, willEncode);
    }

    private byte[] invokeDoEncode(byte[] bytes, int expectedLength, boolean willEncode, PercentCodec codec) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("doEncode", byte[].class, int.class, boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(codec, bytes, expectedLength, willEncode);
    }
}
