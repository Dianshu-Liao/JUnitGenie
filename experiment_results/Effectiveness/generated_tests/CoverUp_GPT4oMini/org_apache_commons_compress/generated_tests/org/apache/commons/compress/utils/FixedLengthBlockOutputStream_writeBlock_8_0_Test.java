package org.apache.commons.compress.utils;

import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.io.IOUtils;

class FixedLengthBlockOutputStream_writeBlock_8_0_Test {

    private WritableByteChannel mockChannel;

    private FixedLengthBlockOutputStream fixedLengthBlockOutputStream;

    private ByteBuffer buffer;

    @BeforeEach
    void setUp() throws IOException {
        mockChannel = mock(WritableByteChannel.class);
        buffer = ByteBuffer.allocate(10);
        fixedLengthBlockOutputStream = new FixedLengthBlockOutputStream(mockChannel, 10);
        // Fill the buffer with data
        buffer.put(new byte[10]);
        // Prepare the buffer for writing
        buffer.flip();
    }

    @Test
    void testWriteBlockSuccessful() throws IOException {
        when(mockChannel.write(buffer)).thenReturn(10);
        invokePrivateWriteBlock();
        verify(mockChannel).write(buffer);
        assertThrows(IOException.class, () -> invokePrivateWriteBlock());
    }

    @Test
    void testWriteBlockPartialWrite() throws IOException {
        when(mockChannel.write(buffer)).thenReturn(5);
        IOException exception = assertThrows(IOException.class, () -> invokePrivateWriteBlock());
        assertEquals("Failed to write 10 bytes atomically. Only wrote  5", exception.getMessage());
    }

    @Test
    void testWriteBlockWithRemainingData() throws IOException {
        when(mockChannel.write(buffer)).thenReturn(10);
        // Add extra data to have remaining data
        buffer.put((byte) 1);
        IOException exception = assertThrows(IOException.class, () -> invokePrivateWriteBlock());
        assertEquals("Failed to write 10 bytes atomically. Only wrote  10", exception.getMessage());
    }

    private void invokePrivateWriteBlock() throws IOException {
        try {
            Method method = FixedLengthBlockOutputStream.class.getDeclaredMethod("writeBlock");
            method.setAccessible(true);
            method.invoke(fixedLengthBlockOutputStream);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
