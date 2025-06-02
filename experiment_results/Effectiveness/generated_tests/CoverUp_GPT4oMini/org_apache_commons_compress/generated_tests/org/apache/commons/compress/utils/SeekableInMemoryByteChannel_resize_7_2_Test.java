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

class SeekableInMemoryByteChannel_resize_7_2_Test {

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
    void testResizeDecreasesSize() throws Exception {
        invokeResize(4);
        assertEquals(4, getDataLength());
    }

    @Test
    void testResizeToZero() throws Exception {
        invokeResize(0);
        assertEquals(1, getDataLength());
    }

    @Test
    void testResizeToNegative() throws Exception {
        invokeResize(-1);
        assertEquals(1, getDataLength());
    }

//    @Test
//    void testResizeToNaiveLimit() throws Exception {
//        invokeResize(Integer.MAX_VALUE);
//        assertEquals(Integer.MAX_VALUE, getDataLength());
//    }

    private void invokeResize(int newLength) throws Exception {
        Method resizeMethod = SeekableInMemoryByteChannel.class.getDeclaredMethod("resize", int.class);
        resizeMethod.setAccessible(true);
        resizeMethod.invoke(channel, newLength);
    }

    private int getDataLength() throws Exception {
        // Access the private field 'data' using reflection to determine its length
        Method getDataMethod = SeekableInMemoryByteChannel.class.getDeclaredMethod("getData");
        getDataMethod.setAccessible(true);
        byte[] data = (byte[]) getDataMethod.invoke(channel);
        return data.length;
    }
}
