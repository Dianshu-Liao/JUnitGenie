package org.apache.commons.compress.utils;

import org.apache.commons.io.input.BoundedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteOrder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Closeable;
import java.io.InputStream;

public class BitInputStream_readCachedBits_9_0_Test {

    private BitInputStream bitInputStream;

    @BeforeEach
    public void setUp() {
        byte[] data = new byte[] { (byte) 0b10101010, (byte) 0b11001100 };
        BoundedInputStream boundedInputStream = new BoundedInputStream(new ByteArrayInputStream(data), data.length);
        bitInputStream = new BitInputStream(boundedInputStream, ByteOrder.LITTLE_ENDIAN);
    }

    private void setBitsCached(long value) throws Exception {
        Field field = BitInputStream.class.getDeclaredField("bitsCached");
        field.setAccessible(true);
        field.set(bitInputStream, value);
    }

    private void setBitsCachedSize(int value) throws Exception {
        Field field = BitInputStream.class.getDeclaredField("bitsCachedSize");
        field.setAccessible(true);
        field.set(bitInputStream, value);
    }

    private long invokeReadCachedBits(int count) throws Exception {
        Method method = BitInputStream.class.getDeclaredMethod("readCachedBits", int.class);
        method.setAccessible(true);
        return (long) method.invoke(bitInputStream, count);
    }

    @Test
    public void testReadCachedBits_LittleEndian_CacheNotEmpty() throws Exception {
        setBitsCached(0b101011110000);
        setBitsCachedSize(12);
        long result = invokeReadCachedBits(4);
        assertEquals(0b1110, result);
    }

    @Test
    public void testReadCachedBits_LittleEndian_CacheEmpty() throws Exception {
        setBitsCached(0b000000000000);
        setBitsCachedSize(0);
        long result = invokeReadCachedBits(4);
        assertEquals(0b0000, result);
    }

    @Test
    public void testReadCachedBits_BigEndian() throws Exception {
        bitInputStream = new BitInputStream(new ByteArrayInputStream(new byte[] { (byte) 0b10101010 }), ByteOrder.BIG_ENDIAN);
        setBitsCached(0b10101010);
        setBitsCachedSize(8);
        long result = invokeReadCachedBits(4);
        assertEquals(0b1010, result);
    }

    @Test
    public void testReadCachedBits_BigEndian_CacheEmpty() throws Exception {
        setBitsCached(0b00000000);
        setBitsCachedSize(0);
        long result = invokeReadCachedBits(4);
        assertEquals(0b0000, result);
    }

    @Test
    public void testReadCachedBits_ExceedingCacheSize() throws Exception {
        setBitsCached(0b11111111);
        setBitsCachedSize(8);
        // Exceeding cache size
        long result = invokeReadCachedBits(10);
        // Should return only 8 bits
        assertEquals(0b11111111, result);
    }
}
