package org.apache.commons.compress.utils;

import java.lang.reflect.Field;
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
import java.util.Arrays;

public class SeekableInMemoryByteChannel_isOpen_3_0_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    public void setUp() {
        channel = new SeekableInMemoryByteChannel();
    }

    @Test
    public void testIsOpen_WhenNotClosed_ShouldReturnTrue() {
        assertTrue(channel.isOpen(), "Channel should be open when not closed.");
    }

    @Test
    public void testIsOpen_WhenClosed_ShouldReturnFalse() throws Exception {
        // Invoke the private method to close the channel
        Field closedField = SeekableInMemoryByteChannel.class.getDeclaredField("closed");
        closedField.setAccessible(true);
        ((AtomicBoolean) closedField.get(channel)).set(true);
        assertFalse(channel.isOpen(), "Channel should be closed.");
    }
}
