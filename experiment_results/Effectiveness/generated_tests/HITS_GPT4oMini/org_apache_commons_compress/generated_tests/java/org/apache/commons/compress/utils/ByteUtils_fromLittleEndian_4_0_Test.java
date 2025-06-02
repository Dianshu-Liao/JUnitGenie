package org.apache.commons.compress.utils;

import java.io.DataInput;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutput;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteUtils_fromLittleEndian_4_0_Test {

    @Test
    public void testFromLittleEndian_OneByte() throws IOException {
        DataInput mockDataInput = Mockito.mock(DataInput.class);
        Mockito.when(mockDataInput.readUnsignedByte()).thenReturn(0x01);
        long result = ByteUtils.fromLittleEndian(mockDataInput, 1);
        assertEquals(1L, result);
    }

    @Test
    public void testFromLittleEndian_TwoBytes() throws IOException {
        DataInput mockDataInput = Mockito.mock(DataInput.class);
        Mockito.when(mockDataInput.readUnsignedByte()).thenReturn(0x01, 0x02);
        long result = ByteUtils.fromLittleEndian(mockDataInput, 2);
        // 0x0201 is 2 in the second byte and 1 in the first byte
        assertEquals(0x0201L, result);
    }

    @Test
    public void testFromLittleEndian_ThreeBytes() throws IOException {
        DataInput mockDataInput = Mockito.mock(DataInput.class);
        Mockito.when(mockDataInput.readUnsignedByte()).thenReturn(0x01, 0x02, 0x03);
        long result = ByteUtils.fromLittleEndian(mockDataInput, 3);
        // 0x030201 is 3 in the third byte, 2 in the second, and 1 in the first
        assertEquals(0x030201L, result);
    }

    @Test
    public void testFromLittleEndian_EightBytes() throws IOException {
        DataInput mockDataInput = Mockito.mock(DataInput.class);
        Mockito.when(mockDataInput.readUnsignedByte()).thenReturn(0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08);
        long result = ByteUtils.fromLittleEndian(mockDataInput, 8);
        // All bytes combined in little-endian order
        assertEquals(0x0807060504030201L, result);
    }

    @Test
    public void testFromLittleEndian_TooManyBytes() {
        DataInput mockDataInput = Mockito.mock(DataInput.class);
        assertThrows(IllegalArgumentException.class, () -> {
            // More than 8 bytes
            ByteUtils.fromLittleEndian(mockDataInput, 9);
        });
    }

    @Test
    public void testFromLittleEndian_ZeroBytes() throws IOException {
        DataInput mockDataInput = Mockito.mock(DataInput.class);
        long result = ByteUtils.fromLittleEndian(mockDataInput, 0);
        // Reading zero bytes should return 0
        assertEquals(0L, result);
    }
}
