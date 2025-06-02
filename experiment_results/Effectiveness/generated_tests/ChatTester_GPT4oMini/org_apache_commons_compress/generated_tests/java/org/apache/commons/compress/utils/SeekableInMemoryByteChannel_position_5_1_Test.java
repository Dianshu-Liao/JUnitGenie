package org.apache.commons.compress.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.ClosedChannelException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

class SeekableInMemoryByteChannel_position_5_1_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    void setUp() {
        channel = new SeekableInMemoryByteChannel();
    }

    @Test
    void testPositionValid() throws IOException {
        long newPosition = 100L;
        SeekableByteChannel result = channel.position(newPosition);
        assertEquals(channel, result, "The returned channel should be the same instance.");
        try {
            assertEquals(100, getPrivatePosition(channel), "Position should be updated to 100.");
        } catch (Exception e) {
            fail("Exception occurred while getting private position: " + e.getMessage());
        }
    }

    @Test
    void testPositionNegative() {
        long newPosition = -1L;
        IOException exception = assertThrows(IOException.class, () -> channel.position(newPosition));
        assertEquals("Position must be in range [0.." + Integer.MAX_VALUE + "]", exception.getMessage());
    }

    @Test
    void testPositionTooLarge() {
        long newPosition = Integer.MAX_VALUE + 1L;
        IOException exception = assertThrows(IOException.class, () -> channel.position(newPosition));
        assertEquals("Position must be in range [0.." + Integer.MAX_VALUE + "]", exception.getMessage());
    }

    @Test
    void testPositionAtMax() throws IOException {
        long newPosition = Integer.MAX_VALUE;
        SeekableByteChannel result = channel.position(newPosition);
        assertEquals(channel, result, "The returned channel should be the same instance.");
        try {
            assertEquals(Integer.MAX_VALUE, getPrivatePosition(channel), "Position should be updated to Integer.MAX_VALUE.");
        } catch (Exception e) {
            fail("Exception occurred while getting private position: " + e.getMessage());
        }
    }

    @Test
    void testPositionAfterClose() throws IOException {
        // Assuming there is a method to close the channel
        channel.close();
        long newPosition = 50L;
        IOException exception = assertThrows(IOException.class, () -> channel.position(newPosition));
        // Adjust the message based on your implementation
        assertEquals("Channel is closed", exception.getMessage());
    }

    private int getPrivatePosition(SeekableInMemoryByteChannel channel) throws Exception {
        Method method = SeekableInMemoryByteChannel.class.getDeclaredMethod("getPosition");
        method.setAccessible(true);
        return (int) method.invoke(channel);
    }
}
