package org.apache.commons.compress.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

@ExtendWith(MockitoExtension.class)
public class FixedLengthBlockOutputStream_writeBlock_8_0_Test {

    private WritableByteChannel mockChannel;

    private FixedLengthBlockOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        mockChannel = Mockito.mock(WritableByteChannel.class);
        outputStream = new FixedLengthBlockOutputStream(mockChannel, 8);
    }

    private void writeData(byte[] data) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        try {
            outputStream.getClass().getDeclaredField("buffer").set(outputStream, buffer);
            outputStream.getClass().getDeclaredMethod("writeBlock").setAccessible(true);
            outputStream.getClass().getDeclaredMethod("writeBlock").invoke(outputStream);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IOException("Error writing data", e);
        }
    }

    @Test
    public void testWriteBlock_SuccessfulWrite() throws IOException {
        byte[] data = new byte[8];
        when(mockChannel.write(any(ByteBuffer.class))).thenReturn(8);
        writeData(data);
        verify(mockChannel).write(any(ByteBuffer.class));
    }

    @Test
    public void testWriteBlock_PartialWrite() throws IOException {
        byte[] data = new byte[8];
        when(mockChannel.write(any(ByteBuffer.class))).thenReturn(4);
        IOException exception = assertThrows(IOException.class, () -> {
            writeData(data);
        });
        assertEquals("Failed to write 8 bytes atomically. Only wrote  4", exception.getMessage());
    }

    @Test
    public void testWriteBlock_IOExceptionThrown() throws IOException {
        byte[] data = new byte[8];
        when(mockChannel.write(any(ByteBuffer.class))).thenThrow(new IOException("Channel closed"));
        IOException exception = assertThrows(IOException.class, () -> {
            writeData(data);
        });
        assertEquals("Channel closed", exception.getMessage());
    }
}
