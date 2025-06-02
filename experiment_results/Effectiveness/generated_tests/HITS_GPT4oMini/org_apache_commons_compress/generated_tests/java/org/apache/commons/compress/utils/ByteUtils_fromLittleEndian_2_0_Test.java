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

public class ByteUtils_fromLittleEndian_2_0_Test {

    @Test
    public void testFromLittleEndian_ValidInput_1Byte() {
        byte[] input = { 0x01 };
        long result = ByteUtils.fromLittleEndian(input, 0, 1);
        assertEquals(1L, result);
    }

    @Test
    public void testFromLittleEndian_ValidInput_2Bytes() {
        byte[] input = { 0x01, 0x02 };
        long result = ByteUtils.fromLittleEndian(input, 0, 2);
        // 0x0201 is 2*256 + 1
        assertEquals(0x0201L, result);
    }

    @Test
    public void testFromLittleEndian_ValidInput_4Bytes() {
        byte[] input = { 0x01, 0x02, 0x03, 0x04 };
        long result = ByteUtils.fromLittleEndian(input, 0, 4);
        // 0x04030201 is 4*256^3 + 3*256^2 + 2*256 + 1
        assertEquals(0x04030201L, result);
    }

    @Test
    public void testFromLittleEndian_ValidInput_8Bytes() {
        byte[] input = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08 };
        long result = ByteUtils.fromLittleEndian(input, 0, 8);
        // Full 8 bytes
        assertEquals(0x0807060504030201L, result);
    }

    @Test
    public void testFromLittleEndian_ZeroLength() {
        byte[] input = { 0x01, 0x02 };
        long result = ByteUtils.fromLittleEndian(input, 0, 0);
        // Length is zero, should return 0
        assertEquals(0L, result);
    }

    @Test
    public void testFromLittleEndian_InvalidLength_TooLong() {
        byte[] input = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08 };
        assertThrows(IllegalArgumentException.class, () -> {
            // More than 8 bytes
            ByteUtils.fromLittleEndian(input, 0, 9);
        });
    }

    @Test
    public void testFromLittleEndian_InvalidOffset() {
        byte[] input = { 0x01, 0x02, 0x03, 0x04 };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Offset is 1, trying to read 4 bytes
            ByteUtils.fromLittleEndian(input, 1, 4);
        });
    }

    @Test
    public void testFromLittleEndian_NegativeOffset() {
        byte[] input = { 0x01, 0x02, 0x03, 0x04 };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Negative offset
            ByteUtils.fromLittleEndian(input, -1, 1);
        });
    }
}
