package org.apache.commons.compress.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
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

public class SeekableInMemoryByteChannel_resize_7_4_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    public void setUp() {
        channel = new SeekableInMemoryByteChannel(new byte[0]);
    }

    @Test
    public void testResizeIncreasesSize() throws Exception {
        invokeResize(8);
        assertEquals(8, getData().length);
    }

//    @Test
//    public void testResizeToGreaterThanNaiveLimit() throws Exception {
//        invokeResize(Integer.MAX_VALUE);
//        assertEquals(Integer.MAX_VALUE, getData().length);
//    }

    @Test
    public void testResizeToSmallerSize() throws Exception {
        invokeResize(4);
        assertEquals(4, getData().length);
        invokeResize(2);
        // Should not shrink
        assertEquals(4, getData().length);
    }

    @Test
    public void testResizeWhenDataIsEmpty() throws Exception {
        channel = new SeekableInMemoryByteChannel();
        invokeResize(5);
        // Should resize to at least 1
        assertEquals(1, getData().length);
    }

    @Test
    public void testResizeToNegativeValue() throws Exception {
        invokeResize(-1);
        // Should not shrink
        assertEquals(1, getData().length);
    }

    private void invokeResize(int newLength) throws Exception {
        Method resizeMethod = SeekableInMemoryByteChannel.class.getDeclaredMethod("resize", int.class);
        resizeMethod.setAccessible(true);
        resizeMethod.invoke(channel, newLength);
    }

    // Helper method to access the internal data for assertions
    public byte[] getData() {
        try {
            // Accessing the private 'data' field using reflection
            Field dataField = SeekableInMemoryByteChannel.class.getDeclaredField("data");
            dataField.setAccessible(true);
            return (byte[]) dataField.get(channel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
