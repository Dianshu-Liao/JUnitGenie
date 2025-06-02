package org.apache.commons.compress.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.ClosedChannelException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class SeekableInMemoryByteChannel_position_5_0_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    public void setUp() {
        // Initialize with a byte array of size 10
        channel = new SeekableInMemoryByteChannel(new byte[10]);
    }

    private int getPosition() throws Exception {
        Field positionField = SeekableInMemoryByteChannel.class.getDeclaredField("position");
        positionField.setAccessible(true);
        return (int) positionField.get(channel);
    }

    @Test
    public void testPositionValid() throws IOException, Exception {
        channel.position(5);
        // Verify the position is set correctly
        assertEquals(5, getPosition());
    }

    @Test
    public void testPositionLowerBound() {
        IOException thrown = assertThrows(IOException.class, () -> {
            channel.position(-1);
        });
        assertEquals("Position must be in range [0..2147483647]", thrown.getMessage());
    }

    @Test
    public void testPositionUpperBound() {
        IOException thrown = assertThrows(IOException.class, () -> {
            channel.position(Integer.MAX_VALUE + 1L);
        });
        assertEquals("Position must be in range [0..2147483647]", thrown.getMessage());
    }

    @Test
    public void testPositionClosedChannel() throws IOException {
        channel.close();
        ClosedChannelException thrown = assertThrows(ClosedChannelException.class, () -> {
            channel.position(0);
        });
        assertNotNull(thrown);
    }

    @Test
    public void testPositionZero() throws IOException, Exception {
        channel.position(0);
        // Verify that position can be set to zero
        assertEquals(0, getPosition());
    }

    @Test
    public void testPositionExactSize() throws IOException, Exception {
        channel.position(10);
        // Verify that position can be set to the exact size
        assertEquals(10, getPosition());
    }
}
