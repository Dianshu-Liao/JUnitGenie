package org.apache.commons.compress.utils;

import java.lang.reflect.Method;
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

class SeekableInMemoryByteChannel_isOpen_3_0_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    void setUp() {
        channel = new SeekableInMemoryByteChannel();
    }

    @AfterEach
    void tearDown() {
        channel = null;
    }

    @Test
    void testIsOpen_WhenChannelIsOpen_ReturnsTrue() {
        assertTrue(channel.isOpen(), "Channel should be open initially.");
    }

    @Test
    void testIsOpen_WhenChannelIsClosed_ReturnsFalse() throws Exception {
        // Use reflection to set the closed state to true
        Method closeMethod = SeekableInMemoryByteChannel.class.getDeclaredMethod("close");
        closeMethod.setAccessible(true);
        closeMethod.invoke(channel);
        assertFalse(channel.isOpen(), "Channel should be closed.");
    }

    @Test
    void testIsOpen_WhenChannelIsNeverClosed_ReturnsTrue() {
        SeekableInMemoryByteChannel channelWithData = new SeekableInMemoryByteChannel(new byte[] { 1, 2, 3 });
        assertTrue(channelWithData.isOpen(), "Channel should be open with data.");
    }

    @Test
    void testIsOpen_WhenChannelIsClosedViaConstructor_ReturnsFalse() throws Exception {
        // Simulate closing the channel in a different constructor or method
        SeekableInMemoryByteChannel channelWithSize = new SeekableInMemoryByteChannel(10);
        Method closeMethod = SeekableInMemoryByteChannel.class.getDeclaredMethod("close");
        closeMethod.setAccessible(true);
        closeMethod.invoke(channelWithSize);
        assertFalse(channelWithSize.isOpen(), "Channel should be closed after invoking close.");
    }
}
