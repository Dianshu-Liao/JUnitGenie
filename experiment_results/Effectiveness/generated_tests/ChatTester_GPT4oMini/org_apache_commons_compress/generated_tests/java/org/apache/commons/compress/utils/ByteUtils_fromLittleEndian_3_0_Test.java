package org.apache.commons.compress.utils;

import org.junit.jupiter.api.function.Executable;
import java.io.IOException;
import java.util.function.IntSupplier;
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

class ByteUtils_fromLittleEndian_3_0_Test {

    // Custom ByteSupplier implementation
    static class TestByteSupplier implements ByteUtils.ByteSupplier {

        private final byte[] data;

        private int index = 0;

        TestByteSupplier(byte[] data) {
            this.data = data;
        }

        @Override
        public int getAsByte() {
            return index < data.length ? data[index++] & 0xFF : -1;
        }
    }

    @Test
    void testFromLittleEndian_ValidInput() throws IOException {
        TestByteSupplier supplier = new TestByteSupplier(new byte[] { 1, 2, 3, 4 });
        long result = ByteUtils.fromLittleEndian(supplier, 4);
        assertEquals(67305985L, result);
    }

    @Test
    void testFromLittleEndian_PrematureEndOfData() {
        TestByteSupplier supplier = new TestByteSupplier(new byte[] { 1 });
        Executable executable = () -> ByteUtils.fromLittleEndian(supplier, 2);
        IOException exception = assertThrows(IOException.class, executable);
        assertEquals("Premature end of data", exception.getMessage());
    }

    @Test
    void testFromLittleEndian_ZeroLength() throws IOException {
        TestByteSupplier supplier = new TestByteSupplier(new byte[] { 0 });
        long result = ByteUtils.fromLittleEndian(supplier, 0);
        assertEquals(0L, result);
    }

    @Test
    void testFromLittleEndian_NegativeLength() {
        TestByteSupplier supplier = new TestByteSupplier(new byte[] { 0 });
        Executable executable = () -> ByteUtils.fromLittleEndian(supplier, -1);
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void testFromLittleEndian_MaximumLength() throws IOException {
        TestByteSupplier supplier = new TestByteSupplier(new byte[] { 0, 1, 2, 3, 4, 5, 6, 7 });
        long result = ByteUtils.fromLittleEndian(supplier, 8);
        assertEquals(0x0706050403020100L, result);
    }
}
