package org.apache.commons.compress.utils;

import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

class SeekableInMemoryByteChannel_resize_7_0_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    void setUp() {
        channel = new SeekableInMemoryByteChannel(new byte[] { 1, 2, 3 });
    }

    @Test
    void testResizeIncreasesSize() throws Exception {
        invokeResize(10);
        assertEquals(16, channel.array().length);
    }

    @Test
    void testResizeDecreasesSize() throws Exception {
        invokeResize(2);
        assertEquals(2, channel.array().length);
    }

    @Test
    void testResizeToZero() throws Exception {
        invokeResize(0);
        assertEquals(1, channel.array().length);
    }

    @Test
    void testResizeToNegative() throws Exception {
        invokeResize(-5);
        assertEquals(1, channel.array().length);
    }

//    @Test
//    void testResizeToNaiveLimit() throws Exception {
//        invokeResize(Integer.MAX_VALUE);
//        assertEquals(Integer.MAX_VALUE, channel.array().length);
//    }

    private void invokeResize(int newLength) throws Exception {
        Method method = SeekableInMemoryByteChannel.class.getDeclaredMethod("resize", int.class);
        method.setAccessible(true);
        method.invoke(channel, newLength);
    }
}
