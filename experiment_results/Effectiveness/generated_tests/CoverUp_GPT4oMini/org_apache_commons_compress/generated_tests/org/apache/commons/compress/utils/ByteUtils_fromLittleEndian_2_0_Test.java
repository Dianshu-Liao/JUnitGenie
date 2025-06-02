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
        byte[] input = { 1, 0, 0, 0 };
        long result = ByteUtils.fromLittleEndian(input, 0, 4);
        assertEquals(1, result);
    }

    @Test
    void testFromLittleEndian_MultipleBytes() {
        // Represents the number 67305985 in little-endian
        byte[] input = { 1, 2, 3, 4 };
        long result = ByteUtils.fromLittleEndian(input, 0, 4);
        assertEquals(67305985, result);
    }

    @Test
    void testFromLittleEndian_ZeroBytes() {
        // Represents the number 0 in little-endian
        byte[] input = { 0, 0, 0, 0 };
        long result = ByteUtils.fromLittleEndian(input, 0, 4);
        assertEquals(0, result);
    }

    @Test
    void testFromLittleEndian_ExceedingLength() {
        // More than 8 bytes
        byte[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ByteUtils.fromLittleEndian(input, 0, 9);
        });
        assertEquals("Can't read more than eight bytes into a long value", thrown.getMessage());
    }

    @Test
    void testFromLittleEndian_SingleByte() {
        // Represents the number 255 in little-endian
        byte[] input = { (byte) 255 };
        long result = ByteUtils.fromLittleEndian(input, 0, 1);
        assertEquals(255, result);
    }

    @Test
    void testFromLittleEndian_NegativeByte() {
        // Represents the number 4294967295 in little-endian
        byte[] input = { (byte) -1, 0, 0, 0 };
        long result = ByteUtils.fromLittleEndian(input, 0, 4);
        assertEquals(4294967295L, result);
    }
}
