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

public class PercentCodec_doEncode_4_0_Test {

    private PercentCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new PercentCodec();
    }

    private byte[] invokeDoEncode(byte[] input, int expectedLength, boolean willEncode) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("doEncode", byte[].class, int.class, boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(codec, input, expectedLength, willEncode);
    }

    @Test
    public void testDoEncode_EmptyArray() throws Exception {
        byte[] input = new byte[0];
        byte[] expected = new byte[0];
        byte[] result = invokeDoEncode(input, 0, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDoEncode_SingleByte() throws Exception {
        // ASCII 'A'
        byte[] input = new byte[] { 65 };
        // Expected output: "%41"
        byte[] expected = new byte[] { 37, 41 };
        byte[] result = invokeDoEncode(input, expected.length, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDoEncode_SpaceWithPlusForSpace() throws Exception {
        PercentCodec codecWithPlus = new PercentCodec(new byte[] {}, true);
        // ASCII ' '
        byte[] input = new byte[] { 32 };
        // Expected output: "+"
        byte[] expected = new byte[] { 43 };
        byte[] result = invokeDoEncode(input, expected.length, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDoEncode_MultipleBytes() throws Exception {
        // ASCII 'A', 'B', 'C'
        byte[] input = new byte[] { 65, 66, 67 };
        // Expected output: "%41%42%43"
        byte[] expected = new byte[] { 37, 41, 37, 42, 37, 43 };
        byte[] result = invokeDoEncode(input, expected.length, true);
        assertArrayEquals(expected, result);
    }
}
