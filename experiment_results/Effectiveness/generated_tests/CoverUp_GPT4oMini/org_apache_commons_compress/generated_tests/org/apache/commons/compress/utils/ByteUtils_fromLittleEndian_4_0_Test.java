package org.apache.commons.compress.utils;

import org.apache.commons.compress.utils.ByteUtils;
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

class ByteUtils_fromLittleEndian_4_0_Test {

    @Test
    void testFromLittleEndian_ValidLength() throws IOException {
        DataInput mockDataInput = mock(DataInput.class);
        when(mockDataInput.readUnsignedByte()).thenReturn(1, 2, 3, 4);
        long result = ByteUtils.fromLittleEndian(mockDataInput, 4);
        assertEquals(0x04030201, result);
        verify(mockDataInput, times(4)).readUnsignedByte();
    }

    @Test
    void testFromLittleEndian_ZeroLength() throws IOException {
        DataInput mockDataInput = mock(DataInput.class);
        long result = ByteUtils.fromLittleEndian(mockDataInput, 0);
        assertEquals(0, result);
        verify(mockDataInput, never()).readUnsignedByte();
    }

    @Test
    void testFromLittleEndian_ExceedingLength() {
        DataInput mockDataInput = mock(DataInput.class);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ByteUtils.fromLittleEndian(mockDataInput, 9);
        });
        assertEquals("Can't read more than eight bytes into a long value", thrown.getMessage());
    }

    @Test
    void testFromLittleEndian_SingleByte() throws IOException {
        DataInput mockDataInput = mock(DataInput.class);
        when(mockDataInput.readUnsignedByte()).thenReturn(255);
        long result = ByteUtils.fromLittleEndian(mockDataInput, 1);
        assertEquals(255, result);
        verify(mockDataInput, times(1)).readUnsignedByte();
    }

    @Test
    void testFromLittleEndian_MultipleBytes() throws IOException {
        DataInput mockDataInput = mock(DataInput.class);
        when(mockDataInput.readUnsignedByte()).thenReturn(1, 2, 3, 4, 5, 6, 7, 8);
        long result = ByteUtils.fromLittleEndian(mockDataInput, 8);
        assertEquals(0x0807060504030201L, result);
        verify(mockDataInput, times(8)).readUnsignedByte();
    }
}
