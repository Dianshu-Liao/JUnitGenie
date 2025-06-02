package org.apache.commons.compress.utils;

import java.nio.channels.ClosedChannelException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class SeekableInMemoryByteChannel_isOpen_3_0_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    public void setUp() {
        channel = new SeekableInMemoryByteChannel();
    }

    @Test
    public void testIsOpen_WhenChannelIsOpen() {
        // Arrange
        // Channel is open by default upon creation
        // Act
        boolean isOpen = channel.isOpen();
        // Assert
        assertTrue(isOpen, "Channel should be open when initialized.");
    }

    @Test
    public void testIsOpen_WhenChannelIsClosed() throws ClosedChannelException {
        // Arrange
        // Simulate closing the channel
        // Assuming there is a close() method to set the channel as closed
        channel.close();
        // Act
        boolean isOpen = channel.isOpen();
        // Assert
        assertFalse(isOpen, "Channel should be closed after close() is called.");
    }
}
