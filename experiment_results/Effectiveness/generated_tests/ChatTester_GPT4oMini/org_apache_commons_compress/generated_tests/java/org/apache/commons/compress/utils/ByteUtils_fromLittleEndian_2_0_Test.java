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

class ByteUtils_fromLittleEndian_2_0_Test {

    @Test
    void testFromLittleEndian_ValidInput() {
        // Represents the number 1 in little-endian
        byte[] bytes = { 1, 0, 0, 0 };
        long result = ByteUtils.fromLittleEndian(bytes, 0, 4);
        assertEquals(1L, result);
    }

    @Test
    void testFromLittleEndian_MultipleBytes() {
        // Represents the number 67305985 in little-endian
        byte[] bytes = { 1, 2, 3, 4 };
        long result = ByteUtils.fromLittleEndian(bytes, 0, 4);
        assertEquals(67305985L, result);
    }

    @Test
    void testFromLittleEndian_EmptyArray() {
        byte[] bytes = ByteUtils.EMPTY_BYTE_ARRAY;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ByteUtils.fromLittleEndian(bytes, 0, 0);
        });
        assertEquals("Length must be greater than 0", exception.getMessage());
    }

    @Test
    void testFromLittleEndian_InvalidOffset() {
        byte[] bytes = { 1, 2, 3, 4 };
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ByteUtils.fromLittleEndian(bytes, -1, 4);
        });
        assertNotNull(exception);
    }

    @Test
    void testFromLittleEndian_InvalidLength() {
        byte[] bytes = { 1, 2, 3, 4 };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Length exceeds available bytes
            ByteUtils.fromLittleEndian(bytes, 0, 5);
        });
        assertEquals("Length exceeds available bytes", exception.getMessage());
    }

    @Test
    void testFromLittleEndian_ZeroLength() {
        byte[] bytes = { 1, 2, 3, 4 };
        long result = ByteUtils.fromLittleEndian(bytes, 0, 0);
        // Zero length should return 0
        assertEquals(0L, result);
    }

    @Test
    void testFromLittleEndian_SingleByte() {
        // Represents the number 5 in little-endian
        byte[] bytes = { 5 };
        long result = ByteUtils.fromLittleEndian(bytes, 0, 1);
        assertEquals(5L, result);
    }

    @Test
    void testFromLittleEndian_NegativeOffset() {
        byte[] bytes = { 10, 20, 30, 40 };
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ByteUtils.fromLittleEndian(bytes, -1, 2);
        });
        assertNotNull(exception);
    }

    @Test
    void testFromLittleEndian_OffsetExceedsArrayLength() {
        byte[] bytes = { 10, 20, 30, 40 };
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Offset + length exceeds array length
            ByteUtils.fromLittleEndian(bytes, 3, 2);
        });
        assertNotNull(exception);
    }
}
