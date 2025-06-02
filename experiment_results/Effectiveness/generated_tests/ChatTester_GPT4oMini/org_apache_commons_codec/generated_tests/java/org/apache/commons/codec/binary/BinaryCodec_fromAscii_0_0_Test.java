package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
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

public class BinaryCodec_fromAscii_0_0_Test {

    @Test
    public void testFromAscii_EmptyArray() throws Exception {
        byte[] asciiInput = {};
        byte[] expectedOutput = {};
        byte[] result = invokeFromAscii(asciiInput);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testFromAscii_SingleByte() throws Exception {
        // Represents the byte 0b10110010
        byte[] asciiInput = { '1', '0', '1', '1', '0', '0', '1', '0' };
        byte[] expectedOutput = { (byte) 0b10110010 };
        byte[] result = invokeFromAscii(asciiInput);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testFromAscii_MultipleBytes() throws Exception {
        byte[] asciiInput = { // 255
        // 255
        // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 0
        '1', // 0
        '1', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', '0', '0' };
        byte[] expectedOutput = { (byte) 0xFF, 0x00 };
        byte[] result = invokeFromAscii(asciiInput);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testFromAscii_IncompleteByte() throws Exception {
        // Represents the byte 0b10110010 but incomplete
        byte[] asciiInput = { '1', '0', '1', '1', '0', '0', '1' };
        // Last 4 bits are ignored
        byte[] expectedOutput = { (byte) 0b10110000 };
        byte[] result = invokeFromAscii(asciiInput);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testFromAscii_AllZeros() throws Exception {
        byte[] asciiInput = { // 0
        // 0
        // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', // 0
        '0', '0', '0' };
        byte[] expectedOutput = { 0x00, 0x00 };
        byte[] result = invokeFromAscii(asciiInput);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testFromAscii_AllOnes() throws Exception {
        byte[] asciiInput = { // 255
        // 255
        // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', // 255
        '1', '1', '1' };
        byte[] expectedOutput = { (byte) 0xFF, (byte) 0xFF };
        byte[] result = invokeFromAscii(asciiInput);
        assertArrayEquals(expectedOutput, result);
    }

    private byte[] invokeFromAscii(byte[] ascii) throws Exception {
        Method method = BinaryCodec.class.getDeclaredMethod("fromAscii", byte[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, (Object) ascii);
    }
}
