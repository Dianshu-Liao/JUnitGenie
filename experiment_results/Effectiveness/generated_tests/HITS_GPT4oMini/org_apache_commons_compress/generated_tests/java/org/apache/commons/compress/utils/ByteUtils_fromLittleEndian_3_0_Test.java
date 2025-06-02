package org.apache.commons.compress.utils;

import org.junit.jupiter.api.function.Executable;
import java.io.IOException;
import java.util.function.Supplier;
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

public class ByteUtils_fromLittleEndian_3_0_Test {

    @FunctionalInterface
    public interface ByteSupplier {

        byte getAsByte();
    }

    @Test
    public void testFromLittleEndian_ValidLength() throws IOException {
        // Always return 1 for testing
        ByteSupplier supplier = () -> 1;
        long result = ByteUtils.fromLittleEndian(supplier::getAsByte, 4);
        // 1 in little-endian for 4 bytes
        assertEquals(0x01000000L, result);
    }

    @Test
    public void testFromLittleEndian_PrematureEndOfData() {
        ByteSupplier supplier = new ByteSupplier() {

            private int count = 0;

            @Override
            public byte getAsByte() {
                if (count < 2) {
                    count++;
                    // Return 1 for the first two calls
                    return 1;
                }
                // Simulate end of data
                return -1;
            }
        };
        IOException exception = assertThrows(IOException.class, () -> {
            ByteUtils.fromLittleEndian(supplier::getAsByte, 4);
        });
        assertEquals("Premature end of data", exception.getMessage());
    }

    @Test
    public void testFromLittleEndian_ValidLengthBoundary() throws IOException {
        // Always return 0 for testing
        ByteSupplier supplier = () -> 0;
        long result = ByteUtils.fromLittleEndian(supplier::getAsByte, 8);
        // All zeros for 8 bytes
        assertEquals(0L, result);
    }

    @Test
    public void testFromLittleEndian_InvalidLengthTooLong() {
        ByteSupplier supplier = () -> 1;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // Length exceeds 8
            ByteUtils.fromLittleEndian(supplier::getAsByte, 9);
        });
        assertEquals("Can't read more than eight bytes into a long value", exception.getMessage());
    }

    @Test
    public void testFromLittleEndian_ZeroLength() throws IOException {
        ByteSupplier supplier = () -> 0;
        long result = ByteUtils.fromLittleEndian(supplier::getAsByte, 0);
        // No bytes read should yield 0
        assertEquals(0L, result);
    }
}
