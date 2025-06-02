package org.apache.commons.compress.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SeekableByteChannel;

class SeekableInMemoryByteChannel_resize_7_3_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    void setUp() {
        // Initialize with a default size
        channel = new SeekableInMemoryByteChannel(new byte[4]);
    }

    @Test
    void testResizeIncreasesSize() throws Exception {
        invokeResize(8);
        assertEquals(8, getDataLength());
    }

    @Test
    void testResizeToSmallerSize() throws Exception {
        invokeResize(2);
        // Should still be 4, as we can't shrink
        assertEquals(4, getDataLength());
    }

    @Test
    void testResizeToExactSize() throws Exception {
        invokeResize(4);
        // Should remain the same
        assertEquals(4, getDataLength());
    }

//    @Test
//    void testResizeToNaiveLimit() throws Exception {
//        invokeResize(Integer.MAX_VALUE);
//        // Adjusted for the naive limit
//        assertEquals(Integer.MAX_VALUE >> 1, getDataLength());
//    }

    @Test
    void testResizeToZero() throws Exception {
        invokeResize(0);
        // Should resize to at least 1
        assertEquals(1, getDataLength());
    }

    @Test
    void testResizeFromEmptyData() throws Exception {
        channel = new SeekableInMemoryByteChannel(new byte[0]);
        invokeResize(4);
        // Should resize to 4
        assertEquals(4, getDataLength());
    }

    private void invokeResize(int newLength) throws Exception {
        Method method = SeekableInMemoryByteChannel.class.getDeclaredMethod("resize", int.class);
        method.setAccessible(true);
        method.invoke(channel, newLength);
    }

    private int getDataLength() throws Exception {
        // Use reflection to access the private 'data' field
        Method method = SeekableInMemoryByteChannel.class.getDeclaredMethod("getData");
        method.setAccessible(true);
        byte[] data = (byte[]) method.invoke(channel);
        return data.length;
    }
}
