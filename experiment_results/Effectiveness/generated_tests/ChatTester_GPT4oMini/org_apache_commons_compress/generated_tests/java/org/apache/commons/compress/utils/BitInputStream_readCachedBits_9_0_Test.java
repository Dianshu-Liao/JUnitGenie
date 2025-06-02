// Test method
package org.apache.commons.compress.utils;

import org.apache.commons.io.input.BoundedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Closeable;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BitInputStream_readCachedBits_9_0_Test {

    private BitInputStream bitInputStream;

    @BeforeEach
    public void setUp() {
        // Fixed line: Use a byte array for the input stream
        InputStream inputStream = new ByteArrayInputStream(new byte[] { (byte) 0b00001111, (byte) 0b11110000 });
        bitInputStream = new BitInputStream(inputStream, ByteOrder.LITTLE_ENDIAN);
    }

    @Test
    public void testReadCachedBitsLittleEndian() throws Exception {
        // Setup the internal state to have cached bits
        // 16 bits cached
        setBitsCached(bitInputStream, 0b1111111111111111L);
        setBitsCachedSize(bitInputStream, 16);
        long result = invokeReadCachedBits(bitInputStream, 8);
        // Expecting the first 8 bits
        assertEquals(0b11111111, result);
        result = invokeReadCachedBits(bitInputStream, 8);
        // Expecting the next 8 bits
        assertEquals(0b11111111, result);
    }

    @Test
    public void testReadCachedBitsBigEndian() throws Exception {
        bitInputStream = new BitInputStream(new ByteArrayInputStream(new byte[] { (byte) 0b00001111, (byte) 0b11110000 }), ByteOrder.BIG_ENDIAN);
        // 16 bits cached
        setBitsCached(bitInputStream, 0b1111111111111111L);
        setBitsCachedSize(bitInputStream, 16);
        long result = invokeReadCachedBits(bitInputStream, 8);
        // Expecting the first 8 bits
        assertEquals(0b11111111, result);
        result = invokeReadCachedBits(bitInputStream, 8);
        // Expecting the next 8 bits
        assertEquals(0b11111111, result);
    }

    @Test
    public void testReadCachedBitsInvalidCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Invalid count
            invokeReadCachedBits(bitInputStream, -1);
        });
    }

    @Test
    public void testReadCachedBitsWithInsufficientCache() throws Exception {
        // Setup the internal state with insufficient cached bits
        // 8 bits cached
        setBitsCached(bitInputStream, 0b11111111);
        setBitsCachedSize(bitInputStream, 8);
        long result = invokeReadCachedBits(bitInputStream, 16);
        // Expecting the cached bits
        assertEquals(0b11111111, result);
    }

    private long invokeReadCachedBits(BitInputStream bitInputStream, int count) throws Exception {
        java.lang.reflect.Method method = BitInputStream.class.getDeclaredMethod("readCachedBits", int.class);
        method.setAccessible(true);
        return (long) method.invoke(bitInputStream, count);
    }

    private void setBitsCached(BitInputStream bitInputStream, long value) throws Exception {
        java.lang.reflect.Field field = BitInputStream.class.getDeclaredField("bitsCached");
        field.setAccessible(true);
        field.set(bitInputStream, value);
    }

    private void setBitsCachedSize(BitInputStream bitInputStream, int value) throws Exception {
        java.lang.reflect.Field field = BitInputStream.class.getDeclaredField("bitsCachedSize");
        field.setAccessible(true);
        field.set(bitInputStream, value);
    }
}
