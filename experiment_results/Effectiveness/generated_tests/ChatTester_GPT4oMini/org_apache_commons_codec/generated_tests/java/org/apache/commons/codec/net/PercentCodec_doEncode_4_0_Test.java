package org.apache.commons.codec.net;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
    public void testDoEncode_WithEncoding() throws Exception {
        // ASCII for 'A', 'B', 'C'
        byte[] input = new byte[] { 65, 66, 67 };
        // 3 bytes encoded to 3*3 = 9 bytes
        int expectedLength = 9;
        boolean willEncode = true;
        byte[] expectedOutput = new byte[] { // 'A'
        // 'A'
        // 'A'
        '%', // 'B'
        '4', // 'B'
        '1', // 'B'
        '%', // 'C'
        '4', // 'C'
        '2', // 'C'
        '%', '4', '3' };
        byte[] actualOutput = invokePrivateDoEncode(input, expectedLength, willEncode);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDoEncode_WithSpaceEncoding() throws Exception {
        // 'A', ' ', 'C'
        byte[] input = new byte[] { 65, 32, 67 };
        // 3 bytes, 1 space encoded to 1 byte
        int expectedLength = 9;
        boolean willEncode = false;
        byte[] expectedOutput = new byte[] { 'A', '+', 'C' };
        byte[] actualOutput = invokePrivateDoEncode(input, expectedLength, willEncode);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDoEncode_WithNegativeByte() throws Exception {
        // 255 in unsigned
        byte[] input = new byte[] { -1 };
        // 1 byte encoded to 3 bytes
        int expectedLength = 3;
        boolean willEncode = true;
        byte[] expectedOutput = new byte[] { // Encoding of -1
        // Encoding of -1
        // Encoding of -1
        '%', 'F', 'F' };
        byte[] actualOutput = invokePrivateDoEncode(input, expectedLength, willEncode);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDoEncode_WithNoEncoding() throws Exception {
        // 'A', 'B', 'C'
        byte[] input = new byte[] { 65, 66, 67 };
        // No encoding, so length remains the same
        int expectedLength = 3;
        boolean willEncode = false;
        byte[] expectedOutput = new byte[] { 'A', 'B', 'C' };
        byte[] actualOutput = invokePrivateDoEncode(input, expectedLength, willEncode);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    private byte[] invokePrivateDoEncode(byte[] bytes, int expectedLength, boolean willEncode) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("doEncode", byte[].class, int.class, boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(percentCodec, bytes, expectedLength, willEncode);
    }
}
