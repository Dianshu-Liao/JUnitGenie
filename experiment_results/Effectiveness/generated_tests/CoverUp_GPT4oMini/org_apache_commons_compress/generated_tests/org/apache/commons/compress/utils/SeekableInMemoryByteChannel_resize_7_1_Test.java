package org.apache.commons.compress.utils;

import java.lang.reflect.Method;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

class SeekableInMemoryByteChannel_resize_7_1_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    void setUp() {
        channel = new SeekableInMemoryByteChannel(new byte[0]);
    }

    @Test
    void testResizeIncreasesSize() throws Exception {
        invokeResize(16);
        assertEquals(16, getDataLength());
    }

    @Test
    void testResizeToSameSize() throws Exception {
        invokeResize(8);
        assertEquals(8, getDataLength());
    }

    @Test
    void testResizeDecreasesSize() throws Exception {
        invokeResize(16);
        invokeResize(8);
        assertEquals(8, getDataLength());
    }

//    @Test
//    void testResizeToNaiveLimit() throws Exception {
//        invokeResize(Integer.MAX_VALUE);
//        assertEquals(Integer.MAX_VALUE, getDataLength());
//    }

    @Test
    void testResizeToZero() throws Exception {
        invokeResize(0);
        assertEquals(1, getDataLength());
    }

    @Test
    void testResizeNegative() throws Exception {
        invokeResize(-10);
        assertEquals(1, getDataLength());
    }

    @Test
    void testResizeClosedChannel() {
        channel.close();
        assertThrows(ClosedChannelException.class, () -> invokeResize(10));
    }

    private void invokeResize(int newLength) throws Exception {
        Method method = SeekableInMemoryByteChannel.class.getDeclaredMethod("resize", int.class);
        method.setAccessible(true);
        method.invoke(channel, newLength);
    }

    // Helper method to access private field for testing
    private int getDataLength() throws Exception {
        Method method = SeekableInMemoryByteChannel.class.getDeclaredMethod("getDataLength");
        method.setAccessible(true);
        return (int) method.invoke(channel);
    }
}
