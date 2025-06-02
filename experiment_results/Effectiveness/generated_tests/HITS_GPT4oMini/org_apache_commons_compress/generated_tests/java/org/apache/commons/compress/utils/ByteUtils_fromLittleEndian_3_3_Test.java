package org.apache.commons.compress.utils;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteUtils_fromLittleEndian_3_3_Test {

    @FunctionalInterface
    interface ByteSupplier {

        byte getAsByte();
    }

    @Test
    public void testFromLittleEndian_ValidInput() throws IOException {
        ByteSupplier supplier = new ByteSupplier() {

            private final byte[] bytes = { 1, 2, 3, 4 };

            private int index = 0;

            @Override
            public byte getAsByte() {
                return index < bytes.length ? bytes[index++] : -1;
            }
        };
        long result = ByteUtils.fromLittleEndian(supplier::getAsByte, 4);
        // 1 + (2 << 8) + (3 << 16) + (4 << 24)
        assertEquals(67305985, result);
    }

    @Test
    public void testFromLittleEndian_PrematureEndOfData() {
        ByteSupplier supplier = new ByteSupplier() {

            private int callCount = 0;

            @Override
            public byte getAsByte() {
                if (callCount < 2) {
                    return (byte) (callCount++);
                } else {
                    // Simulating end of data
                    return -1;
                }
            }
        };
        IOException exception = assertThrows(IOException.class, () -> {
            ByteUtils.fromLittleEndian(supplier::getAsByte, 4);
        });
        assertEquals("Premature end of data", exception.getMessage());
    }

    @Test
    public void testFromLittleEndian_ExceedsMaxLength() {
        ByteSupplier supplier = () -> 0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // Exceeds maximum length
            ByteUtils.fromLittleEndian(supplier::getAsByte, 9);
        });
        assertEquals("Can't read more than eight bytes into a long value", exception.getMessage());
    }

    @Test
    public void testFromLittleEndian_ZeroLength() throws IOException {
        ByteSupplier supplier = () -> 0;
        long result = ByteUtils.fromLittleEndian(supplier::getAsByte, 0);
        // Zero length should return 0
        assertEquals(0, result);
    }

    @Test
    public void testFromLittleEndian_SingleByte() throws IOException {
        ByteSupplier supplier = new ByteSupplier() {

            private int callCount = 0;

            @Override
            public byte getAsByte() {
                // Returns 0 on first call
                return (byte) callCount++;
            }
        };
        long result = ByteUtils.fromLittleEndian(supplier::getAsByte, 1);
        // Single byte should return 0
        assertEquals(0, result);
    }
}
