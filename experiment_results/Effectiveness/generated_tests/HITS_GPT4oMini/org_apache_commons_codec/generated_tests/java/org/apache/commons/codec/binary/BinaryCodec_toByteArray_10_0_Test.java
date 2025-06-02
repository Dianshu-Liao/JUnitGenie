package org.apache.commons.codec.binary;

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

public class BinaryCodec_toByteArray_10_0_Test {

    private final BinaryCodec binaryCodec = new BinaryCodec();

    @Test
    public void testToByteArray_NullInput() {
        byte[] result = binaryCodec.toByteArray(null);
        assertArrayEquals(new byte[] {}, result, "Expected empty byte array for null input");
    }

    @Test
    public void testToByteArray_EmptyString() {
        byte[] result = binaryCodec.toByteArray("");
        assertArrayEquals(new byte[] {}, result, "Expected empty byte array for empty string");
    }

    @Test
    public void testToByteArray_SingleCharacterInput() {
        byte[] result = binaryCodec.toByteArray("1");
        assertArrayEquals(new byte[] { 1 }, result, "Expected byte array with single byte for input '1'");
    }

    @Test
    public void testToByteArray_MultipleCharacterInput() {
        byte[] result = binaryCodec.toByteArray("11001010");
        assertArrayEquals(new byte[] { -110 }, result, "Expected byte array for input '11001010'");
    }

    @Test
    public void testToByteArray_FullByteInput() {
        byte[] result = binaryCodec.toByteArray("11111111");
        assertArrayEquals(new byte[] { -1 }, result, "Expected byte array for input '11111111'");
    }

    @Test
    public void testToByteArray_LeadingZeros() {
        byte[] result = binaryCodec.toByteArray("00000001");
        assertArrayEquals(new byte[] { 1 }, result, "Expected byte array with single byte for input '00000001'");
    }

    @Test
    public void testToByteArray_ComplexInput() {
        byte[] result = binaryCodec.toByteArray("1010101010101010");
        assertArrayEquals(new byte[] { -86, -86 }, result, "Expected byte array for input '1010101010101010'");
    }
}
