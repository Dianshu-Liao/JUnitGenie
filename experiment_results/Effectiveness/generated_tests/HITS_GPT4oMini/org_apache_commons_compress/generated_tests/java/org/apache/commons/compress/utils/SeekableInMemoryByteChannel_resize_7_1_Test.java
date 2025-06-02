package org.apache.commons.compress.utils;

import java.lang.reflect.Field;
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
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

class SeekableInMemoryByteChannel_resize_7_1_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    void setUp() {
        channel = new SeekableInMemoryByteChannel();
    }

    @Test
    void testResizeIncreasesSize() throws Exception {
        resizeChannel(10);
        assertEquals(10, getCurrentSize());
        assertNotNull(getCurrentData());
        assertTrue(getCurrentData().length >= 10);
    }

    @Test
    void testResizeToZero() throws Exception {
        resizeChannel(0);
        assertEquals(0, getCurrentSize());
        assertNotNull(getCurrentData());
        assertTrue(getCurrentData().length >= 0);
    }

    @Test
    void testResizeToNegative() throws Exception {
        resizeChannel(-5);
        // This may not be a valid case depending on the implementation
        assertEquals(-5, getCurrentSize());
        assertNotNull(getCurrentData());
        assertTrue(getCurrentData().length >= 0);
    }

    @Test
    void testResizeToNaiveLimit() throws Exception {
        resizeChannel(Integer.MAX_VALUE >> 1);
        assertEquals(Integer.MAX_VALUE >> 1, getCurrentSize());
        assertNotNull(getCurrentData());
        assertTrue(getCurrentData().length >= (Integer.MAX_VALUE >> 1));
    }

    @Test
    void testResizeToAboveNaiveLimit() throws Exception {
        resizeChannel(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, getCurrentSize());
        assertNotNull(getCurrentData());
        assertTrue(getCurrentData().length >= Integer.MAX_VALUE);
    }

    @Test
    void testResizeFromSmallToLarge() throws Exception {
        resizeChannel(2);
        assertEquals(2, getCurrentSize());
        resizeChannel(16);
        assertEquals(16, getCurrentSize());
        assertNotNull(getCurrentData());
        assertTrue(getCurrentData().length >= 16);
    }

    @Test
    void testResizeFromLargeToSmall() throws Exception {
        resizeChannel(64);
        assertEquals(64, getCurrentSize());
        resizeChannel(32);
        assertEquals(32, getCurrentSize());
        assertNotNull(getCurrentData());
        assertTrue(getCurrentData().length >= 32);
    }

    @Test
    void testResizeWithInitialEmptyData() throws Exception {
        resizeChannel(1);
        assertEquals(1, getCurrentSize());
        assertNotNull(getCurrentData());
        assertEquals(1, getCurrentData().length);
    }

    private void resizeChannel(int newSize) throws Exception {
        Field resizeField = SeekableInMemoryByteChannel.class.getDeclaredField("data");
        resizeField.setAccessible(true);
        channel.getClass().getDeclaredMethod("resize", int.class).invoke(channel, newSize);
    }

    private int getCurrentSize() throws Exception {
        Field sizeField = SeekableInMemoryByteChannel.class.getDeclaredField("size");
        sizeField.setAccessible(true);
        return sizeField.getInt(channel);
    }

    private byte[] getCurrentData() throws Exception {
        Field dataField = SeekableInMemoryByteChannel.class.getDeclaredField("data");
        dataField.setAccessible(true);
        return (byte[]) dataField.get(channel);
    }
}
