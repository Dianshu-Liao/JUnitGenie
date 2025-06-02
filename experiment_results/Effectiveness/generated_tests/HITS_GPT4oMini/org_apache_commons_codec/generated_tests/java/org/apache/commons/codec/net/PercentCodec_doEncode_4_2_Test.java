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

public class PercentCodec_doEncode_4_2_Test {

    private byte[] invokeDoEncode(PercentCodec codec, byte[] input, int expectedLength, boolean willEncode) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("doEncode", byte[].class, int.class, boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(codec, input, expectedLength, willEncode);
    }

    @Test
    public void testDoEncode_EmptyArray() throws Exception {
        PercentCodec codec = new PercentCodec();
        byte[] input = new byte[0];
        byte[] expected = new byte[0];
        byte[] actual = invokeDoEncode(codec, input, 0, true);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDoEncode_SingleByte_Encode() throws Exception {
        PercentCodec codec = new PercentCodec(new byte[] {}, false);
        byte[] input = new byte[] { (byte) 255 };
        byte[] expected = new byte[] { '%', 'F', 'F' };
        byte[] actual = invokeDoEncode(codec, input, 3, true);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDoEncode_SingleByte_NoEncode() throws Exception {
        PercentCodec codec = new PercentCodec(new byte[] {}, false);
        byte[] input = new byte[] { 'A' };
        byte[] expected = new byte[] { 'A' };
        byte[] actual = invokeDoEncode(codec, input, 1, true);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDoEncode_SpaceCharacter() throws Exception {
        PercentCodec codec = new PercentCodec(new byte[] {}, true);
        byte[] input = new byte[] { ' ' };
        byte[] expected = new byte[] { '+' };
        byte[] actual = invokeDoEncode(codec, input, 1, false);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDoEncode_MultipleBytes() throws Exception {
        PercentCodec codec = new PercentCodec(new byte[] {}, false);
        byte[] input = new byte[] { 'A', (byte) 255, 'B' };
        byte[] expected = new byte[] { 'A', '%', 'F', 'F', 'B' };
        byte[] actual = invokeDoEncode(codec, input, 5, true);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDoEncode_BytesWithSpaceAndEncode() throws Exception {
        PercentCodec codec = new PercentCodec(new byte[] {}, true);
        byte[] input = new byte[] { 'A', ' ', (byte) 255 };
        byte[] expected = new byte[] { 'A', '+', '%', 'F', 'F' };
        byte[] actual = invokeDoEncode(codec, input, 5, true);
    }
}
