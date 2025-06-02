package org.apache.commons.compress.utils;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteUtils_fromLittleEndian_1_0_Test {

    @Test
    public void testFromLittleEndian_EmptyArray() {
        byte[] input = ByteUtils.EMPTY_BYTE_ARRAY;
        long result = invokeFromLittleEndian(input);
        assertEquals(0L, result);
    }

    @Test
    public void testFromLittleEndian_SingleByte() {
        byte[] input = new byte[] { 0x01 };
        long result = invokeFromLittleEndian(input);
        assertEquals(1L, result);
    }

    @Test
    public void testFromLittleEndian_TwoBytes() {
        byte[] input = new byte[] { 0x01, 0x02 };
        long result = invokeFromLittleEndian(input);
        assertEquals(0x0201L, result);
    }

    @Test
    public void testFromLittleEndian_ThreeBytes() {
        byte[] input = new byte[] { 0x01, 0x02, 0x03 };
        long result = invokeFromLittleEndian(input);
        assertEquals(0x030201L, result);
    }

    @Test
    public void testFromLittleEndian_FourBytes() {
        byte[] input = new byte[] { 0x01, 0x02, 0x03, 0x04 };
        long result = invokeFromLittleEndian(input);
        assertEquals(0x04030201L, result);
    }

    @Test
    public void testFromLittleEndian_MaxByteValues() {
        byte[] input = new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF };
        long result = invokeFromLittleEndian(input);
        assertEquals(0xFFFFFFFFL, result);
    }

    private long invokeFromLittleEndian(byte[] bytes) {
        try {
            return (long) ByteUtils.class.getDeclaredMethod("fromLittleEndian", byte[].class).invoke(null, (Object) bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
