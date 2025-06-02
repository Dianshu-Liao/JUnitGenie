package org.apache.commons.compress.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.io.IOUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FixedLengthBlockOutputStream_writeBlock_8_2_Test {

    private WritableByteChannel mockChannel;

    private FixedLengthBlockOutputStream stream;

    private ByteBuffer buffer;

    @BeforeEach
    void setUp() {
        mockChannel = mock(WritableByteChannel.class);
        stream = new FixedLengthBlockOutputStream(mockChannel, 10);
        buffer = ByteBuffer.allocate(10);
        setPrivateField(stream, "buffer", buffer);
    }

    @Test
    void testWriteBlock_Success() throws Exception {
        // Prepare the buffer and mock channel
        buffer.put(new byte[10]);
        buffer.flip();
        when(mockChannel.write(buffer)).thenReturn(10);
        // Invoke the private method
        invokePrivateMethod(stream, "writeBlock");
        // Verify that the buffer is cleared
        assertFalse(buffer.hasRemaining());
        verify(mockChannel).write(buffer);
    }

    @Test
    void testWriteBlock_PartialWrite() throws Exception {
        // Prepare the buffer and mock channel
        buffer.put(new byte[10]);
        buffer.flip();
        when(mockChannel.write(buffer)).thenReturn(5);
        // Expect IOException due to partial write
        Exception exception = assertThrows(IOException.class, () -> {
            invokePrivateMethod(stream, "writeBlock");
        });
        String expectedMessage = "Failed to write 10 bytes atomically. Only wrote  5";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testWriteBlock_HasRemaining() throws Exception {
        // Prepare the buffer and mock channel
        buffer.put(new byte[5]);
        buffer.flip();
        when(mockChannel.write(buffer)).thenReturn(5);
        // Expect IOException due to remaining bytes
        Exception exception = assertThrows(IOException.class, () -> {
            invokePrivateMethod(stream, "writeBlock");
        });
        String expectedMessage = "Failed to write 10 bytes atomically. Only wrote  5";
        assertEquals(expectedMessage, exception.getMessage());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            // Fixed the buggy line: changed 'var' to 'Field'
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokePrivateMethod(Object obj, String methodName, Object... args) {
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName);
            method.setAccessible(true);
            method.invoke(obj, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
