package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

@ExtendWith(MockitoExtension.class)
public class BinaryCodec_toByteArray_10_0_Test {

    private BinaryCodec binaryCodec;

    @BeforeEach
    public void setUp() {
        binaryCodec = new BinaryCodec();
    }

    @Test
    public void testToByteArray_NullInput() {
        byte[] result = binaryCodec.toByteArray(null);
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testToByteArray_EmptyString() {
        byte[] result = binaryCodec.toByteArray("");
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testToByteArray_ValidInput() {
        // "1" in binary
        byte[] expected = new byte[] { 0x01 };
        byte[] result = binaryCodec.toByteArray("1");
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToByteArray_ValidInputMultipleBits() {
        // "11" in binary
        byte[] expected = new byte[] { 0x03 };
        byte[] result = binaryCodec.toByteArray("11");
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToByteArray_ValidInputWithLeadingZeros() {
        // "00000001" in binary
        byte[] expected = new byte[] { 0x01 };
        byte[] result = binaryCodec.toByteArray("00000001");
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFromAsciiReflection() throws Exception {
        Method fromAsciiMethod = BinaryCodec.class.getDeclaredMethod("fromAscii", char[].class);
        fromAsciiMethod.setAccessible(true);
        char[] input = "10101010".toCharArray();
        // "10101010" in binary
        byte[] expected = new byte[] { (byte) 0b10101010 };
        byte[] result = (byte[]) fromAsciiMethod.invoke(binaryCodec, (Object) input);
        assertArrayEquals(expected, result);
    }
}
