package org.apache.commons.compress.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SeekableByteChannel;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

class SeekableInMemoryByteChannel_position_5_0_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    void setUp() {
        // Initialize with a byte array of size 10
        channel = new SeekableInMemoryByteChannel(new byte[10]);
    }

    @Test
    void testPositionValid() throws Exception {
        channel.position(5);
        assertEquals(5, invokeGetPosition(channel));
    }

    @Test
    void testPositionZero() throws Exception {
        channel.position(0);
        assertEquals(0, invokeGetPosition(channel));
    }

    @Test
    void testPositionAtMaxValue() throws Exception {
        channel.position(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, invokeGetPosition(channel));
    }

    @Test
    void testPositionNegative() {
        IOException exception = assertThrows(IOException.class, () -> {
            channel.position(-1);
        });
        assertEquals("Position must be in range [0.." + Integer.MAX_VALUE + "]", exception.getMessage());
    }

    @Test
    void testPositionGreaterThanMax() {
        IOException exception = assertThrows(IOException.class, () -> {
            channel.position(Integer.MAX_VALUE + 1L);
        });
        assertEquals("Position must be in range [0.." + Integer.MAX_VALUE + "]", exception.getMessage());
    }

    @Test
    void testPositionOnClosedChannel() throws Exception {
        // Use reflection to close the channel
        Method ensureOpenMethod = SeekableInMemoryByteChannel.class.getDeclaredMethod("ensureOpen");
        ensureOpenMethod.setAccessible(true);
        // This won't close the channel, we need to simulate a closed state
        ensureOpenMethod.invoke(channel);
        // Simulate closing the channel
        channel = new SeekableInMemoryByteChannel();
        IOException exception = assertThrows(ClosedChannelException.class, () -> {
            channel.position(1);
        });
        assertEquals("Channel is closed", exception.getMessage());
    }

    private int invokeGetPosition(SeekableInMemoryByteChannel channel) throws Exception {
        // Use reflection to access the private position field
        Field positionField = SeekableInMemoryByteChannel.class.getDeclaredField("position");
        positionField.setAccessible(true);
        return positionField.getInt(channel);
    }
}
