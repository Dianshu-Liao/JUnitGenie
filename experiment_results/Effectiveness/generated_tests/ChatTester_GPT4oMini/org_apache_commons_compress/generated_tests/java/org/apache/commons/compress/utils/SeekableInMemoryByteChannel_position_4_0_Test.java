package org.apache.commons.compress.utils;

import java.nio.ByteBuffer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class SeekableInMemoryByteChannel_position_4_0_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    public void setUp() {
        channel = new SeekableInMemoryByteChannel();
    }

    @Test
    public void testPositionInitially() {
        // Test the initial position
        assertEquals(0, channel.position(), "Initial position should be 0");
    }

    @Test
    public void testPositionAfterWrite() throws Exception {
        // Write some data to the channel
        ByteBuffer buffer = ByteBuffer.wrap(new byte[] { 1, 2, 3, 4, 5 });
        channel.write(buffer);
        // Test the position after writing data
        assertEquals(5, channel.position(), "Position should be 5 after writing 5 bytes");
    }

    @Test
    public void testPositionAfterTruncate() throws Exception {
        // Write some data to the channel
        ByteBuffer buffer = ByteBuffer.wrap(new byte[] { 1, 2, 3, 4, 5 });
        channel.write(buffer);
        // Truncate the channel
        channel.truncate(3);
        // Test the position after truncating
        assertEquals(3, channel.position(), "Position should be 3 after truncating to 3 bytes");
    }

    @Test
    public void testPositionAfterClose() throws Exception {
        // Write some data to the channel
        ByteBuffer buffer = ByteBuffer.wrap(new byte[] { 1, 2, 3, 4, 5 });
        channel.write(buffer);
        // Close the channel
        channel.close();
        // Test that the position remains the same after closing
        assertEquals(5, channel.position(), "Position should remain 5 after closing the channel");
    }
}
