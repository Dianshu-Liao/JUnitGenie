package org.apache.commons.compress.utils;

import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import java.io.IOException;
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

class SeekableInMemoryByteChannel_position_4_0_Test {

    private SeekableInMemoryByteChannel channel;

    @BeforeEach
    void setUp() {
        channel = new SeekableInMemoryByteChannel(new byte[10]);
    }

    @Test
    void testPositionInitially() {
        assertEquals(0, channel.position());
    }

    @Test
    void testPositionAfterWriting() throws IOException {
        channel.position(5);
        assertEquals(5, channel.position());
    }

    @Test
    void testPositionAfterTruncation() throws IOException {
        channel.position(5);
        channel.truncate(3);
        assertEquals(3, channel.position());
    }

    @Test
    void testPositionOnClosedChannel() throws IOException {
        channel.close();
        assertThrows(ClosedChannelException.class, () -> channel.position(1));
    }

    @Test
    void testPositionOutOfRange() {
        assertThrows(IOException.class, () -> channel.position(-1));
        assertThrows(IOException.class, () -> channel.position(Integer.MAX_VALUE + 1L));
    }
}
