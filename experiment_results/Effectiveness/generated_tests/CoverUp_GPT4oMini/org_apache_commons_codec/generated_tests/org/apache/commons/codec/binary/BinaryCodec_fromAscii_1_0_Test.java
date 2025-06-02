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

public class BinaryCodec_fromAscii_1_0_Test {

    @Test
    public void testFromAscii_NullInput() throws Exception {
        BinaryCodec codec = new BinaryCodec();
        byte[] result = invokeFromAscii(codec, null);
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testFromAscii_EmptyInput() throws Exception {
        BinaryCodec codec = new BinaryCodec();
        byte[] result = invokeFromAscii(codec, new char[] {});
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testFromAscii_SingleByte() throws Exception {
        BinaryCodec codec = new BinaryCodec();
        // Represents byte 0xAA
        char[] input = new char[] { '1', '0', '1', '0', '1', '0', '1', '0' };
        byte[] result = invokeFromAscii(codec, input);
        assertArrayEquals(new byte[] { (byte) 0xAA }, result);
    }

    @Test
    public void testFromAscii_TwoBytes() throws Exception {
        BinaryCodec codec = new BinaryCodec();
        char[] input = new char[] { // Represents byte 0xAA, 0xCC
        // Represents byte 0xAA, 0xCC
        '1', // Represents byte 0xAA, 0xCC
        '0', // Represents byte 0xAA, 0xCC
        '1', // Represents byte 0xAA, 0xCC
        '0', // Represents byte 0xAA, 0xCC
        '1', // Represents byte 0xAA, 0xCC
        '0', // Represents byte 0xAA, 0xCC
        '1', // Represents byte 0xAA, 0xCC
        '0', // Represents byte 0xAA, 0xCC
        '1', // Represents byte 0xAA, 0xCC
        '1', // Represents byte 0xAA, 0xCC
        '0', // Represents byte 0xAA, 0xCC
        '0', // Represents byte 0xAA, 0xCC
        '1', // Represents byte 0xAA, 0xCC
        '1', '0', '0' };
        byte[] result = invokeFromAscii(codec, input);
        assertArrayEquals(new byte[] { (byte) 0xAA, (byte) 0xCC }, result);
    }

    @Test
    public void testFromAscii_ExtraBitsIgnored() throws Exception {
        BinaryCodec codec = new BinaryCodec();
        char[] input = new char[] { // Extra bits should be ignored
        // Extra bits should be ignored
        '1', // Extra bits should be ignored
        '0', // Extra bits should be ignored
        '1', // Extra bits should be ignored
        '0', // Extra bits should be ignored
        '1', // Extra bits should be ignored
        '0', // Extra bits should be ignored
        '1', // Extra bits should be ignored
        '0', // Extra bits should be ignored
        '1', // Extra bits should be ignored
        '1', // Extra bits should be ignored
        '0', // Extra bits should be ignored
        '0', // Extra bits should be ignored
        '1', // Extra bits should be ignored
        '1', // Extra bits should be ignored
        '0', // Extra bits should be ignored
        '0', '1', '1' };
        byte[] result = invokeFromAscii(codec, input);
        assertArrayEquals(new byte[] { (byte) 0xAA, (byte) 0xCC }, result);
    }

    private byte[] invokeFromAscii(BinaryCodec codec, char[] ascii) throws Exception {
        Method method = BinaryCodec.class.getDeclaredMethod("fromAscii", char[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(codec, (Object) ascii);
    }
}
